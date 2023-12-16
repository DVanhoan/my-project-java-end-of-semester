package dao;

import Model.Sach;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SachDAO implements DAOInterface<Sach>{

    public static SachDAO getInstance(){
        return new SachDAO();
    }
    @Override
    public int insert(Sach sach)  {
        int ketQua =  0;
        try {
            //bước 1: tạo kết nối với csdl
            Connection con = JDBCUtil.getConnection();

            //bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            //bước 3: thực thi câu lệnh Sql
            String sql = "insert into Sach(id, tenSach, giaBan, namXuatBan)"+
                    " values('"+sach.getId()+"', '"+ sach.getTenSach()+"', "+sach.getGiaBan()+", "+sach.getNamXuatBan()+")";



            ketQua = st.executeUpdate(sql);


            //bước 4:
            System.out.println("bạn đã thực thi: "+ sql);
            System.out.println("có "+ketQua+" dòng bị thay đổi!");

            //bước 5: ngắt kết nối với cơ sở dữ lieu
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int update(Sach sach) {
        int ketQua =  0;
        try {
            //bước 1: tạo kết nối với csdl
            Connection con = JDBCUtil.getConnection();

            //bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            //bước 3: thực thi câu lệnh Sql
            String sql = "update Sach"+
                         " set "+
                         "tenSach = '"+ sach.getTenSach() + "', "+
                         "giaBan = "+sach.getGiaBan()+", "+
                         "namXuatBan = "+sach.getNamXuatBan()+
                         " where id = '"+ sach.getId()+"'";


            System.out.println(sql);
            ketQua = st.executeUpdate(sql);


            //bước 4:
            System.out.println("bạn đã thực thi: "+ sql);
            System.out.println("có "+ketQua+" dòng bị thay đổi!");

            //bước 5: ngắt kết nối với cơ sở dữ lieu
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int delete(Sach sach) {
        int ketQua =  0;
        try {
            //bước 1: tạo kết nối với csdl
            Connection con = JDBCUtil.getConnection();

            //bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            //bước 3: thực thi câu lệnh Sql
            String sql = "delete from Sach " +
                         " where id = '"+sach.getId()+ "'";


            System.out.println(sql);
            ketQua = st.executeUpdate(sql);


            //bước 5: ngắt kết nối với cơ sở dữ lieu
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> ketQua =  new ArrayList<Sach>();
        try {
            //bước 1: tạo kết nối với csdl
            Connection con = JDBCUtil.getConnection();

            //bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            //bước 3: thực thi câu lệnh Sql
            String sql = "select * from Sach";




            System.out.println(sql);
            ResultSet rs =  st.executeQuery(sql);


            while (rs.next()){
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getInt("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                System.out.println(id+ "  " + tenSach + "  " + giaBan + "  " + namXuatBan);
            }


            //bước 5: ngắt kết nối với cơ sở dữ lieu
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public Sach selectById(Sach sach) {
        return null;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        return null;
    }
}
