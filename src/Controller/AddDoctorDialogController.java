package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Model.GestionPersonnel.Docteur;

public class AddDoctorDialogController {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfSpecialite;
    @FXML
    private TextField tfLicence;
    @FXML
    private TextField tfTelephone;
    @FXML
    private TextField tfEmail;

    private Docteur docteur; // Objet Docteur pour stocker les informations

    public Docteur getDocteur() {
        return docteur;
    }

    @FXML
    private void enregistrerDocteur() {
        String nom = tfNom.getText().trim();
        String prenom = tfPrenom.getText().trim();
        String specialite = tfSpecialite.getText().trim();
        String licence = tfLicence.getText().trim();
        String telephone = tfTelephone.getText().trim();
        String email = tfEmail.getText().trim();

        if (nom.isEmpty() || prenom.isEmpty() || specialite.isEmpty() || licence.isEmpty() || telephone.isEmpty() || email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez remplir tous les champs.");
            alert.showAndWait();
            return;
        }

        try {
            docteur = new Docteur(nom, specialite, Integer.parseInt(licence), telephone, email);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Docteur ajouté avec succès.");
            alert.showAndWait();
            fermer();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Le numéro de licence doit être un entier.");
            alert.showAndWait();
            System.err.println("Erreur de format pour le numéro de licence : " + e.getMessage());
        }
    }

    @FXML
    private void fermer() {
        Stage stage = (Stage) tfNom.getScene().getWindow();
        stage.close();
    }
}
