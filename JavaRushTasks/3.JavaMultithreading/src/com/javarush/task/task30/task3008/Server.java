package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Handler;

/**
 * Created by ilafedoseev on 06/07/2017.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Enter port number");
        int portNumber = ConsoleHelper.readInt();

        ServerSocket serverSocket = new ServerSocket(portNumber);
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            serverSocket.close();
            ConsoleHelper.writeMessage("Server socket has been closed!");
        }
    }

    public static void sendBroadcastMessage(Message message){
        for (Map.Entry<String, Connection> nameConnection : connectionMap.entrySet()) {
            try {
                nameConnection.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Something has happened wtih "
                        + nameConnection.getKey());
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }
}
