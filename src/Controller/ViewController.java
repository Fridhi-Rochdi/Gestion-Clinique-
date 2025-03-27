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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewController {

    private static final String RENDEZVOUS_FILE = "rendezvous.txt";
    private static final String PATIENTS_FILE = "patients.txt";
    private static final String DOCTEURS_FILE = "docteurs.txt";
    @FXML
    private StackPane mainContent; // Conteneur principal pour le contenu dynamique

    private final ObservableList<Patient> patients = FXCollections.observableArrayList();
    private final ObservableList<Docteur> docteurs = FXCollections.observableArrayList();
    private final ObservableList<RendezVous> rendezVousList = FXCollections.observableArrayList();

    private final ObservableList<Facture> factures = FXCollections.observableArrayList();

    @FXML

private void initialize() {
    chargerPatientsDepuisFichier();
    chargerDocteursDepuisFichier();
    chargerRendezVousDepuisFichier();
    afficherBienvenue();

    // Assurez-vous que les rendez-vous sont sauvegardés à la fermeture
   
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

    // Créer un HBox pour les boutons
    HBox buttonBox = new HBox(10); // Espace de 10 pixels entre les boutons
    buttonBox.setStyle("-fx-padding: 10px;"); // Optionnel, pour espacer les boutons du bord

    // Bouton "Ajouter un Patient"
    Button ajouterPatientButton = new Button("Ajouter un Patient");
    ajouterPatientButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
    ajouterPatientButton.setOnAction(event -> ouvrirFenetreAjouterPatient());

    // Bouton "Supprimer un Patient"
    Button supprimerPatientButton = new Button("Supprimer un Patient");
    supprimerPatientButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
    supprimerPatientButton.setOnAction(event -> supprimerPatient(patientsTable));

    // Bouton "Modifier un Patient"
    Button modifierPatientButton = new Button("Modifier un Patient");
    modifierPatientButton.setStyle("-fx-background-color: #ffa500; -fx-text-fill: white;");
    modifierPatientButton.setOnAction(event -> modifierPatient(patientsTable));

    // Ajouter les boutons dans le HBox
    buttonBox.getChildren().addAll(ajouterPatientButton, supprimerPatientButton, modifierPatientButton);

    // Ajouter les composants au VBox
    patientsContent.getChildren().addAll(label, patientsTable, buttonBox);
    mainContent.getChildren().add(patientsContent);
}

private void supprimerPatient(TableView<Patient> patientsTable) {
    // Obtenir l'élément sélectionné
    Patient patientSelectionne = patientsTable.getSelectionModel().getSelectedItem();
    if (patientSelectionne != null) {
        // Supprimer le patient de la liste
        patients.remove(patientSelectionne);

        // Mettre à jour le fichier
        sauvegarderPatientsDansFichier();
    } else {
        afficherErreur("Veuillez sélectionner un patient à supprimer.");
    }
}
private void modifierPatient(TableView<Patient> patientsTable) {
    // Récupérer la ligne sélectionnée
    Patient selectedPatient = patientsTable.getSelectionModel().getSelectedItem();
    if (selectedPatient != null) {
        // Créer une fenêtre de modification ou utiliser un formulaire
        TextField nomField = new TextField(selectedPatient.getNom());
        TextField adresseField = new TextField(selectedPatient.getAdresse());
        DatePicker dateNaissancePicker = new DatePicker(selectedPatient.getDateNaissance());
        TextField symptomesField = new TextField(selectedPatient.getSymptomes());
        TextArea historiqueArea = new TextArea(selectedPatient.getHistoriqueMedical());

        // Créer une fenêtre pop-up ou une nouvelle VBox avec ces champs
        VBox modificationForm = new VBox(10);
        modificationForm.getChildren().addAll(
                new Label("Nom:"), nomField,
                new Label("Adresse:"), adresseField,
                new Label("Date de Naissance:"), dateNaissancePicker,
                new Label("Symptômes:"), symptomesField,
                new Label("Historique Médical:"), historiqueArea
        );

        Button saveButton = new Button("Sauvegarder");
        saveButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        saveButton.setOnAction(e -> {
            // Mettre à jour le patient avec les nouvelles valeurs
            selectedPatient.setNom(nomField.getText());
            selectedPatient.setAdresse(adresseField.getText());
            selectedPatient.setDateNaissance(dateNaissancePicker.getValue());
            selectedPatient.setSymptomes(symptomesField.getText());
            selectedPatient.setHistoriqueMedical(historiqueArea.getText());

            // Rafraîchir la TableView pour refléter les modifications
            patientsTable.refresh();
        });

        // Ajouter le bouton de sauvegarde et le formulaire dans un VBox
        modificationForm.getChildren().add(saveButton);

        // Créer une nouvelle scène ou un pop-up pour afficher le formulaire
        Stage modificationStage = new Stage();
        modificationStage.setTitle("Modifier Patient");
        modificationStage.setScene(new Scene(modificationForm, 400, 300));
        modificationStage.show();
    } else {
        // Message d'erreur si aucun patient n'est sélectionné
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aucune sélection");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner un patient à modifier.");
        alert.showAndWait();
    }
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
        sauvegarderPatientsDansFichier(); // Sauvegarder les patients après ajout
    }

    private void chargerPatientsDepuisFichier() {
        File file = new File(PATIENTS_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] donnees = ligne.split(";");
                if (donnees.length == 6) {
                    Patient patient = new Patient(
                            donnees[0], // Nom
                            donnees[1], // Numéro de sécurité sociale
                            donnees[2], // Adresse
                            LocalDate.parse(donnees[3]), // Date de naissance
                            donnees[4], // Symptômes
                            donnees[5] // Historique médical
                    );
                    patients.add(patient);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            afficherErreur("Erreur lors du chargement des données des patients : " + e.getMessage());
        }
    }

    private void sauvegarderPatientsDansFichier() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATIENTS_FILE))) {
            for (Patient patient : patients) {
                String ligne = String.join(";",
                        patient.getNom(),
                        patient.getNumeroSecuriteSociale(),
                        patient.getAdresse(),
                        patient.getDateNaissance().toString(),
                        patient.getSymptomes(),
                        patient.getHistoriqueMedical()
                );
                writer.write(ligne);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            afficherErreur("Erreur lors de la sauvegarde des données des patients : " + e.getMessage());
        }
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
    TableColumn<Docteur, String> columnNumLicence = new TableColumn<>("Numéro Licence");

    columnNom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
    columnSpecialite.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSpecialite()));
    columnTelephone.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTelephone()));
    columnEmail.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmail()));
    columnNumLicence.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getNumeroLicence())));

    docteursTable.getColumns().addAll(columnNom, columnSpecialite, columnTelephone, columnEmail, columnNumLicence);

    // Créer un HBox pour les boutons
    HBox buttonBox = new HBox(10); // Espace de 10 pixels entre les boutons
    buttonBox.setStyle("-fx-padding: 10px;");

    // Bouton "Ajouter un Docteur"
    Button ajouterDocteurButton = new Button("Ajouter un Docteur");
    ajouterDocteurButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
    ajouterDocteurButton.setOnAction(event -> ouvrirFenetreAjouterDocteur());

    // Bouton "Supprimer un Docteur"
    Button supprimerDocteurButton = new Button("Supprimer un Docteur");
    supprimerDocteurButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
    supprimerDocteurButton.setOnAction(event -> supprimerDocteur(docteursTable));

    // Bouton "Modifier un Docteur"
    Button modifierDocteurButton = new Button("Modifier un Docteur");
    modifierDocteurButton.setStyle("-fx-background-color: #ffa500; -fx-text-fill: white;");
    modifierDocteurButton.setOnAction(event -> modifierDocteur(docteursTable));

    // Ajouter les boutons dans le HBox
    buttonBox.getChildren().addAll(ajouterDocteurButton, supprimerDocteurButton, modifierDocteurButton);

    // Ajouter les composants au VBox
    docteursContent.getChildren().addAll(label, docteursTable, buttonBox);
    mainContent.getChildren().add(docteursContent);
}
private void supprimerDocteur(TableView<Docteur> docteursTable) {
    // Obtenir l'élément sélectionné
    Docteur docteurSelectionne = docteursTable.getSelectionModel().getSelectedItem();
    if (docteurSelectionne != null) {
        // Supprimer le docteur de la liste
        docteurs.remove(docteurSelectionne);

        // Mettre à jour le fichier
        sauvegarderDocteursDansFichier();
    } else {
        afficherErreur("Veuillez sélectionner un docteur à supprimer.");
    }
}

