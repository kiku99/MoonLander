//package FIrebase;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.firestore.Firestore;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.cloud.FirestoreClient;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class ConectionFirebase {
//
//
//    private Firestore bd = null;
//
//    public Firestore iniciciarFirebase(){
//
//        FirebaseOptions options = null;
//        try {
//            options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(getClass().getResourceAsStream("sourcecode-377cf-firebase-adminsdk-dfsej-4bef89f08f.json")))
//                    .setDatabaseUrl("https://sourcecode-377cf.firebaseio.com")
//                    .build();
//
//            FirebaseApp.initializeApp(options);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return FirestoreClient.getFirestore();
//
//    }
//}
