package Test;

import DAO.DAO_Login;
import Model.NguoiDung;
import Program.ConnectMySQL;

import javax.swing.*;
import java.sql.Connection;

public class TestSQL {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            Connection con = ConnectMySQL.getConnection();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
