#!/bin/bash

############################################################
# 执行样例： nohup sh sh_update_aiuiso_4docker.sh
# 其中： name 表示要替换的 container 标识，最好是完整的 name 名称
#       so_name 表示要替换的 so 的名称，该名称在 lib 目录下要存在
#       container_so_path 标识要替换的so在容器中的目录
#       data_compose_path athene部署的位置
#       redis_password redis的密码
#       当前机器IP
#       container_so_path 标识要替换的so在容器中的目录
############################################################

name=athena_esboost_1
so_name=stisc.so
container_so_path=/opt/research/esboost/lib
data_compose_path=/data/athena
redis_password=Jjfa@1307
ip=172.31.53.18

if cat "$data_compose_path/athena_xconf/deploy_sh/xconf_copy/TEST/redis/redis.conf" | grep "p_password" > /dev/null
then
    echo "p_password已存在，无需更新"
else
    echo "开始更新配置中心"
    echo "p_password=$redis_password" >> $data_compose_path/athena_xconf/deploy_sh/xconf_copy/TEST/redis/redis.conf
    echo "t_password=$redis_password" >> $data_compose_path/athena_xconf/deploy_sh/xconf_copy/TEST/redis/redis.conf
fi

bash $data_compose_path/athena_xconf/deploy_sh/delete_xconf.sh root TEST $ip  ALL
bash $data_compose_path/athena_xconf/deploy_sh/upload_to_xconf.sh root TEST $ip $data_compose_path/athena_xconf/deploy_sh/xconf_copy/TEST ALL

echo "开始更新 container: [$name], so: [$so_name]"

DIR=$(cd $(dirname $0); pwd)
cd $DIR
currDate=$(date "+%Y-%m-%d")

# 1. 获取正在运行的容器信息
echo "获取正在运行的容器信息..."
cid=`docker ps -f"name=athena_esboost_1" | awk 'NR==2{print}' | awk '{print $1}'`
image=`docker ps -f"name=athena_esboost_1" | awk 'NR==2{print}' | awk '{print $2}'`
echo "当前版本：$image，容器ID：$cid"
# 2. 到目标宿主机上修改容器内容并重新打镜像
echo "开始替换lib包"
docker cp $so_name $cid:$container_so_path
echo "镜像重新提交"
docker commit $cid $image
echo "开始重启pod"
docker stop $cid
docker rm $cid
$data_compose_path/docker-compose -f $data_compose_path/docker-compose.yaml up -d esboost
