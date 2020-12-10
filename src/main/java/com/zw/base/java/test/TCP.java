package com.zw.base.java.test;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP {
    public static void main(String[] args) {
        Client client = new Client();
        Server server = new Server();
        new Thread(() -> {
            client.start();
        }).start();
        new Thread(() -> {
            server.start();
        }).start();

        while (Thread.activeCount() > 1) {
            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Client {
        public void start() {
            try {
                Socket socket = new Socket();
                InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
                socket.connect(inetSocketAddress);
                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

                String[] arr = {
                        "hello\r\n", "world\r\n", "end\r\n"
                };

                for (String s : arr) {
                    outputStreamWriter.write(s);
                }

                outputStreamWriter.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static class Server {
        private volatile boolean isStop = false;

        public void start() {
            try {
                System.out.println("bbb bbb ......");
                ServerSocket serverSocket = new ServerSocket();
                InetSocketAddress endpoint = new InetSocketAddress("127.0.0.1",6666);
                serverSocket.bind(endpoint);

                while (!isStop) {
                    Socket socket = serverSocket.accept();
                    new Thread(new SocketOP(socket)).start();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private static class SocketOP implements Runnable {
        private Socket socket;

        public SocketOP(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                System.out.println("aaa aaa ......");
                InputStream inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while (!"end".equalsIgnoreCase((line = bufferedReader.readLine()))) {
                    System.out.println(line);
                }

                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
