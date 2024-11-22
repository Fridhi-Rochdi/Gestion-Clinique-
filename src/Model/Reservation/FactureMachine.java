/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Reservation;

/**
 *
 * @author sarra
 */
import java.util.Map;

@FunctionalInterface
public interface FactureMachine {
    // Méthode abstraite unique pour calculer le prix total des machines utilisées
    double calculerPrixTotal(Map<String, Double> machinesUtilisees);
}
