package S_single_responsibily_principle;

// TODO SRP Follow karne wali Real-World Architecture
public class ProductFollowSRP {
    //Only Product data handle karega
    private String name;
    private double price;

    public ProductFollowSRP(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    //calculate price only
    public void calculatePrice(){
        System.out.println("Product price calculating->" + getPrice());
    }

    @Override
    public String toString() {
        return "ProductFollowSRP{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}



//Sirf DB-related kaam
class CartStorage{
    private ProductFollowSRP srp;

    public void saveToDB(ProductFollowSRP product){
        System.out.println("Data save in DB-> " + product);
    }
}

//Sirf invoice PDF banane ka kaam
class CartInvoicePrinter{
    private ProductFollowSRP srp;

    public void printInvoice(ProductFollowSRP invoice){
        System.out.println("Invoice printing-> " + invoice);
    }
}

class Test{
    public static void main(String[] args) {
        ProductFollowSRP product = new ProductFollowSRP("Ipad",35000.00);
        product.calculatePrice();

        CartInvoicePrinter printer = new CartInvoicePrinter();
        printer.printInvoice(product);

        CartStorage storage = new CartStorage();
        storage.saveToDB(product);
    }
}

/*
🔍 Feature	              🎯 Benefit
Easy Maintainability-->	Alag classes, alag changes possible
Easy Testing-->     	Unit test har class individually
Low Coupling-->	        Ek class ke change ka dusri pe effect nahi

 */