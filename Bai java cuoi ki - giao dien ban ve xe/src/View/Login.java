package View;// Import các thư viện cần thiết

import Program.ConnectMySQL;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame{
    // Khai báo các biến thành viên
    private JLabel lblUsername, lblPassword, lblRole, lblMessage;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JComboBox<String> cbRole;
    private JButton btnLogin, btnCancel;
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    // Hàm khởi tạo
    public Login() {
        // Thiết lập tiêu đề và kích thước cửa sổ
        super("Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);










        // Tạo giao diện bằng JPanel
        JPanel panel = new JPanel();


        // Tạo các thành phần GUI và thêm vào JPanel
        lblUsername = new JLabel("user name:",0);
        txtUsername = new JTextField();
        txtUsername.setLocation(20,1);
        panel.add(lblUsername);
        panel.add(txtUsername);

        lblPassword = new JLabel("password:",0);
        txtPassword = new JPasswordField();
        panel.add(lblPassword);
        panel.add(txtPassword);

        lblRole = new JLabel("role:",0);
        cbRole = new JComboBox<>(new String[] {"Admin", "User"});
        panel.add(lblRole);
        panel.add(cbRole);

        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");
        panel.add(btnLogin);
        panel.add(btnCancel);

        lblMessage = new JLabel("", SwingConstants.CENTER);
        lblMessage.setForeground(Color.RED);
        panel.add(lblMessage);



        add(panel);

        // Hiển thị cửa sổ
        setVisible(true);
    }


    public static void main(String[] args) {
        new Login();
    }

}