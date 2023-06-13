//package com.jmu.utim.component;
//
//import com.jmu.utim.config.ServerSocketConfig;
//import org.apache.tomcat.util.net.SocketProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//
//
//
//@Component
//public class TestRunner implements CommandLineRunner {
////
////    @Autowired
////    private SocketProperties properties;
//
//    @Override
//    public void run(String... args) throws Exception {
//        ServerSocket server = null;
//        Socket socket = null;
//        server = new ServerSocket(10097);
//        System.out.println("设备服务器已经开启, 监听端口:" + 10097);
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(
//                10,
//                30,
//                20,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<Runnable>(10),
//                new ThreadPoolExecutor.DiscardOldestPolicy()
//        );
//        while (true) {
//            socket = server.accept();
//            pool.execute(new ServerSocketConfig(socket,0,1));
//        }
//    }
//}