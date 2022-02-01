package sample;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class Main extends Application {
    DatabaseReference reference, reference2,reference3,reference4,reference5;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 550   , 600));
        primaryStage.show();

        Connection connection = new Connection();
        FirebaseDatabase database = connection.createConnection(); // Creating the conneciton
        reference = database.getReference("Statistics");
        reference2 = database.getReference("PatientsList"); // The patients list here
        reference3=database.getReference("Statistics/Infected");
        reference4=database.getReference("Statistics/Dead");
        reference5=database.getReference("Statistics/Recovered");

    }
    private String createReference(String f, String t) { // creating a reference of the files
        StringBuilder sb = new StringBuilder(100);
        sb.append("PatientsList/");
        sb.append(f);
        sb.append("/");
        sb.append(t);
        String path = sb.toString();
        return path;
    }


    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
    }
}
