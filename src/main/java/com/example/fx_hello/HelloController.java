package com.example.fx_hello;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloController {
    Stage stage, aboutStage;
    FXMLLoader fxmlLoader;

    private static int counter = 0;

    @FXML
    private Label welcomeText, outputText, aboutText, aboutTitle;
    @FXML
    private Button btnShow,btnHide, btnFirst, btnSecond, btnAdd, btnAbout, btnClose, btnMore;

    @FXML
    protected void onShowButtonClick() {
        welcomeText.setText("First window app in Java!");
    }

    @FXML
    protected void onHideButtonClick() {
        welcomeText.setText("");
    }

    @FXML
    protected void onSecondViewButtonClick() throws IOException {

        stage = (Stage) btnSecond.getScene().getWindow();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("second-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 320, 400);
        stage.setTitle("Counter window");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onAddButtonClick() {
        counter++;
        outputText.setText(String.valueOf(counter));
    }

    @FXML
    protected void onFirstViewButtonClick()  throws IOException {

        stage = (Stage) btnFirst.getScene().getWindow();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 320, 400);
        stage.setTitle("First window");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onAboutButtonClick()  throws IOException {
        aboutStage = new Stage(StageStyle.DECORATED);
        aboutStage.initOwner(stage);
        aboutStage.initModality(Modality.APPLICATION_MODAL);

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("about-view.fxml"));

        Scene aboutScene = new Scene(fxmlLoader.load(), 320, 240);
        aboutStage.setTitle("About window");
        aboutStage.setScene(aboutScene);
        aboutStage.show();
    }

    @FXML
    protected void onMoreButtonClick() {

        aboutText.setText("Your counter is " + counter);
    }

    @FXML
    protected void onCloseButtonClick() {

        aboutStage = (Stage) btnClose.getScene().getWindow();
        aboutStage.close();
    }
}