package hello;

import Model.GestionPersonnel.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class AddPatientController {

    @FXML
    private TextField fieldNom;
    @FXML
    private TextField fieldPrenom;
    @FXML
    private DatePicker fieldDateNaissance;
    @FXML
    private TextField fieldAdresse;
    @FXML
    private TextField fieldSecu;
    @FXML
    private PasswordField fieldMotDePasse;

    private Patient patient;

    @FXML
    private void enregistrerPatient() {
        String nom = fieldNom.getText();
        String prenom = fieldPrenom.getText();
        LocalDate dateNaissance = fieldDateNaissance.getValue();
        String adresse = fieldAdresse.getText();
        String secu = fieldSecu.getText();
        String motDePasse = fieldMotDePasse.getText();

        if (nom.isEmpty() || prenom.isEmpty() || dateNaissance == null || adresse.isEmpty() || secu.isEmpty() || motDePasse.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Tous les champs sont obligatoires.", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        // Créer un objet Patient
        patient = new Patient(0, nom, prenom, dateNaissance, adresse, motDePasse, secu, "Aucun historique");
        fermer();
    }

    @FXML
    private void fermer() {
        Stage stage = (Stage) fieldNom.getScene().getWindow();
        stage.close();
    }

    public Patient getPatient() {
        return patient;
    }
}
