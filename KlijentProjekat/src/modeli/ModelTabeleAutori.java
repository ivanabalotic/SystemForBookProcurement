/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Napisao;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iva
 */
public class ModelTabeleAutori extends AbstractTableModel{
    private static ResourceBundle bundle_sr_RS;
    ArrayList<Napisao> lista;
    // String[] kolone = {"Redni broj", "Ime autora", "Prezime autora"};
    
    public ModelTabeleAutori(ResourceBundle bundle_sr_RS) {
        this.bundle_sr_RS = bundle_sr_RS;
        lista = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Napisao n = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return rowIndex+1;
            case 1: return n.getAutor().getImeAutora();
            case 2: return n.getAutor().getPrezimeAutora();
            
            default: return "?";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return bundle_sr_RS.getString("REDNI BROJ");
            case 1: return bundle_sr_RS.getString("IME AUTORA");
            case 2: return bundle_sr_RS.getString("PREZIME AUTORA");
            
            default: return "?";
        }
    }

    public void dodajAutora(Napisao n) {
        lista.add(n);
        fireTableDataChanged();
    }

    public void obrisiAutora(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    public ArrayList<Napisao> getLista() {
        return lista;
    }

    public void setBundle_sr_RS(ResourceBundle bundle_sr_RS) {
        ModelTabeleAutori.bundle_sr_RS = bundle_sr_RS;
        fireTableStructureChanged();
    }
    
    
}
