/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import edu.esprit.dao.dealDAO;
import edu.esprit.entities.deal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.xml.bind.annotation.XmlElement.DEFAULT;

/**
 *
 * @author pc
 */
public class DealController extends AbstractTableModel {

    List<deal> maliste = new ArrayList<deal>();
    String[] header = {"ref", "nom", "quantite", "datedebut", "datefin", "tauxred", "decription","Nom Vendeur", "Prénom Vendeur", "categorie"};

    public DealController() {
        maliste = new dealDAO().DisplayAlldeal();
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
                return maliste.get(rowIndex).getRef();
            case 1:
                return maliste.get(rowIndex).getNom();
            case 2:
                return maliste.get(rowIndex).getQauntite();
            case 3:
                return maliste.get(rowIndex).getDatedebut();
            case 4:
                return maliste.get(rowIndex).getDatefin();
            case 5:
                return maliste.get(rowIndex).getTauxred();
            case 6:
                return maliste.get(rowIndex).getDescription();

            
            case 7:

                return maliste.get(rowIndex).getVendeur_id().getNom();
            case 8:

                return maliste.get(rowIndex).getVendeur_id().getPrenom();
            case 9:

                return maliste.get(rowIndex).getCategorie_id().getNom();
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
