import javax.swing.*;

public class RH {
    private final GestionEmploye gestionEmploye;

    public RH(GestionEmploye g) {
        this.gestionEmploye = g;
    }

    public void showRHMenu() {
        String[] options = {"Ajouter un nouvel employé", "Mettre à jour les informations d'un employé", "Supprimer un employé", "Établir un calendrier", "Quitter"};
        int choice;

        do {
            choice = JOptionPane.showOptionDialog(null, "Menu du RH", "Menu RH",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addEmploye();
                    break;
                case 1:
                    String idStr = JOptionPane.showInputDialog("Saisir l'ID de l'employé :");
                    int IDe = Integer.parseInt(idStr);
                    String newPosition = JOptionPane.showInputDialog("Saisir la nouvelle position :");
                    update(IDe, newPosition);
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    setSchedule();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Déconnexion...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Choix invalide. Veuillez réessayer.");
            }
        } while (choice != 4);
    }

    private void addEmploye() {
        String name = JOptionPane.showInputDialog("Entrer le nom de l'employé :");
        String pr = JOptionPane.showInputDialog("Entrer le prénom :");
        String position = JOptionPane.showInputDialog("Entrer la position courante :");
        String idStr = JOptionPane.showInputDialog("L'ID :");
        int ID = Integer.parseInt(idStr);
        String thStr = JOptionPane.showInputDialog("Entrer les heures travaillées :");
        int th = Integer.parseInt(thStr);
        String htStr = JOptionPane.showInputDialog("Entrer le taux horaire :");
        int ht = Integer.parseInt(htStr);

        Employe New = new Employe(ID, name, pr, position, th, ht);
        gestionEmploye.addEmployee(New);

        String[] options = {"OK"};
        int choice = JOptionPane.showOptionDialog(null, "Vous pouvez consulter la nouvelle liste des employés.", "Liste des employés",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            gestionEmploye.listEmployees();
        }

        showRHMenu();
    }

    public void update(int employeeId, String newPosition) {
        Employe employee = gestionEmploye.getEmployeeById(employeeId);
        if (employee != null) {
            employee.setPosition(newPosition);
            JOptionPane.showMessageDialog(null, "Profil de l'employé mis à jour. Toutes nos félicitations pour la nouvelle position. Continuez de travailler!");
        } else {
            JOptionPane.showMessageDialog(null, "Employé introuvable.");
        }
    }

    private void deleteEmployee() {
        String idStr = JOptionPane.showInputDialog("Entrez l'ID de l'employé à supprimer :");
        int employeeId = Integer.parseInt(idStr);
        Employe employee = gestionEmploye.getEmployeeById(employeeId);

        if (employee != null) {
            gestionEmploye.removeEmployee(employee);
            JOptionPane.showMessageDialog(null, "Employé supprimé avec succès !");
        } else {
            JOptionPane.showMessageDialog(null, "Employé introuvable.");
        }
    }

    public calendrier setSchedule() {
        calendrier calendrier = new calendrier("", "");
        String nbjStr = JOptionPane.showInputDialog("Combien de jours à travailler par semaine ?");
        int nbj = Integer.parseInt(nbjStr);
        String nbhStr = JOptionPane.showInputDialog("Saisir les heures de travail par jour :");
        int nbh = Integer.parseInt(nbhStr);
        String hd = JOptionPane.showInputDialog("De :");
        calendrier.setHeureDebut(hd);
        String hf = JOptionPane.showInputDialog("À :");
        calendrier.setHeureFin(hf);

        JOptionPane.showMessageDialog(null, "Calendrier établi : " + nbj + " jours par semaine, " + nbh + " heures par jour, de " + hd + " à " + hf);
        return calendrier;
    }
}
