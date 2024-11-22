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
import java.util.HashMap;
import java.util.Map;

public final class FactureResident extends Facture implements FactureMachine {
    private int nombreJours;
    private Map<String, Double> machinesUtilisees;

    // Constructeur
    public FactureResident(Date dateRendezVous, int heure, int docteurId, int patientId, double montant, int nombreJours) throws InvalideResidencyException {
        super(dateRendezVous, heure, docteurId, patientId, montant, null, "Non payé");

        // Vérification du nombre de jours (doit être supérieur à 0 pour être un résident)
        if (nombreJours <= 0) {
            throw new InvalideResidencyException("Le nombre de jours doit être supérieur à 0 pour être un patient résident.");
        }

        this.nombreJours = nombreJours;
        this.machinesUtilisees = new HashMap<>();
    }

    // Méthode pour ajouter une machine utilisée
    public void ajouterMachine(String typeMachine, double prix) throws InvalideResidencyException {
        // Vérification que le patient est résident avant d'ajouter une machine
        if (nombreJours <= 0) {
            throw new InvalideResidencyException("Le patient n'est pas un résident et ne peut pas utiliser des machines.");
        }

        machinesUtilisees.put(typeMachine, prix);
        System.out.println("Machine ajoutée : " + typeMachine + " (Prix : " + prix + ")");
    }

    // Utilisation de Stream pour générer le prix total et afficher les machines utilisées
    public void afficherEtCalculerPrixMachines() {
        System.out.println("=== Machines utilisées ===");
        machinesUtilisees.forEach((type, prix) -> System.out.println("Machine : " + type + ", Prix : " + prix));

        // Utilisation de Stream pour calculer le prix total
        double totalMachines = machinesUtilisees.values().stream()
                                                  .mapToDouble(Double::doubleValue)
                                                  .sum();
        System.out.println("Prix total des machines : " + totalMachines);
    }

    // Méthode pour générer la facture
    @Override
    public void genererFacture()  {
        System.out.println("=== Génération de la facture ===");
        double totalMachines = calculerPrixTotal(machinesUtilisees); // Appel à la méthode de l'interface
        System.out.println("Prix total des machines : " + totalMachines);
        double prixTotal = getMontant() + (nombreJours * 50); // Exemple : coût par jour
        System.out.println("Montant de base : " + getMontant());
        System.out.println("Coût des jours à la clinique : " + (nombreJours * 50));
        System.out.println("Prix total à payer : " + prixTotal);}

    // Méthode pour payer la facture
    @Override
    public void payer() throws InvalideResidencyException {
        if (nombreJours <= 0) {
            throw new InvalideResidencyException("Le patient n'est pas un résident et ne peut pas payer.");
        }
        setStatutPaiement("Payé");
        setDateDePaiement(new Date());
        System.out.println("Facture payée le : " + getDateDePaiement());
    }

    // Getter et setter pour le nombre de jours
    public void setNombreJours(int nombreJours) throws InvalideResidencyException {
        if (nombreJours <= 0) {
            throw new InvalideResidencyException("Le nombre de jours doit être supérieur à 0 pour être un patient résident.");
        }
        this.nombreJours = nombreJours;
    }

    public int getNombreJours() {
        return nombreJours;
    }
     @Override
    public double calculerPrixTotal(Map<String, Double> machinesUtilisees) {
        return machinesUtilisees.values().stream()
                                .mapToDouble(Double::doubleValue)
                                .sum();
    }
}
