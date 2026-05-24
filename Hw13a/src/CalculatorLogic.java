package hw13a.src;

public class CalculatorLogic {
    public double calculate(double operand1, double operand2, String operator) throws ArithmeticException {
        switch (operator) {
            case "+": return operand1 + operand2; // [cite: 87]
            case "-": return operand1 - operand2; // [cite: 88]
            case "*": return operand1 * operand2; // [cite: 89]
            case "/": 
                if (operand2 == 0) throw new ArithmeticException("Lỗi chia cho 0"); // [cite: 90, 96]
                return operand1 / operand2;
            case "%": return operand1 % operand2; // [cite: 91]
            default: throw new IllegalArgumentException("Phép toán không hợp lệ");
        }
    }
}