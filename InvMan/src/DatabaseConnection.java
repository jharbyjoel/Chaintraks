import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    DatabaseConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chaintrak", "root",
                    "6138385");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from plants");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("sku"));
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
