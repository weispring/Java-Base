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
}
