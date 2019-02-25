package com.llang;

/**
 * Created by lixianchun on 2018/12/4.
 **/
public class LThreadLocal {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static InheritableThreadLocal<String> InheritableThreadLocal = new InheritableThreadLocal<>();

    /**
     * 那使用弱引用的好处呢？
     * 如果使用弱引用，那指向ThreadLocal@123456对象的引用就两个：TL_INT强引用，和ThreadLocalMap中Entry的弱引用。一旦TL_INT被回收，则指向ThreadLocal@123456的就只有弱引用了，在下次gc的时候，这个ThreadLocal@123456就会被回收。
     *
     * ThreadLocal@123456对象只是作为ThreadLocalMap的一个key而存在的，现在它被回收了，但是它对应的value并没有被回收，内存泄露依然存在！而且key被删了之后，变成了null，value更是无法被访问到了！针对这一问题，ThreadLocalMap类的设计本身已经有了这一问题的解决方案，那就是在每次get()/set()/remove()ThreadLocalMap中的值的时候，会自动清理key为null的value。如此一来，value也能被回收了。
     *
     * 既然对key使用弱引用，能使key自动回收，那为什么不对value使用弱引用？答案显而易见，假设往ThreadLocalMap里存了一个value，gc过后value便消失了，那就无法使用ThreadLocalMap来达到存储全线程变量的效果了。（但是再次访问该key的时候，依然能取到value，此时取得的value是该value的初始值。即在删除之后，如果再次访问，取到null，会重新调用初始化方法。）
     *
     * 内存泄露
     * 总结一下内存泄露（本该回收的无用对象没有得到回收）的原因：
     * 弱引用一定程度上回收了无用对象，但前提是开发者手动清理掉ThreadLocal对象的强引用（如TL_INT）。只要线程一直不死，ThreadLocalMap的key-value一直在涨。
     *
     * 解决方法：当某个ThreadLocal变量（比如：TL_INT）不再使用时，记得TL_INT.remove()，删除该key。
     *
     * 在上例中，ThreadLocalDemo持有static的ThreadLocal类型：TL_INT，导致TL_INT的生命周期跟ThreadLocalDemo类的生命周期一样长。意味着TL_INT不会被回收，弱引用形同虚设，所以当前线程无法通过ThreadLocalMap的防护措施清除TL_INT所对应的value（Integer）的强引用。
     *
     * 通常，我们需要保证作为key的TL_INT类型能够被全局访问到，同时也必须保证其为单例，因此，在一个类中将其设为static类型便成为了惯用做法。
     *
     */

    /**
     * 1. 所以对于不同的线程，每次获取副本值时，别的线程并不能获取到当前线程的副本值，形成了副本的隔离，互不干扰。
     * 2. 每次get()/set()/remove()ThreadLocalMap中的值的时候，会自动清理key为null的value。
     * 3. 如果一个线程要保存多个变量，就需要创建多个ThreadLocal，多个ThreadLocal放入Map中时会极大的增加Hash冲突的可能。
     * 4. ThreadLocal内部的ThreadLocalMap键为弱引用，会有内存泄漏的风险。
     * 5. 适用于无状态，副本变量独立后不影响业务逻辑的高并发场景。如果如果业务逻辑强依赖于副本变量，则不适合用ThreadLocal解决，需要另寻解决方案。

     * 特征：
     * 1.底层基于Entry[]实现，Entry继承了弱引用；key为ThreadLocal，放在引用队列里；value为真正需要存储的Object。
     * 2.初始容量（必须为2的次方）16，加载因子0.5（(2/3)*(3/4)），每次扩容为原理的2倍。
     * 3.采用开放定址法解决hash冲突。
     */

    /**
     * 使用InheritableThreadLocal可以将某个线程的ThreadLocal值在其子线程创建时传递过去。
     * 原理：
     */

    public void testInheritableThreadLocal(){
        //如何获取父线程的变量，Thread 中有如下方法
        /**
         *  private void init(ThreadGroup g, Runnable target, String name,
         *         long stackSize) {
         *             init(g, target, name, stackSize, null);
         *         }
         */



    }


}
