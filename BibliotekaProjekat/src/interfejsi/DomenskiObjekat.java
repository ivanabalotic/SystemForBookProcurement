/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfejsi;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Iva
 */
public interface DomenskiObjekat extends Serializable {
    public long getId();
    
    public String getTableName();

    public boolean daLiAutoinkrement();

    public void setObjectId(long id);

    public String vratiAtributeZaInsert();

    public String vratiVrednostiAtributaZaInsert();

    public String getIdName();

    public ArrayList<DomenskiObjekat> vratiListuPoRS(ResultSet rs)throws Exception;

    public String setQueryForUpdate();

    public String prepareQueryForSelect();
}
