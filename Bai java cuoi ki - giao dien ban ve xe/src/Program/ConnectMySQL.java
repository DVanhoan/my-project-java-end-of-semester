package Program;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectMySQL {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/testdb?useSSL=false";
            String user = "root";
            String password = "duongvanhoan22082005";

            Connection connection = (Connection) DriverManager.getConnection(url, user, password);

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from student");

            while (rs.next()){
                System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                        + "  " + rs.getString(3));
            }

            connection.close();



            // chao cac ban da doi
            System.out.println("Suscessful!!!!!!!!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error!!!!!!!!");
            e.printStackTrace();
        }

    }
}