
package Admin;

public class Infirmiers {
    public int id,iduser,numero,idservice;
    private String nom ,prenom,email,dateNaissance,grade,service;
    private String s;

    public Infirmiers(int id,int idservice, int numero, String nom, String prenom, String email, String dateNaissance, String grade) {
        this.setId(id);
        this.setIdservice(idservice);
        this.setNumero(numero);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setEmail(email);
        this.setDatenai(dateNaissance);
        this.setGrade(grade);
    
    }

    public Infirmiers(int idservice,String nom, String prenom, String email, String dateNaissance,int numero, String grade) {
        this.setIdservice(idservice);
        this.setNumero(numero);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setEmail(email);
        this.setDatenai(dateNaissance);
        this.setGrade(grade);
    }
    public Infirmiers() {
        erreur("Tout les champs doivent être renseigner !");
    }
    
    private void erreur(String s) {
	this.setS(s);
    }
    
    public String getS() {
	return s;
    }
    public void setS(String s) {
	this.s = s;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.id = iduser;
    }
       public int getIdservice() {
        return idservice;
    }

    public void setIdservice(int idservice) {
        this.idservice = idservice;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatenai() {
        return dateNaissance;
    }

    public void setDatenai(String dateNaissance) {
        this.dateNaissance = dateNaissance;

    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
    
    
    
    
}
