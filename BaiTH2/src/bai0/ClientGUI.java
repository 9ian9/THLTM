package bai0;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientGUI {
	public static void main(String[] args) throws IOException {
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = null;
		byte[] receiveData = new byte[1024];
		sendData = "GetDate".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2024);
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		String str = new String(receivePacket.getData(), 0, receivePacket.getLength());
		System.out.println(str);
		clientSocket.close();
	}
}

