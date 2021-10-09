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
    //등록하려는 아이디
    private String ID = null;
    //등록하려는 비밀번호
    private char[] pw = null;

    public ResisterPage(){

        setContentPane(resisterPanel);
        setTitle("resister");
        setSize(450, 300);
        setVisible(true);

        Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        //화면 중앙에 띄우기
        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);

        //resister 버튼
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

    public String getID() {
        return ID;
    }

    public char[] getPw() {
        return pw;
    }
}
