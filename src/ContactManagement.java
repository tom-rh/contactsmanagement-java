import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ContactManagement {
    private ArrayList<Contact> contactList;

    public ContactManagement(){
        contactList = new ArrayList<Contact>();
    }

    public int getNumberOfContacts() {
        return contactList.size();
    }

    public void addContact(String prenom, String nom, int age, String telephone) {
        Contact contact = new Contact(prenom, nom, age, telephone);
        contactList.add(contact);
    }

    public void saveContacts() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("contacts.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int count = 0;
        while (contactList.size() > count) {
            out.write(String.valueOf(contactList.get(count).getId()) + ";");
            out.write(String.valueOf(contactList.get(count).getPrenom()) + ";");
            out.write(String.valueOf(contactList.get(count).getNom()) + ";");
            out.write(String.valueOf(contactList.get(count).getAge()) + ";");
            out.write(String.valueOf(contactList.get(count).getTelephone()));
            out.println();
            count++;
        }
        out.close();
    }

    public void displayContactListConsole() {
        int count = 0;
        System.out.println("id ; prenom ; nom ; age ; telephone");
        while (contactList.size() > count) {
            System.out.println(String.valueOf(contactList.get(count).getId()) + ";" + contactList.get(count).getPrenom() + ";" + contactList.get(count).getNom() + ";" + String.valueOf(contactList.get(count).getAge()) + ";" + contactList.get(count).getTelephone());
            count++;
        }
    }
}
