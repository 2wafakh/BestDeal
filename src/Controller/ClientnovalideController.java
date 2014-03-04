/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import edu.esprit.dao.ClientDAO;
import edu.esprit.entities.Client;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Amouna
 */
public class ClientnovalideController extends AbstractTableModel {
    
       String[] headers={"Id","Nom","Prenom","E-mail","Adresse","N°Télèphone"};
     List<Client> listClient=new ArrayList<Client>();

    public ClientnovalideController() {
        ClientDAO cliDao=new ClientDAO();
        listClient=cliDao.DisplayAllClientsNoValid();
        
    }


    public int getRowCount() {

    return listClient.size();

    }

    public int getColumnCount() {

        return headers.length;

    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
             case 0:
                return listClient.get(rowIndex).getRefClt();
            case 1:
                return listClient.get(rowIndex).getNom();
            
            case 2:
                return listClient.get(rowIndex).getPrenom();
            case 3:
                return listClient.get(rowIndex).getEmail();
            case 4:
                return listClient.get(rowIndex).getAdresse();
            case 5:
                return listClient.get(rowIndex).getTel();
            
                    default:
                        return null;

        }


    }
    
    

    public String getColumnName(int column) {
        return headers[column];
    }
}
