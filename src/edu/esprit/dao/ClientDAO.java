/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.esprit.entities.Client;
import edu.esprit.util.MyConnection;

/**
 *
 * @author Lenovo
 */
public class ClientDAO {
   
   public boolean ValiderClient(int id){
        String requete = "update client set valid=1 where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Client valider avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la validation "+ex.getMessage());
        }
        return false;
    }
   
    public void InsertClient(Client c){

        String requete = "insert into client (Nom,Prenom,Adresse,Email) values (?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setString(3, c.getAdresse());
            ps.setString(4, c.getEmail());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void UpdateClient(Client c){
        String requete = "update client set Nom=?, Prenom=?,Adresse=?,Email=? where ref_clt=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setString(3, c.getAdresse());
            ps.setString(4, c.getEmail());
            ps.setInt(5, c.getRefClt());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }

    public void DeleteClient(int id){
        String requete = "delete from client where ref_clt=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Client supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    
    public List<Client> DisplayAllClientsNoValid (){


        List<Client> listeClients =new ArrayList<Client>();

        String requete = "select * from client where valid=0";
        try {
           Statement statement = MyConnection.getInstance().createStatement();
           ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Client client =new Client();
                client.setRefClt(resultat.getInt(1));
                client.setNom(resultat.getString(2));
                client.setPrenom(resultat.getString(3));
                client.setAdresse(resultat.getString(4));
                client.setEmail(resultat.getString(5));
                client.setTel(resultat.getInt(6));
                listeClients.add(client);
            }
            return listeClients;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des clients "+ex.getMessage());
            return null;
        }
    }
    
        public List<Client> DisplayAllClientsValid (){


        List<Client> listeClients =new ArrayList<Client>();

        String requete = "select * from client where valid=1";
        try {
           Statement statement = MyConnection.getInstance().createStatement();
           ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Client client =new Client();
                client.setRefClt(resultat.getInt(1));
                client.setNom(resultat.getString(2));
                client.setPrenom(resultat.getString(3));
                client.setAdresse(resultat.getString(4));
                client.setEmail(resultat.getString(5));
                client.setTel(resultat.getInt(6));

                listeClients.add(client);
            }
            return listeClients;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des clients "+ex.getMessage());
            return null;
        }
    }

}
