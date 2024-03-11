/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Kategorija;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iva
 */
public class ModelTabeleZanrovi extends AbstractTableModel{
    ArrayList<Kategorija> lista;
    private static ResourceBundle bundle_sr_RS;
//    String[] kolone = {"Redni broj", "Naziv zanra"};
    
    public ModelTabeleZanrovi(ResourceBundle bundle_sr_RS) {
        this.bundle_sr_RS = bundle_sr_RS;
        lista = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kategorija k = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return rowIndex+1;
            case 1: return bundle_sr_RS.getString(k.getZanr().getNazivZanra());
            
            default: return "?";
        }
    }

    @Override
    public String getColumnName(int column) {
//        return kolone[column];
        switch (column) {
            case 0: return bundle_sr_RS.getString("REDNI BROJ");
            case 1: return bundle_sr_RS.getString("NAZIV ZANRA");
            
            default: return "?";
        }

    }

    public void dodajZanr(Kategorija k) {
        lista.add(k);
        fireTableDataChanged();
    }

    public void obrisiZanr(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    public ArrayList<Kategorija> getLista() {
        return lista;
    }

    public void setBundle_sr_RS(ResourceBundle bundle_sr_RS) {
        ModelTabeleZanrovi.bundle_sr_RS = bundle_sr_RS;
        fireTableStructureChanged();
    }
    
    
    
}
