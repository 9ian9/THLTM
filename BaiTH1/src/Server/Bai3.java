package Server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Bai3 {
    // Danh sách các client kết nối
    private static List<ClientHandler> clients = new ArrayList<>();
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(7000);
            System.out.println("Server is started");
            
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket);
                
                // Tạo một luồng riêng biệt để xử lý kết nối của client này
                ClientHandler clientHandler = new ClientHandler(socket);
                // Thêm client mới vào danh sách
                clients.add(clientHandler);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Phương thức để gửi tin nhắn đến tất cả các client khác
    public static void sendMessageToAllClients(String message, ClientHandler sender) throws IOException {
        for (ClientHandler client : clients) {
            // Gửi tin nhắn đến tất cả các client khác, trừ chính client gửi tin nhắn này
        	client.sendMessage(message);
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;
    private DataInputStream din;
    private DataOutputStream dos;
    private static int nextClientID = 1;
    private int clientID = nextClientID++;
    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            din = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeInt(clientID);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                String message = din.readUTF();
                System.out.println(message);
                
                // Gửi tin nhắn này đến tất cả các client khác
                Bai3.sendMessageToAllClients(message, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Đóng luồng và socket khi client ngắt kết nối
                din.close();
                dos.close();
                socket.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Phương thức để gửi tin nhắn đến client
    public void sendMessage(String message) throws IOException {
        dos.writeUTF(message);
        dos.flush();
    }
}
