package Model.GestionPersonnel;
import Model.Reservation.Rapport;
import Model.Reservation.RendezVous;
import java.time.LocalDate;
import java.util.Date;
public final class Docteur extends Personne {
    private String specialite;
    private int numeroLicence;
    public Docteur(int idPersonne, String nom, String prenom, LocalDate dateNaissance, String adresse, String motDePasse, String specialite, int numeroLicence) {
        super(idPersonne, nom, prenom, dateNaissance, adresse, motDePasse);
        this.specialite = specialite;
        this.numeroLicence = numeroLicence;
    }
    public Rapport redigerRapport(int numRapport, Date dateRapport, String description, RendezVous rendezVous) {
        if (rendezVous == null) {
            throw new IllegalArgumentException("Le rendez-vous ne peut pas être null.");
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
