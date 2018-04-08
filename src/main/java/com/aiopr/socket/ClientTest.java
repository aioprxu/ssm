package com.aiopr.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/1/23.
 */
public class ClientTest {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",9999);

        Scanner scanner = new Scanner(client.getInputStream());
//        scanner.useDelimiter("/n");
        if(scanner.hasNext()){
            System.out.println(scanner.next());
        }

        client.close();
    }
}
