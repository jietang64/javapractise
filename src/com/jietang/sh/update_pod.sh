#!/bin/bash

############################################################
# 手动替换pod的镜像包版本
# 执行样例： update_pod.sh 组件名 镜像包地址
############################################################

imageName=$1
imageAddr=$2

sh_port=22

if [ -z "$imageName" ]; then
    echo "$(date "+%Y-%m-%d %H:%M:%S"): 请输入镜像名称" >> op.log
    exit
fi
if [ -z "$imageAddr" ]; then
    echo "$(date "+%Y-%m-%d %H:%M:%S"): 请输入镜像地址" >> op.log
    exit
fi

DIR=$(cd $(dirname $0); pwd)

# 1. 获取正在运行的pod的版本号，所在宿主机，容器ID等信息
docker pull $2
docker save -o /data/k8s-packages/$1.tar $2

# 4. 开始分发镜像
tmp_nodes=`kubectl get nodes -owide | awk '{print $6}'`
NODES=($tmp_nodes)
unset NODES[0]
echo "$(date "+%Y-%m-%d %H:%M:%S"): 集群中的节点列表：${NODES[*]}" >> op.log
node_image_path=/data/k8s-packages
if [ -e  /data/k8s-packages/$1.tar ]; then
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
        scp  /data/k8s-packages/$1.tar root@$HOST:$node_image_path
        ssh -p $sh_port root@$HOST "docker load -i /data/k8s-packages/$1.tar"
    done
    echo "$(date "+%Y-%m-%d %H:%M:%S"): 镜像分发完成..." >> op.log

    # 5. 滚动更新
    kubectl -n znwh set image deployment/$1 $1=$2
    echo "$(date "+%Y-%m-%d %H:%M:%S"): k8s中$1的镜像版本已更新，请输入 [ kubectl -n znwh get po -owide | grep $1 ] 检查..." >> op.log
else
    echo "$(date "+%Y-%m-%d %H:%M:%S"): 新的镜像文件不存在..." >> op.log
fi
