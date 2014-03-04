/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao;

import edu.esprit.entities.Categories;
import edu.esprit.entities.Vendeur;
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
public class VendeurDAO {
   
     public Vendeur findvendeurBynom(String nom){
    Vendeur vend = new Vendeur();
     String requete = "select * from vendeur where nom = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1,nom);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                vend. setId_vend(resultat.getInt(1));
                System.out.println("testttttttt"+vend.getId_vend());
                vend.setNom(resultat.getString(2));
                System.out.println(resultat.getString(2));
            }
            return vend;

        } catch (SQLException ex) {
           
            System.out.println("erreur lors de la recherche du Vendeur"+ex.getMessage());
            return null;
        }
     }
    public void insertVendeur(Vendeur d){

        String requete = "insert into vendeur (nom,prenom) values (?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, d.getNom());
            ps.setString(2, d.getPrenom());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateVendeur(Vendeur d){
        String requete = "update vendeur set nom=?,prenom=? where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, d.getNom());
            ps.setString(2, d.getPrenom());
            ps.setInt(3, d.getId_vend());
            ps.executeUpdate();
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    public Vendeur findVendeurByid(int idvendeur){
    Vendeur vendeur = new Vendeur();
     String requete = "select * from vendeur where id = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, idvendeur);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                vendeur.setId_vend(resultat.getInt(1));
                vendeur.setNom(resultat.getString(2));
                vendeur.setPrenom(resultat.getString(3));
                
            }
            return vendeur;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
    public List<Vendeur> DisplayAllVendeur(){


        List<Vendeur> listevendeur = new ArrayList<Vendeur>();

        String requete = "select * from vendeur";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Vendeur vendeur =new Vendeur();
              vendeur.setId_vend(resultat.getInt(1));
              vendeur.setNom(resultat.getString(2));
              vendeur.setPrenom(resultat.getString(3));
                listevendeur.add(vendeur);
            }
            return listevendeur;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des categorie "+ex.getMessage());
            return null;
        }
    }

}
