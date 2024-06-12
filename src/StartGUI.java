import javax.swing.*;
import java.awt.*;

public class StartGUI extends JFrame {
    private UserTypeListener userTypeListener;

    public StartGUI() {
        setTitle("Identification");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        getContentPane().add(panel);

        JButton buttonClient = new JButton("Client");
        panel.add(buttonClient);
        buttonClient.addActionListener(e -> {
            if (userTypeListener != null) {
                userTypeListener.onClientSelected();
            }
        });

        JButton buttonEmployee = new JButton("Employé");
        panel.add(buttonEmployee);
        buttonEmployee.addActionListener(e -> {
            boolean isRH = JOptionPane.showConfirmDialog(null,"êtes-vous RH?","identification",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION;
            if (userTypeListener != null) {
                userTypeListener.onEmployeeSelected(isRH);
            }
        });
    }

    public void addUserTypeListener(UserTypeListener listener) {
        this.userTypeListener = listener;
    }
}
