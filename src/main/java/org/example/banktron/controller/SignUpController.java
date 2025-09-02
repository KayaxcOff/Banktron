package org.example.banktron.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.banktron.func.CheckSign;

public class SignUpController {

    @FXML
    private TextField nameField, passwordField;

    @FXML
    private Button signButton;

    public void checkSignUp() {
        CheckSign checkSign = new CheckSign();
        boolean isSign = checkSign.signUp(nameField.getText(), passwordField.getText());
        if(isSign) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/banktron/fxml/sign-in-view.fxml"));
                Parent root = loader.load();
                Stage signStage = (Stage) signButton.getScene().getWindow();
                signStage.setScene(new Scene(root));
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Could not load sign-in view");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Sign-up failed");
            alert.setContentText("Please check your details and try again.");
            alert.showAndWait();
        }
    }
}