package com.aiopr.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2018/1/23.
 */
public class SocketTest {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("等待客户端连接。。。。");
            Socket client = serverSocket.accept();
            PrintWriter printWriter = new PrintWriter(client.getOutputStream());
            printWriter.print("HelloWorld!!!");
            System.out.println("连接成功啦，我关机了！！！");
            printWriter.close();
            serverSocket.close();
        }
         catch (IOException e) {

            e.printStackTrace();
        }
    }
}
