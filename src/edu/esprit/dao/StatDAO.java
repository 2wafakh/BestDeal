/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao;

import edu.esprit.entities.Avis;
import edu.esprit.entities.Statid;
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
public class StatDAO {
    
     public List<Statid> DisplayAll() {
      
        
      List<Statid> liste = new ArrayList<Statid>();
            
            
            String requete="select * from categorie";
            String requete1 = "SELECT count( vente.deal_ref ),categorie.nom FROM `vente` , `categorie` , `deal` WHERE `vente`.`deal_ref` = `deal`.`ref`AND `categorie`.`id` = `deal`.`categorie_id` and  categorie.id=?";
            
            try {
                PreparedStatement ps1 = null;
                 Statement statement = MyConnection.getInstance().createStatement();
                 ResultSet resultat = statement.executeQuery(requete);
                 ps1 = MyConnection.getInstance().prepareStatement(requete1);
                
                while (resultat.next()) {
                  Statid stat = new Statid(); 
                  ps1.setInt(1,resultat.getInt(1));
                  stat.setNom(resultat.getString(2));
                  ResultSet rs=  ps1.executeQuery();
               while (rs.next()) {
                 
                  stat.setId(rs.getInt(1));
                  
                  liste.add(stat);
                 
                }
                }
            
                
            } catch (SQLException ex) {
                //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erreur lors du chargement des deals" + ex.getMessage());
             
            }
        return liste;
        }
        
     public List<Avis> DisplayAllnote() {
      
        
      List<Avis> list = new ArrayList<Avis>();
            
            
            String requete="select * from deal";
            String requete1 = "select sum(avis.note),deal.nom from avis,deal where avis.deal_ref=deal.ref and deal.ref=? LIMIT 0,7";
            
            try {
                PreparedStatement ps1 = null;
                 Statement statement = MyConnection.getInstance().createStatement();
                 ResultSet resultat = statement.executeQuery(requete);
                 ps1 = MyConnection.getInstance().prepareStatement(requete1);
                
                while (resultat.next()) {
                  
                  ps1.setInt(1,resultat.getInt(1));
                 
                  ResultSet rs=  ps1.executeQuery();
               while (rs.next()) {
                 Avis avis =new Avis();
                  avis.setId(rs.getInt(1));
                  avis.setNom(rs.getString(2));
                  System.out.println(rs.getInt(1));
                  System.out.println(rs.getString(2));
                  list.add(avis);
                 
                }
                }
            
                
            } catch (SQLException ex) {
                //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erreur lors du chargement des deals" + ex.getMessage());
             
            }
        return list;
        }
        
    public static void main (String arg[]){
        StatDAO a= new StatDAO();
        a.DisplayAllnote();
    }
    
    
}
