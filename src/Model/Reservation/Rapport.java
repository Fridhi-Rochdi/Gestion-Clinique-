/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Reservation;

/**
 *
 * @author sarra
 */
import java.util.Date;

public class Rapport {
    private int numRapport;
    private Date dateRapport;
    private String description;
    private RendezVous rendezVous; // Lien avec RendezVous

    // Constructeur
    public Rapport(int numRapport, Date dateRapport, String description, RendezVous rendezVous) {
        this.numRapport = numRapport;
        this.dateRapport = dateRapport;
        this.description = description;
        this.rendezVous = rendezVous;
    }

    // Getters et Setters
    public int getNumRapport() {
        return numRapport;
    }

    public void setNumRapport(int numRapport) {
        this.numRapport = numRapport;
    }

    public Date getDateRapport() {
        return dateRapport;
    }

    public void setDateRapport(Date dateRapport) {
        this.dateRapport = dateRapport;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RendezVous getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(RendezVous rendezVous) {
        this.rendezVous = rendezVous;
    }

    // Méthodes
    public void afficherRapport() {
        System.out.println("Rapport #" + numRapport);
        System.out.println("Date du rapport : " + dateRapport);
        System.out.println("Description : " + description);
        if (rendezVous != null) {
            System.out.println("Lié au rendez-vous : " + rendezVous);
        } else {
            System.out.println("Pas de rendez-vous lié.");
        }
    }

    public void modifierDescription(String nouvelleDescription) {
        this.description = nouvelleDescription;
        System.out.println("Description mise à jour !");
    }

    public boolean estRapportRecent(Date dateLimite) {
        return dateRapport != null && dateRapport.after(dateLimite);
    }

    @Override
    public String toString() {
        return "Rapport{" +
                "numRapport=" + numRapport +
                ", dateRapport=" + dateRapport +
                ", description='" + description + '\'' +
                '}';
    }
}
