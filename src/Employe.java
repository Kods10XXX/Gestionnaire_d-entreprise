import javax.swing.*;

public class Employe {
    private int identifiant;
    private String nom;
    private String prenom;
    private String Position;
    private final String reference;
    private double tauxHoraire;
    private int heuresTravaillees;
    private calendrier Calendrier;

    public Employe(int identifiant, String nom, String prenom,String pos,double tauxHoraire, int heuresTravaillee) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.reference = genererReference();
        this.Position=pos;
        this.tauxHoraire = tauxHoraire;
        this.Calendrier=new calendrier("","");
    }

    public void setCalendrier(calendrier calendrier) {
        this.Calendrier = calendrier;
    }

    public String genererReference() {
        String reference = "";

        for (int i = 0; i < nom.length(); i++) {
            char caractere = nom.charAt(i);

            if (i % 2 == 0) {
                reference += Character.toUpperCase(caractere);
            } else {
                reference += identifiant % 21;
            }
        }

        return reference;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "identifiant=" + identifiant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", reference='" + reference + '\'' +
                "Position ="+getPosition()+'}';
    }

    public calendrier getCalendrier() {
        return Calendrier;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }
    public void setHeuresTravaillees(int heuresTravaillees) {
        this.heuresTravaillees = heuresTravaillees;
    }
    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }
    public double calculerSalaire() {
        return tauxHoraire * (double)heuresTravaillees;
    }
    public void genererRapportFinancier() {
        double salaire = calculerSalaire();
        String rapport = "Rapport financier pour " + prenom + " " + nom + "\n" + "Identifiant de l'employé : " + identifiant + "\n" + "Salaire : $" + salaire;
        JOptionPane.showMessageDialog(null, rapport, "Rapport Financier", JOptionPane.INFORMATION_MESSAGE);
    }
    public void genererRecapHoraire() {
        String message = "Récapitulatif horaire pour " + prenom + " " + nom + "\n" + "Identifiant de l'employé : " + identifiant + "\n" + "Heures travaillées : " + heuresTravaillees + " heures";
        JOptionPane.showMessageDialog(null, message, "Récapitulatif Horaire", JOptionPane.INFORMATION_MESSAGE);
    }


}
