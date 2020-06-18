package com.llang;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RandomTest  {

    public static void main(String[] args) {
        final DateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        ExecutorService ts = Executors.newFixedThreadPool(100);
        for (;;) {
            ts.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //生成随机数，格式化日期
                        String format =  df.format(new Date(Math.abs(new Random().nextLong())));
                        System.out.println(format);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
            });
        }
    }


    @Test
    public void test(){

        Random random = new Random();
        random.nextInt(10);


        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if("2".equals(temp)){
                a.remove(temp);
            }
        }
       /* LockSupport
        ReentrantLock*/
    }
}
