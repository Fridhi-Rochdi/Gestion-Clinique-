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

public class Diagnostic {
    // Attributs
    private String description;
    private int docteurID;
    private int patientID;
    private LocalDate date;

    // Constructeur
    public Diagnostic(String description, int docteurID, int patientID, LocalDate date) {
        this.description = description;
        this.docteurID = docteurID;
        this.patientID = patientID;
        this.date = date;
    }

    // Getters et Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Méthodes
    public void enregistrerDiagnostic() {
        System.out.println("Diagnostic enregistré : " + this.toString());
    }

    public void afficherDiagnostic() {
        System.out.println("Détails du diagnostic :");
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Diagnostic{" +
                "description='" + description + '\'' +
                ", docteurID=" + docteurID +
                ", patientID=" + patientID +
                ", date=" + date +
                '}';
    }
}
