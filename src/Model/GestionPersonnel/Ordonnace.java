/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.GestionPersonnel;

/**
 *
 * @author fridh
 */
import java.util.List;

public record Ordonnace(String numOrd, String date, List<String> medicaments) {

    // Méthode pour ajouter une ordonnance (ici, nous simulerons l'ajout d'une ordonnance)
    public static void ajouterOrdonnace(List<Ordonnace> ordonnances, Ordonnace ordonnace) {
        ordonnances.add(ordonnace);
        System.out.println("Ordonnance ajoutée : " + ordonnace.numOrd());
    }

    // Méthode pour afficher une ordonnance
    public void afficherOrdonnace() {
        System.out.println("Numéro de l'ordonnance : " + numOrd());
        System.out.println("Date de l'ordonnance : " + date());
        System.out.println("Médicaments prescrits : " + String.join(", ", medicaments));
    }
}

