package moon_lander;

import FIrebase.ConectionFirebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import javax.swing.*;

/**
 * Creates frame and set its properties.
 * 
 * @author www.gametutorial.net
 */

public class Window extends JFrame{
    static JFrame frame = new JFrame();
    private Window()
    {
        // Sets the title for this frame.
        frame.setTitle("Moon Lander");
        
        // Sets size of the frame.
        if(false) // Full screen mode
        {
            // Disables decorations for this frame.
            frame.setUndecorated(true);
            // Puts the frame to full screen.
            frame.setExtendedState(frame.MAXIMIZED_BOTH);
        }
        else // Window mode
        {
            // Size of the frame.
            frame.setSize(800, 600);
            // Puts frame to center of the screen.
            frame.setLocationRelativeTo(null);
            // So that frame cannot be resizable by the user.
            frame.setResizable(false);
        }
        
        // Exit the application when user close frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new Framework());



        frame.setVisible(true);
    }



    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window();
            }
        });

        LoginPage loginPage = new LoginPage();

        new ConectionFirebase().initFirebase();
    }

}
