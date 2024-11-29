/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hello;


import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.collections.FXCollections;

public class FactureController {

    @FXML
    private ChoiceBox<String> typeFactureChoiceBox;
    @FXML
    private TextField montantField;
    @FXML
    private TextField montantAssuranceField;
    @FXML
    private Button validerButton;

    @FXML
    public void initialize() {
        // Initialiser la ChoiceBox avec des valeurs.
        typeFactureChoiceBox.setItems(FXCollections.observableArrayList("Assurée", "Non Assurée"));

        // Logique pour activer/désactiver le champ Assurance
        typeFactureChoiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if ("Assurée".equals(newVal)) {
                montantAssuranceField.setDisable(false);
            } else {
                montantAssuranceField.setDisable(true);
                montantAssuranceField.clear();
            }
        });

        // Action du bouton
        validerButton.setOnAction(event -> validerPaiement());
    }

    private void validerPaiement() {
        String type = typeFactureChoiceBox.getValue();
        String montant = montantField.getText();
        String montantAssurance = montantAssuranceField.getText();

        // Ajoutez ici la logique pour traiter le paiement
        System.out.println("Paiement enregistré : Type = " + type + ", Montant = " + montant + ", Assurance = " + montantAssurance);
    }
}
