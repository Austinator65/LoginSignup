package com.example.loginsignup.controller;

import java.io.IOException;

import com.example.loginsignup.MainApp;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class AddItemsController {

    @FXML
    private ImageView addBtn;

    @FXML
    private Text noText;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private AnchorPane mainPane;

    /**
     * 
     */
    @FXML
    void initialize() {
        int counter = 0;
        addBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            extracted(counter);
        });

    }

    private void extracted(int counter) {
        if (counter == 0) {
            addBtn.relocate(650, -180);
            noText.relocate(1000, 1000);

            FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000), addBtn);
            FadeTransition nTransition = new FadeTransition(Duration.millis(50), noText);

            fadeTransition.setFromValue(1f);
            nTransition.setFromValue(1f);
            fadeTransition.setToValue(1f);
            nTransition.setToValue(0f);
            fadeTransition.setCycleCount(1);
            nTransition.setCycleCount(1);
            fadeTransition.setAutoReverse(false);
            nTransition.setAutoReverse(false);
            fadeTransition.play();
            nTransition.play();

            AnchorPane formPane;

            try {
                formPane = FXMLLoader
                        .load(MainApp.class
                                .getResource("AddItemsForm.fxml"));

                FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(1000),
                        formPane);

                fadeTransition2.setFromValue(0f);
                fadeTransition2.setToValue(1f);
                fadeTransition2.setCycleCount(1);
                fadeTransition2.setAutoReverse(false);
                fadeTransition2.play();
                mainPane.getChildren().setAll(formPane);

            } catch (IOException e) {

            }

            counter++;
        }
    }
}
