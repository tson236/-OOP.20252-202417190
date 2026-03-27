public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;git add HW04/
git commit -m "init: Initialize HW04 folder and BankAccount class properties"
    private static final double MIN_BALANCE = 50000.0;
    private static final double TRANSFER_FEE_RATE = 0.02;
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên chủ tài khoản không được để trống.");
        }
        if (initialBalance < MIN_BALANCE) {
            throw new IllegalArgumentException("Số dư ban đầu phải >= " + MIN_BALANCE);
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }
    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }
    public boolean withdraw(double amount) 
    {
        if (amount <= 0) return false;
        if (balance - amount < MIN_BALANCE) return false;
        balance -= amount;
        return true;
    }
    public boolean transfer(BankAccount receiver, double amount) 
    {
        if (receiver == null || amount <= 0) return false;

        double fee = amount * TRANSFER_FEE_RATE;
        double total = amount + fee;

        if (balance - total < MIN_BALANCE) return false;

        this.balance -= total;
        receiver.balance += amount;
        return true;
    }
    public boolean payBill(String billName, double amount)
     {
        if (amount <= 0) return false;
        if (balance - amount < MIN_BALANCE) return false;mkdir -p HW04/src
mkdir -p HW04/design
        balance -= amount;
        return true;
    }
}