package Controller;


import View.Admin_view;
import View.Login;
import View.Register;
import View.User_view;
import database.JDBCUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginController implements ActionListener {
    private Login login;

    public LoginController(Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.btnLogin) {
            String username = login.txtUsername.getText();
            String password = new String(login.txtPassword.getPassword());
            String role = login.cbRole.getSelectedItem().toString();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(login, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                Connection con = null;
                try {
                    con = JDBCUtil.getConnection();
                    String sql = "select * from User where username = ? and password = ? and role = ?";
                    login.stmt = con.prepareStatement(sql);
                    login.stmt.setString(1, username);
                    login.stmt.setString(2, password);
                    login.stmt.setString(3, role);
                    login.rs = login.stmt.executeQuery();

                    if (login.rs.next()) {
                        JOptionPane.showMessageDialog(login, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        con.close();
                        login.setVisible(false);
                        if (role.equals("Admin")) {
                            new Admin_view();
                        } else {
                            new User_view();
                        }
                    } else {
                        JOptionPane.showMessageDialog(login, "Đăng nhập thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        if (e.getSource()==login.btnRegister){
            login.setVisible(false);
            new Register();
        }


        if (e.getSource() == login.btnCancel) {
            System.exit(0);
        }
    }
}