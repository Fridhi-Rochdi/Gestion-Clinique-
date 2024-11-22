/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Reservation;

/**
 *
 * @author sarra
 */
import java.util.Date;

public class Paiement {
    private String modeDePaiement; // Ex: "Carte bancaire", "Espèces", "Chèque"
    private Date dateDePaiement;
    private double montant;

    // Constructeur
    public Paiement(String modeDePaiement, Date dateDePaiement, double montant) throws InvalidPaymentAmountException {
        if (montant <= 0) {
            throw new InvalidPaymentAmountException("Le montant doit être supérieur à 0.");
        }
        this.modeDePaiement = modeDePaiement;
        this.dateDePaiement = dateDePaiement;
        this.montant = montant;
    }

    // Getters et Setters
    public String getModeDePaiement() {
        return modeDePaiement;
    }

    public void setModeDePaiement(String modeDePaiement) {
        this.modeDePaiement = modeDePaiement;
    }

    public Date getDateDePaiement() {
        return dateDePaiement;
    }

    public void setDateDePaiement(Date dateDePaiement) {
        this.dateDePaiement = dateDePaiement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) throws InvalidPaymentAmountException {
        if (montant <= 0) {
            throw new InvalidPaymentAmountException("Le montant doit être supérieur à 0.");
        }
        this.montant = montant;
    }

    // Méthodes
    public void effectuerPaiement() {
        System.out.println("Paiement de " + montant + "€ effectué avec le mode de paiement : " + modeDePaiement);
    }

    public void annulerPaiement() {
        System.out.println("Le paiement de " + montant + "€ a été annulé.");
    }
}
