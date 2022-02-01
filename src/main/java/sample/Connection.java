package sample;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Connection{
    FirebaseOptions options;
    public FirebaseDatabase createConnection(){
        FirebaseDatabase database=null;
try {
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/covidapp-1aa9f-firebase-adminsdk-j33s6-62e08fe1e1.json");
             options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://covidapp-1aa9f-default-rtdb.europe-west1.firebasedatabase.app")
                    .build();

            FirebaseApp.initializeApp(options);
            database=FirebaseDatabase.getInstance();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return database;

    }
}
