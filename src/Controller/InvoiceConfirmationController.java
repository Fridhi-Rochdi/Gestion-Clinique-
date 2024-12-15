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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class InvoiceConfirmationController {

    @FXML
    private Label patientNameLabel;
    
    @FXML
    private Label consultationDateLabel;
    
    @FXML
    private Label totalAmountLabel;
    
    @FXML
    private Label insuranceAmountLabel;
    
    @FXML
    private Label amountToPayLabel;

    @FXML
    private TextArea invoiceSummaryTextArea;

    @FXML
    private Button printInvoiceButton;

    @FXML
    private Button backToHomeButton;
    
    @FXML
    private ImageView clinicImageView;

    // Méthode pour initialiser les données de la facture
    @FXML
    public void initialize() {
        // Exemple d'initialisation avec des données fictives
        patientNameLabel.setText("John Doe");
        consultationDateLabel.setText(LocalDate.now().toString()); // Date actuelle
        totalAmountLabel.setText("100 €");
        insuranceAmountLabel.setText("30 €");
        amountToPayLabel.setText("70 €");

        // Charger l'image de la clinique
        Image image = new Image(getClass().getResourceAsStream("/resources/images/clinic_image.jpg"));
        clinicImageView.setImage(image);

        // Initialiser un résumé de la facture
        invoiceSummaryTextArea.setText("Facture pour consultation du " + LocalDate.now() + "\n\nMontant total: 100 €\nMontant assurance: 30 €\nMontant à payer: 70 €");
    }

    // Méthode pour imprimer la facture
    @FXML
    private void onPrintInvoiceClicked(MouseEvent event) {
        // Implémenter la logique pour imprimer la facture ici
        System.out.println("Impression de la facture...");
    }

    // Méthode pour revenir à la page d'accueil
    @FXML
    private void onBackToHomeClicked(MouseEvent event) {
        // Implémenter la logique pour revenir à l'accueil
        System.out.println("Retour à l'accueil...");
    }
}
