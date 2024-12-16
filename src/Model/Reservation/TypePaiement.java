/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Reservation;

/**
 *
 * @author fridh
 */
public enum TypePaiement {
    CB("Carte Bancaire"),
    PP("PayPal"),
    VB("Virement Bancaire"),
    CH("Chèque");

    private final String libelle;

    // Constructeur pour initialiser le libellé de chaque type de paiement
    TypePaiement(String libelle) {
        this.libelle = libelle;
    }

    // Méthode pour récupérer le libellé du type de paiement
    public String getLibelle() {
        return libelle;
    }

    // Méthode pour obtenir tous les types de paiement sous forme de tableau
    public static TypePaiement[] getAllTypes() {
        return TypePaiement.values();
    }
   
    public static void main(String[] args) {
        // Exemple d'utilisation de l'énumération
        for (TypePaiement type : TypePaiement.getAllTypes()) {
            System.out.println(type.getLibelle());
        }
    }
}