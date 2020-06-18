package com.socket;

/**
 * Author: lixianchun
 * Date: 2019/3/1
 * Description:
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
@Slf4j
public class TestUDP {

    @Test
    public void send() throws Exception {
        String str = "Hello";
        DatagramPacket pack = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"), 10000);

        DatagramSocket scoket = new DatagramSocket();
        for (int i = 0; i < 10; i++) {
            scoket.send(pack);
            log.info("发送：{}",pack);
        }


        scoket.close();
    }

    @Test
    public void revice() throws Exception {

        byte[] by = new byte[1024];

        DatagramPacket pack = new DatagramPacket(by, by.length);

        DatagramSocket scoket = new DatagramSocket(10000);
        while (true) {
            scoket.receive(pack);

            System.out.println(new String(pack.getData()));

        }

    }

}