package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class User_view extends JFrame {
    public JTable table_user;
    public DefaultTableModel tableModel_user;
    public JPanel jPanel_chuc_nang;


    public User_view(){
        setTitle("Bán vé xe giá rẻ");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,2));



        JPanel jPanel_chucnang = new JPanel();
        jPanel_chucnang.setLayout(new FlowLayout());

        JButton jButton_mua = new JButton("Buy");
        JButton jButton_huy = new JButton("Cancel");
        JButton jButton_add = new JButton("Add");

        jPanel_chucnang.add(jButton_add);
        jPanel_chucnang.add(jButton_huy);
        jPanel_chucnang.add(jButton_mua);



        //khu vuc tao bang hien thi danh sach ve xe
        JPanel jPanel_bang = new JPanel();

        JLabel label = new JLabel("Danh sách chuyến xe");


        tableModel_user = new DefaultTableModel();
        tableModel_user.addColumn("Mã Chuyến xe");
        tableModel_user.addColumn("Điểm đi");
        tableModel_user.addColumn("Điểm Đến");
        tableModel_user.addColumn("Ngày khởi hành");
        tableModel_user.addColumn("Giá vé");
        tableModel_user.addColumn("Số vé còn lại");

        table_user = new JTable(tableModel_user);

        JScrollPane scrollPane = new JScrollPane(table_user);
        scrollPane.setPreferredSize(new Dimension(300, 500));

        jPanel_bang.add(label);
        jPanel_bang.add(scrollPane);




        // khoang de mua bans
        JPanel jPanel_giohang = new JPanel();
        jPanel_giohang.setLayout(new BorderLayout());

        DefaultTableModel tableModel_giohang = new DefaultTableModel();
        tableModel_giohang.addColumn("Mã Chuyến xe");
        tableModel_giohang.addColumn("Giá vé");

        JTable jTable_giohang = new JTable(tableModel_giohang);


        jPanel_giohang.add(jTable_giohang, BorderLayout.CENTER);
        jPanel_giohang.add(jPanel_chucnang, BorderLayout.SOUTH);


        add(jPanel_bang);
        add(jPanel_giohang);
        setVisible(true);
    }

    public static void main(String[] args) {
        new User_view();
    }
}
