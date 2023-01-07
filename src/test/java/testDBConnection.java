import java.net.MalformedURLException;
import java.sql.*;

public class testDBConnection {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cicle-staging", "arbiminanda", "admin");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM `company`;");
        resultSet.next();
        resultSet.next();
        String companyName = resultSet.getString("name");
        System.out.println(companyName);

    }

}
