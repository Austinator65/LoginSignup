package com.example.loginsignup.controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import com.example.loginsignup.helper.DBHandler;

//import com.example.loginsignup.helper.DBHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddItemsFormController {

    // DBHandler dbHandler;
    private int id;

    @FXML
    private TextField descriptionTxt;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button saveTaskBtn;

    @FXML
    private TextField taskTxt;

    @FXML
    private Button taskAddedBtn;

    @FXML
    private Label taskAddedFld;

    public void setTask() {
        // dbHandler = new DBHandler();

        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
        String task = taskTxt.getText().trim();
        String description = descriptionTxt.getText().trim();
        // int ids = this.id;
        // System.out.println(task + "task: " + ids);
        if (!task.equals("") || !description.equals("")) {
            try {
                DBHandler.insertTask(task, description,
                        timestamp);

                int num = DBHandler.countTask();
                if (num >= 0) {
                    taskAddedFld.setVisible(true);
                    taskAddedBtn.setVisible(true);
                    taskAddedBtn.setText("My 2Do's [" + (num) + "]");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void initialize() {
        saveTaskBtn.setOnAction(event -> {
            // System.out.println("task: init " + this.id);
            setTask();
            // FXMLLoader fxmlLoader = new
            // FXMLLoader(MainApp.class.getResource("AddItems.fxml"));
            // Scene scene;
            // try {
            // scene = new Scene(fxmlLoader.load());
            // Stage stage = new Stage();

            // stage.setTitle("Hello!");
            // stage.setScene(scene);
            // stage.sizeToScene();
            // stage.setResizable(false);
            // stage.showAndWait();

            // } catch (IOException e) {
            // e.printStackTrace();
            // }

        });

    }

    /**
     * @param id the id to set
     */
    // public void setId(int id) {
    // if (id != 0) {
    // this.id = id;
    // System.out.println("ID on form is " + this.id);
    // System.out.println("ID on form is " + id);
    // }
    // }

    /**
     * @return int return the id
     */
    // public int getId() {
    // if (this.id != 0) {
    // return this.id;
    // } else {
    // return 0;
    // }

    // }

}
