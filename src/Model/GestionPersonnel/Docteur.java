package Model.GestionPersonnel;

import Model.Reservation.Rapport;
import Model.Reservation.RendezVous;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Docteur extends Personne {
    private String specialite;               // Spécialité du docteur
    private int numeroLicence;  
    private String Telephone ;// Numéro de licence
    private List<HoraireDocteur> horaires;  // Liste des horaires associés au docteur
private String Email;

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    // Constructeur
    public Docteur(String nom, String specialite) {
    super(0, nom, "", null, "", ""); // Appel au constructeur de Personne
    this.specialite = specialite;
    this.numeroLicence = 0; // Valeur par défaut
    this.horaires = new ArrayList<>();
}

    // Méthode pour rédiger un rapport
    public Rapport redigerRapport(int numRapport, Date dateRapport, String description, RendezVous rendezVous) {
        if (rendezVous == null) {
            throw new IllegalArgumentException("Le rendez-vous ne peut pas être null.");
        }
        Rapport rapport = new Rapport(numRapport, dateRapport, description, rendezVous);
        System.out.println("Rapport rédigé avec succès !");
        System.out.println("Détails du rapport : " + rapport);
        return rapport; // Retourne le rapport créé pour un traitement ultérieur
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

    public String getTelephone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getDateEntree() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Classe imbriquée pour les horaires
    public class HoraireDocteur {
        private int jour;   // Numéro du jour (1 = Lundi, 7 = Dimanche)
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

   

    // Getters et Setters
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
