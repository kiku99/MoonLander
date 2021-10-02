package moon_lander;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class LoginPage extends JFrame {
    private JTextField tID;
    private JButton btnClear;
    private JButton btnOK;
    private JPanel loginPanel;
    private JPasswordField tpw;
    private JButton btnResister;
    private JLabel message;
    //사용자 아이디
    private static String ID = null;
    //사용자 비밀번호
    private char[] pw = null;

    private boolean logined;

    public LoginPage() {

        setContentPane(loginPanel);
        setTitle("Login");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        logined = false;

        Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        //화면을 중앙에 띄우기
        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);

        //OK버튼
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ID = tID.getText();
                pw = tpw.getPassword();

                if (ID.isEmpty() || Arrays.toString(pw).isEmpty()){
                    message.setText("아이디 또는 비밀번호를 입력하세요");
                }
                else {
                    login();
                    dispose();
                }
            }
        });

        //clear 버튼
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tID.setText("");
                tpw.setText("");
            }
        });

        //resister 버튼
        btnResister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ResisterPage();
                dispose();
            }
        });

    }

    public String getID() {
        return ID;
    }

    public char[] getPw() {
        return pw;
    }

    public boolean login(){
        logined = true;
        return true;
    }
}
