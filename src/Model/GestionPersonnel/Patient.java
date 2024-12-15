package Model.GestionPersonnel;
import Model.Reservation.Paiement;
import Model.Reservation.InvalidPaymentAmountException;
import java.time.LocalDate;
public final class Patient extends Personne {
    private String numeroSecuriteSociale;
    private  String  historiqueMedical;
    private  String  symptomes;
   // Constructeur simplifié dans la classe Patient
public Patient(String nom, String numeroSecuriteSociale, String adresse, LocalDate dateNaissance, String symptomes, String historiqueMedical) {
    super(0, nom, "", dateNaissance, adresse, "");
    this.numeroSecuriteSociale = numeroSecuriteSociale;
    this.symptomes = symptomes;
    this.historiqueMedical = historiqueMedical;
}



public String getSymptomes() {
    return symptomes;
}

public void setSymptomes(String symptomes) {
    this.symptomes = symptomes;
}

public String getHistoriqueMedical() {
    return historiqueMedical;
}

public void setHistoriqueMedical(String historiqueMedical) {
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
   

  

    @Override
    public String toString() {
        return "Patient{" +
               "numeroSecuriteSociale='" + numeroSecuriteSociale + '\'' +
              
               ", nom='" + getNom() + '\'' +
               ", prenom='" + getPrenom() + '\'' +
               ", adresse='" + getAdresse() + '\'' +
               ", dateNaissance=" + getDateNaissance() +
               '}';
    }

    void setHistoriquemedicale(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

   

    public Object getAge() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}