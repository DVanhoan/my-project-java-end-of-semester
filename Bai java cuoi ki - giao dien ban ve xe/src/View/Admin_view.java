package View;



import DAO.DAO_CHUYENXE;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class Admin_view extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    public  Admin_view(){

        setTitle("Quản lí bán vé xe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        JPanel jPanel_chucnag = new JPanel();
        jPanel_chucnag.setLayout(new FlowLayout());

        JButton jButton_add = new JButton("add");
        JButton jButton_edit = new JButton("edit");
        JButton jButton_delete = new JButton("delete");

        jPanel_chucnag.add(jButton_add);
        jPanel_chucnag.add(jButton_edit);
        jPanel_chucnag.add(jButton_delete);



        // Tạo các thành phần giao diện
        JPanel panel_bang = new JPanel();
        JLabel label = new JLabel("Danh sách chuyến xe");

// Tạo một mô hình bảng để hiển thị dữ liệu từ cơ sở dữ liệu
        tableModel = new DefaultTableModel();

// Thêm các cột vào mô hình bảng
        tableModel.addColumn("Mã chuyến xe");
        tableModel.addColumn("Điểm đi");
        tableModel.addColumn("Điểm đến");
        tableModel.addColumn("Ngày khởi hành");
        tableModel.addColumn("Số vé đã bán");

// Tạo bảng từ mô hình bảng
        table = new JTable(tableModel);

// Cho phép bảng sắp xếp dữ liệu theo cột
        table.setAutoCreateRowSorter(true);

// Cho phép bảng tự động điều chỉnh kích thước các cột
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(table);

// Đặt kích thước mong muốn cho bảng
        scrollPane.setPreferredSize(new Dimension(500, 200));

        panel_bang.add(label);
        panel_bang.add(scrollPane);


        add(jPanel_chucnag, BorderLayout.SOUTH);
        add(panel_bang, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Admin_view();
    }

}


