package hello;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import Model.Reservation.RendezVous;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class PlanifierRdvController {

    @FXML
    private DatePicker datePickerRdv;

    @FXML
    private TextField fieldHeure;

    @FXML
    private TextField fieldDocteurId;

    @FXML
    private TextField fieldPatientId;

    public void planifierRendezVous() {
        try {
            LocalDate localDate = datePickerRdv.getValue();
            String heure = fieldHeure.getText();
            int docteurId = Integer.parseInt(fieldDocteurId.getText());
            int patientId = Integer.parseInt(fieldPatientId.getText());

            // Conversion des données
            Date dateRdv = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            String[] timeParts = heure.split(":");
            int heureRdv = Integer.parseInt(timeParts[0]);

            // Créer un rendez-vous
            RendezVous rdv = new RendezVous(dateRdv, heureRdv, docteurId, patientId);
            System.out.println("Rendez-vous planifié avec succès : " + rdv);
        } catch (Exception e) {
            System.err.println("Erreur lors de la planification du rendez-vous : " + e.getMessage());
        }
    }
}
