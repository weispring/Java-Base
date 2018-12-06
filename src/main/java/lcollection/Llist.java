package lcollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixianchun on 2018/12/6.
 **/
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

     4.迭代器
     */

    @Test
    public void testList(){
        List list = new ArrayList();

    }

}
