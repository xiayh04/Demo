package org.ihsp.data.component;

import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {



    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 10; i++) {

            Thread.sleep(300);
            Thread t = new Thread(new A(String.valueOf(i)));
            t.start();
        }

    }
}


class A implements Runnable {
    public static final String IP_ADDR = "127.0.0.1";// 服务器地址

    public static final int PORT = 4523;// 服务器端口号

    String s = "";

    public A(String st) {
        s = st;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        Socket socket = null;
        try {
            socket = new Socket(IP_ADDR, PORT);
            // 读取服务器端数据
            // DataInputStream input = new DataInputStream(socket.getInputStream());
            // 向服务器端发送数据
            // DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            out.print("validation request:mac=1000000");
            out.print("\r\n");
            // out.writeUTF("validation request:mac=1000000");
            out.flush();
            Thread.sleep(10000);
            // String ret = input.readUTF();
            // System.out.println("服务器端返回过来的是: " + ret);
            // if("pass".equals(ret)){
            // out.print(s);
            // out.print(s);
            // out.print(s);
            // out.print(s);
            // out.flush();
            // }else{
            // System.out.println("validation failed.");
            // }
            // out.writeUTF("quit");
            // out.close();
            // Thread.sleep(300);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } finally {
            /*
             * try { input.close(); } catch (IOException e) { // TODO Auto-generated catch block
             * e.printStackTrace(); }
             */
        }
    }
}
