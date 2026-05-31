package hw13b.src;

import javax.swing.*;
import java.awt.*;

public class DateView extends JFrame {
    private JLabel dateLabel;
    private JTextField inputField; 
    public JButton btnPlusDays, btnMinusDays, btnPlusMonths, btnMinusMonths; 

    public DateView() {
        setTitle("Date Display GUI (MVC)");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout(10, 10));
        JPanel northPanel = new JPanel();
        JLabel labelTitle = new JLabel("Ngày hiện tại: ");
        labelTitle.setFont(new Font("Arial", Font.PLAIN, 16));
        dateLabel = new JLabel(); 
        dateLabel.setFont(new Font("Arial", Font.BOLD, 18));
        dateLabel.setForeground(Color.BLUE);
        northPanel.add(labelTitle);
        northPanel.add(dateLabel);
        add(northPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new FlowLayout());
        JLabel labelInput = new JLabel("Nhập số x: ");
        labelInput.setFont(new Font("Arial", Font.PLAIN, 14));
        inputField = new JTextField(10);
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        centerPanel.add(labelInput);
        centerPanel.add(inputField);
        add(centerPanel, BorderLayout.CENTER);
        JPanel southPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        btnMinusDays = new JButton("Lùi x ngày"); 
        btnPlusDays = new JButton("Tiến x ngày"); 
        btnMinusMonths = new JButton("Lùi x tháng"); 
        btnPlusMonths = new JButton("Tiến x tháng"); 

        southPanel.add(btnMinusDays);
        southPanel.add(btnPlusDays);
        southPanel.add(btnMinusMonths);
        southPanel.add(btnPlusMonths);
        add(southPanel, BorderLayout.SOUTH);
    }

    public String getInput() { 
        return inputField.getText().trim(); 
    }
    
    public void setDateDisplay(String date) { 
        dateLabel.setText(date); 
    }
    
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE); // 
    }
}