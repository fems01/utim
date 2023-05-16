package com.jmu.utim;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Thread(new Read()).start();
        //new Thread(new Writer()).start();
    }
}

class Read implements Runnable{
    @Override
    public void run() {
        try
        {
            Socket s = new Socket("192.168.2.195", 10097);
            try
            {
                InputStream inStream = s.getInputStream();
                Scanner in = new Scanner(inStream);

                while (in.hasNextLine())
                {
                    String line = in.nextLine();
                    System.out.println(line);
                }
            }
            finally
            {
                s.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

class Writer implements Runnable{

    @Override
    public void run() {
        try {
            Scanner sc = new Scanner(System.in);
            Socket s = new Socket("192.168.2.142", 8080);//端口和ip写自己的
            OutputStream outStream = s.getOutputStream();
            PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
            while(true){
                String s1 = sc.nextLine();
                if(!"close".equals(s1)){
                    out.println(s1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
