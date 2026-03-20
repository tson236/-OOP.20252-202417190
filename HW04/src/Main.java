public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("--- 1. KHỞI TẠO TÀI KHOẢN ---");
        BankAccount acc1 = null;
        BankAccount acc2 = null;
        try 
        {
            acc1 = new BankAccount("001", "Alice", 500000);
            acc2 = new BankAccount("002", "Bob", 100000);
        }
         catch (IllegalArgumentException e) 
        {
            System.out.println("Lỗi tạo tài khoản: " + e.getMessage());
        }

        System.out.println("\n--- 2. KIỂM TRA NẠP/RÚT TIỀN ---");
        if (acc1.deposit(100000))
            System.out.println("Nạp thành công");
        else
            System.out.println("Nạp thất bại");
        if (!acc1.deposit(-500))
            System.out.println("Nạp âm → thất bại đúng");
        if (acc2.withdraw(30000))
            System.out.println("Rút thành công");
        else
            System.out.println("Rút thất bại");
        if (!acc2.withdraw(50000))
            System.out.println("Rút làm < MIN_BALANCE → thất bại đúng");
        System.out.println("\n--- 3. KIỂM TRA CHUYỂN TIỀN ---");
        if (acc1.transfer(acc2, 100000))
            System.out.println("Chuyển thành công");
        else
            System.out.println("Chuyển thất bại");
        if (!acc2.transfer(acc1, 100000))
            System.out.println("Không đủ tiền + phí → thất bại đúng");
        System.out.println("\n--- 4. KIỂM TRA THANH TOÁN HÓA ĐƠN ---");
        if (acc1.payBill("Internet FPT", 250000))
            System.out.println("Thanh toán thành công");
        else
            System.out.println("Thanh toán thất bại");
        System.out.println("\n--- 5. SỐ DƯ CUỐI CÙNG ---");
        System.out.println("Tài khoản " + acc1.getOwnerName() + ": " + acc1.getBalance());
        System.out.println("Tài khoản " + acc2.getOwnerName() + ": " + acc2.getBalance());
    }
}