package moon_lander;

import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;

public class StoreDB {

    UserRecord userRecord;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference().child("users");

    public StoreDB() {
        storeScore();

    }

    private void storeScore() {
        HashMap<String, Integer> users = new HashMap<String, Integer>();
        users.put(userRecord.getDisplayName(), Framework.score);
        ref.setValueAsync(users);
    }
}
