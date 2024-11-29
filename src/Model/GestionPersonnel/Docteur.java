package Model.GestionPersonnel;
import Model.Reservation.Rapport;
import Model.Reservation.RendezVous;
import java.time.LocalDate;
<<<<<<< HEAD
import java.util.Date;
public final class Docteur extends Personne {
    private String specialite;
    private int numeroLicence;
=======
import java.util.ArrayList;
import java.util.List;

public final class Docteur extends Personne {
    private String specialite;
    private int numeroLicence;
    private List<HoraireDocteur> horaires; // Liste des horaires associés au docteur

    // Constructeur
>>>>>>> fd27a39bff9e563ad2b438970cb7d26606280fe1
    public Docteur(int idPersonne, String nom, String prenom, LocalDate dateNaissance, String adresse, String motDePasse, String specialite, int numeroLicence) {
        super(idPersonne, nom, prenom, dateNaissance, adresse, motDePasse);
        this.specialite = specialite;
        this.numeroLicence = numeroLicence;
        this.horaires = new ArrayList<>();
    }
<<<<<<< HEAD
    public Rapport redigerRapport(int numRapport, Date dateRapport, String description, RendezVous rendezVous) {
        if (rendezVous == null) {
            throw new IllegalArgumentException("Le rendez-vous ne peut pas être null.");
=======

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
>>>>>>> fd27a39bff9e563ad2b438970cb7d26606280fe1
        }
        Rapport rapport = new Rapport(numRapport, dateRapport, description, rendezVous);
        System.out.println("Rapport rédigé avec succès !");
        System.out.println("Détails du rapport : " + rapport);

        return rapport; // Retourne le rapport créé pour un traitement ultérieur
    }

    // Getters et setters (inchangés)
    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    public int getNumeroLicence() {
        return numeroLicence;
    }
    public void setNumeroLicence(int numeroLicence) {
        this.numeroLicence = numeroLicence;
    }
}
