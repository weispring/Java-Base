package com.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class CountDownLatchTest {

    /**
     * CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行。
     */
    @Test
    public void testCountDownLatch() {
        CountDownLatch countDownLatch = new CountDownLatch(5);
    }
}
