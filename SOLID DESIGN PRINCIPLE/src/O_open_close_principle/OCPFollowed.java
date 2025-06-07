package O_open_close_principle;

//now this 100% follow OPEN - CLOSE - PRINCIPLE
class product{
    private String name;
    private double price;

    public product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


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
class CartInvoicePrinterr{
    private Product product;

    public void print(Product product){
        System.out.println("Invoice printed: " + product.getName() + " " + product.getPrice());
    }
}

// Apply OCP - work as a contract between clint and CLASSes
interface DBPersistence{

    //save all type of DATA
    void save();
}

// for SQL
class SQLPersistence implements DBPersistence{
    private Product product;

    public SQLPersistence(Product product) {
        this.product = product;
    }

    @Override
    public void save() {
        System.out.println("Product saved to Mongo: " + product);
    }
}

// for MONGO
class MongoPersistence implements DBPersistence{
    private Product product;

    public MongoPersistence(Product product) {
        this.product = product;
    }

    @Override
    public void save() {
        System.out.println("Save data in MONGO DB: " + product);
    }
}

// for FILE
class FilePersistence implements DBPersistence{
    private Product product;

    public FilePersistence(Product product) {
        this.product = product;
    }

    @Override
    public void save() {
        System.out.println("Save data in FILE: "  + product);
    }
}

public class OCPFollowed {
    public static void main(String[] args) {
        Product product = new Product("Pen" ,200.00);
        product.calculatePrice();

        CartInvoicePrinterr printerr = new CartInvoicePrinterr();
        printerr.print(product);

        DBPersistence sqlPersistence = new SQLPersistence(product);
        sqlPersistence.save();

        DBPersistence mongoPersistence = new MongoPersistence(product);
        mongoPersistence.save();

        DBPersistence filePersistence = new FilePersistence(product);
        filePersistence.save();
    }
}
