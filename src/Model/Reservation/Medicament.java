/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Reservation;

/**
 *
 * @author sarra
 */
public record Medicament(String nom, double dose, String frequence) {
    // Constructeur compact pour valider les attributs
    public Medicament {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom du médicament ne peut pas être vide.");
        }
        if (dose <= 0) {
            throw new IllegalArgumentException("La dose doit être supérieure à 0.");
        }
        if (frequence == null || frequence.isBlank()) {
            throw new IllegalArgumentException("La fréquence ne peut pas être vide.");
        }
    }

    // Méthode personnalisée pour afficher les détails du médicament
    public String details() {
        return "Médicament : " + nom + ", Dose : " + dose + " mg, Fréquence : " + frequence;
    }
       public boolean estPriseTroisFoisParJour() {
        return "3 fois par jour".equalsIgnoreCase(frequence);
    }
}

