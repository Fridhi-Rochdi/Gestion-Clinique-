package hello;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Model.GestionPersonnel.Patient;
import Model.GestionPersonnel.Docteur;
import Model.GestionPersonnel.Reception;
import Model.Reservation.RendezVous;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewController {

    @FXML
    private TableView<Patient> tablePatients;
    @FXML
    private TableColumn<Patient, String> columnPatientNom;
    @FXML
    private TableColumn<Patient, String> columnPatientPrenom;
    @FXML
    private TableColumn<Patient, String> columnPatientSecu;

    @FXML
    private TableView<Docteur> tableDocteurs;
    @FXML
    private TableColumn<Docteur, String> columnDocteurNom;
    @FXML
    private TableColumn<Docteur, String> columnDocteurSpecialite;
    @FXML
    private TableColumn<Docteur, Integer> columnDocteurLicence;

    @FXML
    private TableView<RendezVous> tableRendezVous;
    @FXML
    private TableColumn<RendezVous, String> columnRdvPatient;
    @FXML
    private TableColumn<RendezVous, String> columnRdvDocteur;
    @FXML
    private TableColumn<RendezVous, String> columnRdvDate;
    @FXML
    private TableColumn<RendezVous, Integer> columnRdvHeure;

    private ObservableList<Patient> patients = FXCollections.observableArrayList();
    private ObservableList<Docteur> docteurs = FXCollections.observableArrayList();
    private ObservableList<RendezVous> rendezVous = FXCollections.observableArrayList();

    private Reception reception = new Reception(1, "Admin", "Reception", LocalDate.now(), "Hôpital", "admin123", "Responsable");

    @FXML
    private void initialize() {
        // Lier les colonnes aux attributs des objets
        columnPatientNom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        columnPatientPrenom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPrenom()));
        columnPatientSecu.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNumeroSecuriteSociale()));

        columnDocteurNom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        columnDocteurSpecialite.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSpecialite()));
        columnDocteurLicence.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getNumeroLicence()).asObject());

        columnRdvDate.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDateRendezVous().toString()));
        columnRdvHeure.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getHeure()).asObject());

        // Lier les données des listes aux tableaux
        tablePatients.setItems(patients);
        tableDocteurs.setItems(docteurs);
        tableRendezVous.setItems(rendezVous);
    }

    @FXML
      private void ajouterPatient() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hello/AddPatient.fxml"));
            VBox root = loader.load();

            // Créer une nouvelle fenêtre pour la vue "AddPatient"
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ajouter un Patient");
            dialogStage.setScene(new Scene(root));
            dialogStage.initModality(Modality.APPLICATION_MODAL);

            AddPatientController controller = loader.getController();
            dialogStage.showAndWait();

            // Récupérer les données du patient et l'ajouter à la liste
            Patient newPatient = controller.getPatient();
            if (newPatient != null) {
                patients.add(newPatient);
                System.out.println("Patient ajouté : " + newPatient.getNom());
            }
            else {
                System.out.println("Aucun Patient Ajouté.");}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void ajouterDocteur() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hello/AddDoctorDialog.fxml"));
            VBox root = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ajouter un Docteur");
            dialogStage.setScene(new Scene(root));
            dialogStage.initModality(Modality.APPLICATION_MODAL);

            AddDoctorDialogController dialogController = loader.getController();
            dialogStage.showAndWait();

            Docteur newDocteur = dialogController.getDocteur();
            if (newDocteur != null) {
                docteurs.add(newDocteur);
                System.out.println("Docteur ajouté : " + newDocteur.getNom());
            } else {
                System.out.println("Aucun docteur ajouté.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void planifierRendezVous() {
        if (!patients.isEmpty() && !docteurs.isEmpty()) {
            Patient patient = patients.get(0); // Prendre le premier patient pour l'exemple
            Docteur docteur = docteurs.get(0); // Prendre le premier docteur pour l'exemple
            Date date = Date.from(LocalDate.of(2023, 12, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
            RendezVous rdv = new RendezVous(date, 10, docteur.getIdPersonne(), patient.getIdPersonne());

            reception.planifierRendezVous(rdv);
            rendezVous.add(rdv);
            System.out.println("Planification de rendez-vous terminée.");
        } else {
            System.out.println("Pas assez de données pour planifier un rendez-vous.");
        }
    }

    private void afficherBienvenue() {
        try {
            // Charger la vue "Bienvenue"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hello/Welcome.fxml"));
            VBox root = loader.load();

            // Créer une nouvelle fenêtre de dialogue
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Bienvenue");
            dialogStage.setScene(new Scene(root));
            dialogStage.initModality(Modality.APPLICATION_MODAL);

            // Afficher la fenêtre de bienvenue
            dialogStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
private void ouvrirPlanifierRdv() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PlanifierRdv.fxml"));
        VBox root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Planifier un Rendez-vous");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    } catch (Exception e) {
        System.err.println("Erreur lors de l'ouverture de la vue Planifier Rendez-vous : " + e.getMessage());
    }
}

}
