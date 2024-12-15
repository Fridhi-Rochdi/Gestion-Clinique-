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

// Classe abstraite
public abstract sealed class Facture extends RendezVous permits FactureAssuree, FactureResident {
    private double montant;
    private Date dateDePaiement;
    private String statutPaiement;

    // Constructeur
    public Facture(Date dateRendezVous, int heure, int docteurId, int patientId, double montant, Date dateDePaiement, String statutPaiement) {
        super(dateRendezVous, heure, docteurId, patientId);
        this.montant = montant;
        this.dateDePaiement = dateDePaiement;
        this.statutPaiement = statutPaiement;
    }

    // Getters et Setters
    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateDePaiement() {
        return dateDePaiement;
    }

    public void setDateDePaiement(Date dateDePaiement) {
        this.dateDePaiement = dateDePaiement;
    }

    public String getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(String statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    // Méthodes abstraites
    public abstract void genererFacture();

    public abstract void payer();

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
