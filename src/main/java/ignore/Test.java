package ignore;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Auther: lixianchun
 * @Date: 2018/11/15 14:51
 * @Description:
 */

@Slf4j
public class Test {

    public static void main(String[] args) {
        long sequenceMask = ~(-1L << 12);
        Long a = -1L;
        System.out.println(Long.toBinaryString(22L));
        System.out.println(Long.toBinaryString(sequenceMask));

        System.out.println(new Date(1403854494756L));


    }


    @org.junit.Test
    public void test() {
 /*       StatisticsDto statisticsDto = new StatisticsDto();
        statisticsDto.setDate(1);

        statisticsDto.setDate(2);

        log.info("--");*/

        String a = "3333333344";
        if (a.contains("3")){
            log.info("--33");
        }else if (a.contains("4")){
            log.info("--44");
        }

        List<String> list = Arrays.asList("1","2","3");
        log.info(list.stream().findFirst().get());
        log.info(list.stream().findFirst().get());
        log.info(list.stream().findFirst().get());


    }
}
