package com.jietang;


import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class TimeCrossTest {
    public static void main(String[] args) {
        String time1 = "2:00-4:00|14:00-19:00";
        String time2 = "3:00-5:00|13:00-15:00|16:00-17:00";
        List<List<Date>> bizLimitTimePhase1 = getBizLimitTimePhase(time1);
        List<List<Date>> bizLimitTimePhase2 = getBizLimitTimePhase(time2);
        List<List<Date>> result = new ArrayList<>();
        //1. 多个时间取交集
        for (int i = 0; i < bizLimitTimePhase1.size(); i++) {
            for (int k = 0; k < bizLimitTimePhase2.size(); k++) {
                int time1_start_hour = bizLimitTimePhase1.get(i).get(0).getHours();
                int time1_start_minute = bizLimitTimePhase1.get(i).get(0).getMinutes();
                int time1_end_hour = bizLimitTimePhase1.get(i).get(1).getHours();
                int time1_end_minute = bizLimitTimePhase1.get(i).get(1).getMinutes();

                int time2_start_hour = bizLimitTimePhase2.get(k).get(0).getHours();
                int time2_start_minute = bizLimitTimePhase2.get(k).get(0).getMinutes();
                int time2_end_hour = bizLimitTimePhase2.get(k).get(1).getHours();
                int time2_end_minute = bizLimitTimePhase2.get(k).get(1).getMinutes();
                //时间1的开始时间 < 时间2的结束时间 并且 时间2的开始时间 < 时间1的结束时间 说明二者存在交集
                if (timeCompare(time1_start_hour, time1_start_minute, time2_end_hour, time2_end_minute) <= 0
                        && timeCompare(time2_start_hour, time2_start_minute, time1_end_hour, time1_end_minute) <= 0) {
                    //两个开始时间取较大的 //两个结束时间取较小的
                    List<Date> singleresult = new ArrayList<>();
                    if (timeCompare(time1_start_hour, time1_start_minute, time2_start_hour, time2_start_minute) > 0) {
                        singleresult.add(bizLimitTimePhase1.get(i).get(0));
                    }else {
                        singleresult.add(bizLimitTimePhase2.get(k).get(0));
                    }
                    if (timeCompare(time1_end_hour, time1_end_minute, time2_end_hour, time2_end_minute) > 0) {
                        singleresult.add(bizLimitTimePhase2.get(k).get(1));
                    }else {
                        singleresult.add(bizLimitTimePhase1.get(i).get(1));
                    }
                    result.add(singleresult);
                }
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        System.out.println(result.stream().map(i->simpleDateFormat.format(i.get(0)) + "-"+simpleDateFormat.format(i.get(1))).collect(Collectors.joining("|")));
    }

    public static int timeCompare(int hour1, int minute1, int hour2, int minute2) {
        if (hour1 < hour2) {
            return -1;
        } else if (hour1 > hour2) {
            return 1;
        } else {
            if (minute1 < minute2) {
                return -1;
            } else if (minute1 > minute2) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static List<List<Date>> getBizLimitTimePhase(String times) {
        List<List<Date>> timePeriod = new ArrayList<>();
        try {
            String[] timePeriodString = times.split("\\|");
            for (String time : timePeriodString) {
                String[] beginAndEndTime = time.split("-");
                List<Date> beginAndEndTimeList = new ArrayList<>();
                for (String hourAndMinute : beginAndEndTime) {
                    String[] hourMinuteStrings = hourAndMinute.split(":");
                    Integer hour = Integer.parseInt(hourMinuteStrings[0]);
                    Integer minute = Integer.parseInt(hourMinuteStrings[1]);
                    Date date = new Date();
                    date.setHours(hour);
                    date.setMinutes(minute);
                    beginAndEndTimeList.add(date);
                }
                timePeriod.add(beginAndEndTimeList);
            }
        } catch (Exception e) {
            return null;
        }
        return timePeriod;
    }

}
