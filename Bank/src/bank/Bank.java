package bank;

public class Bank {
    private String accNo;
    private String customerName;
    private char accType;
    private double accBalance;

    public Bank(String accNo, String customerName, char accType, String accBalance) {
        this.accNo = accNo;
        this.customerName = customerName;

        if (accType == 'S' || accType == 'C') {
            this.accType = accType;
        } else {
            System.out.println("Invalid account type. Defaulting to 'S'");
            this.accType = 'S';
        }

        this.accBalance = Double.parseDouble(accBalance);
    }

    public void display() {
        System.out.println("Account No: " + accNo);
        System.out.println("Name: " + customerName);
        System.out.println("Type: " + accType);
        System.out.println("Balance: " + accBalance);
        System.out.println("----------------------");
    }

    public void deposit(String amount) {
        double amountToDeposit = Double.parseDouble(amount);

        if (amountToDeposit <= 0) {
            System.out.println("Amount must be greater than 0 to deposit!");
        } else {
            this.accBalance += amountToDeposit;
        }
    }

    public void withdraw(String amount) {
        double amountToWithdraw = Double.parseDouble(amount);

        if ((this.accBalance - amountToWithdraw) >= 5000) {
            this.accBalance -= amountToWithdraw;
        } else {
            System.out.println("Withdrawal denied: Minimum balance must be 5000!");
        }
    }
}
