package Bai3;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.util.*;
import java.net.Socket;
public class ChatClient {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost", 7000);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		// nhap chuoi de gui den server
		Scanner kb = new Scanner(System.in);
		while(true) {
			System.out.print("Client:");
			String msg = kb.nextLine();
			dos.writeUTF("Client: " + msg);
			dos.flush();
			String st = din.readUTF();
			System.out.println(st);
			kb = kb.reset();
		}
	}

}
