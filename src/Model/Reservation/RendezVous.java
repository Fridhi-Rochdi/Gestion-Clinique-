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

public sealed class RendezVous permits Facture, DossierMedical  {
    // Attributs
    private Date dateRendezVous;
    private int heure;
    private int docteurId;
    private int patientId;

    // Constructeur par défaut
    public RendezVous() {}

    // Constructeur avec paramètres
    public RendezVous(Date dateRendezVous, int heure, int docteurId, int patientId) {
        this.dateRendezVous = dateRendezVous;
        this.heure = heure;
        this.docteurId = docteurId;
        this.patientId = patientId;
    }

    // Getters et Setters
    public Date getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(Date dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public int getDocteurId() {
        return docteurId;
    }

    public void setDocteurId(int docteurId) {
        this.docteurId = docteurId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    // Méthodes

    
    public void planifier(Date dateRendezVous, int heure, int docteurId, int patientId) {
        this.dateRendezVous = dateRendezVous;
        this.heure = heure;
        this.docteurId = docteurId;
        this.patientId = patientId;
        System.out.println("Rendez-vous planifié avec succès !");
    }

    /**
     * Modifier un rendez-vous existant
     * @param nouvelleDate Nouvelle date du rendez-vous
     * @param nouvelleHeure Nouvelle heure du rendez-vous
     */
    public void modifier(Date nouvelleDate, int nouvelleHeure) {
        this.dateRendezVous = nouvelleDate;
        this.heure = nouvelleHeure;
        System.out.println("Rendez-vous modifié avec succès !");
    }

    /**
     * Annuler un rendez-vous
     */
    public void annuler() {
        this.dateRendezVous = null;
        this.heure = 0;
        this.docteurId = 0;
        this.patientId = 0;
        System.out.println("Rendez-vous annulé avec succès !");
    }

}
