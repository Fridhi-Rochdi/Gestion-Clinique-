/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.GestionPersonnel;
<<<<<<< HEAD
=======

>>>>>>> fd27a39bff9e563ad2b438970cb7d26606280fe1
/**
 *
 * @author fridh
 */
import java.util.List;
<<<<<<< HEAD
public record Ordonnace(String numOrd, String date, List<String> medicaments) {
=======

public record Ordonnace(String numOrd, String date, List<String> medicaments) {

    // Méthode pour ajouter une ordonnance (ici, nous simulerons l'ajout d'une ordonnance)
>>>>>>> fd27a39bff9e563ad2b438970cb7d26606280fe1
    public static void ajouterOrdonnace(List<Ordonnace> ordonnances, Ordonnace ordonnace) {
        ordonnances.add(ordonnace);
        System.out.println("Ordonnance ajoutée : " + ordonnace.numOrd());
    }
<<<<<<< HEAD
=======

    // Méthode pour afficher une ordonnance
>>>>>>> fd27a39bff9e563ad2b438970cb7d26606280fe1
    public void afficherOrdonnace() {
        System.out.println("Numéro de l'ordonnance : " + numOrd());
        System.out.println("Date de l'ordonnance : " + date());
        System.out.println("Médicaments prescrits : " + String.join(", ", medicaments));
    }
}

