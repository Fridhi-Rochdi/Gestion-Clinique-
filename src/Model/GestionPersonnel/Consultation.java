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

public class Consultation {
    // Attributs
    private int docteurID;
    private int patientID;
    private LocalDate dateConsultation;
    private String motif;

    // Constructeur
    public Consultation(int docteurID, int patientID, LocalDate dateConsultation, String motif) {
        this.docteurID = docteurID;
        this.patientID = patientID;
        this.dateConsultation = dateConsultation;
        this.motif = motif;
    }

    // Getters et Setters
    public int getDocteurID() {
        return docteurID;
    }

    public void setDocteurID(int docteurID) {
        this.docteurID = docteurID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public LocalDate getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(LocalDate dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    // Méthodes
    public void creerConsultation() {
        System.out.println("Consultation créée avec succès !");
        System.out.println(this.toString());

        // Utilisation d'une classe anonyme pour notifier
        Notifiable notification = new Notifiable() {
            @Override
            public void notifyUser() {
                System.out.println("Notification : Une nouvelle consultation a été créée pour le patient " + patientID + ".");
            }
        };
        notification.notifyUser();
    }

    public void modifierConsultation(int docteurID, int patientID, LocalDate dateConsultation, String motif) {
        this.docteurID = docteurID;
        this.patientID = patientID;
        this.dateConsultation = dateConsultation;
        this.motif = motif;
        System.out.println("Consultation modifiée avec succès !");
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "docteurID=" + docteurID +
                ", patientID=" + patientID +
                ", dateConsultation=" + dateConsultation +
                ", motif='" + motif + '\'' +
                '}';
    }

    // Interface interne pour démonstration de classe anonyme
    interface Notifiable {
        void notifyUser();
    }
}