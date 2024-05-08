package bai2;

import javax.swing.*;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Stack;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import java.awt.Component;
import java.awt.EventQueue;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class ServerGUI extends JFrame implements ActionListener {
    private JPanel contentPane;
    private ServerUDP serverUDP;
    private JTextField tfPort;
    private JLabel lbPort;
    private JButton btnOpen;
    private JScrollPane sp;
    private JTextArea textArea;
    private JButton btnClose;
   

	ServerGUI(){
        setTitle("Server");
        setDefaultCloseOperation((EXIT_ON_CLOSE));
        setSize(800, 504);
        setVisible(true);
        getContentPane().setLayout(null);
        
        lbPort = new JLabel("Mở cổng kết nối");
        lbPort.setBounds(81, 40, 123, 35);
        lbPort.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lbPort);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(21, 120, 736, 334);
        getContentPane().add(textArea);
        
        tfPort= new JTextField();
        tfPort.setBounds(194, 47, 278, 24);
        getContentPane().add(tfPort);
        tfPort.setColumns(10);
        
//        sp = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        sp.setBounds(0, 0, 0, 0);
//        getContentPane().add(sp);
//        
        
        btnOpen = new JButton("Open");
        btnOpen.setBounds(482, 42, 123, 35);
        getContentPane().add(btnOpen);
        btnOpen.addActionListener(this);
        
        btnClose = new JButton("Close");
        btnClose.setBounds(627, 42, 110, 35);
        getContentPane().add(btnClose);
        btnClose.setEnabled(false);
        btnClose.addActionListener(this);

    }
	public void writeTextArea(String text) {
		if(!text.isEmpty()) {
			textArea.append(text);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == btnOpen) {
			int port;
			try {
				port = Integer.parseInt(tfPort.getText());
			}catch(NumberFormatException exception) {
				System.out.println("Vui Long Nhap dung dinh dang so!!!");
				return;
			}
			serverUDP = new ServerUDP(port, Calculate::calculateExpression, (String content) ->{
				if (!content.isEmpty()) {
					writeTextArea("[Client] : " + content +"\n");
				}
			});
			serverUDP.start();
			writeTextArea("Dang lang nghe tu cong: "+ port +"\n");
			btnOpen.setEnabled(false);
			btnClose.setEnabled(true);
			
		}
		if (e.getSource() == btnClose) {
			if(serverUDP != null) {
				serverUDP.close();
				serverUDP = null;
				btnOpen.setEnabled(true);
				btnClose.setEnabled(false);
			}
		}
			
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGUI frame = new ServerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



}