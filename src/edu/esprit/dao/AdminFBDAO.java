/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao;

import edu.esprit.entities.AdminFB;
import edu.esprit.entities.Administrateur;
import edu.esprit.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amouna
 */
public class AdminFBDAO {
    public AdminFB findadminByid(String idfb){
    AdminFB admin = new AdminFB();
     String requete = "select * from fb where idpseudo = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, idfb);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                admin.setId(resultat.getInt(1));
                admin.setFbpseudo(resultat.getString(2));
                admin.setEmail(resultat.getString(3));
                
            }
            return admin;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
        
    }
    
    public List<AdminFB> DisplayAlladmin (){


        List<AdminFB> listeadmin = new ArrayList<AdminFB>();

        String requete = "select * from fb";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                AdminFB admin =new AdminFB();
                admin.setId(resultat.getInt(1));
                admin.setFbpseudo(resultat.getString(2));
                admin.setEmail(resultat.getString(3));

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
