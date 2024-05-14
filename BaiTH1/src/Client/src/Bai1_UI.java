import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Bai1_UI extends JFrame {

	private JPanel contentPane;
	private JTextField port;
	private JTextArea tf_result;
	Socket socket = null;
	private JButton btnSubmit;
	private JTextField msg;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai1_UI frame = new Bai1_UI();
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
	public Bai1_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 510);
		contentPane = new JPanel();
		setTitle("Client_Bai1");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		port = new JTextField();
		port.setBounds(287, 26, 351, 40);
		contentPane.add(port);
		port.setColumns(10);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(149, 26, 98, 40);
		btnClose.setEnabled(false);
		contentPane.add(btnClose);
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnClose.setEnabled(false);
			}
		});
		
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(10, 26, 98, 40);
		contentPane.add(btnConnect);
		btnConnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					socket = new Socket("localhost", Integer.parseInt(port.getText() + ""));
					tf_result.setText("Kết nối thành công vào port " + port.getText());
					btnClose.setEnabled(true);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
//					e1.printStackTrace();
					tf_result.setText("Kết nối thất bại vào port " + port.getText());
					
				}
			}
		});
		
		tf_result = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(tf_result);
		scrollPane.setBounds(10, 148, 628, 315);
		contentPane.add(scrollPane);
		tf_result.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(540, 84, 98, 40);
		contentPane.add(btnSubmit);
		
		msg = new JTextField();
		msg.setColumns(10);
		msg.setBounds(10, 84, 482, 40);
		contentPane.add(msg);
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DataInputStream din;
				try {
					din = new DataInputStream(socket.getInputStream());
					DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
					String msg_1 = msg.getText();
					dos.writeUTF(msg_1);
					dos.flush();
					String st = din.readUTF();
					tf_result.setText(tf_result.getText() + "\n" + st);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
}
