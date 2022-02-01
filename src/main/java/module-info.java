module Covid.Tracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires firebase.admin;
    requires com.google.auth.oauth2;
    requires java.desktop;
    opens sample to javafx.fxml;
    exports sample;
}