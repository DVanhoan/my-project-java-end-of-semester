package Test;

import View.Login;
import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Login();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
