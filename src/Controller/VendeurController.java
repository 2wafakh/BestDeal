/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import edu.esprit.dao.VendeurDAO;
import edu.esprit.entities.Vendeur;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Amouna
 */
public class VendeurController extends AbstractTableModel{
    
    List<Vendeur> maliste = new ArrayList<Vendeur>();
    String[] header = {"ID", "Nom", "Prénom"};

    public VendeurController() {
        maliste = new VendeurDAO().DisplayAllVendeur();
    }

    @Override
    public int getRowCount() {
        return maliste.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return maliste.get(rowIndex).getId_vend();
            case 1:
                return maliste.get(rowIndex).getNom();
            case 2:
                return maliste.get(rowIndex).getPrenom();
            
            
            default:
                throw new IllegalArgumentException();
        }


    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
