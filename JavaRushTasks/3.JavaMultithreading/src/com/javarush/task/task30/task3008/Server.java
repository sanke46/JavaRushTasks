package com.javarush.task.task30.task3008;

import com.javarush.task.task30.task3008.client.Client;

import java.io.Console;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
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

    public static void sendBroadcastMessage(Message message) {
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

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            boolean accepted = false;
            String name = null;

            while (!accepted) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME) {
                    name = message.getData();
                    if (!name.isEmpty() && connectionMap.get(name) == null) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        accepted = true;
                    }
                }
            }
            return name;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String clientName : connectionMap.keySet()) {
                if(!clientName.equals(userName)){
                    connection.send(new Message(MessageType.USER_ADDED, clientName));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            Message message;
            while (true){
                message = connection.receive();
                if(MessageType.TEXT.equals(message.getType())){
                    sendBroadcastMessage(new Message(MessageType.TEXT,userName + ": " + message.getData()));
                }
            }
        }

        public void run() {
            String userName = "";
            Message message;
            SocketAddress remoteAddress = socket.getRemoteSocketAddress();

            ConsoleHelper.writeMessage("Соединение Установленно: " + remoteAddress);
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                message = new Message(MessageType.USER_ADDED,userName);
                sendBroadcastMessage(message);
                sendListOfUsers(connection,userName);
                serverMainLoop(connection,userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Ошибка обмена с удаленным адресом");
                e.printStackTrace();
            }

            if(!"".equals(userName)){
                connectionMap.remove(userName);
                message = new Message(MessageType.USER_REMOVED,userName);
                sendBroadcastMessage(message);
            }

            ConsoleHelper.writeMessage("Соединение завершено: " + remoteAddress);
        }
    }
}


