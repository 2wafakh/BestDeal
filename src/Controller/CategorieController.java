/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.List;
import edu.esprit.dao.CategoriesDAO;
import edu.esprit.entities.Categories;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Amouna
 */
public class CategorieController extends  AbstractTableModel   {
    
    
     String[] headers={"Id","Nom"};
     List<Categories> listCategorie=new ArrayList<Categories>();

    public CategorieController() {
        CategoriesDAO categDao=new CategoriesDAO();
        listCategorie=categDao.DisplayAllCategories();
        
    }


    public int getRowCount() {

    return listCategorie.size();

    }

    public int getColumnCount() {

        return headers.length;

    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
             case 0:
                return listCategorie.get(rowIndex).getId_categorie();
            case 1:
                return listCategorie.get(rowIndex).getNom();
            
                    default:
                        return null;

        }


    }
    
    

    public String getColumnName(int column) {
        return headers[column];
    }

    
    
}
