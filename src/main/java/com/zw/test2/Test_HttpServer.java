package com.zw.test2;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

public class Test_HttpServer {
    public static void main(String[] arg) throws Exception {
        com.sun.net.httpserver.HttpServer server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(8001), 0);
        server.createContext("/test", new TestHandler());
        server.start();
    }

    static class TestHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            System.out.println("TestHandler ......");
            URI uri = exchange.getRequestURI();
            System.out.println("uri: " + uri);
            String response = "hello world";
            exchange.sendResponseHeaders(200, 0);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
