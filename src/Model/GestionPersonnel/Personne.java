package Model.GestionPersonnel;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
public sealed class Personne permits Docteur, Patient, Reception {
<<<<<<< HEAD
    private int idPersonne;         
    private String nom;             
    private String prenom;           
    private LocalDate dateNaissance; 
    private String adresse;          
    private String motDePasse;     
    private static Map<String, String> utilisateurs = new HashMap<>(); 
    private boolean estConnecte = false; 
=======
    
    private int idPersonne;          // Identifiant de la personne
    private String nom;              // Nom de la personne
    private String prenom;           // Prénom de la personne
    private LocalDate dateNaissance; // Date de naissance de la personne
    private String adresse;          // Adresse de la personne
    private String motDePasse;       // Mot de passe de la personne
    
    private static Map<String, String> utilisateurs = new HashMap<>(); // Stockage en mémoire des utilisateurs (pseudo -> mot de passe)
    
    private boolean estConnecte = false; // Attribut pour savoir si l'utilisateur est connecté

    // Constructeur
>>>>>>> fd27a39bff9e563ad2b438970cb7d26606280fe1
    public Personne(int idPersonne, String nom, String prenom, LocalDate dateNaissance, String adresse, String motDePasse) {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.motDePasse = motDePasse;
    }
<<<<<<< HEAD
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
=======

    // Getters et Setters
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

    // Méthode pour se connecter
    public boolean seConnecter(String pseudo, String motDePasse) {
        // Vérification de l'utilisateur dans la base de données (ici simulée avec une Map)
        if (utilisateurs.containsKey(pseudo)) {
            String mdpStocke = utilisateurs.get(pseudo);
            if (mdpStocke.equals(motDePasse)) {
                this.estConnecte = true; // Mise à jour de l'état de connexion
                System.out.println(this.nom + " " + this.prenom + " s'est connecté.");
                return true; // Connexion réussie
            } else {
                System.out.println("Mot de passe incorrect.");
                return false; // Mot de passe incorrect
            }
        } else {
            System.out.println("Utilisateur non trouvé.");
            return false; // Utilisateur non trouvé
        }
    }

    // Méthode pour se déconnecter
    public void seDeconnecter() {
        if (estConnecte) { // Vérification si l'utilisateur est connecté
            this.estConnecte = false; // Mise à jour de l'état de connexion
>>>>>>> fd27a39bff9e563ad2b438970cb7d26606280fe1
            System.out.println(this.nom + " " + this.prenom + " s'est déconnecté.");
        } else {
            System.out.println(this.nom + " " + this.prenom + " n'était pas connecté.");
        }
    }
<<<<<<< HEAD
    public static void enregistrerUtilisateur(String pseudo, String motDePasse) {
        utilisateurs.put(pseudo, motDePasse);
    }
=======

    // Méthode pour enregistrer un nouvel utilisateur (facultatif, si vous voulez l'ajouter)
    public static void enregistrerUtilisateur(String pseudo, String motDePasse) {
        utilisateurs.put(pseudo, motDePasse);
    }

>>>>>>> fd27a39bff9e563ad2b438970cb7d26606280fe1
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
<<<<<<< HEAD
=======

    // Test de la classe
    public static void main(String[] args) {
        // Ajout d'un utilisateur pour la démonstration
        enregistrerUtilisateur("johndoe", "password123");

        // Création d'une personne
        Personne personne = new Personne(1, "John", "Doe", LocalDate.of(1990, 1, 1), "123 rue Exemple", "password123");

        // Tentative de connexion avec des identifiants valides
        boolean connected = personne.seConnecter("johndoe", "password123");
        if (connected) {
            // Connexion réussie, puis déconnexion
            personne.seDeconnecter();
        }

        // Tentative de déconnexion alors que l'utilisateur n'est pas connecté
        personne.seDeconnecter();
    }
>>>>>>> fd27a39bff9e563ad2b438970cb7d26606280fe1
}
