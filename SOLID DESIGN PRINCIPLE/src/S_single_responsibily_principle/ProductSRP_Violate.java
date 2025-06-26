package S_single_responsibily_principle;

//⚠️ Step 2: How does your class violate SRP?
public class ProductSRP_Violate {
    private String name;
    private double price;


    //print invoice
    public void printInvoice(){
        System.out.println("Invoice printing...");
    }

    //calculate product price
    public void calculateProductPrice(){
        System.out.println("Calculating product price");
    }

    //save product data in DB
    public void saveToDB(){
        System.out.println("Data saving in DB..");
    }
}

class ViolateSingleResponsibilityPrinciple{
    public static void main(String[] args) {
        ProductSRP_Violate product = new ProductSRP_Violate();
        product.calculateProductPrice();
        product.printInvoice();
        product.saveToDB();

        /*
❌ todo-> Violation of SRP:
Ab Product class:
data store bhi kar rahi hai
data ko database me bhi save kar rahi hai
PDF invoice bhi bana rahi hai

🎯  Point:
Reason to change:

Agar DB ka structure change ho gaya – class ko change karna padega.
Agar invoice format change ho gaya – class ko change karna padega.

🛑 So, ye class multiple responsibilities le rahi hai = SRP Violate.
         */
    }
}