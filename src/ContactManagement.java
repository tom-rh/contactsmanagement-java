import java.util.Vector;

public class ContactManagement {
    // tableau de contacts
    private Vector<Contact> contactList;
    private int _numberOfContacts;

    public ContactManagement(){
        _numberOfContacts = 0;
    }

    public void addContact(String prenom, String nom, int age, String telephone) {
        Contact contact = new Contact(prenom, nom, age, telephone);
        contactList.add(contact);
    }
}
