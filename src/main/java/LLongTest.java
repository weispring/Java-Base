import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

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


        new Integer(10);
        new Long(10).hashCode();


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
     *
     *
     */
    public void testValueCache(){
        Integer.valueOf(1);
        Long.valueOf(1L);
        Byte.valueOf((byte)2);
        Short.valueOf((short) 1);
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
}
