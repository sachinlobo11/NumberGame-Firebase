import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {


        FileInputStream serviceAccount = null;
        try {


            serviceAccount = new FileInputStream("numbergame-de078-firebase-adminsdk-whekw-084c44b6c4.json");
        } catch (Exception e) {
        }

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("setup done");
        Firestore db = FirestoreClient.getFirestore();

        Map<String, Object> data = new HashMap<>();
        data.put("name", "sachin");
        data.put("lastname", "lobo");
        data.put("points",1000);
        ApiFuture<WriteResult> result = db.collection("users").document("Number").set(data);
        System.out.println("Update time : " + result.get().getUpdateTime());
    }
        }



