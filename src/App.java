import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class App {
    public App() {
        // Gestion des contacts
        ContactManagement contactManagement = new ContactManagement();

        // Visuel
        JFrame frame = new JFrame("Gestion des contacts");

        JPanel panel = new JPanel();

        // Menu principal
        JMenuBar menu = new JMenuBar();
        JMenu gestion = new JMenu("Gestion");
        JMenu help = new JMenu("Aide");

        // Sous-menu pour Gestion
        JMenuItem newContact = new JMenuItem("Ajouter contact");

        // Action à réaliser si on appuie sur le bouton
        newContact.addActionListener(e -> {
            String getPrenom = getNonBlankInput("Indiquez le prénom du contact :");

            String getNom = getNonBlankInput("Indiquez le nom du contact :");

            int getAge = Integer.parseInt(getNonBlankInput("Indiquez l'âge du contact :"));

            String getTelephone = getNonBlankInput("Indiquez le numéro de téléphone du contact :");

            contactManagement.addContact(getPrenom,getNom,getAge,getTelephone);

            contactManagement.saveContacts();
        });

        JMenuItem editContact = new JMenuItem("Modifier un contact");

        // Action à réaliser si on appuie sur le bouton
        editContact.addActionListener(e -> {
            int getID = Integer.parseInt(getNonBlankInput("Spécifiez l'ID du contact auquel vous vous souhaitez apporter des modifications :"));

            String[] choices = { "Prénom", "Nom", "Age", "Téléphone"};
            String getInfoToChange = (String) JOptionPane.showInputDialog(null, "Choisissez l'information que vous souhaitez modifier", "Choix de l'information à modifier :", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

            String getNewInfo = getNonBlankInput("Indiquez la nouvelle valeur :");

            contactManagement.editContact(getID, getInfoToChange,getNewInfo);

            contactManagement.saveContacts();
        });

        gestion.add(newContact);
        gestion.add(editContact);

        menu.add(gestion);
        menu.add(help);

        frame.setLayout(new GridLayout(20, 1));

        frame.add(menu);
        frame.add(panel);

        JLabel text = new JLabel();
        text.setText("Nombre total de contacts : " + contactManagement.getNumberOfContacts());

        frame.add(text);

        frame.add(scroll);

        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    String getNonBlankInput(String saisie) {
        String input;
        input = JOptionPane.showInputDialog(saisie);

        while (input.equals("")) {
            JOptionPane.showMessageDialog(null, "Vous devez écrire quelque chose !");
            input = JOptionPane.showInputDialog(saisie);
        }

        return input;
    }
}
