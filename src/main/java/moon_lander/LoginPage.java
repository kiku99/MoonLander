package moon_lander;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginPage extends JFrame {
    private JTextField tID;
    private JButton btnClear;
    private JButton btnOK;
    private JPanel loginPanel;
    private JPasswordField tpw;
    private JButton btnResister;

    public String ID;

    public char[] pw;

    public LoginPage() {

        setContentPane(loginPanel);
        setTitle("welcome");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Dimension frameSize = getSize();

        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();

        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ID = tID.getText();
                pw = tpw.getPassword();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tID.setText("");
                tpw.setText("");
            }
        });

        btnResister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ResisterPage();
                dispose();
            }
        });

    }
}
