/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author pc
 */
public class dealcourant extends deal{
     private String date ;
       private int id_ref ; 

    public void setDate(String date) {
        this.date = date;
    }

    public void setId_ref(int id_ref) {
        this.id_ref = id_ref;
    }

    public String getDate() {
        return date;
    }

    public int getId_ref() {
        return id_ref;
    }
    
}
