package L_liskov_sustitution_principle.guideline_for_LSP.signature_Rule;

class Parent{

    public void solve(String s){
        System.out.println("HelloG");
    }
}

class Child extends Parent{
    @Override
    public void solve(String s) {
        System.out.println("HiiG");
    }
}


class Client{
    private Parent parent;

    Client (Parent p){
        this.parent=p;
    }
    void print(){
        parent.solve("Hello");
    }
}

public class MethodArgumentRule {
    public static void main(String[] args) {

        Child c = new Child();
        c.solve("HHH");
        Parent p = new Parent();
        p.solve("HOHO");
        Client client = new Client(c);
        client.print();
        Client client1 = new Client(p);
    }
}
