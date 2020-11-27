#!/bin/bash

############################################################
# 执行样例： nohup sh update_flowmanage.sh {版本参数} >> /dev/null 2>&1 &
#   其中： 版本参数的值为 v352  v353，分别对应两个文件夹中的xml文件
# 该脚本需要在 master01 执行，原因：
#   1）需要到其他服务器的免密权限
#   2）需要能执行 kubectl 命令
############################################################

ver=$1
sh_port=22

if [ -z "$ver" ]; then
    echo "$(date "+%Y-%m-%d %H:%M:%S"): 请输入版本参数，如： v353 等。。。" >> op.log
    exit
fi
if [ "$ver" != "v356"  ]; then
    echo "$(date "+%Y-%m-%d %H:%M:%S"): 请输入正确的版本号。。。" >> op.log
    exit
fi

DIR=$(cd $(dirname $0); pwd)
currDate=$(date "+%Y-%m-%d")
jar_path=/data/sh_update/$currDate

# 1. 获取正在运行的pod的版本号，所在宿主机，容器ID等信息
echo "$(date "+%Y-%m-%d %H:%M:%S"): 获取正在运行的pod的版本号，所在宿主机，容器ID等信息..." >> op.log
podname=`kubectl -n znwh get pods -owide | grep gfdp-service-iavpadapter | grep Running | head -n 1| awk '{print $1}'`
podonhost=`kubectl -n znwh get pods -owide | grep gfdp-service-iavpadapter | grep Running | head -n 1| awk '{print $7}'`
image=`kubectl -n znwh describe po $podname | grep "Image:"`
image_ver=${image##*:}
cid=`kubectl -n znwh describe po $podname | grep "Container ID"`
cid_full=${cid##*/}
cid_short=${cid_full:0:12}
echo "$(date "+%Y-%m-%d %H:%M:%S"): 当前版本：$image_ver，所在宿主机： $podonhost，容器ID：$cid_short" >> op.log

# 2. 到目标宿主机上修改容器内容并重新打镜像
echo "$(date "+%Y-%m-%d %H:%M:%S"): 到目标宿主机上修改容器内容并重新打镜像..." >> op.log
ssh -p $sh_port $podonhost " mkdir -p $jar_path "
scp $ver/gfdp-service-iavpadapter/* root@$podonhost:$jar_path/
ssh -p $sh_port root@$podonhost "
    docker cp $jar_path/action_transfer.ftl $cid_short:/app/conf/templates/model
	  docker cp $jar_path/catch_exception.ftl $cid_short:/app/conf/templates/model
	  docker cp $jar_path/flow.ftl $cid_short:/app/conf/templates
    docker commit $cid_short hub.iflytek.com/cti_mea/gfdp-service-iavpadapter:mixwav
    docker save -o $jar_path/gfdp-service-iavpadapter_mixwav.tar hub.iflytek.com/cti_mea/gfdp-service-iavpadapter:mixwav
"

# 3. 将新镜像拷贝到master01上
echo "$(date "+%Y-%m-%d %H:%M:%S"): 将新镜像拷贝到master01上..." >> op.log
scp root@$podonhost:$jar_path/gfdp-service-iavpadapter_mixwav.tar $DIR/

# 4. 开始分发镜像
tmp_nodes=`kubectl get nodes -owide | awk '{print $6}'`
NODES=($tmp_nodes)
unset NODES[0]
echo "$(date "+%Y-%m-%d %H:%M:%S"): 集群中的节点列表：${NODES[*]}" >> op.log
node_image_path=/data/k8s-packages
if [ -e $DIR/gfdp-service-iavpadapter_mixwav.tar ]; then
    echo "$(date "+%Y-%m-%d %H:%M:%S"): 开始分发镜像..." >> op.log
    for i in "${!NODES[@]}"; do
        HOST=${NODES[$i]}
		if ssh -p $sh_port $HOST test -e $node_image_path; then
            echo "$(date "+%Y-%m-%d %H:%M:%S"): node: $HOST, path is exit!" >> op.log
        else
            ssh -p $sh_port root@$HOST "mkdir -p $node_image_path"
            echo "$(date "+%Y-%m-%d %H:%M:%S"): node: $HOST, create path: $node_image_path" >> op.log
        fi
        echo "$(date "+%Y-%m-%d %H:%M:%S"): 分发镜像到 $HOST" >> op.log
        scp $DIR/gfdp-service-iavpadapter_mixwav.tar root@$HOST:$node_image_path
        ssh -p $sh_port root@$HOST "docker load -i /data/k8s-packages/gfdp-service-iavpadapter_mixwav.tar"
    done
    echo "$(date "+%Y-%m-%d %H:%M:%S"): 镜像分发完成..." >> op.log

    # 5. 滚动更新
    kubectl -n znwh set image deployment/gfdp-service-iavpadapter gfdp-service-iavpadapter=hub.iflytek.com/cti_mea/gfdp-service-iavpadapter:mixwav
    echo "$(date "+%Y-%m-%d %H:%M:%S"): k8s中gfdp-service-iavpadapter的镜像版本已更新，请输入 [ kubectl -n znwh get po -owide | grep gfdp-job-aisppremarket ] 检查..." >> op.log
else
    echo "$(date "+%Y-%m-%d %H:%M:%S"): 新的镜像文件不存在..." >> op.log
fi
