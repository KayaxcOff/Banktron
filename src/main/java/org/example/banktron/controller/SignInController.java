package org.example.banktron.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.banktron.func.CheckSign;

public class SignInController {

    @FXML
    private TextField nameField, passwordField;

    @FXML
    private Button signButton;

    public void checkSignIn() {
        CheckSign checkSign = new CheckSign();
        boolean isSign = checkSign.signIn(nameField.getText(), passwordField.getText());

        if(isSign) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/banktron/view/main-view.fxml"));
                Parent root = loader.load();
                Stage mainStage = (Stage) signButton.getScene().getWindow();
                mainStage.getScene().setRoot(root);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Loading Error");
                alert.setContentText("An error occurred while loading the main view.");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Sign In Failed");
            alert.setContentText("Invalid username or password. Please try again.");
            alert.showAndWait();
        }
    }
}