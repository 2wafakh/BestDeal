/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao;

import edu.esprit.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.esprit.entities.Categories;

/**
 *
 * @author Amouna
 */
public class CategoriesDAO {
    
    public void insertCategories(Categories d){

        String requete = "insert into categorie (nom) values (?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, d.getNom());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateCategories(Categories d){
        String requete = "update categorie set nom=? where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, d.getNom());
            ps.setInt(2, d.getId_categorie());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }

    public void deleteCategories(int id){
        String requete = "delete from categorie where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("categorie supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


   public Categories findcategoriesByid(int idcat){
    Categories cate = new Categories();
     String requete = "select * from categorie where id = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, idcat);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                cate.setId_categorie(resultat.getInt(1));
                cate.setNom(resultat.getString(2));
               
            }
            return cate;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du categorie "+ex.getMessage());
            return null;
        }
    }

    

    public List<Categories> DisplayAllCategories(){


        List<Categories> listecategorie = new ArrayList<Categories>();

        String requete = "select * from categorie";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Categories categorie =new Categories();
                categorie.setId_categorie(resultat.getInt(1));
                categorie.setNom(resultat.getString(2));

                listecategorie.add(categorie);
            }
            return listecategorie;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des categorie "+ex.getMessage());
            return null;
        }
    }
    
    public Categories findcatBynom(String nom){
    Categories cat = new Categories();
     String requete = "select * from categorie where nom= ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1,nom);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                cat.setId_categorie(resultat.getInt(1));
                System.out.println("testttttttt"+cat.getId_categorie());
               cat.setNom(resultat.getString(2));
                System.out.println(resultat.getString(2));
            }
            return cat;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }

}
