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

public final class DossierMedical extends RendezVous {
    private String observations;

    // Constructeur
    public DossierMedical(Date dateRendezVous, int heure, int docteurId, int patientId, String observations) {
        super(dateRendezVous, heure, docteurId, patientId);
        this.observations = observations;
    }

    // Getter et Setter
    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    // Méthode pour afficher le dossier médical
    public void afficherDossier() {
        System.out.println(this.toString());
    }

    // Redéfinition de la méthode toString
    @Override
    public String toString() {
        return "Dossier Médical {" +
               "Date du Rendez-vous = " + getDateRendezVous() +
               ", Heure = " + getHeure() +
               ", Docteur ID = " + getDocteurId() +
               ", Patient ID = " + getPatientId() +
               ", Observations = '" + observations + '\'' +
               '}';
    }
}

