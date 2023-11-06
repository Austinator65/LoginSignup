package com.example.loginsignup.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import com.example.loginsignup.MainApp;
import com.example.loginsignup.helper.DBHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddItemsFormController {

    DBHandler dbHandler;
    public int id;

    @FXML
    private TextField descriptionTxt;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button saveTaskBtn;

    @FXML
    private TextField taskTxt;

    public void setUserid(int userid) {
        this.id = userid;
        System.out.println("ID is:" + this.id);
    }

    public int getUserid() {
        return this.id;
    }

    @FXML
    void initialize() {
        saveTaskBtn.setOnAction(event -> {

            dbHandler = new DBHandler();
            Calendar calendar = Calendar.getInstance();
            java.sql.Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

            System.out.println("test" + getUserid());

            try {
                DBHandler.insertTask(getUserid(), "Make this work", "My first task", timestamp);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("AddItems.fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();

                stage.setTitle("Hello!");
                stage.setScene(scene);
                stage.sizeToScene();
                stage.setResizable(false);
                stage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }
}
