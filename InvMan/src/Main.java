import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
       //IDandPasswords idandPasswords = new IDandPasswords();
       //idandPasswords.getLoginInfo();
       //LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
       Products products = new Products();
       //AssignSku skuAssign = new AssignSku(products.getProducts());
       RemoveSku removeSku = new RemoveSku(products.getProducts());
    }
}