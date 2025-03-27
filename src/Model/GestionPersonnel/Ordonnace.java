package Model.GestionPersonnel;

import java.util.List;
import java.util.stream.Collectors;

public record Ordonnace(String numOrd, String date, List<String> medicaments) {

    // Méthode statique pour ajouter une ordonnance à une liste d'ordonnances avec Stream
    public static void ajouterOrdonnace(List<Ordonnace> ordonnances, Ordonnace ordonnance) {
        ordonnances.add(ordonnance);
        System.out.println("Ordonnance ajoutée : " + ordonnance.numOrd());
    }

    // Méthode pour afficher les détails de l'ordonnance avec Stream et lambda
    public void afficherOrdonnace() {
        System.out.println("Numéro de l'ordonnance : " + numOrd());
        System.out.println("Date de l'ordonnance : " + date());
        
        // Utilisation de Stream et lambda pour afficher les médicaments
        String medicamentsAffiches = medicaments.stream()
                                                .collect(Collectors.joining(", "));
        System.out.println("Médicaments prescrits : " + medicamentsAffiches);
    }

    // Méthode statique pour afficher toutes les ordonnances d'une liste
    public static void afficherOrdonnances(List<Ordonnace> ordonnances) {
        ordonnances.forEach(ordonnance -> ordonnance.afficherOrdonnace());
    }

    // Méthode statique pour obtenir une liste des ordonnances avec un médicament spécifique
    public static List<Ordonnace> filtrerParMedicament(List<Ordonnace> ordonnances, String medicament) {
        return ordonnances.stream()
                          .filter(ord -> ord.medicaments.contains(medicament))
                          .collect(Collectors.toList());
    }
}
