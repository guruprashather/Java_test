abstract class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance =balance+amount;
        System.out.println("Deposited " + amount + ", Balance " + balance);
    }

    abstract void withdraw(double amount);
}

interface Transaction {
    void transfer(BankAccount toAccount, double amount);
}

class SavingsAccount extends BankAccount implements Transaction {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void withdraw(double amount) {
        if (balance - amount >= 500) {
            balance =balance- amount;
            System.out.println("Withdrawn " + amount + ", Balance " + balance);
        } else {
            System.out.println("Withdrawal failed");
        }
    }

    public void transfer(BankAccount toAccount, double amount) {
        if (balance - amount >= 500) {
            withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transferred " + amount + " to " + toAccount.accountNumber);
        } else {
            System.out.println("Transfer failed");
        }
    }
}

class CurrentAccount extends BankAccount implements Transaction {
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void withdraw(double amount) {
        if (balance - amount >= -5000) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + ", Balance " + balance);
        } else {
            System.out.println("Withdrawal failed");
        }
    }

    public void transfer(BankAccount toAccount, double amount) {
        if (balance - amount >= -5000) {
            withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transferred " + amount + " to " + toAccount.accountNumber);
        } else {
            System.out.println("Transfer failed");
        }
    }
}

public class Question2 {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SAV123", 5000);
        CurrentAccount current = new CurrentAccount("CUR456", 2000);

        savings.deposit(1000);
        current.withdraw(3000);
        savings.transfer(current, 1500);
        current.transfer(savings, 6000);
    }
}
