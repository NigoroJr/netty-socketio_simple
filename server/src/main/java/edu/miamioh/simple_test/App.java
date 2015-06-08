package edu.miamioh.simple_test;

import com.corundumstudio.socketio.listener.*;
import com.corundumstudio.socketio.*;

public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(3000);

        SocketIOServer server = new SocketIOServer(config);
        server.addEventListener("income", MyObj.class,
                new DataListener<MyObj>() {
            @Override
            public void onData(SocketIOClient cli, MyObj obj,
                    AckRequest ack) {
                System.out.printf("Player ID %d (of team %d) at (%d, %d)\n",
                        obj.player.id,
                        obj.player.teamId,
                        obj.player.coord.x,
                        obj.player.coord.y);
                System.out.printf("=> (%d, %d)\n", obj.newCoord.x, obj.newCoord.y);
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
