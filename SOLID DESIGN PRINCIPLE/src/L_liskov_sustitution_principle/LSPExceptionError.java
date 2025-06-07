package L_liskov_sustitution_principle;

import java.util.ArrayList;
import java.util.List;

//✅ Step 1: Exception Error Version || ❌ Problem: FixedDepositAccount withdraw() method allow nahi karta,

interface Account{
    void deposit(double amount);
    void withdraw(double amount);

    double getBalance();
}

class SavingAcc implements Account{
    private double balance;

    public SavingAcc(double balance){
        this.balance=balance;
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
    }

    @Override
    public void withdraw(double amount) {
        balance-=amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

class CurrentAcc implements Account{
    private double balance;

    public CurrentAcc(double ba){
        this.balance=ba;
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
    }

    @Override
    public void withdraw(double amount) {
        balance-=amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
// ❌ FixedAccount supports only deposit
class FixedAcc implements Account{
    private double balance;

    public FixedAcc(double balance){
        this.balance=balance;
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdraw not allow in fixed Account??");
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

class Client{
    List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void processAllAcc(){
        for (Account account : accounts){
            account.deposit(1000.00);

            try {
                account.withdraw(255.00);
            }catch (UnsupportedOperationException e){
                System.out.println("Error." + e.getMessage());
            }
            System.out.println( " Final Balance: ₹" + account.getBalance());
            System.out.println("--------------------------------------------------");
        }

    }
}



public class LSPExceptionError {
    public static void main(String[] args) {
        Client client = new Client();
        client.addAccount(new SavingAcc(500.00));
        client.addAccount(new CurrentAcc(3000));
        client.addAccount(new FixedAcc(4000));

        client.processAllAcc();


    }
}
