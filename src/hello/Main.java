package hello;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
public void start(Stage primaryStage) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hello/FactureView.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setTitle("Gestion Clinique");
        primaryStage.show();
    } catch (IOException e) {
        e.printStackTrace(); // Affiche l'exception complète
    }
}

    public static void main(String[] args) {
        // Lance l'application JavaFX
        launch(args);
    }
}
