package bai2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.function.Consumer;

public class CLientUDP {
	private int port;
	private String host = "localhost";
	private DatagramSocket datagramSocket;
	private Consumer<String> receive;
	CLientUDP(int port, String host,  Consumer<String> receive){
		this.port = port;
		this.host = host;
		this.receive = receive;
	}
	public void start() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					datagramSocket = new DatagramSocket(0);
					byte[] receiveData = new byte[1024];
					while(true) {
						DatagramPacket receiveDatagramPacket = new DatagramPacket(receiveData, receiveData.length);
						datagramSocket.receive(receiveDatagramPacket);
						String receiveContent = new String(receiveDatagramPacket.getData(), 0, receiveDatagramPacket.getLength(), "UTF-8");
						receive.accept(receiveContent);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					datagramSocket.close();
				}
				
			}
		}).start();
	}
	public void send(String content) {
		
		try {
			byte[] sendData = content.getBytes();
			DatagramPacket sendDatagramPacket = new DatagramPacket(sendData, sendData.length);
			sendDatagramPacket.setAddress(InetAddress.getByName(host));
			sendDatagramPacket.setPort(port);
			datagramSocket.send(sendDatagramPacket);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close() {
		if (datagramSocket != null) {
			datagramSocket.close();
		}
	}
	
}
