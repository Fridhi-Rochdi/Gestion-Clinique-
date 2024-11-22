/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.GestionPersonnel;

/**
 *
 * @author fridh
 */
import java.time.LocalDate;

public final class Patient extends Personne {
    
    private String numeroSecuriteSociale;   // Numéro de sécurité sociale
    private String historiqueMedical;       // Historique médical du patient
    
    // Constructeur
    public Patient(int idPersonne, String nom, String prenom, LocalDate dateNaissance, String adresse, String motDePasse, String numeroSecuriteSociale, String historiqueMedical) {
        super(idPersonne, nom, prenom, dateNaissance, adresse, motDePasse);  // Appel du constructeur de la classe Personne
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        this.historiqueMedical = historiqueMedical;
    }

    // Getters et Setters
    public String getNumeroSecuriteSociale() {
        return numeroSecuriteSociale;
    }

    public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }

    public String getHistoriqueMedical() {
        return historiqueMedical;
    }

    public void setHistoriqueMedical(String historiqueMedical) {
        this.historiqueMedical = historiqueMedical;
    }
    
    // Méthode pour demander un rendez-vous
    public void demanderRendezVous(String date, String heure) {
        // Logique pour demander un rendez-vous à un docteur (exemple simple)
        System.out.println("Demande de rendez-vous pour le " + date + " à " + heure + " a été envoyée.");
        // Ici, vous pouvez ajouter plus de logique comme vérifier la disponibilité du docteur, etc.
    }
    
    // Méthode pour payer une facture
    public void payerFacture(double montant) {
        // Logique pour payer une facture (exemple simple)
        System.out.println("Le paiement de la facture d'un montant de " + montant + " a été effectué.");
        // Vous pouvez ajouter de la logique ici pour mettre à jour le statut du paiement, etc.
    }

    @Override
    public String toString() {
        return "Patient{" +
               "numeroSecuriteSociale='" + numeroSecuriteSociale + '\'' +
               ", historiqueMedical='" + historiqueMedical + '\'' +
               ", nom='" + getNom() + '\'' +
               ", prenom='" + getPrenom() + '\'' +
               ", adresse='" + getAdresse() + '\'' +
               ", dateNaissance=" + getDateNaissance() +
               '}';
    }

    void setHistoriquemedicale(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getHistoriquemedicale() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getSymptomes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setSymptomes(String symptomes) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
