/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Narudzbina;
import interfejsi.DomenskiObjekat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iva
 */
public class ModelTabeleNarudzbina extends AbstractTableModel{
    ArrayList<DomenskiObjekat> lista;
    private static ResourceBundle bundle_sr_RS;
//    String[] kolone = {"Kupac", "Korisnik", "Datum izdavanja", "Ukupan iznos", "Status"};
    
    public ModelTabeleNarudzbina(ResourceBundle bundle_sr_RS) {
        this.bundle_sr_RS = bundle_sr_RS;
        lista = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Narudzbina n = (Narudzbina) lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        
        switch (columnIndex) {
            case 0: return n.getKupac();
            case 1: return n.getKorisnik();
            case 2: return sdf.format(n.getDatumIzdavanja());
            case 3: return n.getUkupanIznos();
            case 4: return bundle_sr_RS.getString(n.getStatus());
            
            default: return "?";
        }
    }

    @Override
    public String getColumnName(int column) {
//        return kolone[column];
        switch (column) {
            case 0: return bundle_sr_RS.getString("KUPAC");
            case 1: return bundle_sr_RS.getString("KORISNIK");
            case 2: return bundle_sr_RS.getString("DATUM IZDAVANJA");
            case 3: return bundle_sr_RS.getString("UKUPAN IZNOS");
            case 4: return "Status";
            
            default: return "?";
        }
    }
    
    public Narudzbina vratiNaruzbinu(int red){
        return (Narudzbina) lista.get(red);
    }
    
    public void pretrazi(String s) {
        ArrayList<DomenskiObjekat> novaLista = new ArrayList<>();
        for (DomenskiObjekat n : lista) {
            Narudzbina narudzbina = (Narudzbina) n;
            if(narudzbina.getKorisnik().toString().toUpperCase().contains(s.toUpperCase())){
                novaLista.add(narudzbina);
            }
            if(narudzbina.getKupac().toString().toUpperCase().contains(s.toUpperCase())){
                novaLista.add(narudzbina);
            }
        }
        lista = novaLista;
        fireTableDataChanged();
    }

    public void setLista(ArrayList<DomenskiObjekat> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public void setBundle_sr_RS(ResourceBundle bundle_sr_RS) {
        ModelTabeleNarudzbina.bundle_sr_RS = bundle_sr_RS;
        fireTableStructureChanged();
    }
    
    
    
    
}
