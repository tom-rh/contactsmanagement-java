import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ContactManagement {
    private int _numberOfContacts;
    private ArrayList<Contact> contactList;

    public ContactManagement(){
        _numberOfContacts = 0;
        contactList = new ArrayList<Contact>();
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
        out.write("test");
        out.close();
    }
}
