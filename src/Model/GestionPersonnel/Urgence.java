/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.GestionPersonnel;
/**
 *
 * @author fridh
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Urgence {
    // Enumération pour le niveau d'urgence
    public enum NiveauUrgence {
        FAIBLE, MOYEN, GRAVE, CRITIQUE
    }
    /**/
    // Attributs
    private NiveauUrgence niveauUrgence;
    private int idPatient;
    private int tempsAttenteEstime; 
    private static List<Urgence> listePatients = new ArrayList<>();
    // Constructeur
    public Urgence(NiveauUrgence niveauUrgence, int idPatient, int tempsAttenteEstime) {
        this.niveauUrgence = niveauUrgence;
        this.idPatient = idPatient;
        this.tempsAttenteEstime = tempsAttenteEstime;
    }
    // Getters et Setters
    public NiveauUrgence getNiveauUrgence() {
        return niveauUrgence;
    }
    public void setNiveauUrgence(NiveauUrgence niveauUrgence) {
        this.niveauUrgence = niveauUrgence;
    }
    public int getIdPatient() {
        return idPatient;
    }
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }
    public int getTempsAttenteEstime() {
        return tempsAttenteEstime;
    }
    public void setTempsAttenteEstime(int tempsAttenteEstime) {
        this.tempsAttenteEstime = tempsAttenteEstime;
    }
    // Méthode pour ajouter un patient à la liste
    public static void ajouterPatient(Urgence urgence) {
        listePatients.add(urgence);
        System.out.println("Patient ID " + urgence.idPatient + " ajouté avec un niveau d'urgence " + urgence.niveauUrgence);
    }
    // Méthode pour classer les patients par urgence
    public static void classerPatientsParUrgence() {
        listePatients.sort(Comparator.comparing(Urgence::getNiveauUrgence).reversed());
        System.out.println("Les patients ont été classés par niveau d'urgence.");
    }
    // Méthode pour suivre un patient (affiche les détails)
    public static void suivrePatient(int idPatient) {
        for (Urgence urgence : listePatients) {
            if (urgence.getIdPatient() == idPatient) {
                System.out.println("Détails du patient ID " + idPatient + ":");
                System.out.println("Niveau d'urgence : " + urgence.getNiveauUrgence());
                System.out.println("Temps d'attente estimé : " + urgence.getTempsAttenteEstime() + " minutes.");
                return;
            }
        }
        System.out.println("Patient ID " + idPatient + " introuvable.");
    }
    // Affichage de la liste des patients
    public static void afficherListePatients() {
        System.out.println("Liste des patients :");
        for (Urgence urgence : listePatients) {
            System.out.println("ID : " + urgence.getIdPatient() + ", Niveau : " + urgence.getNiveauUrgence() + ", Attente : " + urgence.getTempsAttenteEstime() + " minutes.");
        }
    }
}

