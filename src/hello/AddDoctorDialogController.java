package hello;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import Model.GestionPersonnel.Docteur;

import java.time.LocalDate;

public class AddDoctorDialogController {

    @FXML
    private VBox rootVBox;

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfSpecialite;
    @FXML
    private TextField tfLicence;

    private Docteur docteur;

    /**
     * Retourne l'objet Docteur créé.
     * 
     * @return Docteur
     */
    public Docteur getDocteur() {
        return docteur;
    }

    /**
     * Méthode appelée lors du clic sur le bouton "Enregistrer".
     */
    @FXML
    private void enregistrer() {
        try {
            // Récupération des données des champs
            String nom = tfNom.getText().trim();
            String prenom = tfPrenom.getText().trim();
            String specialite = tfSpecialite.getText().trim();
            String licenceText = tfLicence.getText().trim();

            // Validation des données
            if (nom.isEmpty() || prenom.isEmpty() || specialite.isEmpty() || licenceText.isEmpty()) {
                System.err.println("Tous les champs doivent être remplis.");
                return;
            }

            int licence;
            try {
                licence = Integer.parseInt(licenceText);
            } catch (NumberFormatException e) {
                System.err.println("Le numéro de licence doit être un entier.");
                return;
            }

            // Création de l'objet Docteur
            docteur = new Docteur(1, nom, prenom, LocalDate.now(), "Adresse par défaut", "password", specialite, licence);

            // Fermeture de la fenêtre
            Stage stage = (Stage) tfNom.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            System.err.println("Erreur lors de l'enregistrement : " + e.getMessage());
        }
    }

    /**
     * Animation de l'arrière-plan.
     */
    @FXML
    private void initialize() {
        animateBackground();
    }

    private void animateBackground() {
        // Création de la timeline pour changer l'arrière-plan
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, e -> rootVBox.setStyle(
                "-fx-padding: 20; " +
                "-fx-background-radius: 15; " +
                "-fx-background-color: linear-gradient(to bottom, #ffffff, #e0e0e0); " +
                "-fx-border-radius: 15; " +
                "-fx-border-color: #cccccc; " +
                "-fx-border-width: 1; " +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 15, 0.4, 0, 5);"
            )),
            new KeyFrame(Duration.seconds(3), e -> rootVBox.setStyle(
                "-fx-padding: 20; " +
                "-fx-background-radius: 15; " +
                "-fx-background-color: linear-gradient(to bottom, #ffcccc, #ff9999); " +
                "-fx-border-radius: 15; " +
                "-fx-border-color: #cccccc; " +
                "-fx-border-width: 1; " +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 15, 0.4, 0, 5);"
            )),
            new KeyFrame(Duration.seconds(6), e -> rootVBox.setStyle(
                "-fx-padding: 20; " +
                "-fx-background-radius: 15; " +
                "-fx-background-color: linear-gradient(to bottom, #ccccff, #9999ff); " +
                "-fx-border-radius: 15; " +
                "-fx-border-color: #cccccc; " +
                "-fx-border-width: 1; " +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 15, 0.4, 0, 5);"
            ))
        );

        timeline.setCycleCount(Timeline.INDEFINITE); // Animation infinie
        timeline.setAutoReverse(true);              // Animation continue
        timeline.play();                            // Lancer l'animation
    }
}
