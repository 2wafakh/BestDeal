/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.entities;

/**
 *
 * @author Lenovo
 */
public class Client {
    
    private int refClt;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private String Email;
    private int Valid;
    private int tel;

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
    public int getRefClt() {
        return refClt;
    }
    
    public void setRefClt(int refClt) {
        this.refClt=refClt;
    }
    
    public String getNom() {
        return Nom;
    }
    public void setNom(String Nom) {
        this.Nom=Nom;
    }
     public String getPrenom() {
        return Prenom;
    }
    public void setPrenom(String Prenom) {
        this.Prenom=Prenom;
    }
     public String getAdresse() {
        return Adresse;
    }
    public void setAdresse(String Adresse) {
        this.Adresse=Adresse;
    }
     public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email=Email;
    }
    
     public int getValid() {
        return Valid;
    }
    public void setValid(int Valid) {
        this.Valid=Valid;
    }
}
