import java.util.Scanner;

class BankAccount{
    private double balance;

    public BankAccount(double initialBalance)
    {
        this.balance=initialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if (amount>0)
            balance+=amount;
        else
            System.out.println("Invalid deposit amount.");
    }

    public boolean withdraw(double amount){
        if (amount>0 && amount <= balance){
            balance-=amount;
            return true;
        }
        else
            return false;
    }

}

class ATM{
    private final BankAccount account;

    public ATM(BankAccount account)
    {
        this.account=account;
    }
    public void displayMenu() {
        Scanner se = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Welcome to the ATM.");
            System.out.println("1 For Balance enquiry.");
            System.out.println("2 For Deposit");
            System.out.println("3 For Withdraw");
            System.out.println("4 For Exit");

            choice = se.nextInt();

            if (choice == 1) {
                checkBalance();
            } else if (choice == 2) {
                deposit(se);
            } else if (choice == 3) {
                withdraw(se);
            } else if (choice == 4) {
                System.out.println("Thank you for using the ATM.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }
    private void checkBalance()
    {
        System.out.println("Your current balance is: "+account.getBalance()+"Rs.");
    }
    private void deposit(Scanner se)
    {
        System.out.println("Enter your amount to deposit: ");
        double amount = se.nextDouble();
        account.deposit(amount);
        System.out.println("Amount deposited successfully. Your new balance is "+account.getBalance()+"Rs.");
    }
    private void withdraw(Scanner se)
    {
        System.out.println("Enter the amount to withdraw: ");
        double amount = se.nextDouble();
        if(account.withdraw(amount))
        {
            System.out.println("Amount withdraw successfully. Your new balance is :"+account.getBalance()+"Rs.");
        }
        else {
            System.out.println("Insufficient balance or invalid amount. Transaction failed.");
        }

    }
}
public class ATMcode {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0);
        ATM atm = new ATM(account);
        atm.displayMenu();
    }
}