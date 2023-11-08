package com.example.loginsignup.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ListController {
    @FXML
    private ImageView addBtn;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ListView<String> taskList;

    ObservableList<String> listView = FXCollections.observableArrayList(
            "atiso", "Austin", "Mpho", "John", "Sipho", "Mbali", "Palesa");

    @FXML
    void initialize() {
        taskList.setItems(listView);
    }
}