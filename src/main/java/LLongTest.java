import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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





    }

    /**
     * String 固定数组，操作产生新的对象
     *
     * 可扩容数据
     * StringBuffer 线程安全
     * StringBuilder 线程不安全
     * 两者相似
     *
     */
    @Test
    public void testString(){
        String a = "";
        String bb = a.replace("","");

       /* replaceFirst
        toLowerCase
        format*/

        //bb.hashCode()



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
