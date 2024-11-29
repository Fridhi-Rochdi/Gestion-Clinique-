package hello;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashScreenController {
    @FXML
    private Label splashText;

    public void initialize() {
        // Crée une transition pour animer le texte (FadeIn)
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(5), splashText);
        fadeIn.setFromValue(0.0);  // Transparence initiale
        fadeIn.setToValue(1.0);    // Transparence finale
        fadeIn.setCycleCount(1);
        fadeIn.setOnFinished(e -> {
            // Démarre l'application principale après l'animation
            loadMainApp();
        });
        
        // Démarre l'animation
        fadeIn.play();
    }

    private void loadMainApp() {
        // Code pour charger la fenêtre principale (Welcome.fxml, par exemple)
        Platform.runLater(() -> {
            try {
                // Ouvrir la fenêtre principale (Welcome.fxml ou autre)
                Stage stage = (Stage) splashText.getScene().getWindow();
                stage.close();  // Fermer l'écran de démarrage

                // Charger l'application principale
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
                Scene mainScene = new Scene(loader.load());
                Stage mainStage = new Stage();
                mainStage.setTitle("Gestion Clinique");
                mainStage.setScene(mainScene);
                mainStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
