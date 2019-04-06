package com.socket;

import lombok.extern.slf4j.Slf4j;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Author: lixianchun
 * Date: 2019/3/1
 * Description:
 */
@Slf4j
public class Client {

    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("localhost");//localhost为服务器IP
        int portsend = 1111;

        String sentence = "hello";
        byte[] data = sentence.getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length, address, portsend);
        DatagramSocket filesend = new DatagramSocket();
        filesend.send(packet);
        log.info("客户 发送：{}",sentence);



        byte[] data2 = new byte[1024];
        DatagramPacket packetfilename = new DatagramPacket(data2, data2.length);

        filesend.receive(packetfilename);
        log.info("客户 接受：{}",new String(packetfilename.getData()));
        System.out.println("Start file from server!");
        filesend.close();

    }
}
