package Model.GestionPersonnel;
import Model.Reservation.RendezVous;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**

 */
public final class Reception extends Personne {
    private String poste;
    private static List<Patient> patientsEnregistres = new ArrayList<>();
    private static List<RendezVous> rendezVousPlanifies = new ArrayList<>();

    // Constructeur
    public Reception(int idPersonne, String nom, String prenom, LocalDate dateNaissance, String adresse, String motDePasse, String poste) {
        super(idPersonne, nom, prenom, dateNaissance, adresse, motDePasse);
        this.poste = poste;
    }

    // Getters et Setters
    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    // Méthodes
    /**
     * Enregistrer un patient s'il n'est pas déjà enregistré.
     * @param patient Le patient à enregistrer.
     */
    public void enregistrerPatient(Patient patient) {
        if (!patientsEnregistres.contains(patient)) {
            patientsEnregistres.add(patient);
            System.out.println("Patient enregistré : " + patient.getNom() + " " + patient.getPrenom());
        } else {
            System.out.println("Le patient " + patient.getNom() + " " + patient.getPrenom() + " est déjà enregistré.");
        }
    }

    /**
     * Planifier un rendez-vous entre un patient et un docteur.
     * @param rendezVous Le rendez-vous à planifier.
     */
    public void planifierRendezVous(RendezVous rendezVous) {
        if (rendezVous == null) {
            System.out.println("Impossible de planifier un rendez-vous vide.");
            return;
        }
        if (rendezVousPlanifies.contains(rendezVous)) {
            System.out.println("Le rendez-vous est déjà planifié.");
            return;
        }
        rendezVousPlanifies.add(rendezVous);
        System.out.println("Rendez-vous planifié avec succès pour le patient " +
                rendezVous.getPatientId() + " avec le docteur " + rendezVous.getDocteurId() +
                " le " + rendezVous.getDateRendezVous() + " à " + rendezVous.getHeure() + "h.");
    }

    /**
     * Annuler un rendez-vous existant.
     * @param rendezVous Le rendez-vous à annuler.
     */
    public void annulerRendezVous(RendezVous rendezVous) {
        if (rendezVousPlanifies.remove(rendezVous)) {
            System.out.println("Rendez-vous annulé avec succès.");
        } else {
            System.out.println("Le rendez-vous spécifié n'existe pas.");
        }
    }

    /**
     * Afficher la liste des patients enregistrés.
     */
    public void afficherListePatients() {
        if (patientsEnregistres.isEmpty()) {
            System.out.println("Aucun patient enregistré.");
        } else {
            System.out.println("Liste des patients enregistrés :");
            for (Patient patient : patientsEnregistres) {
                System.out.println("- " + patient.getNom() + " " + patient.getPrenom());
            }
        }
    }

    /**
     * Afficher la liste des rendez-vous planifiés.
     */
    public void afficherListeRendezVous() {
        if (rendezVousPlanifies.isEmpty()) {
            System.out.println("Aucun rendez-vous planifié.");
        } else {
            System.out.println("Liste des rendez-vous planifiés :");
            for (RendezVous rdv : rendezVousPlanifies) {
                System.out.println("- Rendez-vous du patient ID " + rdv.getPatientId() +
                        " avec le docteur ID " + rdv.getDocteurId() +
                        " le " + rdv.getDateRendezVous() + " à " + rdv.getHeure() + "h.");
            }
        }
    }

    /**
     * Rechercher un patient par son nom.
     * @param nom Le nom du patient à rechercher.
     * @return Liste des patients correspondants.
     */
    public List<Patient> rechercherPatientParNom(String nom) {
        List<Patient> resultats = new ArrayList<>();
        for (Patient patient : patientsEnregistres) {
            if (patient.getNom().equalsIgnoreCase(nom)) {
                resultats.add(patient);
            }
        }
        return resultats;
    }

    @Override
    public String toString() {
        return "Reception{" +
                "poste='" + poste + '\'' +
                ", nombre de patients enregistrés=" + patientsEnregistres.size() +
                ", nombre de rendez-vous planifiés=" + rendezVousPlanifies.size() +
                '}';
    }
}
