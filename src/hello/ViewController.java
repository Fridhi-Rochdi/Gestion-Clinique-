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

public class ViewController {
    // Liens avec les éléments FXML
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

    // Données pour les tableaux
    private ObservableList<Patient> patients = FXCollections.observableArrayList();
    private ObservableList<Docteur> docteurs = FXCollections.observableArrayList();
    private ObservableList<RendezVous> rendezVous = FXCollections.observableArrayList();

    // Classe de réception pour la gestion des données
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
        // Exemple d'ajout d'un patient
        Patient newPatient = new Patient(1, "Dupont", "Jean", LocalDate.of(1985, 5, 15), "123 Rue Principale", "password", "123456789", "Historique médical");
        reception.enregistrerPatient(newPatient);
        patients.add(newPatient);
        System.out.println("Ajout d'un patient terminé.");
    }

    @FXML
    private void ajouterDocteur() {
        // Exemple d'ajout d'un docteur
        Docteur newDocteur = new Docteur(1, "Martin", "Paul", LocalDate.of(1970, 7, 20), "456 Avenue Centrale", "password", "Cardiologue", 12345);
        docteurs.add(newDocteur);
        System.out.println("Ajout d'un docteur terminé.");
    }

    @FXML
    private void planifierRendezVous() {
        // Exemple de planification de rendez-vous
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
}
