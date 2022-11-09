import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("numbergame-de078-firebase-adminsdk-whekw-084c44b6c4.json");
        } catch (Exception e) {
            System.out.println("Public key File couldnt read! ");
        }

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
        System.out.println("setup done");
      ///**************************


        System.out.println("Host/ Player?");
Scanner sc =new Scanner(System.in);
String Opinion = sc.nextLine();

        FirebaseService.serviceForsend(Opinion);
        //FirebaseService.serviceForRead();
    }

}



