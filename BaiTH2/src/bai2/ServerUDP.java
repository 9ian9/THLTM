package bai2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.swing.JTextArea;

import bai1.XuLiChuoi;

public class ServerUDP {
	private DatagramSocket datagramSocket;
	private InetAddress inetAddress;
	private Function<String, Double> request;
	private Consumer<String> receive;
	private int port;

	ServerUDP(int port, Function<String, Double> requestHandler, Consumer<String> receiveHandler) {
		this.port = port;
		this.receive = receiveHandler;
		this.request = requestHandler;

	}



	public void start() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					datagramSocket = new DatagramSocket(port);
					byte[] receiveData = new byte[1024];
					while (true) {
						DatagramPacket receiveDatagramPacket = new DatagramPacket(receiveData, receiveData.length);
						datagramSocket.receive(receiveDatagramPacket);
						String receiveContent = new String(receiveDatagramPacket.getData(), 0,
								receiveDatagramPacket.getLength(), "UTF-8");
						receive.accept(receiveContent);

						double requestContent = request.apply(receiveContent);

						byte[] sendData = String.valueOf(requestContent).getBytes();
						DatagramPacket sendDatagramPacket = new DatagramPacket(sendData, sendData.length);
						inetAddress = receiveDatagramPacket.getAddress();
						sendDatagramPacket.setAddress(inetAddress);
						sendDatagramPacket.setPort(receiveDatagramPacket.getPort());
						datagramSocket.send(sendDatagramPacket);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					datagramSocket.close();
				}
			}
		}).start();;
	}

	public void close() {
		if(datagramSocket != null) {
			datagramSocket.close();
		}
	}


}
