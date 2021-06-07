package com.jietang;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;

import java.util.List;

/**
 * @author: jietang
 * @create: 2021/2/24-5:49 下午
 **/

public class EncTest {
    public static void main(String[] args) {

            int start = 3 ,end =7;
            String phoneNum = "18855556666";
            int len = phoneNum.length();
            int count = end- start;
            String bit ="";
            for(int j =0;j<count;j++){
                bit += "*";
            }
        System.out.println(phoneNum.substring(0,start)+ bit +phoneNum.substring(end,len));
    }


}
