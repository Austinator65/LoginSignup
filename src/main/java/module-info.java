module com.example.loginsignup {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    

    opens com.example.loginsignup to javafx.fxml;
    opens com.example.loginsignup.controller to javafx.fxml;
    exports com.example.loginsignup;
    exports com.example.loginsignup.controller;
}
