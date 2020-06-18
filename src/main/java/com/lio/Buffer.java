package com.lio;

/**
 * @author lixianchun
 * @Description
 * @date 2019/5/30 19:12
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Buffer {


    public static void bufferStream() throws Exception {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D://a.docx"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D://a复制.doc"));
        int b = 0;
        long start = System.currentTimeMillis();
        while ((b = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(b);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("缓冲花费时间：" + (end - start) + " ms");
    }

    public static void stream() throws Exception {
        FileInputStream fis = new FileInputStream("d://a.docx");
        FileOutputStream fos = new FileOutputStream("D://复制a.docx");
        int b = 0;
        long start = System.currentTimeMillis();

        while ((b = fis.read()) != -1) {
            fos.write(b);
        }

       /* byte[] buf = new byte[8192];
        while ((b = fis.read(buf)) != -1) {
            fos.write(buf,0,b);
        }*/
        fis.close();
        fos.close();
        long end = System.currentTimeMillis();
        System.out.println("非缓冲花费时间：" + (end - start) + "ms");
    }

    public static void main(String[] args) throws Exception {
        /**
         * 本质差异 批量与单个
         * read(byte[]) 与read()
         * write(byte[]) 与write(byte)
         *
         */
        bufferStream();
        stream();
    }
}