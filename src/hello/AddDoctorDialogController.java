package hello;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import Model.GestionPersonnel.Docteur;

import java.time.LocalDate;

public class AddDoctorDialogController {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfSpecialite;
    @FXML
    private TextField tfLicence;

    private Docteur docteur;

    public Docteur getDocteur() {
        return docteur;
    }

    @FXML
    private void enregistrer() {
        try {
            String nom = tfNom.getText();
            String prenom = tfPrenom.getText();
            String specialite = tfSpecialite.getText();
            int licence = Integer.parseInt(tfLicence.getText());

            docteur = new Docteur(1, nom, prenom, LocalDate.now(), "Adresse par défaut", "password", specialite, licence);

            Stage stage = (Stage) tfNom.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
