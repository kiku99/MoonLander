package moon_lander;

import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.*;

import java.util.HashMap;

public class StoreDB {

    private final FirebaseDatabase db = FirebaseDatabase.getInstance();

    private DatabaseReference userRef = db.getReference("users");

    private LoginPage loginPage;
    public static Object score;


    public void storeScore(int score) {
        HashMap<String, Integer> users = new HashMap<>();
        users.put("high score", score);
        this.userRef.setValueAsync(users);
        readData();
    }

    public void readData(){
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println(dataSnapshot.getValue());
                score = dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("read data failed");
            }
        });
    }

}
