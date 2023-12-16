package Controller;

import View.Login;
import View.Register;
import database.JDBCUtil;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class RegisterController implements ActionListener {

    private Register register;


    public RegisterController(Register register) {
        this.register = register;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register.btnRegister) {
            String username = register.txtUsername.getText();
            String password = new String(register.txtPassword.getPassword());
            String role = register.cbRole.getSelectedItem().toString();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(register, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                Connection con = null;
                try {
                    con = JDBCUtil.getConnection();
                    String sql = "insert into User (username, password, role) values (?, ?, ?)";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    stmt.setString(3, role);

                    int result = stmt.executeUpdate();

                    if (result > 0) {
                        JOptionPane.showMessageDialog(register, "Đăng ký thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        con.close();
                        register.setVisible(false);
                        new Login();
                    } else {
                        JOptionPane.showMessageDialog(register, "Đăng ký thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        if (e.getSource() == register.btnCancel) {
            register.setVisible(false);
            new Login();

        }
    }
}
