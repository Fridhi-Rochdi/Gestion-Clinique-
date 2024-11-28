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
    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    public boolean seConnecter(String pseudo, String motDePasse) {
        if (utilisateurs.containsKey(pseudo)) {
            String mdpStocke = utilisateurs.get(pseudo);
            if (mdpStocke.equals(motDePasse)) {
                this.estConnecte = true;
                System.out.println(this.nom + " " + this.prenom + " s'est connecté.");
                return true;
            } else {
                System.out.println("Mot de passe incorrect.");
                return false; 
            }
        } else {
            System.out.println("Utilisateur non trouvé.");
            return false;
        }
    }
    public void seDeconnecter() {
        if (estConnecte) { 
            this.estConnecte = false; 
            System.out.println(this.nom + " " + this.prenom + " s'est déconnecté.");
        } else {
            System.out.println(this.nom + " " + this.prenom + " n'était pas connecté.");
        }
    }
    public static void enregistrerUtilisateur(String pseudo, String motDePasse) {
        utilisateurs.put(pseudo, motDePasse);
    }
    @Override
    public String toString() {
        return "Personne{" +
               "idPersonne=" + idPersonne +
               ", nom='" + nom + '\'' +
               ", prenom='" + prenom + '\'' +
               ", dateNaissance=" + dateNaissance +
               ", adresse='" + adresse + '\'' +
               '}';
    }
}
