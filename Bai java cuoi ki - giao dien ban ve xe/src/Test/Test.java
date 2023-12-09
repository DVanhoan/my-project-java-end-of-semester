package Test;

import View.Tab1_View;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Tab1_View();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
