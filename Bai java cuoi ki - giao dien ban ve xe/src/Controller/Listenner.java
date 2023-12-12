package Controller;

import DAO.DAO_Login;
import Model.NguoiDung;
import Program.ConnectMySQL;
import View.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Listenner implements ActionListener {
    private Login login;


    public Listenner(Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //nếu người dùng nhấn nút Login
        if (e.getSource() == login.btn_Login){
            String userName = login.txt_useranme.getText();
            String password = new String(login.txt_password.getPassword());
            String role = login.comboBox.getSelectedItem().toString();

            if (userName.isEmpty() || password.isEmpty()){
                login.lb_message.setText("Vui lòng nhập đầy đủ thông tin");
            }
            else {
                try {
                    ConnectMySQL con = (ConnectMySQL) ConnectMySQL.getConnection();


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }



            }



        }

        if (e.getSource() == login.btn_cancel){
            System.exit(0);
        }
    }
}
