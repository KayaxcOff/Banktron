package org.example.banktron;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App extends Application {

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            String FILE_NAME = "banktron.json";
            if (!Files.exists(Paths.get(FILE_NAME))) Files.write(Paths.get(FILE_NAME), "[]".getBytes());
            FXMLLoader loader = new FXMLLoader(App.class.getResource("fxml/sign-view.fxml"));
            Scene scene = new Scene(loader.load());
            primaryStage.setTitle("Banktron");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
