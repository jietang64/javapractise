#!/bin/bash

while (true)
do
  curl -i -XPOST 'http://172.31.244.114:18056/write?db=mydb' --data-binary 'MarketBatchDetails_2021_1TEST,businessId=373683322132049,consumerId=10869305621348777,batchId=393107126686824,phoneNo=13965680015 status="3",businessName="勿动_yqwang测试交互",consumerName="测试客户20200403",detailsId="12579435978561794",city="合肥",province="安徽",carrierCode="1",elapsedTime=13,beginTime=1611988623000,endTime=1611988636000,currentCallTime=1,transactionId="2101301437020803001",label_2_是否是机主_否=1,label_2_是否进入子流程_子话术6=1'
done

