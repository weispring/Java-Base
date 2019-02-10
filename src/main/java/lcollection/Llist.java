package lcollection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * Created by lixianchun on 2018/12/6.
 **/
@Slf4j
public class Llist {


    /**
     *
     性能
     1.数组扩容
     这是对ArrayList效率影响比较大的一个因素。
     每当执行Add、AddRange、Insert、InsertRange等添加元素的方法，都会检查内部数组的容量是否不够，不够就扩容，将旧元素Copy到新数组中，然后丢弃旧数组
     设置合适大小，避免多次扩容，占用过多内存
     正确的预估可能的元素，并且在适当的时候调用TrimSize清除不用内存

     2.频繁的调用IndexOf、Contains等方法（Sort、BinarySearch等方法经过优化，不在此列）
     ArrayList是动态数组，它不包括通过Key或者Value快速访问的算法，所以实际上调用IndexOf、Contains等方法是执行的简单的循环来查找元素，建议使用Hashtable或SortedList等键值对的集合。

     3.数组结构的优点是便于对集合进行快速的随机访问，如果经常需要根据索引位置访问集合中的对象，使用由ArrayList类实现的List集合的效率较好。数组结构的缺点是向指定索引位置插入对象和删除指定索引位置对象的速度较慢，如果经常需要向List集合的指定索引位置插入对象，或者是删除List集合的指定索引位置的对象，使用由ArrayList类实现的List集合的效率则较低，并且插入或删除对象的索引位置越小效率越低，原因是当向指定的索引位置插入对象时，会同时将指定索引位置及之后的所有对象相应的向后移动一位。

     4.迭代器，需要移动指针操作，即next()方法（所有迭代器都是如此）
     */

    @Test
    public void testList(){
        List list = new ArrayList();
    }

    @Test
    public void testVector(){

        /**
         * 与ArrayList 类似，线程安全，扩容增加1倍，也可以自定义扩容值，构造方法如下
         *  public Vector(int initialCapacity, int capacityIncrement) {
         *         super();
         *         if (initialCapacity < 0)
         *             throw new IllegalArgumentException("Illegal Capacity: "+
         *                     initialCapacity);
         *         this.elementData = new Object[initialCapacity];
         *         this.capacityIncrement = capacityIncrement;
         *     }
         */
        Vector<String> vector = new Vector<>();

        HashMap<String,Object> map = null;
        String a = new String();
        a.hashCode();


    }

    @Test
    public void testBitSet(){
        BitSet bitSet = new BitSet();
        bitSet.set(11);
        bitSet.set(8);

        boolean  flag1 = bitSet.get(11);
        boolean  flag2 = bitSet.get(8);

        boolean  flag3 = bitSet.get(5);

        int a = 1 << 32;

        a = a << 1;

        a = a << 1;
        a = a << 1;





        log.info("");
    }




}
