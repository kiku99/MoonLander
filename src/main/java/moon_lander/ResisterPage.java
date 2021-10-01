package moon_lander;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResisterPage extends JFrame {
    private JTextField tResisterID;
    private JButton btnAddAccount;
    private JPanel resisterPanel;
    private JPasswordField tResisterPw;

    public String ID;

    public char[] pw;

    public ResisterPage(){

        setContentPane(resisterPanel);
        setTitle("resister");
        setSize(450, 300);
        setVisible(true);

        Dimension frameSize = getSize();

        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();

        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);

        btnAddAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ID = tResisterID.getText();
                pw = tResisterPw.getPassword();

                new LoginPage();
                dispose();
            }
        });
    }


}
