package View;


import Controller.Listenner;
import Model.NguoiDung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame {
    public Label lb_username, lb_password, lb_role, lb_message;
    public JTextField txt_useranme;
    public JPasswordField txt_password;
    public JComboBox<String> comboBox;
    public JButton btn_Login, btn_cancel;
    public Connection con;
    public PreparedStatement stmt;
    public ResultSet rs;

    public  Login(){
        super("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,2));



        //tạo giao diện đăng nhập
        JPanel jPanel_trai = new JPanel();
        jPanel_trai.setLayout(new GridLayout(5,2,10,10));

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
        lb_role = new Label("Role");
        comboBox = new JComboBox<>(new String[]{"admin", "user"});
        jPanel_trai.add(lb_role);
        jPanel_trai.add(comboBox);

        //các nút thao tác để đăng nhập hoặc hủy bỏ đăng nhập
        btn_Login = new JButton("Login");
        btn_cancel = new JButton("Cancel");
        jPanel_trai.add(btn_Login);
        jPanel_trai.add(btn_cancel);


        //tạo thông báo tới người dùng
        lb_message = new Label("", SwingConstants.CENTER);
        lb_message.setForeground(Color.RED);
        jPanel_trai.add(lb_message);



        JPanel jPanel_phai = new JPanel();
        jPanel_phai.setLayout(new BorderLayout());
        JButton jButton = new JButton("QUẢN LÝ BÁN VÉ");
        jPanel_phai.add(jButton, BorderLayout.CENTER);




         add(jPanel_phai);
         add(jPanel_trai);

        ActionListener ac = new  Listenner(this);
        btn_Login.addActionListener(ac);
        btn_cancel.addActionListener(ac);


        this.setVisible(true);

    }






}