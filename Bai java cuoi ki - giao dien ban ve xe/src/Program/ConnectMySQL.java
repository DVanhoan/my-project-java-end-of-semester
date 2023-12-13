package Program;


import java.sql.*;

public class ConnectMySQL {
    public static Connection getConnection() throws SQLException {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mySQL://127.0.0.1:3306/NhaSach?useSSL=false";
            String username = "root";
            String password = "duongvanhoan22082005";

            // tao ket noi
            con = DriverManager.getConnection(url, username, password);

            System.out.println("suscesful!!!");
        } catch (SQLException e) {
            System.out.println("Error!!!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(Connection con){
        try {
            if (con != null){
                con.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}