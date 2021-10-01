package moon_lander;

import javax.swing.*;
import java.awt.*;

public class menu extends JFrame {
    private JTextField tFirstName;
    private JTextField tLastName;
    private JButton btnClear;
    private JButton btnOK;
    private JPanel mainPanel;

    public menu() {

        setContentPane(mainPanel);
        setTitle("welcome");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
