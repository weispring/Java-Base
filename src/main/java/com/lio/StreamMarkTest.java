package com.lio;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author lixianchun
 * @Description
 * @date 2019/5/30 19:47
 */
public class StreamMarkTest {
    public static void main(String[] args) throws Exception{

        /**
         * 根据JAVA官方文档的描述，mark(int readlimit)方法表示，标记当前位置，并保证在mark以后最多可以读取readlimit字节数据，mark标记仍有效。如果在mark后读取超过readlimit字节数据，mark标记就会失效，调用reset()方法会有异常。
         但实际的运行情况却和JAVA文档中的描述并不完全相符。 有时候在BufferedInputStream类中调用mark(int readlimit)方法后，即使读取超过readlimit字节的数据，mark标记仍有效，仍然能正确调用reset方法重置。

         事实上，mark在JAVA中的实现是和缓冲区相关的。只要缓冲区够大，mark后读取的数据没有超出缓冲区的大小，mark标记就不会失效。如果不够大，mark后又读取了大量的数据，导致缓冲区更新，原来标记的位置自然找不到了。

         因此，mark后读取多少字节才失效，并不完全由readlimit参数确定，也和BufferedInputStream类的缓冲区大小有关。 如果BufferedInputStream类的缓冲区大小大于readlimit，在mark以后只有读取超过缓冲区大小的数据，mark标记才会失效。
         */
        try {
            // 初始化一个字节数组，内有5个字节的数据
            byte[] bytes={1,2,3,4,5};
            // 用一个ByteArrayInputStream来读取这个字节数组
            ByteArrayInputStream in=new ByteArrayInputStream(bytes);
            // 将ByteArrayInputStream包含在一个BufferedInputStream，并初始化缓冲区大小为2。
            BufferedInputStream bis=new BufferedInputStream(in,2);
            // 读取字节1
            System.out.print(bis.read()+",");
            // 在字节2处做标记，同时设置readlimit参数为1
            // 根据JAVA文档mark以后最多只能读取1个字节，否则mark标记失效，但实际运行结果不是这样
            System.out.println("mark");
            bis.mark(1);

            /*
             * 连续读取两个字节，超过了readlimit的大小，mark标记仍有效
             */
            // 连续读取两个字节
            System.out.print(bis.read()+",");
            System.out.print(bis.read()+",");
            // 调用reset方法，未发生异常，说明mark标记仍有效。
            // 因为，虽然readlimit参数为1，但是这个BufferedInputStream类的缓冲区大小为2，
            // 所以允许读取2字节
            System.out.println("reset");
            bis.reset();

            /*
             * 连续读取3个字节，超过了缓冲区大小，mark标记失效。
             * 在这个例子中BufferedInputStream类的缓冲区大小大于readlimit,
             * mark标记由缓冲区大小决定
             */
            // reset重置后连续读取3个字节，超过了BufferedInputStream类的缓冲区大小
            System.out.print(bis.read()+",");
            System.out.print(bis.read()+",");
            System.out.print(bis.read()+",");
            // 再次调用reset重置，抛出异常，说明mark后读取3个字节，mark标记失效
            System.out.println("reset again");
            bis.reset();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}

