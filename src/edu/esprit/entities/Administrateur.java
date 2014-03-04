/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author Amouna
 */
public class Administrateur {

    private int id_admin;
    private String login ;
    private String passe ;

    public int getId_admin() {
        return id_admin;
    }

    public String getLogin() {
        return login;
    }

    public String getPasse() {
        return passe;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasse(String passe) {
        this.passe = passe;
    }
    
    
    
    
    
}