private void modifierDocteur(TableView<Docteur> docteursTable) {
    // Récupérer la ligne sélectionnée
    Docteur selectedDocteur = docteursTable.getSelectionModel().getSelectedItem();
    if (selectedDocteur != null) {
        // Créer une fenêtre de modification ou utiliser un formulaire
        TextField nomField = new TextField(selectedDocteur.getNom());
        TextField specialiteField = new TextField(selectedDocteur.getSpecialite());
        TextField telephoneField = new TextField(selectedDocteur.getTelephone());
        TextField emailField = new TextField(selectedDocteur.getEmail());
        TextField numLicenceField = new TextField(String.valueOf(selectedDocteur.getNumeroLicence()));

        // Créer une fenêtre pop-up ou une nouvelle VBox avec ces champs
        VBox modificationForm = new VBox(10);
        modificationForm.getChildren().addAll(
                new Label("Nom:"), nomField,
                new Label("Spécialité:"), specialiteField,
                new Label("Téléphone:"), telephoneField,
                new Label("Email:"), emailField,
                new Label("Numéro de Licence:"), numLicenceField
        );

        Button saveButton = new Button("Sauvegarder");
        saveButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        saveButton.setOnAction(e -> {
            // Mettre à jour le docteur avec les nouvelles valeurs
            selectedDocteur.setNom(nomField.getText());
            selectedDocteur.setSpecialite(specialiteField.getText());
            selectedDocteur.setTelephone(telephoneField.getText());
            selectedDocteur.setEmail(emailField.getText());
            selectedDocteur.setNumeroLicence(Integer.parseInt(numLicenceField.getText()));

            // Rafraîchir la TableView pour refléter les modifications
            docteursTable.refresh();

            // Sauvegarder les changements dans le fichier
            sauvegarderDocteursDansFichier();
        });

        // Ajouter le bouton de sauvegarde et le formulaire dans un VBox
        modificationForm.getChildren().add(saveButton);

        // Créer une nouvelle scène ou un pop-up pour afficher le formulaire
        Stage modificationStage = new Stage();
        modificationStage.setTitle("Modifier Docteur");
        modificationStage.setScene(new Scene(modificationForm, 400, 300));
        modificationStage.show();
    } else {
        // Message d'erreur si aucun docteur n'est sélectionné
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aucune sélection");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner un docteur à modifier.");
        alert.showAndWait();
    }
}


    private void chargerDocteursDepuisFichier() {
        File file = new File(DOCTEURS_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] donnees = ligne.split(";");

                if (donnees.length == 5) {
                    try {
                        Docteur docteur = new Docteur(
                                donnees[0], // Nom
                                donnees[1], // Spécialité
                                Integer.parseInt(donnees[2]), // Téléphone
                                donnees[3], // Email
                                donnees[4] // Numéro de licence
                        );
                        docteurs.add(docteur);
                    } catch (NumberFormatException e) {
                        System.err.println("Erreur de format dans les données : " + ligne);
                    }
                } else {
                    System.err.println("Ligne invalide : " + ligne);
                }
            }
        } catch (IOException e) {
            afficherErreur("Erreur lors du chargement des données des docteurs : " + e.getMessage());
        }
    }

    private void ouvrirFenetreAjouterDocteur() {
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
                docteurs.add(nouveauDocteur);
                sauvegarderDocteursDansFichier();
            }
        } catch (Exception e) {
            afficherErreur("Erreur lors de l'ouverture de la fenêtre Ajouter un Docteur : " + e.getMessage());
        }
    }

    private void sauvegarderDocteursDansFichier() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DOCTEURS_FILE))) {
            for (Docteur docteur : docteurs) {
                // Conversion du numéro de licence en chaîne de caractères avant l'appel à String.join
                String ligne = String.join(";",
                        docteur.getNom(),
                        docteur.getSpecialite(),
                        docteur.getTelephone(),
                        docteur.getEmail(),
                        String.valueOf(docteur.getNumeroLicence()) // Convertir le numéro de licence en String
                );
                writer.write(ligne);
                writer.newLine();
            }
        } catch (IOException e) {
            afficherErreur("Erreur lors de la sauvegarde des données des docteurs : " + e.getMessage());
        }
    }

    private void afficherErreur(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setContentText(message);
        alert.showAndWait();
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
        ajouterFactureButton.setOnAction(event -> ouvrirFenetre("/View/FactureView.fxml", "Ajouter une Facture"));

        facturesContent.getChildren().addAll(label, facturesTable, ajouterFactureButton);
        mainContent.getChildren().add(facturesContent);
    }

    public void afficherGestionRendezVous() {
        mainContent.getChildren().clear();
        VBox rendezVousContent = new VBox(20);
        Label label = new Label("Gestion des Rendez-Vous");
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TableView<RendezVous> rendezVousTable = new TableView<>(rendezVousList);

        TableColumn<RendezVous, String> columnPatient = new TableColumn<>("Patient");
        TableColumn<RendezVous, String> columnDocteur = new TableColumn<>("Docteur");
        TableColumn<RendezVous, String> columnDate = new TableColumn<>("Date");
        TableColumn<RendezVous, Integer> columnHeure = new TableColumn<>("Heure");

        columnPatient.setCellValueFactory(data -> new SimpleStringProperty("Patient " + data.getValue().getPatientId()));
        columnDocteur.setCellValueFactory(data -> new SimpleStringProperty("Docteur " + data.getValue().getDocteurId()));
        columnDate.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDateRendezVous().toString()));
        columnHeure.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getHeure()).asObject());

        rendezVousTable.getColumns().addAll(columnPatient, columnDocteur, columnDate, columnHeure);

        Button planifierRendezVousButton = new Button("Planifier un Rendez-vous");
        planifierRendezVousButton.setOnAction(event -> ouvrirFenetrePlanifierRendezVous());

        rendezVousContent.getChildren().addAll(label, rendezVousTable, planifierRendezVousButton);
        mainContent.getChildren().add(rendezVousContent);
    }
