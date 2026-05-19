package bank;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private String balance;

    public BankAccount(String accountNumber, String accountHolderName, String balance) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(String depositAmount) {

        double currentBalance = Double.parseDouble(balance);
        double amount = Double.parseDouble(depositAmount);

        currentBalance += amount;

        balance = String.valueOf(currentBalance);

        System.out.println("Deposit Successful");
        System.out.println("Updated Balance = Rs. " + balance);
    }

    public void withdrawal(String withDrawAmount) {

        double currentBalance = Double.parseDouble(balance);
        double amount = Double.parseDouble(withDrawAmount);

        if ((currentBalance - amount) < 5000) {
            System.out.println("Withdrawal Denied: Minimum balance must be Rs. 5000");
            return;
        }

        currentBalance -= amount;

        balance = String.valueOf(currentBalance);

        System.out.println("Withdrawal Successful");
        System.out.println("Updated Balance = Rs. " + balance);
    }

    protected double getBalance() {
        return Double.parseDouble(balance);
    }

    public void display() {

        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: Rs. " + balance);
    }
}