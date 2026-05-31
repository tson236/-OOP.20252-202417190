package hw13a.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JTextField displayField; 
    private CalculatorLogic logic;
    private String currentOperator = "";
    private double firstOperand = 0;
    private boolean isNewInput = true;
    public CalculatorView() {
        logic = new CalculatorLogic();
        setTitle("Mini Calculator");
        setSize(320, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.BOLD, 28));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        add(displayField, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] buttonLabels = {
            "C", "<-", "%", "/",  
            "7", "8", "9", "*",   
            "4", "5", "6", "-",   
            "1", "2", "3", "+",   
            ".", "0", "", "="     
        };
        for (String label : buttonLabels) {
            if (label.isEmpty()) {
                buttonPanel.add(new JLabel("")); 
                continue;
            }
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            try {
                if ("0123456789.".contains(command)) {
                    if (isNewInput) {
                        displayField.setText(command);
                        isNewInput = false;
                    } else {
                        displayField.setText(displayField.getText() + command);
                    }
                } else if ("C".equals(command)) { 
                    displayField.setText("");
                    firstOperand = 0;
                    currentOperator = "";
                    isNewInput = true;
                } else if ("<-".equals(command)) { 
                    String text = displayField.getText();
                    if (!text.isEmpty()) {
                        displayField.setText(text.substring(0, text.length() - 1));
                    }
                } else if ("+-*/%".contains(command)) { 
                    if (!displayField.getText().isEmpty()) {
                        firstOperand = Double.parseDouble(displayField.getText());
                        currentOperator = command;
                        isNewInput = true; 
                    }
                } else if ("=".equals(command)) { 
                    if (!displayField.getText().isEmpty() && !currentOperator.isEmpty()) {
                        double secondOperand = Double.parseDouble(displayField.getText());
                        double result = logic.calculate(firstOperand, secondOperand, currentOperator);
                        if (result == (long) result) {
                            displayField.setText(String.format("%d", (long) result));
                        } else {
                            displayField.setText(String.valueOf(result));
                        }
                        
                        isNewInput = true;
                        currentOperator = "";
                    } else {
                        throw new IllegalArgumentException("Thiếu toán hạng"); 
                    }
                }
            } catch (ArithmeticException ex) {
                displayField.setText("Lỗi chia 0");
                isNewInput = true;
            } catch (Exception ex) {
                displayField.setText("Lỗi nhập liệu");
                isNewInput = true;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorView().setVisible(true));
    }
}