package Controller;

import DAO.DAO_ChuyenXe;
import Model.ChuyenXe;
import View.Admin_view;
import View.Login;
import database.JDBCUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.ArrayList;

public class AdminController implements ActionListener, MouseListener {
    private Admin_view adminView;
    Connection con = null;
    ResultSet rs = null;
    private DAO_ChuyenXe daoChuyenXe;

    public AdminController(Admin_view adminView) {
        this.adminView = adminView;
    }

    public void selectAll() {
        Statement st = null;
        try {
            con = JDBCUtil.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM ChuyenXe");
            adminView.tableModel.setRowCount(0);
            while (rs.next()) {
                Object[] rowdata = new Object[6];
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getFloat(5);
                rowdata[5] = rs.getInt(6);
                adminView.tableModel.addRow(rowdata);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ChuyenXe getInfor() {
        String MaChuyenXe = adminView.tf_id.getText();
        String DiemDi = adminView.tf_dienDi.getText();
        String DiemDen = adminView.tf_dienDen.getText();
        String NgayKhoiHanh = adminView.tf_ngay.getText();
        float giaVe = Float.parseFloat(adminView.tf_giaVe.getText());
        int SoLuongVe = Integer.parseInt(adminView.tf_sove.getText());

        ChuyenXe chuyenXe = new ChuyenXe(MaChuyenXe, DiemDi, DiemDen, NgayKhoiHanh, giaVe, SoLuongVe);
        return chuyenXe;
    }



    public void ThemVaoTable_QuanLy(){
        //lấy dữ liệu trong jtextfield
        ChuyenXe chuyenXe =  getInfor();
        //thêm các dữ liệu vừa thu thập được ném vào bảng đồ họa
        adminView.tableModel.addRow(new Object[]{chuyenXe.getMaChuyenXe(), chuyenXe.getDiemDi(), chuyenXe.getDiemDen(),
        chuyenXe.getNgayKhoiHanh(), chuyenXe.getGiaVe(), chuyenXe.getSoLuongVe()});

        //Thêm dữ liệu vào bảng trong cơ sở dữ liệu
        daoChuyenXe = new DAO_ChuyenXe();
        daoChuyenXe.insert(chuyenXe);
    }


    public void XoaKhoiTable_QuanLy(){
        //lấy dữ liệu trong jtextfield
        ChuyenXe chuyenXe = getInfor();

        // Xóa chuyến xe đó khỏi bảng cơ sở dữ liệu
        daoChuyenXe = new DAO_ChuyenXe();
        daoChuyenXe.delete(chuyenXe);
    }


    public void chinhSuaThongTin(){
        // thu thập dữ liệu
        ChuyenXe chuyenXe =  getInfor();

        //Chỉnh sửa dữ liệu trong bảng cơ sở dữ liệu
        daoChuyenXe = new DAO_ChuyenXe();
        daoChuyenXe.update(chuyenXe);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Xử lý sự kiện cho nút Add
        if (e.getSource()==adminView.jButton_add) {
            ThemVaoTable_QuanLy();
            JOptionPane.showMessageDialog(adminView, "Thêm vé xe thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }



        else if (e.getSource()==adminView.jButton_delete){
            XoaKhoiTable_QuanLy();
            selectAll();
            JOptionPane.showMessageDialog(adminView, "Đã xóa chuyến xe thành công!","Thông báo", JOptionPane.INFORMATION_MESSAGE);

        }



        else if (e.getSource()==adminView.jButton_edit) {
            getInfor();
            chinhSuaThongTin();
            JOptionPane.showMessageDialog(adminView, "Đã chỉnh sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            selectAll();
        }

        else if (e.getSource()==adminView.jButton_Logout){
            adminView.setVisible(false);
            new Login();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int vitri = adminView.table.getSelectedRow();
        System.out.println("vi tri "+ vitri);
        Object MaChuyenXe = adminView.tableModel.getValueAt(vitri, 0);
        adminView.tf_id.setText(MaChuyenXe.toString());
        Object DiemDi = adminView.tableModel.getValueAt(vitri, 1);
        adminView.tf_dienDi.setText(DiemDi.toString());
        Object DiemDen = adminView.tableModel.getValueAt(vitri, 2);
        adminView.tf_dienDen.setText(DiemDen.toString());
        Object NgayKhoiHanh = adminView.tableModel.getValueAt(vitri, 3);
        adminView.tf_ngay.setText(NgayKhoiHanh.toString());
        Object giaVe = adminView.tableModel.getValueAt(vitri, 4);
        adminView.tf_giaVe.setText(giaVe.toString());
        Object SoLuongVe = adminView.tableModel.getValueAt(vitri, 5);
        adminView.tf_sove.setText(SoLuongVe.toString());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
