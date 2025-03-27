package Model.GestionPersonnel;

import java.util.ArrayList;
import java.util.List;

public class Service implements AjouterDocteurService, SupprimerDocteurService, DisponibiliteDocteurService, ListeDocteursService {
    private String nomService;
    private List<String> listeDocteurs; // Liste des noms des docteurs
    private String description;

    // Constructeur
    public Service(String nomService, String description) {
        this.nomService = nomService;
        this.description = description;
        this.listeDocteurs = new ArrayList<>();
    }

    // Getters
    public String getNomService() {
        return nomService;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public List<String> getListeDocteurs() {
        return new ArrayList<>(listeDocteurs); // Retourne une copie pour éviter les modifications externes
    }

    // Méthode pour ajouter un docteur
    @Override
    public void ajouterDocteur(String docteur) {
        // Lambda expression for adding doctor if not already present
        if (!listeDocteurs.contains(docteur)) {
            listeDocteurs.add(docteur);
            System.out.println("Docteur " + docteur + " ajouté avec succès.");
        } else {
            System.out.println("Le docteur " + docteur + " est déjà dans la liste.");
        }
    }

    // Méthode pour supprimer un docteur
    @Override
    public void supprimerDocteur(String docteur) {
        // Using removeIf to simplify doctor removal with lambda expression
        boolean isRemoved = listeDocteurs.removeIf(d -> d.equals(docteur));
        if (isRemoved) {
            System.out.println("Docteur " + docteur + " supprimé avec succès.");
        } else {
            System.out.println("Le docteur " + docteur + " n'existe pas dans la liste.");
        }
    }

    // Méthode pour vérifier si un docteur est disponible
    @Override
    public boolean isDisponible(String docteur) {
        // Lambda expression for checking availability
        return listeDocteurs.stream().anyMatch(d -> d.equals(docteur));
    }
}
