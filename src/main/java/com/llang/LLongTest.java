package com.llang;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: lixianchun
 * @Date: 2018/11/24 18:12
 * @Description:
 */
@Slf4j
public class LLongTest {


    @Test
    public void test(){

        /**
         * 先除100 取各位和十位
         * 再除100
         * 除10 取个位
         * //    static void getChars(long i, int index, char[] buf) {
         */
        Long.toString(117L);
        System.out.println("-------");
        new Long("34567");

        //CharacterDataLatin1

        Boolean boolFlag = new Boolean("true");
        //return value ? 1231 : 1237;
        boolFlag.hashCode();

        Byte b = new Byte((byte) 121);
        //return (int)value;
        b.hashCode();


        int x = 1;
        x <<= 3;
        log.info("结果：{}",x);

        x = (int)(13441>>> 32);
        log.info("结果：{}",x);

       int dddd = "10000100000000000000000000000000".length();

       // int bb = 27 - Integer.valueOf("10000100000000000000000000000000",2).intValue() ;



        log.info("--{}",Integer.MIN_VALUE);

        new Integer(10);
        new Long(10).hashCode();

        //AtomicInteger cas
        //AtomicLong 可并行，多个cell
    }

    /**
     * 1. 四种整形包装类皆有缓存，-128 - 127，Integer 可以通过jvm参数配置 最大值大于127
     *
     * 在-128~127的Integer值并且以Integer x = value;的方式赋值的Integer值在进行==和equals比较时，都会返回true，
     * 因为Java里面对处在在-128~127之间的Integer值，用的是原生数据类型int，会在内存里供重用，也就是说这之间的Integer值进行==比较时只是进行int原生数据类型的数值比较，
     * 而超出-128~127的范围，进行==比较时是进行地址及数值比较。
     *
     * 2. 四种包装类型的hashCode 都和value有关
     * 3. 四种包装类型的equals方法都是值比较
     * 4. Number包装类和String互转
     * 5. Byte和Short较为简单，主要看Integer和Long
     *
     *
     */
    public void testValueCache(){
        Integer.valueOf(1);
        Long.valueOf(1L);
        Byte.valueOf((byte)2);
        Short.valueOf((short) 1);
        //Float



    }







    /**
     * problem
     */
    @Test
    public void testIntergePro(){

        String bb = "".replace("","");
        String[] a = {};
        String.format("",a);

        Integer.toHexString(1);
        Integer.toOctalString(1);
        Integer.toBinaryString(1);

    }


    /**
     * String 固定数组，操作产生新的对象
     *
     * 可扩容数据,初始容量为16初始容量为16，扩容后2n+2
     * StringBuffer 线程安全,toString会缓存char[] 数组
     * StringBuilder 线程不安全
     * 两者相似
     */
    @Test
    public void testString(){
        String a = "";
        String bb = a.replace("","");

       /* replaceFirst
        toLowerCase
        format*/

        //bb.hashCode()

    /*public StringBuilder(String str) {
            super(str.length() + 16);
            append(str);
        }*/
        StringBuffer aa = new StringBuffer();
        StringBuilder b = new StringBuilder();



    }


    @Test
    public void testQu(){
        String format = "i am %s , come from %s ";
        List<String> messages = new ArrayList<>(5);
        messages.add("lichun");
        messages.add("china");
        String result = String.format(format,messages.toArray());
        log.info("result :{}",result);
    }
}
