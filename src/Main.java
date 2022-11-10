import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("numbergame-de078-firebase-adminsdk-whekw-084c44b6c4.json");
        } catch (Exception e) {
            System.out.println("Public key File couldn't read! ");
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
if (FirebaseService.getDocumentdata("name").equals("null")) {
    FirebaseService.serviceForsend(Opinion);
    TimeUnit.SECONDS.sleep(10);
    if (FirebaseService.getDocumentdata("name").equals("agree")){
        if (Opinion.equalsIgnoreCase("host")){
            System.out.println("Congrats you are host! Enter secret number: ");
            int number = sc.nextInt();
            FirebaseService.serviceForsend("agree",number);
            System.out.println("wait for 15 seconds!");
            TimeUnit.SECONDS.sleep(15);
            FirebaseService.getDocumentdata("guess");
        }
    }
}




        //FirebaseService.serviceForRead();
    }

}



