package com.example.loginsignup.controller;

import java.io.IOException;
//import databaseController;
import java.sql.SQLException;

import com.example.loginsignup.MainApp;
import com.example.loginsignup.animation.Shacker;
import com.example.loginsignup.helper.DBHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//import com.example.loginsignup.MainApp;

public class LoginController {
    private int id;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField userNameField;

    @FXML
    private Button loginLoginBtn;

    @FXML
    private Button loginSigupBtn;

    @FXML
    private Label textTxtField;

    // public void setUserid(int id) {
    // this.id = id;
    // }

    // public int getUserid() {
    // return id;
    // }

    private void showAddItemsScreen() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(MainApp.class.getResource("AddItems.fxml"));
        try {

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Application");
            stage.setScene(scene);
            loginLoginBtn.getScene().getWindow().hide();
            // AddItemsController addItemsController = fxmlLoader.getController();
            // addItemsController.setUserid(id);
            stage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loginUser(String loginUsername, String loginPass) throws SQLException {
        String result = DBHandler.checkUser(loginUsername, loginPass);
        id = DBHandler.userId(loginUsername);

        if (result != null) {

            showAddItemsScreen();
        } else {

            textTxtField.setText("Invalid credentials, Please try again!");
            Shacker userNameshacker = new Shacker(userNameField);
            Shacker passShacker = new Shacker(passwordField);
            passShacker.shake();
            userNameshacker.shake();

        }
        // return -1;
    }

    @FXML
    void signUpBtn(ActionEvent event) {

        System.out.println("SignUp");
        loginSigupBtn.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("SignUp.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Sign Up page");
            stage.setScene(scene);

            stage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize() {
        loginLoginBtn.setOnAction(event -> {
            String loginUsername = userNameField.getText().trim();
            String loginPass = passwordField.getText().trim();

            if (!loginUsername.equals("") || !loginPass.equals("")) {
                try {
                    loginUser(loginUsername, loginPass);
                    // setUserid();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Empty field");
            }

        });
    }

}
