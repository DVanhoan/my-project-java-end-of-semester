package DAO;

import Model.NguoiDung;
import Program.ConnectMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_Login implements DAOInterface<NguoiDung>{
    private PreparedStatement stmt;

    public static DAO_Login getInstance(){
        return new DAO_Login();
    }
    @Override
    public int insert(NguoiDung nguoiDung) throws SQLException {
        int ketQua =  0;
        try {
            //bước 1: tạo kết nối với csdl
            Connection con = ConnectMySQL.getConnection();

            //bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            //bước 3: thực thi câu lệnh Sql
            String sql = "imsert into User(name, password, role)value"+
                         "('"+nguoiDung.userName + "', '"+ nguoiDung.password+
                         "', '"+ nguoiDung.role + "')";


            ketQua = st.executeUpdate(sql);


            //bước 4:
            System.out.println("bạn đã thực thi: "+ sql);
            System.out.println("có "+ketQua+" dòng bị thay đổi!");

            //bước 5: ngắt kết nối với cơ sở dữ lieu
            ConnectMySQL.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;




    }

    @Override
    public int update(NguoiDung nguoiDung) {
        return 0;
    }

    @Override
    public int delete(NguoiDung nguoiDung) {
        return 0;
    }

    @Override
    public ArrayList<NguoiDung> selectAll() {
        return null;
    }

    @Override
    public int select_Login(NguoiDung nguoiDung) {
        return 0;
    }

    @Override
    public ArrayList<NguoiDung> selectByCondition(String condition) {
        return null;
    }
}
