package moon_lander;

import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;

public class StoreDB {

    private final FirebaseDatabase db = FirebaseDatabase.getInstance();

    private DatabaseReference userRef = db.getReference("users");

    private LoginPage loginPage;


    public void storeScore(int score) {
        HashMap<String, Integer> users = new HashMap<>();
        users.put("user", score);
        this.userRef.setValueAsync(users);
    }

}
