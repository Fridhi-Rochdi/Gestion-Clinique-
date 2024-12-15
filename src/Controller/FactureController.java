
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Controller;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

public class FactureController {

    @FXML
    private ChoiceBox<String> typeFactureChoiceBox;
    @FXML
    private ChoiceBox<String> typeFactureResidenceChoiceBox;

    public void initialize() {
        // Remplir les ChoiceBox avec des éléments
        typeFactureChoiceBox.setItems(FXCollections.observableArrayList("Facture Assurée", "Pas Assurée"));
        typeFactureResidenceChoiceBox.setItems(FXCollections.observableArrayList("Facture Résidente", "Facture Normale"));
    }
}

