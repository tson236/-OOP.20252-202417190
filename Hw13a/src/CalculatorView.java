package hw13a.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JTextField displayField; // [cite: 84]
    private CalculatorLogic logic;
    
    // Các biến lưu trạng thái tính toán
    private String currentOperator = "";
    private double firstOperand = 0;
    private boolean isNewInput = true;

    public CalculatorView() {
        logic = new CalculatorLogic();
        setTitle("Mini Calculator");
        setSize(320, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Màn hình hiển thị
        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.BOLD, 28));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        add(displayField, BorderLayout.NORTH);

        // Khu vực chứa các nút bấm
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        
        // Mảng chứa nhãn của các nút
        String[] buttonLabels = {
            "C", "<-", "%", "/",  // [cite: 90, 91, 93, 94]
            "7", "8", "9", "*",   // [cite: 85, 89]
            "4", "5", "6", "-",   // [cite: 85, 88]
            "1", "2", "3", "+",   // [cite: 85, 87]
            ".", "0", "", "="     // [cite: 85, 94]
        };

        // Tạo và thêm các nút vào panel
        for (String label : buttonLabels) {
            if (label.isEmpty()) {
                buttonPanel.add(new JLabel("")); // Ô trống
                continue;
            }
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    // Lớp xử lý sự kiện khi bấm nút
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            try {
                if ("0123456789.".contains(command)) {
                    // Nếu đang nhập số mới thì ghi đè, ngược lại thì nối thêm vào
                    if (isNewInput) {
                        displayField.setText(command);
                        isNewInput = false;
                    } else {
                        displayField.setText(displayField.getText() + command);
                    }
                } else if ("C".equals(command)) { // Xóa toàn bộ
                    displayField.setText("");
                    firstOperand = 0;
                    currentOperator = "";
                    isNewInput = true;
                } else if ("<-".equals(command)) { // Xóa lùi
                    String text = displayField.getText();
                    if (!text.isEmpty()) {
                        displayField.setText(text.substring(0, text.length() - 1));
                    }
                } else if ("+-*/%".contains(command)) { // Các phép toán
                    if (!displayField.getText().isEmpty()) {
                        firstOperand = Double.parseDouble(displayField.getText());
                        currentOperator = command;
                        isNewInput = true; // Đánh dấu để lần bấm tiếp theo sẽ nhập số thứ 2
                    }
                } else if ("=".equals(command)) { // Tính kết quả
                    if (!displayField.getText().isEmpty() && !currentOperator.isEmpty()) {
                        double secondOperand = Double.parseDouble(displayField.getText());
                        // Gọi logic để tính toán (đã tách biệt UI và Logic) [cite: 81]
                        double result = logic.calculate(firstOperand, secondOperand, currentOperator);
                        
                        // Hiển thị số nguyên nếu kết quả không có phần thập phân
                        if (result == (long) result) {
                            displayField.setText(String.format("%d", (long) result));
                        } else {
                            displayField.setText(String.valueOf(result));
                        }
                        
                        isNewInput = true;
                        currentOperator = "";
                    } else {
                        throw new IllegalArgumentException("Thiếu toán hạng"); // [cite: 97]
                    }
                }
            } catch (ArithmeticException ex) {
                // Bắt lỗi chia cho 0 từ lớp CalculatorLogic [cite: 96]
                displayField.setText("Lỗi chia 0");
                isNewInput = true;
            } catch (Exception ex) {
                // Bắt các lỗi biểu thức không hợp lệ khác [cite: 97]
                displayField.setText("Lỗi nhập liệu");
                isNewInput = true;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorView().setVisible(true));
    }
}