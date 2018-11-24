import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Auther: lixianchun
 * @Date: 2018/11/24 16:01
 * @Description:
 */
@Slf4j
public class RunTimeTest {
    /**
     * System
     * Object
     * Class
     * Runtime
     * Arrays
     *
     */




    @Test
    public void test() throws Exception{

        /**
         * 初始化 System.initializeSystemClass();
         *
         *
         */
        System.arraycopy(null,0,null,0,1);
        System.getProperties();
        System.gc();
        System.loadLibrary("");
        System.exit(0);


        //空闲内存
        System.out.println("free:" + Runtime.getRuntime().freeMemory() / 1024
                / 1024);
        //当前可用内存
        System.out.println("total:" + Runtime.getRuntime().totalMemory() / 1024
                / 1024);
        //最大可用内存
        System.out.println("max:" + Runtime.getRuntime().maxMemory() / 1024
                / 1024);
        //执行命令
        System.getProperties().get("");
        System.exit(0);

        Runtime.getRuntime().exec("");
        Runtime.getRuntime().exit(0);
        Runtime.getRuntime().gc();

        Arrays

    }

    @Test
    public void testHashCode(){

        A a = new A();
        a.setA("111");

        A b = new A();
        b.setA("111");

        log.info("结果hashcode:{}, equals :{}",a.hashCode()==b.hashCode(),a.equals(b));

        log.info("---: {}", getClass().getTypeName());

        Object obj = new Object();
        obj.hashCode();
    }


    @Setter
    class A {
        private String a;

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return a.equals(((A)obj).a);
        }
    }


    @Test
    public void testMemory() {

        System.out.println("free:" + Runtime.getRuntime().freeMemory() / 1024
                / 1024);
        System.out.println("total:" + Runtime.getRuntime().totalMemory() / 1024
                / 1024);
        System.out.println("max:" + Runtime.getRuntime().maxMemory() / 1024
                / 1024);
        System.out.println("=============");
        long t = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        String[] aaa = new String[2000000];

        System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
        System.out.println("=============");
        try {
            Thread.sleep(3000);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        for (int i = 0; i < 2000000; i++) {
            aaa[i] = new String("aaa");
        }
        System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
        System.out.println("=============");
        try {
            Thread.sleep(30000);
        } catch (Exception ee) {
            ee.printStackTrace();
        }

    }
}
