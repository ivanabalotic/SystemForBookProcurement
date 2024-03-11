/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.StavkaNarudzbine;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iva
 */
public class ModelTabeleStavkiNar extends AbstractTableModel{
    ArrayList<StavkaNarudzbine> lista;
    ArrayList<StavkaNarudzbine> zaBrisanje;
    private static ResourceBundle bundle_sr_RS;
    
//    String[] kolone = {"Knjiga", "Cena knjige", "Kolicina", "Ukupan iznos"};
    
    public ModelTabeleStavkiNar(ResourceBundle bundle_sr_RS) {
        this.bundle_sr_RS = bundle_sr_RS;
        lista = new ArrayList<>();
        zaBrisanje = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaNarudzbine sn = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return sn.getKnjiga();
            case 1: return sn.getKnjiga().getCena();
            case 2: return sn.getKolicina();
            case 3: return sn.getUkupanIznosStavkeNarudzbine();
            
            default: return "?";
        }
    }

    @Override
    public String getColumnName(int column) {
//        return kolone[column];
//  kolone = {"Knjiga", "Cena knjige", "Kolicina", "Ukupan iznos"};
        switch (column) {
            case 0: return bundle_sr_RS.getString("KNJIGA");
            case 1: return bundle_sr_RS.getString("CENA KNJIGE");
            case 2: return bundle_sr_RS.getString("KOLICINA");
            case 3: return bundle_sr_RS.getString("UKUPAN IZNOS");
            
            default: return "?";
        }
    }

    public void setLista(ArrayList<StavkaNarudzbine> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public void dodaj(StavkaNarudzbine sn) {
        boolean dodato = false;
        for (StavkaNarudzbine stavkaNarudzbine : lista) {
            if (stavkaNarudzbine.getKnjiga().equals(sn.getKnjiga())) {
                stavkaNarudzbine.setIzmene("izmeni");
                stavkaNarudzbine.setKolicina(stavkaNarudzbine.getKolicina() + 1);
                stavkaNarudzbine.setUkupanIznosStavkeNarudzbine(stavkaNarudzbine.getKnjiga().getCena() * stavkaNarudzbine.getKolicina());
                dodato = true;
            }
        }
        
        if (!dodato) {
            sn.setIzmene("dodaj");
            lista.add(sn);
        }
            
        fireTableDataChanged();
    }
    
    public void postavi(StavkaNarudzbine sn) {
        boolean dodato = false;
        for (StavkaNarudzbine stavkaNarudzbine : lista) {
            if (stavkaNarudzbine.getKnjiga().equals(sn.getKnjiga())) {
                stavkaNarudzbine.setKolicina(stavkaNarudzbine.getKolicina() + 1);
                stavkaNarudzbine.setUkupanIznosStavkeNarudzbine(stavkaNarudzbine.getKnjiga().getCena() * stavkaNarudzbine.getKolicina());
                dodato = true;
            }
        }
        
        if (!dodato) {
            lista.add(sn);
        }
            
        fireTableDataChanged();
    }
    

    public void obrisiStavku(int red) {
        lista.get(red).setIzmene("obrisi");
        zaBrisanje.add(lista.get(red));
        lista.remove(red);
        fireTableDataChanged();
    }

    public StavkaNarudzbine vratiStavku(int red) {
        return lista.get(red);
    }

    public ArrayList<StavkaNarudzbine> getLista() {
        return lista;
    }

    public void smanjiKolicinuStavke(int red) {
        if (lista.get(red).getKolicina() - 1 == 0) {
            lista.get(red).setIzmene("obrisi");
            zaBrisanje.add(lista.get(red));
            lista.remove(red);
        } else {
            lista.get(red).setKolicina(lista.get(red).getKolicina() - 1);
            lista.get(red).setIzmene("izmeni");
            lista.get(red).setUkupanIznosStavkeNarudzbine(lista.get(red).getKnjiga().getCena() * lista.get(red).getKolicina());
        }

        fireTableDataChanged();
    }

    public ArrayList<StavkaNarudzbine> getZaBrisanje() {
        return zaBrisanje;
    }

    public void setBundle_sr_RS(ResourceBundle bundle_sr_RS) {
        ModelTabeleStavkiNar.bundle_sr_RS = bundle_sr_RS;
        fireTableStructureChanged();
    }

    
  
    
    
    
}
