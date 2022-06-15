import java.io.*;
import java.util.ArrayList;

public class ContactManagement {
    private final ArrayList<Contact> _contactList;

    public ContactManagement(){
        _contactList = new ArrayList<>();
        // Lecture des lignes du fichier de sauvegarde pour initialiser la liste de contacts si le fichier existe sinon création du fichier
        File file = new File("contacts.txt");
        if(file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                for (String line; (line = br.readLine()) != null; ) {
                    String[] parts = line.split(";");
                    this.addContact(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                new PrintWriter(new FileWriter(file));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getNumberOfContacts() {
        return _contactList.size();
    }

    public ArrayList<Contact> getContactList() {
        return _contactList;
    }

    public void addContact( String prenom, String nom, int age, String telephone) {
        Contact contact = new Contact(prenom, nom, age, telephone);
        _contactList.add(contact);
    }
    public void addContact(int id, String prenom, String nom, int age, String telephone) {
        Contact contact = new Contact(id, prenom, nom, age, telephone);
        _contactList.add(contact);
    }

    public void editContact(int id, String choice, String input) {
        int countLine = 0;
        while (_contactList.size() > countLine) {
            if (id == _contactList.get(countLine).getId()) {
                switch (choice) {
                    case "Prénom" -> _contactList.get(countLine).setPrenom(input);
                    case "Nom" -> _contactList.get(countLine).setNom(input);
                    case "Age" -> _contactList.get(countLine).setAge(Integer.parseInt(input));
                    case "Téléphone" -> _contactList.get(countLine).setTelephone(input);
                    default -> System.out.println("Choix incorrect");
                }
            }
            countLine++;
        }
    }

    public void saveContacts() {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter("contacts.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int count = 0;
        while (_contactList.size() > count) {
            out.write(_contactList.get(count).getId() + ";");
            out.write(_contactList.get(count).getPrenom() + ";");
            out.write(_contactList.get(count).getNom() + ";");
            out.write(_contactList.get(count).getAge() + ";");
            out.write(_contactList.get(count).getTelephone());
            out.println();
            count++;
        }
        out.close();
    }

    public void displayContactListConsole() {
        int count = 0;
        System.out.println("id ; prenom ; nom ; age ; telephone");
        while (_contactList.size() > count) {
            System.out.println(_contactList.get(count).getId() + ";" + _contactList.get(count).getPrenom() + ";" + _contactList.get(count).getNom() + ";" + _contactList.get(count).getAge() + ";" + _contactList.get(count).getTelephone());
            count++;
        }
    }
}
