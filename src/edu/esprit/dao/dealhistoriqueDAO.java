/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao;
import edu.esprit.entities.dealhistorique;
import edu.esprit.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author pc
 */
public class dealhistoriqueDAO {
  public void insertDealhis(dealhistorique d){
  String requete="insert into deal(id_ref,date) values (?,?)";
  try {
  PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
   ps.setString(1,d.getDate());
   ps.setInt(2,d.getId_ref());
  
  ps.executeUpdate();
  
  System.out.println("Ajout effectuée avec succès");
   } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
  System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }   
}
