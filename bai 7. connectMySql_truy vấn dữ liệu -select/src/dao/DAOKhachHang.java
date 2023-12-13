package dao;

import Model.KhachHang;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOKhachHang implements DAOInterface<KhachHang>{

    public static DAOKhachHang getInstance(){
        return new DAOKhachHang();
    }
    @Override
    public int insert(KhachHang khachHang) {
        int ketQua = 0;
        try {
            //tạo kết nối với cơ sở dữ liệu
            Connection con = JDBCUtil.getConnection();

            //tạo ra đối tượng statement

            Statement st = con.createStatement();

            String sql = "insert into KhachHang(id, hoVaTen, ngaySinh, diaChi)"+
                         "values("+ khachHang.getId()+", '"+khachHang.getHoVaTen()+"', '"+
                         khachHang.getNgaySinh()+"', '"+khachHang.getDiaChi()+"')";

            System.out.println(sql);
            ketQua = st.executeUpdate(sql);

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(KhachHang khachHang) {
        return 0;
    }

    @Override
    public int delete(KhachHang khachHang) {
        return 0;
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        return null;
    }

    @Override
    public KhachHang selectById(KhachHang khachHang) {
        return null;
    }

    @Override
    public ArrayList<KhachHang> selectByCondition(String condition) {
        return null;
    }
}
