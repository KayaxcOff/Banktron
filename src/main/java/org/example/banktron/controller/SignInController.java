package org.example.banktron.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.banktron.func.CheckSign;
import org.example.banktron.func.User;

public class SignInController {

    @FXML
    private TextField nameField, passwordField;

    @FXML
    private Button signButton;

    public void checkSignIn() {
        String username = nameField.getText();
        String password = passwordField.getText();

        if (username == null || username.trim().isEmpty()) {
            showAlert("Error", "Username can't be null!", Alert.AlertType.WARNING);
            return;
        }

        if (password == null || password.trim().isEmpty()) {
            showAlert("Error", "Username can't be null", Alert.AlertType.WARNING);
            return;
        }

        CheckSign checkSign = new CheckSign();
        boolean isSign = checkSign.signIn(username, password);

        if(isSign) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/banktron/fxml/main-view.fxml"));
                Parent root = loader.load();

                // Ana görünüm kontrolcüsüne kullanıcı bilgisini geçir
                MainViewController mainController = loader.getController();
                User currentUser = new User(username, password, 0); // Gerçek uygulamada veritabanından yüklenecek
                mainController.setUser(currentUser);

                Stage mainStage = (Stage) signButton.getScene().getWindow();
                mainStage.getScene().setRoot(root);
            } catch (Exception e) {
                showAlert("Error", "Main Page couldn't load\nThe Error: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            showAlert("Sign In Error", "Username and Password can't be null", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}