package lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private final static Logger log = LoggerFactory.getLogger(LockTest.class);

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
        try{
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
        }catch (Exception e){
            log.info("{}",e);
        }


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


    private static Integer a = new Integer(1);


    /**
     * 线程阻塞
     * @throws Exception
     */
    @Test
    public void testParLkUntil() throws InterruptedException{

        log.info("正常开始");

        log.info("正常结束");

        log.info("异常开始");
        //也能阻塞，最大值 999
        LockSupport.parkNanos(90000000000L);
        log.info("异常结束");


        new Thread(()->{
            log.info("线程2阻塞");
            //该锁不必须是已经被占用
            LockSupport.parkUntil(a,System.currentTimeMillis() + 30000);
            log.info("线程2阻塞结束");
        }).start();

        log.info("主线程sleep");
        Thread.currentThread().sleep(33000);
        log.info("主线程sleep end ");
    }


    /**
     * 解除阻塞
     * @throws Exception
     */
    @Test
    public void testUnparkTime() throws Exception{

/*        Thread thread = new Thread(()->{
            log.info("线程0阻塞");
            synchronized(a){
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("线程0阻塞结束");
        });
        thread.start();
        thread.join(100);*/

        Thread thread1 = new Thread(()->{
            log.info("线程1阻塞");

            LockSupport.parkNanos(a,30000000000L);

            log.info("线程1阻塞结束");
        });
        thread1.start();
        new Thread(()->{
            log.info("线程2阻塞");
            LockSupport.parkNanos(a,30000000000L);
            log.info("线程2阻塞结束");
        }).start();
        log.info("主线程sleep");
        Thread.currentThread().sleep(1000);
        //接触阻塞
        LockSupport.unpark(thread1);

        Thread.currentThread().sleep(33000);
        log.info("主线程sleep end ");
    }

}
