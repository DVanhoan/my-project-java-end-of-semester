package View;



import Controller.AdminController;
import DAO.DAO_ChuyenXe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class Admin_view extends JFrame {
    public final JButton jButton_Logout;
    public final JButton jButton_add;
    public final JButton jButton_edit;
    public final JButton jButton_delete;
    public final JTextField tf_id;
    public final JTextField tf_dienDi;
    public final JTextField tf_dienDen;
    public final JTextField tf_ngay;
    public final JTextField tf_sove;
    public final JTextField tf_giaVe;
    public JTable table;
    public DefaultTableModel tableModel;
    public  Admin_view(){

        setTitle("Quản lí bán vé xe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Font font_tieude = new Font("Arial", Font.BOLD, 25);
        Font font_chuBang = new Font("Arial", Font.BOLD, 20);
        Font font_chu = new Font("Arial", Font.BOLD, 18);




        JPanel jPanel_nhap = new JPanel();
        jPanel_nhap.setLayout(new GridLayout(3,4));

        JLabel jLabel_id = new JLabel("Mã chuyến xe:",0);
        jLabel_id.setFont(font_chu);
        tf_id = new JTextField("");
        tf_id.setFont(font_chu);

        JLabel jLabel_diemDi = new JLabel("Điểm đi:",0);
        jLabel_diemDi.setFont(font_chu);
        tf_dienDi = new JTextField("");
        tf_dienDi.setFont(font_chu);

        JLabel jLabel_diemDen = new JLabel("Điểm đến:",0);
        jLabel_diemDen.setFont(font_chu);
        tf_dienDen = new JTextField("");
        tf_dienDen.setFont(font_chu);

        JLabel jLabel_ngay = new JLabel("Ngày khởi hành:",0);
        jLabel_ngay.setFont(font_chu);
        tf_ngay = new JTextField("");
        tf_ngay.setFont(font_chu);

        JLabel jLabel_giaVe = new JLabel("giá Vé:",0);
        jLabel_giaVe.setFont(font_chu);
        tf_giaVe = new JTextField("");
        tf_giaVe.setFont(font_chu);

        JLabel jLabel_sove = new JLabel("Số vé còn lại:",0);
        jLabel_sove.setFont(font_chu);
        tf_sove = new JTextField("");
        tf_sove.setFont(font_chu);

        jPanel_nhap.add(jLabel_id);
        jPanel_nhap.add(tf_id);
        jPanel_nhap.add(jLabel_diemDi);
        jPanel_nhap.add(tf_dienDi);
        jPanel_nhap.add(jLabel_diemDen);
        jPanel_nhap.add(tf_dienDen);
        jPanel_nhap.add(jLabel_ngay);
        jPanel_nhap.add(tf_ngay);
        jPanel_nhap.add(jLabel_giaVe);
        jPanel_nhap.add(tf_giaVe);
        jPanel_nhap.add(jLabel_sove);
        jPanel_nhap.add(tf_sove);


        JPanel jPanel_chucnag = new JPanel();
        jPanel_chucnag.setLayout(new FlowLayout());

        AdminController ac = new AdminController(this);



        jButton_add = new JButton("add");
        jButton_add.setFont(font_chu);
        jButton_add.addActionListener(ac);
        jButton_edit = new JButton("edit");
        jButton_edit.setFont(font_chu);
        jButton_edit.addActionListener(ac);
        jButton_delete = new JButton("delete");
        jButton_delete.setFont(font_chu);
        jButton_delete.addActionListener(ac);
        jButton_Logout = new JButton("Logout");
        jButton_Logout.setFont(font_chu);
        jButton_Logout.addActionListener(ac);

        jPanel_chucnag.add(jButton_add);
        jPanel_chucnag.add(jButton_edit);
        jPanel_chucnag.add(jButton_delete);
        jPanel_chucnag.add(jButton_Logout);



        JPanel panel_bang = new JPanel();
        JLabel label = new JLabel("Danh sách chuyến xe");
        label.setFont(font_tieude);

        tableModel = new DefaultTableModel();

        tableModel.addColumn("Mã chuyến xe");
        tableModel.addColumn("Điểm đi");
        tableModel.addColumn("Điểm đến");
        tableModel.addColumn("Ngày khởi hành");
        tableModel.addColumn("giá vé");
        tableModel.addColumn("Số vé còn lại");

// Tạo bảng từ mô hình bảng
        table = new JTable(tableModel);
        table.addMouseListener(ac);

// Cho phép bảng sắp xếp dữ liệu theo cột
        table.setAutoCreateRowSorter(true);

// Cho phép bảng tự động điều chỉnh kích thước các cột
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(988, 400));



        panel_bang.add(label);
        panel_bang.add(scrollPane);


        ac.selectAll();

        add(jPanel_chucnag, BorderLayout.SOUTH);
        add(jPanel_nhap, BorderLayout.CENTER);
        add(panel_bang, BorderLayout.NORTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Admin_view();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}


