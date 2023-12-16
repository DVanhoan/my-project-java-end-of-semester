package database;



import java.sql.*;

public class JDBCUtil {


    public static Connection getConnection() throws SQLException {
        Connection c = null;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mySQL://127.0.0.1:3306/QuanLYBanVe?useSSL=false";
            String username = "root";
            String password = "duongvanhoan22082005";

            // tao ket noi
            c = DriverManager.getConnection(url, username, password);

            String sql = "insert into ChuyenXe(maChuyenXe, diemDi, diemDen, NgayKhoiHanh, SoVeDaBan)";
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection(Connection c){
        try {
            if (c != null){
                c.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void printfInfo(Connection c){
        if (c!=null){
            try {
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
