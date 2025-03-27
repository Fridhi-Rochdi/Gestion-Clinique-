package Controller;

import Model.Reservation.RendezVous;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.stage.Stage;

public class PlanifierRdvController {

    @FXML
    private DatePicker datePickerRdv;

    @FXML
    private TextField fieldHeure;

    @FXML
    private TextField fieldDocteurId;

    @FXML
    private TextField fieldPatientId;

    private ObservableList<RendezVous> rendezVousList;

    public void setRendezVousList(ObservableList<RendezVous> rendezVousList) {
        this.rendezVousList = rendezVousList;
    }

    @FXML
    public void planifierRendezVous() {
        try {
            // Récupérer les données du formulaire
            LocalDate localDate = datePickerRdv.getValue();
            String heure = fieldHeure.getText();
            int docteurId = Integer.parseInt(fieldDocteurId.getText());
            int patientId = Integer.parseInt(fieldPatientId.getText());

            // Convertir les données
            Date dateRdv = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            String[] timeParts = heure.split(":");
            int heureRdv = Integer.parseInt(timeParts[0]);

            // Créer et ajouter un rendez-vous
            RendezVous rdv = new RendezVous(dateRdv, heureRdv, docteurId, patientId);
            rendezVousList.add(rdv);

            // Fermer la fenêtre
            ((Stage) datePickerRdv.getScene().getWindow()).close();
        } catch (Exception e) {
            System.err.println("Erreur lors de la planification du rendez-vous : " + e.getMessage());
        }
    }
}
