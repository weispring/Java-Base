package com.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: lixianchun
 * Date: 2019/3/9
 * Description:
 */
@Slf4j
public class TestCondition {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    public static void main(String[] args) {


        new TestCondition().testCondition();

        log.info("{}",CAPACITY);
        log.info("{}",RUNNING);
        log.info("{}",SHUTDOWN);

        log.info("{}",STOP);
        log.info("{}",TIDYING);
        log.info("{}",TERMINATED);

        log.info("{}",Integer.parseInt("01100000000000000000000000000000",2));

        log.info("{},{}",Integer.toBinaryString(RUNNING),RUNNING);


    }

    class BoundedBuffer {
        final Lock lock = new ReentrantLock();
        //条件锁
        final Condition notFull  = lock.newCondition();
        final Condition notEmpty = lock.newCondition();

        final Object[] items = new Object[10];
        int putptr, takeptr, count;

        public void put(Object x) throws InterruptedException {
            lock.lock();
            try {
                while (count == items.length)
                    notFull.await();
                log.info("放入：{}",x);
                items[putptr] = x;
                if (++putptr == items.length) putptr = 0;
                ++count;
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            lock.lock();
            try {
                while (count == 0)
                    notEmpty.await();
                Object x = items[takeptr];
                if (++takeptr == items.length) takeptr = 0;
                --count;
                notFull.signal();
                log.info("取出：{}",x);
                return x;
            } finally {
                lock.unlock();
            }
        }
    }

    public void testCondition() {
        BoundedBuffer boundedBuffer = new BoundedBuffer();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 30,
                1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(100));
        //threadPoolExecutor.submit()
        for (int i=0;i<50;i++){
            new Thread(()-> {
                try {
                    boundedBuffer.take();
                } catch (InterruptedException e) {
                    log.info("异常：{}",e);
                }
            }).start();

            new Thread(()-> {
                try {
                    boundedBuffer.put(boundedBuffer);
                } catch (InterruptedException e) {
                    log.info("异常：{}",e);
                }
            }).start();
        }
        log.info("创建完毕");
    }


}
