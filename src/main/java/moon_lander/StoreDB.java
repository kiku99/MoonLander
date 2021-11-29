package moon_lander;

import com.google.firebase.database.*;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StoreDB {

    private final FirebaseDatabase db = FirebaseDatabase.getInstance();

    private final DatabaseReference userRef = db.getReference("users");

    public static Object score;

    Logger logger = Logger.getLogger(StoreDB.class.getName());


    public void storeScore(int score) {
        HashMap<String, Integer> users = new HashMap<>();
        users.put("high score", score);
        this.userRef.setValueAsync(users);
    }

    public void readData(){
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                logger.log(Level.INFO, "ss");
                score = dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                logger.log(Level.INFO, "ss");
            }
        });
    }

    public Object returnData(){
        return score;
    }
}
