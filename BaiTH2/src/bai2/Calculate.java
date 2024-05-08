package bai2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Calculate {

	public static double calculateExpression(String expression) {
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        expression = expression.replaceAll("\\s+", "");
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                StringBuilder operand = new StringBuilder();
                while (i < expression.length()
                        && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    operand.append(expression.charAt(i++));
                }
                i--; // Điều chỉnh chỉ số i
                operandStack.push(Double.parseDouble(operand.toString()));
            }
            // Nếu là toán tử
            else if (isOperator(ch)) {
                // Đẩy toán tử từ ngăn xếp nếu có độ ưu tiên cao hơn hoặc bằng toán tử hiện tại
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(ch)) {
                    double operand2 = operandStack.pop();
                    double operand1 = operandStack.pop();
                    char operator = operatorStack.pop();
                    operandStack.push(performOperation(operator, operand1, operand2));
                }
                // Đẩy toán tử hiện tại vào ngăn xếp toán tử
                operatorStack.push(ch);
            }
            // Nếu là dấu mở ngoặc
            else if (ch == '(') {
                operatorStack.push(ch);
            }
            // Nếu là dấu đóng ngoặc
            else if (ch == ')') {
                // Đẩy toán tử từ ngăn xếp vào ngăn xếp toán hạng cho đến khi gặp dấu mở ngoặc
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    double operand2 = operandStack.pop();
                    double operand1 = operandStack.pop();
                    char operator = operatorStack.pop();
                    operandStack.push(performOperation(operator, operand1, operand2));
                }
                // Loại bỏ dấu mở ngoặc khỏi ngăn xếp toán tử
                operatorStack.pop();
            }
        }

        // Tính toán giá trị của biểu thức còn lại trong ngăn xếp toán tử và toán hạng
        while (!operatorStack.isEmpty()) {
            double operand2 = operandStack.pop();
            double operand1 = operandStack.pop();
            char operator = operatorStack.pop();
            operandStack.push(performOperation(operator, operand1, operand2));
        }

        // Kết quả cuối cùng là giá trị của biểu thức
        return operandStack.pop();
    }

    // Hàm kiểm tra xem một ký tự có phải là toán tử hay không
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Hàm xác định độ ưu tiên của một toán tử
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1; // Giá trị mặc định
        }
    }

    // Hàm thực hiện phép toán
    private static double performOperation(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Lỗi chia cho 0");
                }
                return operand1 / operand2;
            default:
                return 0; // Trường hợp không xác định
        }
    }
}
