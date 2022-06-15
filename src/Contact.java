/*
 * Classe contact
 */
public class Contact {
    private static int count = 0;
    private final int _id;
    private String _prenom;
    private String _nom;
    private int _age;
    private String _telephone;

    // Construteur avec les informations spécifiées mais sans ID
    public Contact(String prenom, String nom, int age, String telephone) {
        _id = ++count;
        _prenom = prenom;
        _nom = nom;
        _age = age;
        _telephone = telephone;
    }

    // Construteur avec toutes les informations spécifiées
    public Contact(int id, String prenom, String nom, int age, String telephone) {
        _id = id;
        _prenom = prenom;
        _nom = nom;
        _age = age;
        _telephone = telephone;
    }

    public int getId() {
        return _id;
    }

    public String getPrenom() {
        return _prenom;
    }

    public String getNom() {
        return _nom;
    }

    public int getAge() {
        return _age;
    }

    public String getTelephone() {
        return _telephone;
    }

    public void setPrenom(String prenom) {
        _prenom = prenom;
    }

    public void setNom(String nom) {
        _nom = nom;
    }

    public void setAge(int age) {
        _age = age;
    }

    public void setTelephone(String telephone) {
        _telephone = telephone;
    }
}
