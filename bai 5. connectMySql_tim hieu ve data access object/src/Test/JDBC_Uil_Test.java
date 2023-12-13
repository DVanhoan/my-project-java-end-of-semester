package Test;

import database.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBC_Uil_Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        JDBCUtil.printfInfo(connection);
        JDBCUtil.closeConnection(connection);

    }
}
