package edu.miamioh.simple_test;

import com.corundumstudio.socketio.listener.*;
import com.corundumstudio.socketio.*;

public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(3000);

        SocketIOServer server = new SocketIOServer(config);
        server.addEventListener("income", MyObjToSend.class,
                new DataListener<MyObjToSend>() {
            @Override
            public void onData(SocketIOClient cli, MyObjToSend obj,
                    AckRequest ack) {
                System.out.println("Received data from " + obj.id
                        + " in team " + obj.team);
            }
        });

        server.start();
        System.out.println("Server started");

        // Run "forever"
        try {
            Thread.sleep(Long.MAX_VALUE);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Stopping server");
        server.stop();
    }
}
