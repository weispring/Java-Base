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
public class Server {

    public static void main(String[] args) throws Exception {

        System.out.println("Server Start Working!");

        int portsend = 1111;
        byte[] data = new byte[1024];
        DatagramSocket filereceive = new DatagramSocket(portsend);
        InetAddress address = InetAddress.getByName("localhost");//客户端IP
        DatagramPacket packet = new DatagramPacket(data, data.length);
        // 此方法在接收到数据报之前会一直阻塞
        filereceive.receive(packet);
        log.info("服务接受：{}",new String(packet.getData()));
        System.out.println("Server Connected With Client, Start TransForm File!");



        // 发送文件名和路径
        String sentence = "服务器回应";

        DatagramPacket packet2 = new DatagramPacket(sentence.getBytes(), sentence.getBytes().length,
                packet.getAddress(), packet.getPort());
        //filesend.connect(address, portsend);//可能会有用
        filereceive.send(packet2);
        log.info("服务 发送：{}",sentence);
        filereceive.close();
    }




}
