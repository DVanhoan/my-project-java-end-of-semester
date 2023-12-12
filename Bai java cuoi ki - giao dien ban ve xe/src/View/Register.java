package View;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register extends JFrame {
    private Label lb_username, lb_password, lb_role, lb_message;
    private JTextField txt_useranme;
    private JPasswordField txt_password;
    private JComboBox<String> comboBox;
    private JButton btn_register, btn_cancel;
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    public Register(){
        super("Register");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,2));



        //tạo giao diện đăng nhập
        JPanel jPanel_trai = new JPanel();
        jPanel_trai.setLayout(new GridLayout(5,2,5,5));

        //phần nhập tên đăng nhập
        lb_username = new Label("User Name");
        txt_useranme = new JTextField();
        jPanel_trai.add(lb_username);
        jPanel_trai.add(txt_useranme);

        //phần nhập mật khẩu
        lb_password = new Label("Password");
        txt_password = new JPasswordField();
        jPanel_trai.add(lb_password);
        jPanel_trai.add(txt_password);

        //thêm vai trò của người dùng
        lb_role = new Label("Vai trò");
        comboBox = new JComboBox<>(new String[]{"admin", "user"});
        jPanel_trai.add(lb_role);
        jPanel_trai.add(comboBox);

        //các nút thao tác để đăng nhập hoặc hủy bỏ đăng nhập
        btn_register = new JButton("register");
        btn_cancel = new JButton("Cancel");
        jPanel_trai.add(btn_register);
        jPanel_trai.add(btn_cancel);




        JPanel jPanel_phai = new JPanel();
        jPanel_phai.setLayout(new BorderLayout());
        JButton jButton = new JButton("Register");
        jPanel_phai.add(jButton, BorderLayout.CENTER);




        add(jPanel_phai);
        add(jPanel_trai);
        this.setVisible(true);
    }
}
