package Model.GestionPersonnel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Docteur extends Personne {
    private String specialite;
    private int numeroLicence;
    private List<HoraireDocteur> horaires; // Liste des horaires associés au docteur

    // Constructeur
    public Docteur(int idPersonne, String nom, String prenom, LocalDate dateNaissance, String adresse, String motDePasse, String specialite, int numeroLicence) {
        super(idPersonne, nom, prenom, dateNaissance, adresse, motDePasse);
        this.specialite = specialite;
        this.numeroLicence = numeroLicence;
        this.horaires = new ArrayList<>();
    }

    // Méthode pour ajouter un horaire
    public void ajouterHoraire(int jour, String heure) {
        HoraireDocteur horaire = new HoraireDocteur(jour, heure);
        horaires.add(horaire);
        System.out.println("Horaire ajouté : " + horaire);
    }

    // Méthode pour afficher tous les horaires
    public void afficherHoraires() {
        System.out.println("Horaires du docteur " + super.getNom() + " :");
        for (HoraireDocteur horaire : horaires) {
            System.out.println(horaire);
        }
    }

    // Classe imbriquée pour les horaires
    public class HoraireDocteur {
        private int jour;  // Numéro du jour (1 = Lundi, 7 = Dimanche)
        private String heure; // Heure au format "HH:mm"

        // Constructeur
        public HoraireDocteur(int jour, String heure) {
            this.jour = jour;
            this.heure = heure;
        }

        // Getters
        public int getJour() {
            return jour;
        }

        public String getHeure() {
            return heure;
        }

        @Override
        public String toString() {
            return "Jour: " + jour + ", Heure: " + heure;
        }
    }

    // Méthode pour consulter un patient
    public void consulterPatient(Patient patient) {
        String symptomes = patient.getHistoriqueMedical();
        if (symptomes == null || symptomes.isEmpty()) {
            symptomes = "Symptômes non définis.";
        }
        System.out.println("Diagnostic pour le patient : " + symptomes);
    }
}
