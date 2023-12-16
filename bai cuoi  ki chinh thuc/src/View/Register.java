package View;

import Controller.RegisterController;

import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class Register extends JFrame {
    public final JLabel lblUsername;
    public final JTextField txtUsername;
    public final JLabel lblPassword;
    public final JPasswordField txtPassword;
    public final JLabel lblRole;
    public final JComboBox<String> cbRole;
    public final JButton btnCancel;
    public final JButton btnRegister;

    public Register(){

        super("Register");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));

        Font font = new Font("Arial", Font.BOLD, 30);
        Font font_chu = new Font("Arial", Font.BOLD,15);


        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        lblUsername = new JLabel("user name:");
        lblUsername.setFont(font_chu);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(lblUsername, gbc);

        txtUsername = new JTextField(10);
        txtUsername.setFont(font_chu);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(txtUsername, gbc);

        lblPassword = new JLabel("password:");
        lblPassword.setFont(font_chu);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(lblPassword, gbc);

        txtPassword = new JPasswordField(10);
        txtPassword.setFont(font_chu);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(txtPassword, gbc);

        lblRole = new JLabel("role:");
        lblRole.setFont(font_chu);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(lblRole, gbc);

        cbRole = new JComboBox<>(new String[] {"User"});
        cbRole.setFont(font_chu);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(cbRole, gbc);

        JPanel jPanel_chucnang = new JPanel();
        jPanel_chucnang.setLayout(new FlowLayout());
        btnRegister = new JButton("Register");
        btnRegister.setFont(font_chu);
        btnCancel = new JButton("Cancel");
        btnCancel.setFont(font_chu);
        jPanel_chucnang.add(btnRegister);
        jPanel_chucnang.add(btnCancel);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(jPanel_chucnang, gbc);


        JLabel jLabel_tieudeLog = new JLabel("REGISTER");
        jLabel_tieudeLog.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(jLabel_tieudeLog, gbc);

        RegisterController handler = new RegisterController(this);
        btnRegister.addActionListener(handler);
        btnCancel.addActionListener(handler);


        JPanel jPanel_anh = new JPanel();
        jPanel_anh.setLayout(new BorderLayout());
        jPanel_anh.setBackground(Color.red);
        JLabel jLabel_tieude = new JLabel("Vé Xe Giá Rẻ");
        jLabel_tieude.setForeground(Color.WHITE);
        jLabel_tieude.setFont(font);

        jLabel_tieude.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel_anh.add(jLabel_tieude, BorderLayout.CENTER);


        // Thêm JPanel vào cửa sổ
        // Sử dụng phương thức add với tham số là vị trí để đặt các JPanel ở các vùng khác nhau của cửa sổ
        add(jPanel_anh);
        add(panel);



        URL urlIconApp = Login.class.getResource("icon_app.png");
        Image img = Toolkit.getDefaultToolkit().createImage(urlIconApp);
        this.setIconImage(img);

        // Hiển thị cửa sổ
        setVisible(true);
    }

}
