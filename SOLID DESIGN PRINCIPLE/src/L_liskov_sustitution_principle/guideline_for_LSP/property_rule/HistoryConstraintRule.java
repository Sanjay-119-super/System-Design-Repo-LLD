package L_liskov_sustitution_principle.guideline_for_LSP.property_rule;

class Acc{
    protected double balance;

    public Acc(double balance){
        this.balance=balance;
    }

    public void withdraw(double amount){
        if (balance -amount <0){
            throw new RuntimeException("Amount negative");
        }
        balance-=amount;
    }
}

class FixedDeposit extends Acc{
    public FixedDeposit(double b){
        super(b);
    }

    @Override
    public void withdraw(double amount) {
        if (balance-amount <0) throw new RuntimeException("Not allow");
    }
}
public class HistoryConstraintRule {
    public static void main(String[] args) {
        Acc acc = new Acc(100);
        acc.withdraw(50);

        try {
            Acc acc1 = new FixedDeposit(200);
            acc1.withdraw(500);
        }catch (RuntimeException e){
            System.out.println("Not Allow: " +e.getLocalizedMessage());
        }
    }
}
