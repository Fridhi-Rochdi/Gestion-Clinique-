package Controller;

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
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(4), splashText);
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
                // Attendre un petit délai pour être sûr que l'animation est terminée avant de changer de scène
                Thread.sleep(500);  // Délai de 500ms pour être sûr

                // Fermer l'écran de démarrage
                Stage stage = (Stage) splashText.getScene().getWindow();
                stage.close();

                // Charger l'application principale
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Welcome.fxml"));
                Scene mainScene = new Scene(loader.load());
                Stage mainStage = new Stage();
                mainStage.setTitle("Gestion hospitalière");
                mainStage.setScene(mainScene);
                mainStage.show();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
