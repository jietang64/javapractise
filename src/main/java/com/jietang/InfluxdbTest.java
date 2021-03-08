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

public class InfluxdbTest {
    public static void main(String[] args) {
        InfluxDBClient influxDBClient = InfluxDBClientFactory
                .createV1("http://172.31.244.114:8086", null, null, "mydb",null);
        QueryApi queryApi = influxDBClient.getQueryApi();
        List<FluxTable> query = queryApi.query("from(bucket:\"telegraf/autogen\")\n" +
                "  |> range(start: -15m)\n" +
                "  |> filter(fn: (r) =>\n" +
                "    r._measurement == \"cpu\" and\n" +
                "    r._field == \"usage_system\" and\n" +
                "    r.cpu == \"cpu-total\"\n" +
                "  )\n" +
                "  |> yield()");
        for (FluxTable fluxTable : query) {
            List<FluxRecord> records = fluxTable.getRecords();
            for (FluxRecord fluxRecord : records) {
                System.out.println(fluxRecord.getTime() + ": " + fluxRecord.getValueByKey("_value"));
            }
        }

        influxDBClient.close();

    }
}
