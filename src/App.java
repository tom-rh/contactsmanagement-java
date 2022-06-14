import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public App() {
        // Gestion des contacts
        ContactManagement contactManagement = new ContactManagement();
        contactManagement.saveContacts();

        // Visuel
        JFrame frame = new JFrame("Gestion des contacts");

        JPanel panel = new JPanel();

        // Menu principal
        JMenuBar menu = new JMenuBar();
        JMenu gestion = new JMenu("Gestion");
        JMenu help = new JMenu("Aide");

        // Sous-menu pour Gestion
        JMenuItem newContact = new JMenuItem("Ajouter contact");

        newContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame jFramePrenom = new JFrame();
                String getPrenom = JOptionPane.showInputDialog(jFramePrenom, "Indiquez le prénom du contact :");

                JFrame jFrameNom = new JFrame();
                String getNom = JOptionPane.showInputDialog(jFrameNom, "Indiquez le nom du contact :");

                JFrame jFrameAge = new JFrame();
                int getAge = Integer.parseInt(JOptionPane.showInputDialog(jFrameAge, "Indiquez l'âge du contact :"));

                JFrame jFrameTelephone = new JFrame();
                String getTelephone = JOptionPane.showInputDialog(jFrameTelephone, "Indiquez le numéro de téléphone du contact :");

                contactManagement.addContact(getPrenom,getNom,getAge,getTelephone);
            }
        });

        JMenuItem editContact = new JMenuItem("Modifier un contact");

        gestion.add(newContact);
        gestion.add(editContact);

        menu.add(gestion);
        menu.add(help);

        frame.setLayout(new GridLayout(20, 1));

        frame.add(menu);
        frame.add(panel);

        // L'en-têtes du JTable
        String[] column = {"Prénom", "Nom", "Age", "Telephone"};

        // Les lignes du JTable
        String[][] data = {
                {"Tom", "R", "20", "0663380401"},
                {"T2", "R2", "21", "0668848495"}
        };

        Contact Tom = new Contact("Tom", "Pacaud", 21, "0648503264");

        // Créer le JTable
        JTable table = new JTable(data, column);
        JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        frame.add(scroll);




        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
