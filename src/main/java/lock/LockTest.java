package lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockTest {
    @Test
    public void testUnsafe() {
        log.info("unsafe begin");
        Unsafe unsafe = UnsafeUtils.getUnsafe();
        Thread currThread = Thread.currentThread();


        unsafe.unpark(currThread);
        unsafe.unpark(currThread);
        unsafe.unpark(currThread);

        log.info("unsafe park begin");
        unsafe.park(false, 0);
        log.info("unsafe park end");

        System.out.println("SUCCESS!!!");
    }


    @Test
    public void testUnsafeInterrupt() {
        Unsafe unsafe = UnsafeUtils.getUnsafe();

        Thread currThread = Thread.currentThread();
        new Thread(()->{
            try {
                log.info("new thread ");
                Thread.sleep(3000);
                log.info("sleep end ");
                currThread.interrupt();
                //unsafe.unpark(currThread);
            } catch (Exception e) {}
        }).start();
        log.info("main thread park ");
        unsafe.park(false, 0);
        log.info("SUCCESS!!!");

    }


    @Test
    public void testUnsafeParkTime() {
        Unsafe unsafe = org.springframework.objenesis.instantiator.util.UnsafeUtils.getUnsafe();
        //相对时间后面的参数单位是纳秒
        log.info("begin park");
        //false 相对时间 纳秒，true 绝对时间 毫秒
        unsafe.park(false, 3000000000L);
        log.info("end park");
        log.info("SUCCESS!!!");


    }

    @Test
    public void testReentrantLock() throws Exception{
        ReentrantLock reentrantLock = new ReentrantLock();
        //状态设置为1，重入累加
        reentrantLock.tryLock(100, TimeUnit.SECONDS);
        //状态设置为0，unpark下一个线程
        reentrantLock.unlock();
    }


}
