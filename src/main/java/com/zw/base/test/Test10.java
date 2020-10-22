package com.zw.base.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test10 {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add(0, "hello1");
        strs.add(1, "hello2");
        strs.add(1, "hello3");

        System.out.println("end ...... " + strs.get(1));

        //使用静态方法获取实例。只能格式化日期
        DateFormat df1 = DateFormat.getDateInstance();

        //只能格式化时间
        DateFormat df2 = DateFormat.getTimeInstance();

        //格式化日期时间
        DateFormat df3 = DateFormat.getDateTimeInstance();

        //要格式化的Date对象
        Date date = new Date();
        //使用format()格式化Date对象
        System.out.println(df1.format(date));
        System.out.println(df2.format(date));
        System.out.println(df3.format(date));

        //创建SimpleDateFormat对象，指定样式    2019-05-13 22:39:30
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //2019年的第133天。占位符是特定的
        SimpleDateFormat sdf2 = new SimpleDateFormat("y年的第D天");
        //要格式化的Date对象
        date = new Date();
        //使用format()方法格式化Date对象为字符串，返回字符串
        System.out.println(sdf1.format(date));
        System.out.println(sdf2.format(date));


        /////////////////
        date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH");
        String str = df.format(date);
        int a = Integer.parseInt(str);
        if (a >= 0 && a <= 6) {
            System.out.println("凌晨");
        }
        if (a > 6 && a <= 12) {
            System.out.println("上午");
        }
        if (a > 12 && a <= 13) {
            System.out.println("中午");
        }
        if (a > 13 && a <= 18) {
            System.out.println("下午");
        }
        if (a > 18 && a <= 24) {
            System.out.println("晚上");
        }
    }
}
