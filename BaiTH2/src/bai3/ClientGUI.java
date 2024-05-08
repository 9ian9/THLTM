package bai3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bai3.CLientUDP;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.Scrollbar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMessage;
	private JTextField textFieldPort;
	private JButton btnSend;
	private JTextArea textAreaChat;
	private JButton btnConnect;
	private JButton btnDisconnect;
	private CLientUDP clientUDP;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public ClientGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelMessage = new JPanel();
		panelMessage.setBounds(0, 360, 619, 45);
		contentPane.add(panelMessage);
		panelMessage.setLayout(null);

		textMessage = new JTextField();
		textMessage.setBounds(0, 0, 500, 45);
		panelMessage.add(textMessage);
		textMessage.setColumns(10);

		btnSend = new JButton("Send");
		btnSend.setBounds(501, 0, 118, 45);
		btnSend.addActionListener(this);
		panelMessage.add(btnSend);
		btnSend.setEnabled(false);
		JScrollPane scollPanelChat = new JScrollPane();
		scollPanelChat.setBounds(0, 67, 619, 288);
		contentPane.add(scollPanelChat);

		textAreaChat = new JTextArea();
		textAreaChat.setEditable(false);
		scollPanelChat.setViewportView(textAreaChat);

		textFieldPort = new JTextField();
		textFieldPort.setColumns(10);
		textFieldPort.setBounds(129, 20, 175, 32);
		contentPane.add(textFieldPort);

		JLabel lblPort = new JLabel("Nhập Port: ");
		lblPort.setBounds(10, 20, 97, 32);
		contentPane.add(lblPort);

		btnConnect = new JButton("Connect");
		btnConnect.setBounds(364, 20, 118, 34);
		btnConnect.addActionListener(this);
		contentPane.add(btnConnect);

		btnDisconnect = new JButton("Disconnect");
		btnDisconnect.setBounds(501, 19, 118, 35);
		btnDisconnect.addActionListener(this);
		btnDisconnect.setEnabled(false);
		contentPane.add(btnDisconnect);
//		if(!socket.isClosed() && socket != null) {
//			btnSend.setEnabled(false);
//		}
	}

	public void writeTextArea(String text) {
		if (!text.isEmpty()) {
			textAreaChat.append(text);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub

		if (e.getSource() == btnConnect) {
			int port;
			try {
				port = Integer.parseInt(textFieldPort.getText());

			} catch (NumberFormatException exception) {
				System.out.println("Vui Long Nhap dung dinh dang so!!!");
				return;
			}
			clientUDP = new CLientUDP(port, "localhost", (String content) -> {
				if (!content.isEmpty()) {
					writeTextArea(content + "\n");
				}
			});
			clientUDP.start();
			writeTextArea("Da Ket Noi toi server!!!" + "\n");
			btnConnect.setEnabled(false);
			btnDisconnect.setEnabled(true);
			btnSend.setEnabled(true);

			// try {z

		}
		if (e.getSource() == btnSend) {
			if (!textMessage.getText().isEmpty()) {
				clientUDP.send(textMessage.getText());
				writeTextArea("Me: " + textMessage.getText() + "\n");
				textMessage.setText(null);
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

}
