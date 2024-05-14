import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class Bai1_UI extends JFrame {

	private JPanel contentPane;
	private JTextField port;
	ServerSocket server = null;
	private JTextArea tf_input;

	public static String chuoiDao(String input)
	{
		String result = "";
		
		int length = input.length();
		for(int i = 0; i < length; i ++)
		{
			result = input.charAt(i) + result;
		}
			
		return result;
	}
	
	public static String chuoiInHoa(String input)
	{
		String result = "";
		for(int i = 0 ; i<input.length(); i++)
		{
			char chuCai = input.charAt(i);
			if((int)chuCai>=97 && (int)chuCai<=122)
			{
				result = result + (char)((int)chuCai - 32);
			}
			else
			{
				result = result + chuCai;
			}
		}
		return result;
	}
	
	public static String chuoiVuaThuongVuaHoa(String input)
	{
		String result = "";
		for(int i = 0 ; i<input.length(); i++)
		{
			char chuCai = input.charAt(i);
			if((int)chuCai>=97 && (int)chuCai<=122)
			{
				result = result + (char)((int)chuCai - 32);
			}
			else if((int)chuCai>=41 && (int)chuCai<=90)
			{
				result = result + (char)((int)chuCai + 32);
			}
			else
			{
				result = result + chuCai;
			}
		}
		return result;
	}
	
	public static int soTu(String input)
	{
		int result = 0;
		for(int i = 0; i<input.length();i++)
		{
			if(input.charAt(i) == ' ' && i != 0 && input.charAt(i-1) != ' ' )
			{
				result ++;
			}
		}
		
		if(input.charAt(input.length()-1) != ' ')
		{
			result ++;
		}
		
		return result;
	}
	
	public static String tanSoCacNguyenAm(String input)
	{
		int NAa = 0;
		int NAi = 0;
		int NAu = 0;
		int NAe = 0;
		int NAo = 0;
		for(int i = 0 ;i<input.length();i++)
		{
			switch (input.charAt(i)){
			case 'a': {
				NAa++;
				break;
			}
			case 'i': {
				NAi++;
				break;
			}
			case 'u': {
				NAu++;
				break;
			}
			case 'e': {
				NAe++;
				break;
			}
			case 'o': {
				NAo++;
				break;
			}
			}
		}
		String result = "";
		
		result += "So lan xuat hien nguyen am a: "+ NAa + "\n";
		result += "So lan xuat hien nguyen am i: "+ NAi + "\n";
		result += "So lan xuat hien nguyen am u: "+ NAu + "\n";
		result += "So lan xuat hien nguyen am e: "+ NAe + "\n";
		result += "So lan xuat hien nguyen am o: "+ NAo + "\n";
		
		return result;
	}
	
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
		setBounds(100, 100, 609, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Server_Bai1");
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		port = new JTextField();
		port.setBounds(75, 78, 190, 43);
		contentPane.add(port);
		port.setColumns(10);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(424, 78, 108, 43);
		contentPane.add(btnClose);
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					server.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnClose.setEnabled(false);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(291, 78, 108, 43);
		contentPane.add(btnConnect);
		
		tf_input = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(tf_input);
		scrollPane.setBounds(75, 142, 457, 165);
		contentPane.add(scrollPane);
		tf_input.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Server Bai 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(236, 10, 131, 43);
		contentPane.add(lblNewLabel);
		btnConnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					btnClose.setEnabled(true);
					server = new ServerSocket(Integer.parseInt(port.getText()+""));
					System.out.println("Server is started ....");
					Socket socket = server.accept();
					tf_input.setText(tf_input.getText() + "Client connected from: " + socket.getInetAddress().getHostAddress() + "\n");
                    new Thread(new ClientHandler(socket, tf_input)).start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	// Class xử lý từng client
    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private JTextArea field;
        public ClientHandler(Socket socket, JTextArea field) {
            this.socket = socket;
            this.field = field;
            
        }

        @Override
        public void run() {
            try {
                DataInputStream din = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    String st = din.readUTF();
                    field.setText(field.getText() + "Input String : " + st + "\n");
                    // Xử lý chuỗi và gửi kết quả cho client
                    String result = "";
                    result += "Chuoi sau khi dao la: " + chuoiDao(st) + "\n";
                    result += "Chuoi sau khi doi sang in hoa la: " + chuoiInHoa(st) + "\n";
                    result += "Chuoi sau khi doi sang chuoi vua thuong vua hoa la: " + chuoiVuaThuongVuaHoa(st) + "\n";
                    result += "So Tu Trong Chuoi: " + soTu(st) + "\n";
                    result += tanSoCacNguyenAm(st);

                    dos.writeUTF("result : " + "\n" + result);
                    dos.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
