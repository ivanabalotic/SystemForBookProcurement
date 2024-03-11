/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iva
 */
public class ModelTabeleAktivnihKor extends AbstractTableModel {

    ArrayList<String> lista;
    private static ResourceBundle bundle_sr_RS;

    public ModelTabeleAktivnihKor(ResourceBundle bundle_sr_RS) {
        this.bundle_sr_RS = bundle_sr_RS;
        lista = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return lista.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return bundle_sr_RS.getString("AKTIVNI KORISNICI"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public void setLista(ArrayList<String> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public void setBundle_sr_RS(ResourceBundle bundle_sr_RS) {
        ModelTabeleAktivnihKor.bundle_sr_RS = bundle_sr_RS;
        fireTableStructureChanged();
    }
    
    
    
}
