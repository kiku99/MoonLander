package FIrebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ConectionFirebase {

    public void initFirebase(){

        try {
            FileInputStream serviceAccount = new FileInputStream("credentials.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://sourcecode-377cf-default-rtdb.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            Logger.getLogger(ConectionFirebase.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
