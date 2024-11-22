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

public final class FactureAssuree extends Facture implements AutoCloseable {
    private double montantAssurance;

    // Constructeur
    public FactureAssuree(Date dateRendezVous, int heure, int docteurId, int patientId, double montant, Date dateDePaiement, String statutPaiement, double montantAssurance) throws InvalidAssuranceAmountException {
        super(dateRendezVous, heure, docteurId, patientId, montant, dateDePaiement, statutPaiement);
        if (montantAssurance <= 0) {
            throw new InvalidAssuranceAmountException("Le montant de l'assurance doit être supérieur à 0.");
        }
        this.montantAssurance = montantAssurance;
    }

    // Implémentation des méthodes abstraites
    @Override
    public void genererFacture() {
        System.out.println("=== Génération de la facture d'assurance ===");
        System.out.println("Montant de l'assurance : " + montantAssurance);
        System.out.println("Statut de paiement : " + getStatutPaiement());
        System.out.println("Date de facturation : " + getDateDePaiement());
    }

    @Override
    public void payer() {
        setStatutPaiement("Payé");
        System.out.println("Facture d'assurance payée le : " + new Date());
    }

    @Override
    public void close() {
        System.out.println("Fermeture de la ressource FactureAssuree.");
    }

    public double getMontantAssurance() {
        return montantAssurance;
    }

    public void setMontantAssurance(double montantAssurance) throws InvalidAssuranceAmountException {
        if (montantAssurance <= 0) {
            throw new InvalidAssuranceAmountException("Le montant de l'assurance doit être supérieur à 0.");
        }
        this.montantAssurance = montantAssurance;
    }

    private static class InvalidAssuranceAmountException extends Exception {

        public InvalidAssuranceAmountException() {
        }

        private InvalidAssuranceAmountException(String le_montant_de_lassurance_doit_être_supéri) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
