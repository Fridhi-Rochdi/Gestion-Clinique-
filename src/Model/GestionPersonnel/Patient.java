package Model.GestionPersonnel;
import Model.Reservation.Paiement;
import Model.Reservation.InvalidPaymentAmountException;
import java.time.LocalDate;
public final class Patient extends Personne {
    private String numeroSecuriteSociale;
    private String historiqueMedical;
    public Patient(int idPersonne, String nom, String prenom, LocalDate dateNaissance, String adresse, String motDePasse, String numeroSecuriteSociale, String historiqueMedical) {
        super(idPersonne, nom, prenom, dateNaissance, adresse, motDePasse);
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        this.historiqueMedical = historiqueMedical;
    }
    public void demanderRendezVous(String date, String heure) {
        System.out.println("Demande de rendez-vous pour le " + date + " à " + heure + ".");
    }
    public void payerFacture(String modeDePaiement, double montant) {
        try {
            Paiement paiement = new Paiement(modeDePaiement, new java.util.Date(), montant);
            paiement.effectuerPaiement();
        } catch (InvalidPaymentAmountException e) {
            System.out.println("Erreur de paiement : " + e.getMessage());
        }
    }
    public String getNumeroSecuriteSociale() {
        return numeroSecuriteSociale;
    }

    public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }
    public String getHistoriqueMedical() {
        return historiqueMedical;
    }
    public void setHistoriqueMedical(String historiqueMedical) {
        this.historiqueMedical = historiqueMedical;
    }
}
