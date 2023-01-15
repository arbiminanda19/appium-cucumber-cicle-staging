package helper;

import java.sql.*;

public class dbConnection {

    public String getCompanyName() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cicle-staging", "arbiminanda", "admin");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM `company`;");
        resultSet.next();
        String companyName = resultSet.getString("name");
        return companyName;
    }

}
