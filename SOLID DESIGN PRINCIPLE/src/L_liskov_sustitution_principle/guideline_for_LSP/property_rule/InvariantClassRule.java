package L_liskov_sustitution_principle.guideline_for_LSP.property_rule;

class Account{
    protected double balance;

    public Account(double d){
        if (balance <0) throw new RuntimeException("negative balance");
        this.balance=d;
    }

    public void withdraw(double amount){
        if (balance -amount <0) throw new RuntimeException("Balance km hai");
        balance-=amount;
        System.out.println("Balance withdraw , Remainnig balance: " + balance);
    }
}

class CheatAccount extends Account{

    public CheatAccount(double d) {
        super(d);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount; // break the rule of LSP
        System.out.println("Amount withdraw , remaining balance: (Cheat) " + this.balance);
    }
}
public class InvariantClassRule {
    public static void main(String[] args) {
        Account account = new Account(100);
        account.withdraw(50);

        Account account1 = new CheatAccount(100);
        account1.withdraw(200);
    }
}
