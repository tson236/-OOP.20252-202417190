package hw13b.src;

import javax.swing.*;
import java.awt.*;

public class DateView extends JFrame {
    private JLabel dateLabel;
    private JTextField inputField; // [cite: 116]
    public JButton btnPlusDays, btnMinusDays, btnPlusMonths, btnMinusMonths; // [cite: 117-120]

    public DateView() {
        setTitle("Date Display GUI (MVC)");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Hiển thị giữa màn hình
        setLayout(new BorderLayout(10, 10));

        // 1. Khu vực hiển thị ngày phía trên (North)
        JPanel northPanel = new JPanel();
        JLabel labelTitle = new JLabel("Ngày hiện tại: ");
        labelTitle.setFont(new Font("Arial", Font.PLAIN, 16));
        
        dateLabel = new JLabel(); // Khởi tạo để hết lỗi NullPointerException
        dateLabel.setFont(new Font("Arial", Font.BOLD, 18));
        dateLabel.setForeground(Color.BLUE);
        
        northPanel.add(labelTitle);
        northPanel.add(dateLabel);
        add(northPanel, BorderLayout.NORTH);

        // 2. Khu vực nhập số x ở giữa (Center) [cite: 116]
        JPanel centerPanel = new JPanel(new FlowLayout());
        JLabel labelInput = new JLabel("Nhập số x: ");
        labelInput.setFont(new Font("Arial", Font.PLAIN, 14));
        inputField = new JTextField(10);
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        
        centerPanel.add(labelInput);
        centerPanel.add(inputField);
        add(centerPanel, BorderLayout.CENTER);

        // 3. Khu vực chứa 4 nút bấm điều khiển phía dưới (South) [cite: 117-120]
        JPanel southPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        btnMinusDays = new JButton("Lùi x ngày"); // [cite: 117]
        btnPlusDays = new JButton("Tiến x ngày"); // [cite: 118]
        btnMinusMonths = new JButton("Lùi x tháng"); // [cite: 119]
        btnPlusMonths = new JButton("Tiến x tháng"); // [cite: 120]

        southPanel.add(btnMinusDays);
        southPanel.add(btnPlusDays);
        southPanel.add(btnMinusMonths);
        southPanel.add(btnPlusMonths);
        add(southPanel, BorderLayout.SOUTH);
    }

    // Hàm lấy chuỗi ký tự người dùng nhập vào ô x
    public String getInput() { 
        return inputField.getText().trim(); 
    }
    
    // Hàm cập nhật chuỗi ngày hiển thị lên màn hình
    public void setDateDisplay(String date) { 
        dateLabel.setText(date); 
    }
    
    // Hàm hiển thị hộp thoại cảnh báo lỗi 
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE); // 
    }
}