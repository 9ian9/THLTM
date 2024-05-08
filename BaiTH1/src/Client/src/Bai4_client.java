import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Bai4_client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",7000);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		String data = din.readUTF();
		System.out.println(data);
		socket.close();
	}
}
