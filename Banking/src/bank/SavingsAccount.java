package bank;

public class SavingsAccount extends BankAccount {
    private String interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, String balance, String interestRate) {

        super(accountNumber, accountHolderName, balance);

        this.interestRate = interestRate;
    }

    public void calculateInterest() {

        double balance = getBalance();
        double rate = Double.parseDouble(interestRate);

        double interest = (balance * rate) / 100;

        System.out.println("Interest Amount = Rs. " + interest);
    }
}
