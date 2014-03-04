/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao;

import edu.esprit.entities.Vendeur;
import edu.esprit.entities.deal;
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
public class dealDAO {

    public void insertDeal(deal d) {
        String requete = "insert into deal(nom,quantite,datedebut,datefin,tauxred,description,vendeur_id,categorie_id) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, d.getNom());
            ps.setInt(2, d.getQauntite());
            ps.setString(3, d.getDatefin());
            ps.setString(4, d.getDatefin());
            ps.setString(6, d.getDescription());
            ps.setInt(5, d.getTauxred());
            ps.setInt(7, d.getVendeur_id().getId_vend());
            ps.setInt(8, d.getCategorie_id().getId_categorie());
            ps.executeUpdate();

            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }

    public void updateDeal(deal d) {
        String requete = "update deal set nom=?, quantite=?,datedebut=?,datefin=?,tauxred=?,description=?,vendeur_id=?,categorie_id =? where ref=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, d.getNom());
            ps.setInt(2, d.getQauntite());
            ps.setString(3, d.getDatedebut());
            ps.setString(4, d.getDatefin());
            ps.setInt(5, d.getTauxred());
            ps.setString(6, d.getDescription());
            ps.setInt(7, d.getVendeur_id().getId_vend());
            ps.setInt(8, d.getCategorie_id().getId_categorie());
            ps.setInt(9, d.getRef());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    public void deleteDeal(int ref) {
        String requete = "delete from deal where ref=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, ref);
            ps.executeUpdate();
            System.out.println("deal supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public deal finddealByref(int ref) {

        String requete = "select * from deal where ref=?";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();

            VendeurDAO vendeurDAO = new VendeurDAO();
            CategoriesDAO categorieDAO = new CategoriesDAO();

            deal deal = new deal();
            while (resultat.next()) {

                deal.setRef(resultat.getInt(1));
                deal.setNom(resultat.getString(2));
                deal.setQauntite(resultat.getInt(3));
                deal.setDatedebut(resultat.getString(4));
                deal.setDatefin(resultat.getString(5));
                deal.setTauxred(resultat.getInt(6));
                deal.setDescription(resultat.getString(7));

                deal.setVendeur_id(vendeurDAO.findVendeurByid(resultat.getInt(9)));
                deal.setCategorie_id(categorieDAO.findcategoriesByid(resultat.getInt(8)));
            }
            return deal;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
    }

    public List<deal> DisplayAlldeal() {


        List<deal> listedeal = new ArrayList<deal>();

        String requete = "select * from deal";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            VendeurDAO vendeur = new VendeurDAO();
            CategoriesDAO categorie = new CategoriesDAO();
            while (resultat.next()) {
                deal deal = new deal();
                deal.setRef(resultat.getInt(1));
                deal.setNom(resultat.getString(2));
                deal.setQauntite(resultat.getInt(3));
                deal.setDatedebut(resultat.getString(4));
                deal.setDatefin(resultat.getString(5));
                deal.setTauxred(resultat.getInt(6));
                deal.setDescription(resultat.getString(7));
                deal.setVendeur_id(vendeur.findVendeurByid(resultat.getInt(9)));
                deal.setCategorie_id(categorie.findcategoriesByid(resultat.getInt(8)));

                listedeal.add(deal);
            }
            return listedeal;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des deals" + ex.getMessage());
            return null;
        }
    }
}
