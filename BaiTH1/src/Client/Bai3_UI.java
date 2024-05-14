package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Bai3_UI extends JFrame {
    private JTextArea chatTextArea;
    private JTextField messageTextField;
    private JButton sendButton;

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    private int clientID;
    
    public Bai3_UI() {
        setTitle("Chat Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatTextArea = new JTextArea();
        chatTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        messageTextField = new JTextField();
        inputPanel.add(messageTextField, BorderLayout.CENTER);

        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);

        connectToServer();
        receiveMessages();
    }

    private void connectToServer() {
        try {
            socket = new Socket("localhost", 7000); // Thay localhost và cổng nếu cần
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
         // Nhận ID từ server
            clientID = dis.readInt();
            chatTextArea.append("Currently you're client " + clientID + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String message = messageTextField.getText();
        try {
            dos.writeUTF("Client " + clientID + ": " + message);
            dos.flush();
            messageTextField.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receiveMessages() {
        Thread receiveThread = new Thread(() -> {
            try {
                while (true) {
                    String message = dis.readUTF();
                    chatTextArea.append(message + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        receiveThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Bai3_UI();
            }
        });
    }
}
