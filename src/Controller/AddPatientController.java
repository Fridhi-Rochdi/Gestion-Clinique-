package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import Model.GestionPersonnel.Patient;
import java.time.LocalDate;

public class AddPatientController {

    private ViewController parentController;

    public void setParentController(ViewController parentController) {
        this.parentController = parentController;
    }

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
    private TextArea fieldSymptomes;
    @FXML
    private TextArea fieldHistoriqueMedical;
    @FXML
    private Button btnEnregistrer;

    @FXML
    private void enregistrerPatient() {
        String nom = fieldNom.getText().trim();
        String prenom = fieldPrenom.getText().trim();
        LocalDate dateNaissance = fieldDateNaissance.getValue();
        String adresse = fieldAdresse.getText().trim();
        String secu = fieldSecu.getText().trim();
        String symptomes = fieldSymptomes.getText().trim();
        String historiqueMedical = fieldHistoriqueMedical.getText().trim();

        if (nom.isEmpty() || prenom.isEmpty() || dateNaissance == null || adresse.isEmpty() || secu.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez remplir tous les champs.");
            alert.showAndWait();
            return;
        }

        Patient patient = new Patient(nom, secu, adresse, dateNaissance, symptomes, historiqueMedical);
        parentController.ajouterPatient(patient);
        fermer();
    }

    @FXML
    private void fermer() {
        Stage stage = (Stage) btnEnregistrer.getScene().getWindow();
        stage.close();
    }
}
