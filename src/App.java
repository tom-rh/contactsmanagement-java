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

        frame.setLayout(new BorderLayout());

        frame.add(menu, BorderLayout.NORTH);

        //frame.add(panel);

        JLabel text = new JLabel();
        text.setText("Nombre total de contacts : " + contactManagement.getNumberOfContacts());

        panel.add(text);

        // Bouton permettant d'actualiser l'affichage du tableau
        JButton btnUpdate =new JButton("Actualiser");
        btnUpdate.addActionListener(e -> {
            //this.displayContactList();
        });

        panel.add(btnUpdate);

        // L'en-têtes du JTable
        String[] column = {"ID", "Prénom", "Nom", "Age", "Telephone"};

        // Remplissage du tableau avec les données stockées
        String[][] data = new String[100][5];
        ArrayList<Contact> contactList = contactManagement.getContactList();
        int countLine = 0;
        while (contactList.size() > countLine) {
            data[countLine][0] = String.valueOf(contactList.get(countLine).getId());
            data[countLine][1] = contactList.get(countLine).getPrenom();
            data[countLine][2] = contactList.get(countLine).getNom();
            data[countLine][3] = String.valueOf(contactList.get(countLine).getAge());
            data[countLine][4] = contactList.get(countLine).getTelephone();
            countLine++;
        }

        // Créer le JTable
        JTable table = new JTable(data, column);
        table.setRowHeight(30);
        table.setSize(500,300);

        panel.add(table);
        frame.add(panel, BorderLayout.CENTER);

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
