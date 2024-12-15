/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.GestionPersonnel;

/**
 *
 * @author fridh
 */
public class SalleConsultation {
    // Attributs
    private int numeroSalle;
    private int capacite;
    private boolean etat; // true si la salle est réservée, false si elle est libre

    // Constructeur
    public SalleConsultation(int numeroSalle, int capacite) {
        this.numeroSalle = numeroSalle;
        this.capacite = capacite;
        this.etat = false; // Par défaut, la salle est libre
    }

    // Getters et Setters
    public int getNumeroSalle() {
        return numeroSalle;
    }

    public void setNumeroSalle(int numeroSalle) {
        this.numeroSalle = numeroSalle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    // Méthodes
    public void reserverSalle() {
        if (!etat) {
            etat = true;
            System.out.println("Salle " + numeroSalle + " réservée avec succès.");
        } else {
            System.out.println("La salle " + numeroSalle + " est déjà réservée.");
        }
    }

    public void libererSalle() {
        if (etat) {
            etat = false;
            System.out.println("Salle " + numeroSalle + " libérée avec succès.");
        } else {
            System.out.println("La salle " + numeroSalle + " est déjà libre.");
        }
    }

    @Override
    public String toString() {
        return "SalleConsultation{" +
                "numeroSalle=" + numeroSalle +
                ", capacite=" + capacite +
                ", etat=" + (etat ? "Réservée" : "Libre") +
                '}';
    }
}
