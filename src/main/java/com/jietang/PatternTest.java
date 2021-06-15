package com.jietang;


import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.MapContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;

//cpu_load_short,host=server02 value=0.67
//cpu_load_short,host=server02,region=us-west value=0.55 1422568543702900257
//cpu_load_short,direction=in,host=server01,region=us-west value=2.0 1422568543702900257
public class PatternTest {
    public static void main(String[] args) {
        String content = "3aaa3";
        //正则表达式，用于匹配非数字串，+号用于匹配出多个非数字串
        Pattern pattern = Pattern.compile("[^0-9]+");
        //用定义好的正则表达式拆分字符串，把字符串中的数字留出来
        String[] cs = pattern.split(content);
        System.out.println(Arrays.toString(cs));
    }

}
