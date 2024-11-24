package Controller;

import Model.GestionPersonnel.Service;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MedicalSystemViewController {
    @FXML
    private TextField tfDoctorName, tfServiceName, tfDescription;
    @FXML
    private Button btnAddDoctor, btnRemoveDoctor, btnShowDoctors, btnCheckAvailability;
    @FXML
    private TextArea taOutput;

    private Service service;

    @FXML
    public void initialize() {
        // Initialisation du modèle
        service = new Service("Cardiologie", "Service de cardiologie pour les patients.");

        // Associer les actions des boutons
        btnAddDoctor.setOnAction(e -> ajouterDocteur());
        btnRemoveDoctor.setOnAction(e -> supprimerDocteur());
        btnShowDoctors.setOnAction(e -> afficherListeDocteurs());
        btnCheckAvailability.setOnAction(e -> verifierDisponibilite());
    }

    private void ajouterDocteur() {
        String doctorName = tfDoctorName.getText().trim();
        if (doctorName.isEmpty()) {
            afficherMessage("Erreur : le nom du docteur est vide.");
            return;
        }
        service.ajouterDocteur(doctorName);
        afficherMessage("Docteur ajouté : " + doctorName);
    }

    private void supprimerDocteur() {
        String doctorName = tfDoctorName.getText().trim();
        if (doctorName.isEmpty()) {
            afficherMessage("Erreur : le nom du docteur est vide.");
            return;
        }
        service.supprimerDocteur(doctorName);
        afficherMessage("Docteur supprimé : " + doctorName);
    }

    private void afficherListeDocteurs() {
        afficherMessage("Liste des docteurs : " + service.getListeDocteurs());
    }

    private void verifierDisponibilite() {
        String doctorName = tfDoctorName.getText().trim();
        if (doctorName.isEmpty()) {
            afficherMessage("Erreur : le nom du docteur est vide.");
            return;
        }
        boolean disponible = service.isDisponible(doctorName);
        afficherMessage("Disponibilité de " + doctorName + " : " + (disponible ? "Disponible" : "Non disponible"));
    }

    private void afficherMessage(String message) {
        taOutput.appendText(message + "\n");
    }
}
