/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;
import edu.esprit.entities.Vendeur;
/**
 *
 * @author pc
 */
public class deal {
   private int ref;
    private String nom;
    private int qauntite;
    private String datedebut;
    private String datefin;
    private int tauxred;
    private String description;
    private Vendeur vendeur_id;
    private Categories Categorie_id;
    
  public Categories getCategorie_id() {
        return Categorie_id;
    }
   

    public void setCategorie_id(Categories Categorie_id) {
        this.Categorie_id = Categorie_id;
    }
   

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQauntite(int qauntite) {
        this.qauntite = qauntite;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public void setTauxred(int tauxred) {
        this.tauxred = tauxred;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVendeur_id(Vendeur vendeur_id) {
        this.vendeur_id = vendeur_id;
    }


    public int getRef() {
        return ref;
    }

    public String getNom() {
        return nom;
    }

    public int getQauntite() {
        return qauntite;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public int getTauxred() {
        return tauxred;
    }

    public String getDescription() {
        return description;
    }

    public Vendeur getVendeur_id() {
        return vendeur_id;
    }
}