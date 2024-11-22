/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Reservation;

/**
 *
 * @author sarra
 */
import java.util.*;
import java.util.stream.Collectors;

public class AppointmentService {
    private List<RendezVous> rendezVousList;

    // Constructeur
    public AppointmentService() {
        this.rendezVousList = new ArrayList<>();
    }

    // Ajouter un rendez-vous
    public void ajouterRendezVous(RendezVous rendezVous) throws InvalidAppointmentException {
        if (rendezVous.getHeure() < 0 || rendezVous.getHeure() > 23) {
            throw new InvalidAppointmentException("L'heure du rendez-vous doit être comprise entre 0 et 23.");
        }
        rendezVousList.add(rendezVous);
        System.out.println("Rendez-vous ajouté avec succès !");
    }

    // Supprimer un rendez-vous
    public void supprimerRendezVous(int idPatient) {
        rendezVousList.removeIf(rdv -> rdv.getPatientId() == idPatient);
        System.out.println("Rendez-vous du patient ID " + idPatient + " supprimé.");
    }

    // Filtrer les rendez-vous d'un docteur
    public List<RendezVous> filtrerRendezVousParDocteur(int docteurId) {
        return rendezVousList.stream()
                .filter(rdv -> rdv.getDocteurId() == docteurId)
                .collect(Collectors.toList());
    }

    // Trouver le rendez-vous le plus proche d'une date donnée
    public Optional<RendezVous> trouverProchainRendezVous(Date date) {
        return rendezVousList.stream()
                .filter(rdv -> rdv.getDateRendezVous().after(date))
                .min(Comparator.comparing(RendezVous::getDateRendezVous));
    }

    // Afficher tous les rendez-vous
    public void afficherTousLesRendezVous() {
        rendezVousList.forEach(rdv -> System.out.println(rdv));
    }
}
