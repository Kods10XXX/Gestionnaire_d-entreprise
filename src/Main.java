import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        GestionEmploye gestionEmploye = new GestionEmploye();
        RH rh = new RH(gestionEmploye);
        Article article1 = new Article("Article 1", 10);
        Article article2 = new Article("Article 2", 10.0);
        Article article3 = new Article("Article 3", 20.0);
        Vente vente = new Vente();
        SwingUtilities.invokeLater(() -> {
            StartGUI startGUI = new StartGUI();
            startGUI.addUserTypeListener(new UserTypeListener() {
                @Override
                public void onClientSelected() {
                    String nomClient = JOptionPane.showInputDialog("Entrer le nom du client :");
                    String prenomClient = JOptionPane.showInputDialog("Entrer le prenom du client :");
                    String adresseClient = JOptionPane.showInputDialog("Entrer l'adresse du client :");
                    Client client = new Client(nomClient, prenomClient, adresseClient);
                    JOptionPane.showMessageDialog(null, "Bienvenue " + client.getNom() + " " + client.getPrenom() + "!");
                    String[] options = {"Article 1- $" + article1.getPrix(), "Article 2- $" + article2.getPrix(), "Article 3- $" + article3.getPrix()};
                    int choix = JOptionPane.showOptionDialog(null, "CHoisir un article", "Articles disponibles", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    switch (choix) {
                        case 0:
                            vente.ajouterArticle(article1);
                            vente.genererFacture();
                            break;
                        case 1:
                            vente.ajouterArticle(article2);
                            vente.genererFacture();
                            break;
                        case 2:
                            vente.ajouterArticle(article3);
                            vente.genererFacture();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "choix invalide. Veuillez choisir parmi les articles disponibles");
                            break;
                    }
                }

                @Override
                public void onEmployeeSelected(boolean isRH) {
                    if (isRH) {
                        rh.showRHMenu();
                    } else {
                        String empIDStr = JOptionPane.showInputDialog("Donner l'ID de l'employe :");
                        int empID = Integer.parseInt(empIDStr);
                        int choiX;
                        do {
                            String[] empOptions = {"Consultez mon profil", "Consulter Salaire", "Consulter l'horaire", "Quitter"};
                            choiX = JOptionPane.showOptionDialog(null, "Menu de l'employe", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, empOptions, empOptions[0]);
                            switch (choiX) {
                                case 0:
                                    gestionEmploye.displayEmployeeProfile(empID);
                                    break;
                                case 1:
                                    Employe e = gestionEmploye.getEmployeeById(empID);
                                    e.genererRapportFinancier();
                                    break;
                                case 2:
                                    gestionEmploye.displaySchedule(empID, rh.setSchedule());
                                    break;
                                case 3:
                                    JOptionPane.showMessageDialog(null, "Deconnxion...");
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Choix invalide. Veuillez réessayer");


                            }
                        } while (choiX != 3);
                    }
                }
            });
            startGUI.setVisible(true);
            startGUI.setLocationRelativeTo(null);
        });
    }
}
