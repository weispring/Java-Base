package com.lfile;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: lixianchun
 * Date: 2019/3/6
 * Description:
 */
public class CSVUtilsTest {

    /**
     * CSV文件生成方法
     * @param head
     * @param outPutPath
     * @param filename
     * @return
     */
    public static File createCSVFileHead(Object head,
                                     String outPutPath, String filename) {

        File csvFile = null;
        BufferedWriter csvWtriter = null;
        try {
            csvFile = new File(outPutPath + File.separator + filename + ".csv");
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            if (!csvFile.exists()){
                csvFile.createNewFile();
            }


            // GB2312使正确读取分隔符","
            csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                    csvFile), "GB2312"), 1024);
            // 写入文件头部
            writeHead(head, csvWtriter);

            csvWtriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvWtriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }



    /**
     * CSV文件生成方法
     * @param dataList
     * @param outPutPath
     * @param filename
     * @return
     */
    public static File createCSVFile(List<Object> dataList,
                                     String outPutPath, String filename) {

        File csvFile = null;
        BufferedWriter csvWtriter = null;
        try {
            csvFile = new File(outPutPath + File.separator + filename + ".csv");
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            if (!csvFile.exists()){
                csvFile.createNewFile();
            }


            // GB2312使正确读取分隔符","
            csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                    csvFile,true), "GB2312"), 1024);

            // 写入文件内容
            for (Object row : dataList) {
                writeHead(row, csvWtriter);
            }
            csvWtriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvWtriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }


    /**
     * 写一行数据方法
     * @param head
     * @param csvWriter
     * @throws IOException
     */
    private static void writeHead(Object head, BufferedWriter csvWriter) throws IOException {
        // 写入文件头部

        csvWriter.write(head.toString());
        csvWriter.newLine();
    }

    /**
     * 写一行数据方法
     * @param row
     * @param csvWriter
     * @throws IOException
     */
    private static void writeRow(List<Object> row, BufferedWriter csvWriter) throws IOException {
        // 写入文件头部
        for (Object data : row) {
            StringBuffer sb = new StringBuffer();
            String rowStr = sb.append("\"").append(data).append("\",").toString();
            csvWriter.write(rowStr);
        }
        csvWriter.newLine();
    }

    public static void main(String[] args) {
        String outPutPath = "./";
        String fileName = "test001";
        //createCSVFileHead(new Head(),outPutPath,fileName);
        List<Object> list = new ArrayList<>();
        list.add(new Data());
        createCSVFile(list,outPutPath,fileName);
    }


    @Setter
    @Getter
    public static class Head{

        @Override
        public String toString() {
            return  "id" + ',' + "name" + ',' + "money" +",";
        }
    }


    @Setter
    @Getter
    public static class Data{

        private String id;

        private String name;

        private Integer money;

        @Override
        public String toString() {
            return  id + ',' + name + ',' + money +",";
        }
    }
}