package Model.GestionPersonnel;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public sealed class Personne permits Docteur, Patient, Reception {
    private int idPersonne;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String adresse;
    private String motDePasse;
    private static Map<String, String> utilisateurs = new HashMap<>();
    private boolean estConnecte = false;

    public Personne(int idPersonne, String nom, String prenom, LocalDate dateNaissance, String adresse, String motDePasse) {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.motDePasse = motDePasse;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public boolean seConnecter(String pseudo, String motDePasse) {
        if (utilisateurs.containsKey(pseudo) && utilisateurs.get(pseudo).equals(motDePasse)) {
            this.estConnecte = true;
            return true;
        }
        return false;
    }

    public void seDeconnecter() {
        if (estConnecte) {
            estConnecte = false;
        }
    }

    public static void enregistrerUtilisateur(String pseudo, String motDePasse) {
        utilisateurs.put(pseudo, motDePasse);
    }
}
