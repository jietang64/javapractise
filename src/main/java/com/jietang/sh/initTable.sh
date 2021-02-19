#!/bin/bash

if [ -z "$1" ]; then
    echo "$(date "+%Y-%m-%d %H:%M:%S"): 请输入服务器 IP"
    exit
fi

curl -i -XPOST http://$1:8086/query --data-urlencode "q=CREATE DATABASE aisp_biz"

curl -i -XPOST http://$1:8086/query --data-urlencode "q=CREATE CONTINUOUS QUERY cq_MarketBatchHourSum ON aisp_biz BEGIN SELECT count(/^label_/) INTO aisp_biz.autogen.MarketBatchHourSum FROM aisp_biz.autogen.MarketBatchDetails_2021_1 GROUP BY time(1h) ,consumerId, businessId END"

