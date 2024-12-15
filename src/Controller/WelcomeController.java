package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class WelcomeController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    

   
   
@FXML
private void handleLogin() {
    String email = emailField.getText();
    String password = passwordField.getText();

    if (email.equals("admin@gmail.com") && password.equals("password123")) {
        // Créer une alerte de succès
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Connexion réussie");
        alert.setHeaderText(null);
        alert.setContentText("Bienvenue!");

        // Affiche l'alerte et attend la réponse
        Optional<ButtonType> result = alert.showAndWait();

        // Vérifiez si l'utilisateur a cliqué sur "OK"
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                // Charger la vue View.fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/VIEW/View.fxml"));
                Scene newScene = new Scene(loader.load());

                // Obtenez la fenêtre actuelle et remplacez la scène
                Stage currentStage = (Stage) emailField.getScene().getWindow();
                currentStage.setScene(newScene);
                currentStage.setTitle("Gestion hospitalière");
                currentStage.show();
            } catch (IOException e) {
                e.printStackTrace();

                // Affiche une alerte en cas d'erreur
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText("Chargement échoué");
                errorAlert.setContentText("Impossible de charger la page View.fxml. Veuillez vérifier le fichier.");
                errorAlert.showAndWait();
            }
        }
    } else {
        // Affiche une alerte d'erreur si les identifiants sont incorrects
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Erreur de connexion");
        errorAlert.setHeaderText("Connexion échouée");
        errorAlert.setContentText("Vérifiez vos identifiants.");
        errorAlert.showAndWait();
    }
}


    @FXML
    private void forgotPassword() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mot de passe oublié");
        alert.setHeaderText(null);
        alert.setContentText("Une option de réinitialisation de mot de passe sera bientôt disponible.");
        alert.showAndWait();
    }

    @FXML
    private void createAccount() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Créer un compte");
        alert.setHeaderText(null);
        alert.setContentText("Formulaire de création de compte à venir.");
        alert.showAndWait();
    }
}