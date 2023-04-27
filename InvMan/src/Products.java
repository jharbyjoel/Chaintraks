import java.util.HashMap;
import java.util.Scanner;

public class Products {
    HashMap<String, Integer> products = new HashMap<String, Integer>();
    String name;
    int sku;

    Products (){

    }
    Products(String name, int sku){
        this.name = name;
        this.sku = sku;
        products.put("Basil",123456);
        products.put("Cilantro",654321);
        products.put("Rosemary",789012);
    }

    public void setProducts(HashMap<String, Integer> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    void userInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Assign a SKU to the product: ");
        Integer skuNum = scanner.nextInt();
        products.put(productName,skuNum);
        scanner.close();
    }


        protected HashMap<String, Integer> getProducts() {
        return products;
    }
}
