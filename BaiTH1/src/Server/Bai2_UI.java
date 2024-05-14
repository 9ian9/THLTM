package Server;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class Bai2_UI extends JFrame {

	private JPanel contentPane;
	private JTextField port;
	ServerSocket server = null;
	private JTextArea tf_input;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai2_UI frame = new Bai2_UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static int evaluateExpression(String expression) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (Character.isDigit(ch)) {
                StringBuilder num = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num.append(expression.charAt(i));
                    i++;
                }
                operandStack.push(Integer.parseInt(num.toString()));
                i--;
            } else if (ch == ')') {
                while (operatorStack.peek() != '(') {
                    int result = applyOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop());
                    operandStack.push(result);
                }
                operatorStack.pop(); // Remove '('
            } else {
                while (!operatorStack.isEmpty() && precedence(ch) <= precedence(operatorStack.peek())) {
                    int result = applyOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop());
                    operandStack.push(result);
                }
                operatorStack.push(ch);
            }
        }

        while (!operatorStack.isEmpty()) {
            int result = applyOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop());
            operandStack.push(result);
        }

        return operandStack.pop();
    }

    public static int applyOperator(char operator, int b, int a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

	/**
	 * Create the frame.
	 */
	public Bai2_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Server_Bai2");
		
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
		
		JLabel lblNewLabel = new JLabel("Server Bai 2");
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
//					while (true) {
//                        Socket socket = server.accept();
//                        tf_input.setText(tf_input.getText() + "Client connected from: " + socket.getInetAddress() + "\n");
//                        new Thread(new ClientHandler(socket, tf_input)).start();
//                    }
					
					new Thread(new ClientHandler(server, tf_input)).start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	// Class xử lý từng client
    private static class ClientHandler implements Runnable {
//        private final Socket socket;
        private Socket socket;
        private JTextArea field;
//        public ClientHandler(Socket socket, JTextArea field) {
//            this.socket = socket;
//            this.field = field;
//            
//        }
        public ClientHandler(ServerSocket server, JTextArea field) {
            try {
				this.socket = server.accept();
				field.setText(field.getText() + "Client connected from: " + socket.getInetAddress() + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            this.field = field;
            
        }

        @Override
        public void run() {
            try {
            	DataInputStream din = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				while(true)
				{
					String st = din.readUTF();
					field.setText(field.getText() + "Input String : " + st + "\n");
					System.out.println("String input : "+ st );
					String result = evaluateExpression(st) + "";
					dos.writeUTF("result : " + "\n" + result);
					dos.flush();
				}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
