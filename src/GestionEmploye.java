import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class GestionEmploye {
    private final Map<Integer, Employe> employees;

    public GestionEmploye() {
        employees = new HashMap<>();
        employees.put(1,new Employe(1,"Doe","John","directur",60,12));
        employees.put(2,new Employe(2,"Doe","Jane","responsable marketing",40.0,10));
        }




    public  Employe getEmployeeById(int empId) {
        return employees.get(empId);
    }

    public void addEmployee(Employe employee) {
        employees.put(employee.getIdentifiant(), employee);
    }

    public void removeEmployee(Employe employee) {
        employees.remove(employee.getIdentifiant());
    }

    public void listEmployees() {
        StringBuilder employeeList = new StringBuilder("Liste des employés:\n");
        for (Employe employe : employees.values()) {
            employeeList.append("ID: ").append(employe.getIdentifiant()).append(", Nom: ").append(employe.getNom()).append(", Prénom: ").append(employe.getPrenom()).append("\n");
        }
        JOptionPane.showMessageDialog(null, employeeList.toString());
    }


    public void displayEmployeeProfile(int empId) {
        Employe employe= employees.get(empId);
        if (employe != null) {
           JOptionPane.showMessageDialog(null,"Profil de l'employé :\nNom :"+employe.getNom()+"\nPrenom : " + employe.getPrenom()+"\nreference : " + employe.genererReference());

        } else {
            JOptionPane.showMessageDialog(null,"Employé introuvable!");
        }
    }
    public void displaySchedule(int employeeId,calendrier c) {
        Employe employee = employees.get(employeeId);
        if (employee != null) {
            JOptionPane.showMessageDialog(null,"Horaire de l'employé " + employee.getNom() + " :\n"+"--------------------\n"+"Heure de début : " + c.getHeureDebut()+"\nHeure de fin : " + c.getHeureFin()+"\n--------------------");
                }

        else {
            JOptionPane.showMessageDialog(null, "Employé non trouvé!");
        }

    }
    public void consulterSalaire(int employeeId) {
        Employe employee = getEmployeeById(employeeId);
        if (employee != null) {
            double salaire = employee.calculerSalaire();
            employee.genererRapportFinancier();
            JOptionPane.showMessageDialog(null, "Salaire de l'employé " + employee.getPrenom() + " " + employee.getNom() + " : $" + salaire);
        } else {
            JOptionPane.showMessageDialog(null, "Employé introuvable.");
        }
    }

}
