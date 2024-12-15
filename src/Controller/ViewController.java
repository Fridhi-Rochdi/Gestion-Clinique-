package Controller;

import Controller.AddDoctorDialogController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import Model.GestionPersonnel.Docteur;
import Model.GestionPersonnel.Patient;
import Model.Reservation.RendezVous;
import Model.Reservation.Facture;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewController {

    @FXML
    private StackPane mainContent; // Conteneur principal pour le contenu dynamique

    private final ObservableList<Patient> patients = FXCollections.observableArrayList();
    private final ObservableList<Docteur> docteurs = FXCollections.observableArrayList();
    private final ObservableList<RendezVous> rendezVous = FXCollections.observableArrayList();
    private final ObservableList<Facture> factures = FXCollections.observableArrayList();

    // Initialisation
    @FXML
    private void initialize() {
        afficherBienvenue();
    }

    @FXML
    public void afficherBienvenue() {
        mainContent.getChildren().clear();
        Label accueilLabel = new Label("Bienvenue sur le Système de Gestion");
        accueilLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        mainContent.getChildren().add(accueilLabel);
    }

    @FXML
    public void afficherGestionPatients() {
        mainContent.getChildren().clear();
        VBox patientsContent = new VBox(20);
        Label label = new Label("Gestion des Patients");
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TableView<Patient> patientsTable = new TableView<>(patients);
        TableColumn<Patient, String> columnNom = new TableColumn<>("Nom");
        TableColumn<Patient, String> columnSecu = new TableColumn<>("Numéro Sécurité Sociale");
        TableColumn<Patient, String> columnAdresse = new TableColumn<>("Adresse");
        TableColumn<Patient, String> columnDateNaissance = new TableColumn<>("Date de Naissance");
        TableColumn<Patient, String> columnSymptomes = new TableColumn<>("Symptômes");
        TableColumn<Patient, String> columnHistorique = new TableColumn<>("Historique Médical");

        columnNom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        columnSecu.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNumeroSecuriteSociale()));
        columnAdresse.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAdresse()));
        columnDateNaissance.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDateNaissance().toString()));
        columnSymptomes.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSymptomes()));
        columnHistorique.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getHistoriqueMedical()));

        patientsTable.getColumns().addAll(columnNom, columnSecu, columnAdresse, columnDateNaissance, columnSymptomes, columnHistorique);

        Button ajouterPatientButton = new Button("Ajouter un Patient");
        ajouterPatientButton.setOnAction(event -> ouvrirFenetreAjouterPatient());

        patientsContent.getChildren().addAll(label, patientsTable, ajouterPatientButton);
        mainContent.getChildren().add(patientsContent);
    }

    private void ouvrirFenetreAjouterPatient() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AddPatient.fxml"));
            Parent root = loader.load();

            AddPatientController controller = loader.getController();
            controller.setParentController(this);

            Stage stage = new Stage();
            stage.setTitle("Ajouter un Patient");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ajouterPatient(Patient patient) {
        patients.add(patient);
    }

     @FXML
 public void afficherGestionDocteurs() {
        mainContent.getChildren().clear();
        VBox docteursContent = new VBox(20);
        Label label = new Label("Gestion des Docteurs");
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TableView<Docteur> docteursTable = new TableView<>(docteurs);
        TableColumn<Docteur, String> columnNom = new TableColumn<>("Nom");
        TableColumn<Docteur, String> columnSpecialite = new TableColumn<>("Spécialité");
        TableColumn<Docteur, String> columnTelephone = new TableColumn<>("Téléphone");
        TableColumn<Docteur, String> columnEmail = new TableColumn<>("Email");

        columnNom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        columnSpecialite.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSpecialite()));
        columnTelephone.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTelephone()));
        columnEmail.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmail()));

        docteursTable.getColumns().addAll(columnNom, columnSpecialite, columnTelephone, columnEmail);

        Button ajouterDocteurButton = new Button("Ajouter un Docteur");
        ajouterDocteurButton.setOnAction(event -> ouvrirFenetreAjouterDocteur(docteursTable));

        docteursContent.getChildren().addAll(label, docteursTable, ajouterDocteurButton);
        mainContent.getChildren().add(docteursContent);
    }

    private void ouvrirFenetreAjouterDocteur(TableView<Docteur> docteursTable) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AddDoctorDialog.fxml"));
            Parent root = loader.load();

            AddDoctorDialogController controller = loader.getController();

            Stage stage = new Stage();
            stage.setTitle("Ajouter un Docteur");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

            Docteur nouveauDocteur = controller.getDocteur();
            if (nouveauDocteur != null) {
                docteurs.add(nouveauDocteur); // Ajouter à la liste observable
                docteursTable.refresh(); // Rafraîchir le TableView
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 @FXML
    public void afficherGestionFactures() {
        mainContent.getChildren().clear();
        VBox facturesContent = new VBox(20);
        Label label = new Label("Gestion des Factures");
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TableView<Facture> facturesTable = new TableView<>(factures);
        TableColumn<Facture, String> columnDatePaiement = new TableColumn<>("Date de Paiement");
        TableColumn<Facture, String> columnMontant = new TableColumn<>("Montant");
        TableColumn<Facture, String> columnStatut = new TableColumn<>("Statut Paiement");

        columnDatePaiement.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDateDePaiement().toString()));
        columnMontant.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getMontant())));
        columnStatut.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatutPaiement()));

        facturesTable.getColumns().addAll(columnDatePaiement, columnMontant, columnStatut);

        Button ajouterFactureButton = new Button("Ajouter une Facture");
        ajouterFactureButton.setOnAction(event -> ouvrirFenetre("/View/AddFacture.fxml", "Ajouter une Facture"));

        facturesContent.getChildren().addAll(label, facturesTable, ajouterFactureButton);
        mainContent.getChildren().add(facturesContent);
    }

    @FXML
    public void afficherGestionRendezVous() {
        mainContent.getChildren().clear();
        VBox rendezVousContent = new VBox(20);
        Label label = new Label("Gestion des Rendez-Vous");
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TableView<RendezVous> rendezVousTable = new TableView<>(rendezVous);
        TableColumn<RendezVous, String> columnPatient = new TableColumn<>("Patient");
        TableColumn<RendezVous, String> columnDocteur = new TableColumn<>("Docteur");
        TableColumn<RendezVous, String> columnDate = new TableColumn<>("Date");
        TableColumn<RendezVous, Integer> columnHeure = new TableColumn<>("Heure");

        columnPatient.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNomPatient()));
        columnDocteur.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNomDocteur()));
        columnDate.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDateRendezVous().toString()));
        columnHeure.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getHeure()).asObject());

        rendezVousTable.getColumns().addAll(columnPatient, columnDocteur, columnDate, columnHeure);

        Button planifierRendezVousButton = new Button("Planifier un Rendez-vous");
        planifierRendezVousButton.setOnAction(event -> ouvrirFenetre("/View/PlanifierRdv.fxml", "Planifier un Rendez-vous"));

        rendezVousContent.getChildren().addAll(label, rendezVousTable, planifierRendezVousButton);
        mainContent.getChildren().add(rendezVousContent);
    }
    private void ouvrirFenetre(String cheminFxml, String titre) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(cheminFxml));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titre);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
