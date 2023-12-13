package View;// Import các thư viện cần thiết

import Program.ConnectMySQL;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
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
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        // Tạo các thành phần GUI và thêm vào JPanel
        lblUsername = new JLabel("user name:",0);
        txtUsername = new JTextField();
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

        // Đăng ký sự kiện cho các nút nhấn
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);

        // Thêm JPanel vào cửa sổ
        add(panel);

        // Hiển thị cửa sổ
        setVisible(true);
    }

    // Hàm xử lý sự kiện
    @Override
    public void actionPerformed(ActionEvent e) {
        // Nếu người dùng nhấn nút Đăng nhập
        if (e.getSource() == btnLogin) {
            // Lấy thông tin đăng nhập từ giao diện
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            String role = cbRole.getSelectedItem().toString();

            // Kiểm tra tính hợp lệ của thông tin đăng nhập
            if (username.isEmpty() || password.isEmpty()) {
                lblMessage.setText("Vui lòng nhập đầy đủ thông tin!");
            } else {
                // Kết nối với cơ sở dữ liệu
                try {
                    con = ConnectMySQL.getConnection();
                    // Tạo câu lệnh truy vấn
                    String sql = "select * from User";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    stmt.setString(3, role);
                    // Thực hiện truy vấn
                    rs = stmt.executeQuery();
                    // Kiểm tra kết quả truy vấn
                    if (rs.next()) {
                        // Nếu có bản ghi thỏa mãn, đăng nhập thành công
                        lblMessage.setText("Đăng nhập thành công!");
                        // Đóng kết nối
                        con.close();
                        // Ẩn cửa sổ đăng nhập
                        this.setVisible(false);
                        // Mở cửa sổ mới tùy theo vai trò
                        if (role.equals("Admin")) {
                            new Admin_view();
                        } else {
                            new User_view();
                        }
                    } else {
                        // Nếu không có bản ghi thỏa mãn, đăng nhập thất bại
                        lblMessage.setText("Đăng nhập thất bại!");
                        // Đóng kết nối
                        con.close();
                    }
                } catch (SQLException ex) {
                    // Nếu có lỗi xảy ra, hiển thị thông báo
                    ex.printStackTrace();
                    lblMessage.setText("Lỗi kết nối cơ sở dữ liệu!");
                }
            }
        }

        // Nếu người dùng nhấn nút Hủy bỏ
        if (e.getSource() == btnCancel) {
            // Thoát chương trình
            System.exit(0);
        }
    }



}