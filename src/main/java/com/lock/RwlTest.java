package com.lock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class RwlTest {

    static final int SHARED_SHIFT   = 16;
    static final int SHARED_UNIT    = (1 << SHARED_SHIFT);
    static final int MAX_COUNT      = (1 << SHARED_SHIFT) - 1;
    static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;

    /**
     *  无法进行锁升级
     */
    @Test
    public void testReentrantReadWriteLockStronger(){
        log.info("SHARED_SHIFT：{}",SHARED_SHIFT);

        log.info("SHARED_UNIT：{}",SHARED_UNIT);

        log.info("MAX_COUNT：{}",MAX_COUNT);
        log.info("EXCLUSIVE_MASK：{}",Integer.toBinaryString(EXCLUSIVE_MASK));
        System.out.print(System.currentTimeMillis());

        ReadWriteLock rtLock = new ReentrantReadWriteLock();
        rtLock.readLock().lock();
        System.out.println("get readLock.");
        rtLock.writeLock().lock();
        System.out.println("blocking");
    }


    /**
     * 锁降级
     */
    @Test
    public void testReentrantReadWriteLockWeaker(){
        ReadWriteLock rtLock = new ReentrantReadWriteLock();
        rtLock.writeLock().lock();
        System.out.println("writeLock");

        rtLock.readLock().lock();
        System.out.println("get read lock");
        rtLock.writeLock().unlock();
        log.info("释放写锁：{}");
    }


    @Getter
    @Setter
    @AllArgsConstructor
    public static class CachedData {
        Object data;
        //保证状态可见性
        volatile boolean cacheValid;
        public static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    }

    @Test
    public void testCacheData(){
        CachedData cachedData = new CachedData("0000",false);//模拟获取到的数据
        CachedData.rwl.readLock().lock();
        if (!cachedData.cacheValid) {
            // 在获取写锁前必须释放读锁
            CachedData.rwl.readLock().unlock();
            CachedData.rwl.writeLock().lock();
            //再次检查其他线程是否已经抢到
            if (!cachedData.cacheValid) {
                //获取数据
                cachedData.setData("---");
                cachedData.cacheValid = true;
            }
            // 在释放写锁之前通过获取读锁来降级
            CachedData.rwl.readLock().lock();
            //释放写锁，保持读锁
            CachedData.rwl.writeLock().unlock();
        }

        //use(data);
        CachedData.rwl.readLock().unlock();
    }

}
