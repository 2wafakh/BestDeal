package edu.esprit.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import edu.esprit.entities.Administrateur;
import edu.esprit.util.MyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amouna
 */
public class AdministrateurDao {

     public List<Administrateur> DisplayAlladmin (){


        List<Administrateur> listeadmin = new ArrayList<Administrateur>();

        String requete = "select * from administrateur";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Administrateur admin =new Administrateur();
                admin.setId_admin(resultat.getInt(1));
                admin.setLogin(resultat.getString(2));
                admin.setPasse(resultat.getString(3));

                listeadmin.add(admin);
            }
            return listeadmin;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des admin "+ex.getMessage());
            return null;
        }
    }
    
    
    
}
