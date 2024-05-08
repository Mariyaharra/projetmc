
package Projet;
import Admin.GestionInfirmiers;
import java.awt.*;
import Admin.Infirmiers;
import Infirmier.Infirmier;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List; // Assurez-vous d'importer la classe List depuis le package java.util

public class Dbms_Basic {
    Connection con;
    private int idUser;
    public PreparedStatement ps;
    private ResultSet res,iduser,idservice,service,listeInfirmier,nom;
    private Statement s;
    private String update,query,idService;

    public Dbms_Basic() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("ok le serveur");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmiers", "root", "");
            System.out.println("ok la bdd");
            s = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



  
    public void insererInfirmier(Infirmiers i) throws SQLException {
        // Insertion de l'utilisateur
       String  updates = "INSERT INTO users (username, mdp, role) VALUES ('"+i.getEmail()+"','"+i.getDatenai()+"','+infirmier+')";
        query="select id from users where username='"+i.getEmail().toUpperCase()+"'"; 
        try {
            s.executeUpdate(updates);
            iduser=s.executeQuery(query);
	} catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
		}
        try {
            while ( iduser.next()) {
                idUser = iduser.getInt("id");
            }
	} catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
           // Vérifier que la date de naissance n'est pas null
        
            
       String sql = "INSERT INTO infirmier (iduser, nom, prenom, email, numTel, dateNaiss, grade, idservice) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Remplacement des paramètres par les valeurs correspondantes
            preparedStatement.setInt(1, idUser);
            preparedStatement.setString(2, i.getNom());
            preparedStatement.setString(3, i.getPrenom());
            preparedStatement.setString(4, i.getEmail());
            preparedStatement.setInt(5, i.getNumero());
            preparedStatement.setString(6, i.getDatenai());
            preparedStatement.setString(7, i.getGrade());
            preparedStatement.setInt(8, i.getIdservice());

            // Exécution de la requête
            preparedStatement.executeUpdate();
        
    


    
        }
   }

public int getIdService(String nomService) {
    int idService = -1; // Valeur par défaut si le service n'est pas trouvé

    try {
        // Utilisez PreparedStatement pour exécuter la requête avec des paramètres
        query = "SELECT id FROM service WHERE nom = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        
        // Définissez la valeur du paramètre
        preparedStatement.setString(1, nomService);
        
        // Exécutez la requête et récupérez le résultat
        ResultSet resultSet = preparedStatement.executeQuery();
        
        // Parcourez le résultat
        while (resultSet.next()) {
            idService = resultSet.getInt("id");
            return idService;
        }
    } catch (SQLException ex) {
        Logger.getLogger(Dbms_Basic.class.getName()).log(Level.SEVERE, null, ex);
    }
    return idService;
}
   

    /**
     *
     * @return
     */
    public List<String> fillCombo() {
    List<String> services = new ArrayList<>();
    query = "SELECT nom FROM service"; // Sélectionnez uniquement le nom du service
    try {  
        service = s.executeQuery(query);
        while (service.next()) {
            String serviceName = service.getString("nom");
            services.add(serviceName);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Dbms_Basic.class.getName()).log(Level.SEVERE, null, ex);
    }
    return services;
}
public List<Infirmiers> getInfirmiers() {
    List<Infirmiers> infirmiersList = new ArrayList<Infirmiers>();
   

    try {
        query = "SELECT * FROM infirmier";
        listeInfirmier = s.executeQuery(query);
        while (listeInfirmier.next()) {
            // Créer un objet Infirmiers à partir des données récupérées dans la base de données
            Infirmiers infirmier = new Infirmiers();
            infirmier.setId(listeInfirmier.getInt("id"));
            infirmier.setNom(listeInfirmier.getString("nom"));
            infirmier.setPrenom(listeInfirmier.getString("prenom"));
            infirmier.setNumero(Integer.parseInt(listeInfirmier.getString("numTel"))); // Numéro de téléphone en tant que chaîne
            infirmier.setDatenai(listeInfirmier.getString("dateNaiss"));
            infirmier.setGrade(listeInfirmier.getString("grade"));
            infirmier.setIdservice(listeInfirmier.getInt("idservice"));
            infirmier.setService(this.getService(infirmier.getIdservice()));
            // Ajouter l'infirmier à la liste
            infirmiersList.add(infirmier);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Dbms_Basic.class.getName()).log(Level.SEVERE, null, ex);
    }
   
    
    return infirmiersList;
}
public String getService(int idservice) throws SQLException{
    query = "SELECT nom FROM service where id="+idservice;
    try{   
        Statement ss = con.createStatement();
        nom = ss.executeQuery(query);
        while (nom.next()) {
            String serviceName = nom.getString("nom");
            return serviceName;
        }
        
       
    } catch (SQLException ex) {
        Logger.getLogger(Dbms_Basic.class.getName()).log(Level.SEVERE, null, ex);
    }
        return null;
    
        


}

}



    
        


   
   
