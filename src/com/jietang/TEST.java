package com.jietang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TEST {
    public static void main(String[] args) {
        String aaa = "1010-1011|1201-1203";
        String[] splitTime = aaa.split("\\|");
        List<String>  splitTimeList = new ArrayList<>();
        for (int i = 0; i < splitTime.length; i++) {
            if(splitTime[i].length() != 9){
                System.out.println(1111111);
            }
            StringBuffer stringBuffer = new StringBuffer(splitTime[i]);
            stringBuffer.insert(2,":");
            stringBuffer.insert(8,":");
            splitTimeList.add(stringBuffer.toString());
        }
        aaa = splitTimeList.stream().collect(Collectors.joining("|"));
        System.out.println(aaa);

    }
}
