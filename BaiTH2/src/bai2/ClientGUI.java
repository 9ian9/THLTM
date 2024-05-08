package bai2;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.EventQueue;

public class ClientGUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField tfPort;
	private JLabel lbPort;
	private JButton btnConnect;
	private JScrollPane sp;
	private JTextArea textArea;
	private JButton btnDisconnect;
	private JTextField tfMessage;
	private JButton btnSend;
	private CLientUDP clientUDP;

	ClientGUI() {
		setTitle("Client");
		setDefaultCloseOperation((EXIT_ON_CLOSE));
		setSize(800, 504);
		setVisible(true);
		getContentPane().setLayout(null);

		lbPort = new JLabel("Chọn cổng kết nối");
		lbPort.setBounds(46, 18, 123, 35);
		lbPort.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lbPort);

		tfPort = new JTextField();
		tfPort.setBounds(194, 25, 278, 24);
		getContentPane().add(tfPort);
		tfPort.setColumns(10);

//        sp = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        sp.setBounds(0, 0, 0, 0);
//        getContentPane().add(sp);
//        

		btnConnect = new JButton("Connect");
		btnConnect.setBounds(505, 20, 123, 35);
		getContentPane().add(btnConnect);
		btnConnect.addActionListener(this);

		btnDisconnect = new JButton("Disconnect");
		btnDisconnect.setBounds(647, 20, 110, 35);
		getContentPane().add(btnDisconnect);
		btnDisconnect.setEnabled(false);

		tfMessage = new JTextField();
		tfMessage.setColumns(10);
		tfMessage.setBounds(30, 106, 278, 24);
		getContentPane().add(tfMessage);

		btnSend = new JButton("Send");
		btnSend.setBounds(349, 101, 123, 35);
		getContentPane().add(btnSend);
		btnSend.setEnabled(false);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 165, 704, 289);
		getContentPane().add(scrollPane_1);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		btnSend.addActionListener(this);
		btnDisconnect.addActionListener(this);

	}

	public void writeTextArea(String text) {
		if (!text.isEmpty()) {
			textArea.append(text);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConnect) {
			int port;
			try {
				port = Integer.parseInt(tfPort.getText());

			} catch (NumberFormatException exception) {
				System.out.println("Vui Long Nhap dung dinh dang so!!!");
				return;
			}
			clientUDP = new CLientUDP(port, "localhost", (String content) -> {
				if (!content.isEmpty()) {
					writeTextArea("[Server] : " + "\n" + content + "\n" );
				}
			});
			clientUDP.start();
			writeTextArea("Da Ket Noi toi server!!!" + "\n");
			btnConnect.setEnabled(false);
			btnDisconnect.setEnabled(true);
			btnSend.setEnabled(true);

		}
		if (e.getSource() == btnSend) {
			if (!tfMessage.getText().isEmpty()) {
				clientUDP.send(tfMessage.getText());
				tfMessage.setText(null);
			}
		}
		if (e.getSource() == btnDisconnect) {
			if (clientUDP != null) {
				clientUDP.close();
				clientUDP = null;

	            btnConnect.setEnabled(true);
	            btnDisconnect.setEnabled(false);
	            btnSend.setEnabled(false);
	        }
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI frame = new ClientGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}