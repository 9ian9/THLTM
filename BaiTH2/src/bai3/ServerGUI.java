package bai3;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;


import bai3.ServerUDP;

import java.awt.TextArea;

import javax.swing.JTextArea;


import javax.swing.JScrollPane;


import javax.swing.JTextField;

import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ServerGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMessage;
	private JTextField textFieldPort;
	private JButton btnOpen;
	private JTextArea textAreaChat;
	private JButton btnSend;
	private JButton btnClose;
	private ServerUDP serverUDP;

	/**
	 * 
	 * Launch the application.
	 * 
	 */
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

	public ServerGUI() {
		setTitle("Waiting for client");
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
		btnSend.addActionListener(this);
		btnSend.setBounds(510, 0, 118, 45);
		btnSend.setEnabled(false);
		panelMessage.add(btnSend);
		JScrollPane scollPanelChat = new JScrollPane();
		scollPanelChat.setBounds(0, 67, 619, 288);
		contentPane.add(scollPanelChat);
		textAreaChat = new JTextArea();
		textAreaChat.setEditable(false);
		scollPanelChat.setViewportView(textAreaChat);
		textFieldPort = new JTextField();

		textFieldPort.setBounds(117, 24, 175, 32);

		contentPane.add(textFieldPort);

		textFieldPort.setColumns(10);

		JLabel lblPort = new JLabel("Nhập Port: ");

		lblPort.setBounds(10, 24, 97, 32);

		contentPane.add(lblPort);

		btnOpen = new JButton("Open");
		btnOpen.addActionListener(this);
		btnOpen.setBounds(332, 22, 118, 34);

		contentPane.add(btnOpen);
		btnClose = new JButton("Close");
		btnClose.addActionListener(this);
		btnClose.setBounds(478, 21, 118, 35);
		btnClose.setEnabled(false);
		contentPane.add(btnClose);

	}
	public void writeTextArea(String text) {
		if(!text.isEmpty()) {
			textAreaChat.append(text);
		}
	}
	@SuppressWarnings("deprecation")

	@Override

	public void actionPerformed(ActionEvent e) {

// TODO Auto-generated method stub

		if (e.getSource() == btnOpen) {
			int port;
			try {
				port = Integer.parseInt(textFieldPort.getText());
			}catch(NumberFormatException exception) {
				System.out.println("Vui Long Nhap dung dinh dang so!!!");
				return;
			}
			serverUDP = new ServerUDP(port, (String content) ->{
				if (!content.isEmpty()) {
					writeTextArea(content +"\n");
				}
			});
			serverUDP.start();
			writeTextArea("Dang lang nghe tu cong: "+ port +"\n");
			btnOpen.setEnabled(false);
			btnSend.setEnabled(true);
			btnClose.setEnabled(true);
			
		}

		if (e.getSource() == btnSend) {
			if (!textMessage.getText().isEmpty()) {
				serverUDP.send(textMessage.getText());
				writeTextArea("Me: " + textMessage.getText() + "\n");
				textMessage.setText(null);
			}
		}

		if (e.getSource() == btnClose) {
			if(serverUDP != null) {
				serverUDP.close();
				serverUDP = null;
				btnOpen.setEnabled(true);
				btnClose.setEnabled(false);
				btnSend.setEnabled(false);
			}
		}

	}

}