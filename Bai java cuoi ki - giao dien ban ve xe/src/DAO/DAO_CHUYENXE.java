package DAO;

import Model.ChuyenXe;
import Program.ConnectMySQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_CHUYENXE implements DAOInterface<ChuyenXe>{

    public static DAO_CHUYENXE getInstance(){
        return new DAO_CHUYENXE();
    }
    @Override
    public int insert(ChuyenXe chuyenXe) throws SQLException {
        int ketQua =  0;
        try {

            Connection con = ConnectMySQL.getConnection();


            Statement st = con.createStatement();


            String sql = "insert into Sach(maChuyenXe, diemDi, diemDen, NgayKhoiHanh, SoVeDaBan)"+
                    " values('"+chuyenXe.getMaChuyenXe()+"', '"+ chuyenXe.getDiemDi()+
                    "', '"+chuyenXe.getDiemDen()+"', '"+chuyenXe.getNgayKhoiHanh()+"', "+
                    chuyenXe.getSoVeDaBan()+")";


            ketQua = st.executeUpdate(sql);


            ConnectMySQL.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int update(ChuyenXe chuyenXe) {
        int ketQua =  0;
        try {

            Connection con = ConnectMySQL.getConnection();


            Statement st = con.createStatement();




            String sql = "insert into Sach(maChuyenXe, diemDi, diemDen, NgayKhoiHanh, SoVeDaBan)"+
                    " values('"+chuyenXe.getMaChuyenXe()+"', '"+ chuyenXe.getDiemDi()+
                    "', '"+chuyenXe.getDiemDen()+"', '"+chuyenXe.getNgayKhoiHanh()+"', "+
                    chuyenXe.getSoVeDaBan()+")";


            ketQua = st.executeUpdate(sql);


            ConnectMySQL.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int delete(ChuyenXe chuyenXe) {
        return 0;
    }

    @Override
    public ArrayList<ChuyenXe> selectAll() {
        return null;
    }

    @Override
    public int select_Login(ChuyenXe chuyenXe) {
        return 0;
    }

    @Override
    public ArrayList<ChuyenXe> selectByCondition(String condition) {
        return null;
    }
}
