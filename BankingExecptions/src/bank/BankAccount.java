package bank;

public class BankAccount {
    private final String accountNumber;
    private final String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double depositAmount) {
        if (depositAmount <= 0) {
            System.out.println("Deposit amount must be greater than zero");
        } else {
            this.balance += depositAmount;

            System.out.println("Deposit Successful of Rs. " + depositAmount);
            System.out.println("Updated Balance = Rs. " + this.balance);
        }
    }

    public void withdrawal(double withDrawAmount) throws InsufficientBalanceException {
        if (this.balance < withDrawAmount) {
            throw new InsufficientBalanceException(
                    "Insufficient balance!\nWithdrawal Failed of Rs. " +
                    withDrawAmount +
                    "\nTotal Balance: " + this.balance
            );
        } else {
            this.balance -= withDrawAmount;

            System.out.println("Withdrawal Successful of Rs. " + withDrawAmount);
            System.out.println("Updated Balance = Rs. " + balance);
        }
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: Rs. " + balance);
    }
}
