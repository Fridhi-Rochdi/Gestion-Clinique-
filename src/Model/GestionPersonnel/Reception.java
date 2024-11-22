package Model.GestionPersonnel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Reception extends Personne {
    private String poste;
    private static List<Patient> patientsEnregistres = new ArrayList<>();

    public Reception(int idPersonne, String nom, String prenom, LocalDate dateNaissance, String adresse, String motDePasse, String poste) {
        super(idPersonne, nom, prenom, dateNaissance, adresse, motDePasse);
        this.poste = poste;
    }

    public void enregistrerPatient(Patient patient) {
        if (!patientsEnregistres.contains(patient)) {
            patientsEnregistres.add(patient);
            System.out.println("Patient enregistré.");
        } else {
            System.out.println("Patient déjà enregistré.");
        }
    }
}
