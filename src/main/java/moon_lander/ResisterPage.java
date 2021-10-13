package moon_lander;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResisterPage extends JFrame {
    private JTextField tResisterID;
    private JButton btnAddAccount;
    private JPanel resisterPanel;
    private JPasswordField tResisterPw;

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

                try {
                    UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                            .setEmail(tResisterID.getText())
                            .setEmailVerified(false)
                            .setDisplayName(String.valueOf(tResisterPw.getPassword()));

                    UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
                    System.out.println("유저 생성 성공");
                    JOptionPane.showMessageDialog(null, "유저 생성 성공");
                }
                catch (FirebaseAuthException ex){
                    Logger.getLogger(ResisterPage.class.getName()).log(Level.SEVERE, null, ex);
                }

                new LoginPage();
                dispose();
            }
        });
    }

}
