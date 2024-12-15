/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.GestionPersonnel;

import java.util.List;

public record Ordonnace(String numOrd, String date, List<String> medicaments) {

    // Méthode statique pour ajouter une ordonnance à une liste d'ordonnances
    public static void ajouterOrdonnace(List<Ordonnace> ordonnances, Ordonnace ordonnance) {
        ordonnances.add(ordonnance);
        System.out.println("Ordonnance ajoutée : " + ordonnance.numOrd());
    }

    // Méthode pour afficher les détails de l'ordonnance
    public void afficherOrdonnace() {
        System.out.println("Numéro de l'ordonnance : " + numOrd());
        System.out.println("Date de l'ordonnance : " + date());
        System.out.println("Médicaments prescrits : " + String.join(", ", medicaments));
    }
}
