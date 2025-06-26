package L_liskov_sustitution_principle.guideline_for_LSP.method_rule;

class User{
    protected String password;

    public User(String password){
        this.password=password;
    }

    public void passCreate(String num){
        if (num.length()<10){
            System.out.println("Password created");
        }
        else {
            System.out.println("Not created");
        }
    }
}

class AdminUser extends User{

    public AdminUser(String pass){
        super(pass);
    }
    @Override
    public void passCreate(String num) {
        if (num.length()<6){
            System.out.println("Password created");
        }
        else {
            System.out.println("Password not created");
        }
    }
}
public class PreConditionRule {
    public static void main(String[] args) {
        AdminUser user = new AdminUser("Admin");
        user.passCreate("12345");
    }
}
