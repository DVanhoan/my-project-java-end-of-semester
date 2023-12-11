package View;


import javax.swing.*;
import java.awt.*;

public class Tab1_View extends JFrame {
    public  Tab1_View(){
        this.setTitle("Bán Vé Xe");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1,2));

        JPanel jPanel_trai = new JPanel();
        jPanel_trai.setLayout(new BorderLayout());

        JLabel header = new JLabel("Thực Đơn Nhà Hàng Vippo");
        JPanel jPanel_tieude = new JPanel();
        jPanel_tieude.add(header);
        jPanel_trai.add(jPanel_tieude, BorderLayout.NORTH);





















        JPanel jPanel_phai = new JPanel();
        jPanel_phai.setLayout(new BorderLayout());
        JButton jButton = new JButton("chao");
        jPanel_phai.add(jButton, BorderLayout.CENTER);




        this.add(jPanel_phai, BorderLayout.WEST);
        this.add(jPanel_trai, BorderLayout.EAST);
        this.setVisible(true);

    }


}