private void sauvegarderRendezVousDansFichier() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(RENDEZVOUS_FILE))) {
        for (RendezVous rendezVous : rendezVousList) {
            String ligne = String.join(";",
                    "Patient " + rendezVous.getPatientId(),
                    "Docteur " + rendezVous.getDocteurId(),
                    rendezVous.getDateRendezVous().toString(),
                    String.valueOf(rendezVous.getHeure())
            );
            writer.write(ligne);
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
        afficherErreur("Erreur lors de la sauvegarde des rendez-vous : " + e.getMessage());
    }
}
private void chargerRendezVousDepuisFichier() {
    File file = new File(RENDEZVOUS_FILE);
    if (!file.exists()) return;

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String ligne;
        while ((ligne = reader.readLine()) != null) {
            String[] donnees = ligne.split(";");
            if (donnees.length == 4) {
                try {
                    String patientIdStr = donnees[0].split(" ")[1];  // Extraire l'ID du patient
                    String docteurIdStr = donnees[1].split(" ")[1];  // Extraire l'ID du docteur
                    LocalDate dateRendezVous = LocalDate.parse(donnees[2]);  // Date du rendez-vous
                    int heure = Integer.parseInt(donnees[3]);  // Heure du rendez-vous
                    
                    // Convertir les ID en entiers si nécessaire
                    int patientId = Integer.parseInt(patientIdStr);
                    int docteurId = Integer.parseInt(docteurIdStr);
                    
                    // Convertir LocalDate en Date
                    Date date = java.sql.Date.valueOf(dateRendezVous);
                    
                    // Créez un nouvel objet RendezVous et ajoutez-le à la liste
                    RendezVous rendezVous = new RendezVous(date, heure, docteurId, patientId);
                    rendezVousList.add(rendezVous);
                } catch (Exception e) {
                    System.out.println("Erreur de conversion des données : " + e.getMessage());
                }
            }
        }
        // Mettez à jour la table avec les nouveaux rendez-vous
        
    } catch (IOException e) {
        afficherErreur("Erreur lors du chargement des données des rendez-vous : " + e.getMessage());
    }
}

    private void ouvrirFenetrePlanifierRendezVous() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PlanifierRdv.fxml"));
            Parent root = loader.load();

            PlanifierRdvController controller = loader.getController();
            controller.setRendezVousList(rendezVousList);

            Stage stage = new Stage();
            stage.setTitle("Planifier un Rendez-vous");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
