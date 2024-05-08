package bai3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.swing.JTextArea;

import bai1.XuLiChuoi;

public class ServerUDP {
	private DatagramSocket datagramSocket;
	private Consumer<String> receive;
	private List<DatagramPacket> receiveDatagramPackets;
	private int port;

	ServerUDP(int port, Consumer<String> receiveHandler) {
		this.port = port;
		this.receive = receiveHandler;

	}

	public void start() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					datagramSocket = new DatagramSocket(port);
					receiveDatagramPackets = new ArrayList<>();
					byte[] receiveData = new byte[1024];
					while (true) {
						DatagramPacket receiveDatagramPacket = new DatagramPacket(receiveData, receiveData.length);
						datagramSocket.receive(receiveDatagramPacket);
						if (!receiveDatagramPackets.contains(receiveDatagramPacket)) {
							
							receiveDatagramPackets.add(receiveDatagramPacket);
						}
						String receiveContent = new String(receiveDatagramPacket.getData(), 0,
								receiveDatagramPacket.getLength(), "UTF-8");
						receive.accept("Client port " + receiveDatagramPacket.getPort() + ": " + receiveContent);
						receiveDatagramPacket.getAddress();
						InetAddress inetAddress = receiveDatagramPacket.getAddress();
						int port = receiveDatagramPacket.getPort();
						transferData(receiveContent, inetAddress, port);

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					datagramSocket.close();
				}
			}
		}).start();
		;
	}

	public void send(String content) {
		byte[] sendData = content.getBytes();
		for (int i = 0; i < receiveDatagramPackets.size(); i++) {
			try {
				
				DatagramPacket sendDatagramPacket = new DatagramPacket(sendData, sendData.length);
				sendDatagramPacket.setAddress(receiveDatagramPackets.get(i).getAddress());
				sendDatagramPacket.setPort(receiveDatagramPackets.get(i).getPort());
				datagramSocket.send(sendDatagramPacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized void transferData(String content, InetAddress inetAddress, int port) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int sender = 0;
				for (int i = 0; i < receiveDatagramPackets.size(); i++) {
					
					if (receiveDatagramPackets.get(i).getAddress().equals(inetAddress)
							&& receiveDatagramPackets.get(i).getPort() == port) {
						sender = i;
						continue;
					}
					try {
						byte[] sendData = ("from "+ receiveDatagramPackets.get(sender).getPort()+": " +content).getBytes();
						DatagramPacket sendDatagramPacket = new DatagramPacket(sendData, sendData.length);
						sendDatagramPacket.setAddress(receiveDatagramPackets.get(i).getAddress());
						sendDatagramPacket.setPort(receiveDatagramPackets.get(i).getPort());
						datagramSocket.send(sendDatagramPacket);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();;

	}

	public void close() {
		if (datagramSocket != null) {
			datagramSocket.close();
		}
	}

}
