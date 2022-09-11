import java.sql.*;

public class ConnectionExample {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306";
        String userName = "root";
        String password = "mysql";

        Connection connection = DriverManager.getConnection(url, userName, password);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from member.member");

//        resultSet.next();
//        String email = resultSet.getString("email");
//        System.out.println(email);

        resultSet.close();
        statement.close();
        connection.close();
    }
}