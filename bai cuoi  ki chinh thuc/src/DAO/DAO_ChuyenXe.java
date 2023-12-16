package DAO;

import Model.ChuyenXe;
import View.Admin_view;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

public class DAO_ChuyenXe implements DA0_INTERFACE<ChuyenXe>{
    private Connection con = null;
    ResultSet rs = null;
    private Admin_view adminView;
    private PreparedStatement ps;

    public static ChuyenXe getInstance(){
        return new ChuyenXe();
    }


    @Override
    public ChuyenXe insert(ChuyenXe chuyenXe) {
        try {
            con = JDBCUtil.getConnection();
            String sql = "INSERT INTO ChuyenXe(MaChuyenXe, DiemDi, DiemDen, NgayKhoiHanh, GiaVe, SoVeConLai) VALUES(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, chuyenXe.getMaChuyenXe());
            ps.setString(2, chuyenXe.getDiemDi());
            ps.setString(3, chuyenXe.getDiemDen());
            ps.setString(4, chuyenXe.getNgayKhoiHanh());
            ps.setFloat(5, chuyenXe.getGiaVe());
            ps.setInt(6, chuyenXe.getSoLuongVe());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chuyenXe;
    }

    public ChuyenXe update(ChuyenXe chuyenXe) {
        try {
            con = JDBCUtil.getConnection();
            String sql = "UPDATE ChuyenXe SET DiemDi = ?, DiemDen = ?, NgayKhoiHanh = ?, GiaVe = ?, SoVeConLai = ? WHERE MaChuyenXe = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, chuyenXe.getDiemDi());
            ps.setString(2, chuyenXe.getDiemDen());
            ps.setString(3, chuyenXe.getNgayKhoiHanh());
            ps.setFloat(4, chuyenXe.getGiaVe());
            ps.setInt(5, chuyenXe.getSoLuongVe());
            ps.setString(6, chuyenXe.getMaChuyenXe());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chuyenXe;
    }

    @Override
    public ChuyenXe delete(ChuyenXe chuyenXe) {
        try {
            con = JDBCUtil.getConnection();
            String sql = "delete from ChuyenXe where MaChuyenXe = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,chuyenXe.getMaChuyenXe());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chuyenXe;
    }

    @Override
    public void selectAll() {
    }


    @Override
    public int selectById(ChuyenXe chuyenXe) {
        int row = adminView.tableModel.getRowCount();
        int result = -1; // Biến để lưu kết quả
        for(int i=0; i<row; i++){
            if (adminView.tf_id.getText().equals(chuyenXe.getMaChuyenXe())){
                result = i; // Gán giá trị của i cho result
                break; // Thoát khỏi vòng lặp
            }
        }
        return result; // Trả về result
    }


    @Override
    public ArrayList<ChuyenXe> selectByCondition(String condition) {
        return null;
    }
}
