package com.ignore;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
public class CommonTest {
    @Test
    public void testResult() throws Exception{
        boolean flag = true;
        flag = false;
        flag |= false;
        long a = 4;

        a = (1L << 4); // Restores invariants
        BitSet bitSet = new BitSet();
        bitSet.set(2);
        bitSet.set(4);

        boolean g = bitSet.get(6);

        //Float
        //ff800000
        log.info("-------------");
        String result = null;
        log.info(":{}",result);

        int j = 0;
    }
    @Test
    public void testL(){
        int a = 2;
        a = (a >>> -1);
        a = (a >>> -2);
        log.info("xxx : {}",Long.toBinaryString(a));
    }


    @Test
    public void testList() throws Exception{
        List<String> l = Arrays.asList("2","3","4","5");
        List<String> list = new ArrayList<>(l);
        for (int i=0;i<list.size();i++){
			/*Iterator iterator = list.iterator();
			while (iterator.hasNext()){
				log.info("当前值：{}",iterator.next());
			}*/
            for (String a : list){
                log.info("当前值：{}",a);
                list.add(a);
            }
        }
        log.info(":{}","");
    }

    @Test
    public void testEnum() throws Exception {
        //BitM
        //Collections.synchronizedList();
        Set<String> set = new HashSet<>();
        HashMap<String,Object> map  = new HashMap();
        TestEnum testEnum1 = TestEnum.TEST_1;
        TestEnum testEnum2 = TestEnum.TEST_2;
        TestEnum testEnum3 = TestEnum.TEST_3;
        log.info(testEnum1.toString() + ":" + testEnum1.name());
    }

}
