package hw13b.src;

public class DateController {
    private DateModel model;
    private DateView view;

    public DateController(DateModel model, DateView view) {
        this.model = model;
        this.view = view;
        
        // Hiển thị ngày hệ thống hiện tại ngay khi khởi động [cite: 112]
        view.setDateDisplay(model.getFormattedDate());
        
        // Gắn bộ lắng nghe sự kiện (Event Listeners) cho cả 4 nút bấm [cite: 115]
        view.btnMinusDays.addActionListener(e -> updateDate("minusDays"));
        view.btnPlusDays.addActionListener(e -> updateDate("plusDays"));
        view.btnMinusMonths.addActionListener(e -> updateDate("minusMonths"));
        view.btnPlusMonths.addActionListener(e -> updateDate("plusMonths"));
    }

    // Xử lý kiểm tra dữ liệu đầu vào và điều hướng tính toán [cite: 127-131]
    private void updateDate(String action) {
        try {
            String input = view.getInput();
            
            // Bắt lỗi bỏ trống ô nhập liệu [cite: 128]
            if (input.isEmpty()) {
                throw new IllegalArgumentException("Vui lòng không để trống ô nhập số x!");
            }
            
            int x;
            try {
                x = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                // Bắt lỗi nếu người dùng nhập chữ, ký tự đặc biệt [cite: 129]
                throw new IllegalArgumentException("Dữ liệu nhập vào phải là một số nguyên hợp lệ!");
            }
            
            // Bắt lỗi nhập số âm [cite: 130]
            if (x < 0) {
                throw new IllegalArgumentException("Số x không được là số âm!");
            }

            // Gọi các hàm tương ứng từ lớp Model dựa trên hành động [cite: 122-125]
            switch (action) {
                case "minusDays":
                    model.minusDays(x); // [cite: 123]
                    break;
                case "plusDays":
                    model.addDays(x); // [cite: 124]
                    break;
                case "minusMonths":
                    model.minusMonths(x); // [cite: 125]
                    break;
                case "plusMonths":
                    model.addMonths(x); // [cite: 125]
                    break;
            }

            // Yêu cầu View cập nhật lại màn hình hiển thị ngày mới
            view.setDateDisplay(model.getFormattedDate());
            
        } catch (IllegalArgumentException ex) {
            // Ném thông báo lỗi ra màn hình thông qua hộp thoại của View 
            view.showError(ex.getMessage());
        }
    }
}