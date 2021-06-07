package com.jietang;


import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.MapContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

//cpu_load_short,host=server02 value=0.67
//cpu_load_short,host=server02,region=us-west value=0.55 1422568543702900257
//cpu_load_short,direction=in,host=server01,region=us-west value=2.0 1422568543702900257
public class JxlTest {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
      //  df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parse = null;
        try {
            parse = df.parse("2021-02-25T15:00:00Z");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse.getTime());

    }


    private static void writeData() {
        JexlContext jc = new MapContext();
        jc.set("KEY_3",1.1d);
        jc.set("KEY_4",2.2d);
        jc.set("KEY_5",1.3d);
        jc.set("KEY_6",1d);
        CalExpression("3*4*5+6",jc);

    }

    public static double CalExpression(String jexlExpStr, JexlContext jc) {
        try {
            // 创建表达式对象
            StringBuffer jexlExp = new StringBuffer(jexlExpStr);
            for (int i = 0; i < jexlExp.length() - 1; i++) {
                System.out.print(jexlExp.charAt(i));
                //数字变量无法正确识别，统一在变量前面加“KEY_”
                //如果前一个字符是符号，自己是数字或字母 表示是个变量
                if (!Character.isLetterOrDigit(jexlExp.charAt(i)) && Character.isLetterOrDigit(jexlExp.charAt(i + 1))) {
                    jexlExp.insert(i + 1, "KEY_");
                    i = i + 4;
                } else if (Character.isLetterOrDigit(jexlExp.charAt(i)) && i == 0) {
                    //如果第一个字符就是数字
                    jexlExp.insert(i, "KEY_");
                    i = i + 4;
                }
            }
            double value = (double) new JexlBuilder().create().createExpression(jexlExp.toString()).evaluate(jc);
            System.out.println(value);
            return value;
        } catch (Exception e) {
            System.out.println(String.format("标签统计逻辑表达式【%s】执行错误%s", jexlExpStr, e.getMessage()));
            return 0d;
        }
    }

}
