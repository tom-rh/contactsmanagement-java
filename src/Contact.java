public class Contact {
    private String _prenom;
    private String _nom;
    private int _age;
    private String _telephone;

    public Contact() {
        _prenom = "Inconnu";
        _nom = "Inconnu";
        _age = 0;
        _telephone = "";
    }

    public Contact(String prenom, String nom, int age, String telephone) {
        _prenom = prenom;
        _nom = nom;
        _age = age;
        _telephone = telephone;
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
}
