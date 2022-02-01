package sample;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    DatabaseReference reference, reference2, reference3, reference4, reference5;
    private String successMessage = String.format("-fx-text-fill: GREEN;");
    private String errorMessage = String.format("-fx-text-fill: RED;");
    private String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    private String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");
    private String[] genders = {"Male", "Female"};
    private String[] conditions = {"Recovered", "Infected", "Dead"};
    private String diseases = "";
    private String medCondition = "";
    private String gender = "";
    private int statsInfected, statsRecovered, statsDead;
    public String statsI, statsR, statsD;


    @FXML
    private Button addButton;

    @FXML
    private CheckBox asmtha;

    @FXML
    private CheckBox diabet;

    @FXML
    private CheckBox lungCancer;

    @FXML
    private TextField patientsAge;

    @FXML
    private TextField patientsCity;

    @FXML
    private ChoiceBox<String> patientsConditon;

    @FXML
    private ChoiceBox<String> patientsGender;

    @FXML
    private TextField patientsID;

    @FXML
    private TextField patientsName;

    @FXML
    private Button updateButton;

    @FXML
    private Label invalidAge;

    @FXML
    private Label invalidCity;

    @FXML
    private Label invalidCondition;

    @FXML
    private Label invalidGender;

    @FXML
    private Label invalidID;

    @FXML
    private Label invalidName;

    @FXML
    private Label dataSaved;

    @FXML
    void addClicked(ActionEvent event) throws InterruptedException {

        String name = patientsName.getText();
        String id = patientsID.getText();
        String city = patientsCity.getText();
        String age = patientsAge.getText();
        boolean dataSent = true;

        Connection connection = new Connection();
        FirebaseDatabase database = connection.createConnection(); // Creating the conneciton
        reference = database.getReference("Statistics");
        reference2 = database.getReference("PatientsList"); // The patients list here
        reference3 = database.getReference("Statistics/Infected");
        reference4 = database.getReference("Statistics/Dead");
        reference5 = database.getReference("Statistics/Recovered");

        if (id.length() != 9 || id.isBlank()) {
            invalidID.setText("You must enter an ID with the length of 9");
            invalidID.setStyle(errorMessage);
            patientsID.setStyle(errorStyle);
            dataSent = false;

        } else {
            invalidID.setText("");
            patientsID.setStyle(successStyle);
        }
        if (name.isBlank()) {
            invalidName.setText("You must enter a name");
            invalidName.setStyle(errorMessage);
            patientsName.setStyle(errorStyle);
            dataSent = false;
        } else {
            patientsName.setStyle(successStyle);
            invalidName.setText("");
        }
        if (city.isBlank()) {
            invalidCity.setText("You must enter a city");
            invalidCity.setStyle(errorMessage);
            patientsCity.setStyle(errorStyle);
            dataSent = false;
        } else {
            patientsCity.setStyle(successStyle);
            invalidCity.setText("");

        }
        if (age.isBlank()) {
            invalidAge.setText("You must enter an age");
            invalidAge.setStyle(errorMessage);
            patientsAge.setStyle(errorStyle);
            dataSent = false;
        } else {
            patientsAge.setStyle(successStyle);
            invalidAge.setText("");

        }
        for (char c : age.toCharArray()) {
            if (!Character.isDigit(c)) {
                invalidAge.setText("You must enter only numbers");
                invalidAge.setStyle(errorMessage);
                patientsAge.setStyle(errorStyle);
                dataSent = false;
            }
        }
        if (patientsGender.getValue() == null) {
            invalidGender.setText("You must choose a gender");
            invalidGender.setStyle(errorMessage);
            patientsGender.setStyle(errorStyle);
            dataSent = false;
        } else {
            patientsGender.setStyle(successStyle);
            invalidGender.setText("");

        }
        if (patientsConditon.getValue() == null) {
            invalidCondition.setText("You must choose a condition");
            invalidCondition.setStyle(errorMessage);
            patientsConditon.setStyle(errorStyle);
            dataSent = false;
        } else {
            patientsConditon.setStyle(successStyle);
            invalidCondition.setText("");

        }

        if (dataSent) {
            dataSaved.setStyle(successMessage);
            dataSaved.setText("Data Saved Succesfully!");
        } else
            dataSaved.setText("");
        String infected = "";
        String recovered = "";
        String dead = "";
        medCondition = patientsConditon.getValue();
        gender = patientsGender.getValue();
        if (diabet.isSelected())
            diseases = "diabets, ";


        if (lungCancer.isSelected())
            diseases += "lung cancer, ";


        if (patientsConditon.getValue().toString().equals("Still Infected"))
            statsInfected++;
        if (patientsConditon.getValue().toString().equals("Recovered"))
            statsRecovered++;
        else
            statsDead++;

        DatabaseReference child;
        child = reference2.child(patientsID.getText().setValueAsync(
                new Pacient(patientsName.getText(), age, patientsAge.getText()
                        , patientsCity.getText(), gender, diseases)));


        String statInfected = String.valueOf(statsInfected);
        String statDead = String.valueOf(statsDead);
        String statRecovered = String.valueOf(statsRecovered);

        reference.child("Infected").

        setValueAsync(statInfected);
            reference.child("Recovered").

        setValueAsync(statDead);
            reference.child("Dead").

        setValueAsync(statsD);

        medCondition = patientsConditon.getValue();
        gender = patientsGender.getValue().toString();
        String infected="";
        String recovered="";
        String dead="";
        // checking for any other disaeses
                    if (lungCancer.isSelected())
        diseases = "diabets, ";
        int diseasesCount;
        diseasesCount++;

                    if (lungCancer.isSelected())
        diseases += "lung cancer, ";


                    if (asmtha.isSelected())
        diseases += "asmtha, ";

        reference2.child(patientsID.getText()).child("fullName").setValueAsync(patientsName.getText());
        reference2.child(patientsID.getText()).child("age").setValueAsync(patientsAge.getText());
        reference2.child(patientsID.getText()).child("city").setValueAsync(patientsCity.getText());
        reference2.child(patientsID.getText()).child("medCondition").setValueAsync(patientsConditon.getValue());
        reference2.child(patientsID.getText()).child("gender").setValueAsync(patientsGender.getValue());
        reference2.child(patientsID.getText()).child("diseases").setValueAsync(diseases.g);
    }
}
    @FXML
    void updateClicked(ActionEvent event) {

        dataSaved.setStyle(successMessage);
        dataSaved.setText("Data Updated Succesfully");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patientsGender.getItems().addAll(genders);
        patientsConditon.getItems().addAll(conditions);
    }
    public void viewStatsClicked(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Oops");
        alert.setContentText("Yikes, The app is not fully functional yet!");
        alert.showAndWait();

    }
}
