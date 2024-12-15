/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author sarra
 */



import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DiagnosticController {

    @FXML
    private ChoiceBox<String> patientChoiceBox;
    @FXML
    private DatePicker consultationDatePicker;
    @FXML
    private TextArea diagnosticTextArea;
    @FXML
    private Button submitButton;

    @FXML
    public void initialize() {
        // Initialisation des choix de patients et autres éléments, si nécessaire
        patientChoiceBox.getItems().addAll("Patient A", "Patient B", "Patient C");
        
        // Action au clic sur le bouton "Valider"
        submitButton.setOnAction(event -> submitDiagnostic());
    }

    private void submitDiagnostic() {
        String patient = patientChoiceBox.getValue();
        String date = consultationDatePicker.getValue().toString();
        String diagnostic = diagnosticTextArea.getText();

        // Traitement des données, par exemple, enregistrer dans une base de données ou afficher
        System.out.println("Diagnostic pour " + patient + " du " + date + " : " + diagnostic);
    }
}
