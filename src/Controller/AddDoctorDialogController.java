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
        // Récupération des valeurs des champs de texte
        String nom = tfNom.getText().trim();
        String prenom = tfPrenom.getText().trim();
        String specialite = tfSpecialite.getText().trim();
        String licence = tfLicence.getText().trim();
        String telephone = tfTelephone.getText().trim();
        String email = tfEmail.getText().trim();

        // Vérification que tous les champs sont remplis
        if (nom.isEmpty() || prenom.isEmpty() || specialite.isEmpty() || licence.isEmpty() || telephone.isEmpty() || email.isEmpty()) {
            // Affichage d'une alerte en cas de champ vide
            Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez remplir tous les champs.");
            alert.showAndWait();
            return;
        }
        // Création de l'objet Docteur avec les informations récupérées
        docteur = new Docteur(nom, specialite);  // Utilisez le constructeur correct
        docteur.setNumeroLicence(Integer.parseInt(licence));  // Mettre à jour le numéro de licence
        docteur.setTelephone(telephone);  // Mettre à jour le téléphone
        docteur.setEmail(email);  // Mettre à jour l'email

        // Affichage d'une alerte de succès
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Docteur ajouté avec succès.");
        alert.showAndWait();

        // Fermer la fenêtre
        fermer();
    }

    @FXML
    private void fermer() {
        Stage stage = (Stage) tfNom.getScene().getWindow();
        stage.close();
    }
}
