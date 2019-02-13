package ignore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: lixianchun
 * @Date: 2018/11/15 16:35
 * @Description:
 */
@Slf4j
public class TestJunit {

    @Test
    public void test(){

        //inheritableThreadLocals
        //InheritableThreadLocal
        int a = new AtomicInteger().get();
        log.info("测试：{}",1234);

        /**
         * 迭代 排序比较 modCount
         */
        List list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(new TestPojo(String.valueOf(i)));
        }
        Iterator<String> iterable = list.iterator();
        while (iterable.hasNext()){
            iterable.next();
            iterable.remove();
        }
        log.info("");

        Vector<String> vector = new Vector<>();



        Map<String,String> map = new HashMap<>();
        map.keySet().iterator();



    }


    @Getter
    @Setter
    @AllArgsConstructor
    private class TestPojo{
        private String name;

    }
}
