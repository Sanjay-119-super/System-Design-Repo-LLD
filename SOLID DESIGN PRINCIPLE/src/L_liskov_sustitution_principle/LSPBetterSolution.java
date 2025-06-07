package L_liskov_sustitution_principle;

// best Solution ==> Liskov substitution principle ok.....

import java.util.ArrayList;
import java.util.List;

interface NoneWithdrawAccount{
    void deposit(double amount);
    double getBalance();
}

interface NoneDepositAccount{
    void withdraw(double amount);
    double getBalance();
}

// saving account class implements--> both interfaces
class SavingAccount implements NoneDepositAccount,NoneWithdrawAccount{
    private double balance;
    private String name;

    public SavingAccount(double balance , String accountName){
        this.balance=balance;
        this.name=accountName;
    }

    @Override
    public void withdraw(double amount) {
        if (amount>balance) throw new IllegalArgumentException("Balance is low");
        balance-=amount;
        System.out.println(name + ": ₹" + amount + " withdrawn");
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
        System.out.println(name + ": ₹" + amount + " deposited");
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

// current account class--> implements --> both interfaces HAS-A
class CurrentAccount implements NoneDepositAccount , NoneWithdrawAccount{
    private double balance;
    private String name;

    public CurrentAccount(double balance, String accountName){
        this.balance=balance;
        this.name=accountName;
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
        System.out.println(name + ": ₹" + amount + " deposited");
    }

    @Override
    public void withdraw(double amount) {
        if (amount>balance) throw new IllegalArgumentException("Balance is low");
        balance-=amount;
        System.out.println(name + ": ₹" + amount + " withdrawn");
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

// fixed class only allow deposit method here apply 100% --> liskov substitution principle ):
class FixedAccount implements NoneWithdrawAccount{
    private double balance;
    private String name;

    public FixedAccount(double balance, String accountName){
        this.balance=balance;
        this.name=accountName;
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
        System.out.println(name + ": ₹" + amount + " deposited");
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

//client class
class ClientForAll{
    List<NoneDepositAccount> noneDepositAccountList = new ArrayList<>();
    List<NoneWithdrawAccount> noneWithdrawAccounts = new ArrayList<>();

    // Account Register
    public void addWithdrawableAccount(NoneDepositAccount depositAccount){
        noneDepositAccountList.add(depositAccount);
    }

    public void addDepositbleAccount(NoneWithdrawAccount withdrawAccount){
        noneWithdrawAccounts.add(withdrawAccount);
    }

    // process all deposit operation
    public void processDeposit(){
        System.out.println("------Deposit------");
        for (NoneWithdrawAccount account : noneWithdrawAccounts){
            account.deposit(1000.00);
            System.out.println("Balance after deposit: " + account.getBalance());
        }
    }

    // process all withdraw operations
    public void processWithdraw(){
        System.out.println("------Withdraw-------");
        for (NoneDepositAccount account : noneDepositAccountList){
            try {
                account.withdraw(500);
                System.out.println("Balance after withdraw: " + account.getBalance());
            }catch (IllegalArgumentException e){
                System.out.println("Error-> " + e.getMessage());
            }
        }
    }



}


public class LSPBetterSolution {
    public static void main(String[] args) {
        // create client
        ClientForAll client = new ClientForAll();

        // create account
        SavingAccount savingAccount = new SavingAccount(5000.500, "Saving Account");
        CurrentAccount currentAccount = new CurrentAccount(6600.00,"Current Account");
        FixedAccount fixedAccount = new FixedAccount(7000.00,"Fixed Account");

        // register account
        client.addDepositbleAccount(savingAccount);
        client.addWithdrawableAccount(savingAccount);

        client.addDepositbleAccount(currentAccount);
        client.addWithdrawableAccount(currentAccount);

        client.addDepositbleAccount(fixedAccount);

        // process transaction
        client.processDeposit();
        client.processWithdraw();
    }
}
