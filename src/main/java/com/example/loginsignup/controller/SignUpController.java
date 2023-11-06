package com.example.loginsignup.controller;

import java.sql.SQLException;

import com.example.loginsignup.helper.DBHandler;
//import com.example.loginsignup.DatabaseController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class SignUpController {

    // DatabaseController databaseController = new DatabaseController();
    // static private DatabaseController databaseController;
    // DBHandler dbHandler = new DBHandler();

    @FXML
    private TextField cpassTxt;

    @FXML
    private Button signUpBtn;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField firstNameTxt;

    @FXML
    private TextField lastNameTxt;

    @FXML
    private TextField passTxt;

    @FXML
    private TextField userNameTxt;

    @FXML
    private CheckBox termsCheckBtn;

    public void signUpUser() {
        try {

            String firstname = firstNameTxt.getText().trim();
            String lastname = lastNameTxt.getText().trim();
            String username = userNameTxt.getText().trim();
            String email = emailTxt.getText().trim();
            String pass = passTxt.getText().trim();
            String cpass = cpassTxt.getText().trim();

            if (!lastname.equals("") || !username.equals("") || !username.equals("") || !email.equals("")
                    || !pass.equals("") || !cpass.equals("")) {
                if (pass.equals(cpass)) {
                    DBHandler.addUser(firstname, lastname, username, email, pass);
                    signUpBtn.getScene().getWindow().hide();
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void initialize() {
        // DBHandler dbHandler = new DBHandler();
        signUpBtn.setOnAction(event -> {
            signUpUser();
        });

    }
}
