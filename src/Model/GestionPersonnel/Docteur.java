package Model.GestionPersonnel;

import java.time.LocalDate;

public final class Docteur extends Personne {
    private String specialite;
    private int numeroLicence;

    public Docteur(int idPersonne, String nom, String prenom, LocalDate dateNaissance, String adresse, String motDePasse, String specialite, int numeroLicence) {
        super(idPersonne, nom, prenom, dateNaissance, adresse, motDePasse);
        this.specialite = specialite;
        this.numeroLicence = numeroLicence;
    }

    public void consulterPatient(Patient patient) {
        String symptomes = patient.getHistoriqueMedical();
        if (symptomes == null || symptomes.isEmpty()) {
            symptomes = "Symptômes non définis.";
        }
        System.out.println("Diagnostic pour le patient : " + symptomes);
    }
}
