package L_liskov_sustitution_principle;

import java.util.ArrayList;
import java.util.List;

//common for all classes
interface Account1{
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

//saving account
class SavingAcc1 implements Account1{
    private double balance;
    private String AccName;

    public SavingAcc1(double balance,String name){
        this.balance=balance;
        this.AccName=name;
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
        System.out.println(AccName + ": ₹" + amount + " deposited.");
    }

    @Override
    public void withdraw(double amount) {
        balance-=amount;
        System.out.println(AccName + ": ₹" + amount + " withdrawn.");
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

//current account
class CurrentAcc1 implements Account1{
    private double balance;
    private String AccName;

    public CurrentAcc1(double balance, String accName){
        this.balance=balance;
        this.AccName=accName;
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
        System.out.println(AccName + ": ₹" + amount + " deposited.");
    }

    @Override
    public void withdraw(double amount) {
        balance-=amount;
        System.out.println(AccName + ": ₹" + amount + " withdrawn.");
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

// fixed account || here break LSP ==> fiexed account never allow withdraw only allow deposit
class FixedAcc1 implements Account1{
    private double balance;
    private String AccName;

    public FixedAcc1(double balance, String accName){
        this.balance=balance;
        this.AccName=accName;
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
        System.out.println(AccName + ": ₹" + amount + " deposited.");
    }

    @Override
    public void withdraw(double amount) {
        balance-=amount;
        System.out.println(AccName + ": ₹" + amount + " withdrawn.");
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

// client for use accounts
class Client1{
    List<Account1> account1s = new ArrayList<>();

    //add account
    public void addAcc(Account1 account1){
        account1s.add(account1);
    }

    //process
    public void process(){
        for (Account1 acc: account1s){
            System.out.println("--------------------------------------------------");
            acc.deposit(100);



            if (!((acc) instanceof FixedAcc1)){
                acc.withdraw(200);
            }
            else {
                System.out.println("Withdraw not allo bhai...");
            }
            System.out.println("✅ Final Balance: ₹" + acc.getBalance());

        }

    }
}



public class LSPClientChecking {
    public static void main(String[] args) {
        Client1 client1 = new Client1();
        client1.addAcc(new SavingAcc1(1000.00,"Saving Account"));
        client1.addAcc(new CurrentAcc1(2000.00,"Current Account"));
        client1.addAcc(new FixedAcc1(3000.00,"Fixed Account"));

        client1.process();
    }
}
