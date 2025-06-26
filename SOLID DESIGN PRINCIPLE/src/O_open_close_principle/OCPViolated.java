package O_open_close_principle;
//todo This code break the rule of OPEN - CLOSE - PRINCIPLE ??
//handle data & price calculation
class Product{
    private String name;
    private double price;

    //constructor for set instances
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    //calculate the price
    public void calculatePrice(){
        System.out.println("Calculating price: " + getPrice());
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

// handle invoice print only
class CartInvoicePrinter{
    private Product product;

    public void print(Product product){
        System.out.println("Invoice printed: " + product.getName() + " " + product.getPrice());
    }
}

// handle all presistance activity bad practice we will see next do not worry
class CartStorage{
    private Product product;

    //save to SQL DB
    public void saveToSQL(Product product){
        System.out.println("Product saved to MYSQL: "+ product);
    }

    //save to MONGO DB
    public void saveToMongo(Product product){
        System.out.println("Product saved to Mongo: "+ product);
    }
    //save to FILE DB
    public void saveToFile(Product product){
        System.out.println("Product saved to FILE: "+ product);
    }
}

public class OCPViolated {
    public static void main(String[] args) {
        Product product = new Product("Laptop",400000.00);
        product.calculatePrice();

        CartInvoicePrinter printer = new CartInvoicePrinter();
        printer.print(product);

        CartStorage storage = new CartStorage();
        storage.saveToSQL(product);
        storage.saveToMongo(product);
        storage.saveToFile(product);
    }
}
