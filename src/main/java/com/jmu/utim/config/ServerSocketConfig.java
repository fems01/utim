package com.jmu.utim.config;



//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;

import java.io.*;
import java.net.Socket;

public class ServerSocketConfig extends Thread {

    private Socket socket;
    private Integer count;
    private Integer delCount;

    public ServerSocketConfig(Socket socket, Integer count, Integer delCount) {
        this.socket = socket;
        this.count = count;
        this.delCount = delCount;
    }

    @Override
    public void run() {
        DataInputStream input = null;
        try {
            // 设置连接超时9秒
            socket.setSoTimeout(20000);
            System.out.println("客户 - " + socket.getRemoteSocketAddress() + " -> 机连接成功");
            input = new DataInputStream(socket.getInputStream());
            try {
                while (true) {
                    String projectPath = System.getProperty("user.dir");
                    String imagePath = projectPath + File.separator + "logistics" + File.separator + "tomcat" + File.separator + "uploads" + File.separator;

                    byte[] bytes = new byte[17];
                    byte[] byteLen = new byte[16];
                    input.readFully(bytes);
                    input.readFully(byteLen);
                    String mac = new String(bytes);
                    System.out.println("mac:" + mac);
                    System.out.println("length:" + new String(byteLen).trim());
                    byte[] dataBytes = new byte[Integer.parseInt(new String(byteLen).trim())];
                    File file = new File(imagePath + mac);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    count++;
                    input.readFully(dataBytes);
                    DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream
                            (imagePath + mac + File.separator + count +".jpg"));
                    dataOutputStream.write(dataBytes);
                    System.out.println("count:" + count);
                }
            } catch (IOException | IllegalArgumentException e) {
                System.out.println("发生异常");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class DataFormException extends Throwable {
        public DataFormException(String s) {
            System.out.println(s);
        }
    }
}