package com.lthread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NamedInheritableThreadLocal;
import org.springframework.core.NamedThreadLocal;

/**
 * Author: lixianchun
 * Date: 2019/3/5
 * Description:
 */
@Slf4j
public class ThreadLocalTest {


    private static final ThreadLocal<Integer> threadLocal = new NamedThreadLocal<>("NamedThreadLocal Integer");


    private static final ThreadLocal<Integer> inheritableThreadLocal = new NamedInheritableThreadLocal<>("InheritableThreadLocal Integer");

    public static void main(String[] args) {
        threadLocal.set(223344);
        inheritableThreadLocal.set(10101033);
        log.info("main 线程id：{}",Thread.currentThread().getId());
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("线程id：{}",Thread.currentThread().getId());
                log.info("integerThreadLocal：{}",inheritableThreadLocal.get());
                log.info("threadLocal：{}",threadLocal.get());
            }
        }).start();
    }


}
