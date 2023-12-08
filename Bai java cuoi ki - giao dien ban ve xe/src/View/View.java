package View;

import javax.swing.*;
import java.awt.*;


public class View extends JFrame {

    public View(){
        this.createGUI();
        this.setDisplay();
    }

    private void setDisplay() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void createGUI() {
        //Tao danh sach cac Tab cua ung dung.
        JTabbedPane tabbedPane = new JTabbedPane();





        //Thiet ke Tab Dau tien cua ung dung.
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(new JScrollPane(createTextArea(10, 40)), BorderLayout.NORTH);




        JTextArea ta = new JTextArea(10, 40);
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);
        ta.setForeground(Color.BLUE);


        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.add(ta);



        //Thiet ke Tab thu hai cua ung ung.
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(jScrollPane, BorderLayout.NORTH);




        JButton button = new JButton("Login");
        panel2.add(button, BorderLayout.SOUTH);




        //Thiet lap Tab thu ba cho ung dung.
        JPanel panel3 = new JPanel(new GridLayout(1, 1));
        JLabel lb = new JLabel("");
        lb.setHorizontalAlignment(JLabel.CENTER);
        panel3.add(lb);







        /* add three tab with three JPanel */
        tabbedPane.addTab("Tab 1", null, panel1, "click to show panel 1");
        tabbedPane.addTab("Tab 2", null, panel2, "click to show panel 2");
        tabbedPane.addTab("Tab 3", null, panel3, "click to show panel 3");


        this.add(tabbedPane);
    }





    private JTextArea createTextArea(int row, int col) {
        JTextArea ta = new JTextArea(row, col);
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);
        ta.setForeground(Color.BLUE);
        return ta;
    }


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new View();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}