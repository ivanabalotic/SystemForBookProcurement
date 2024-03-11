/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import interfejsi.DomenskiObjekat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Iva
 */
public class Kategorija implements DomenskiObjekat {
    private Knjiga knjiga;
    private Zanr zanr;

    public Kategorija() {
    }

    public Kategorija(Knjiga knjiga, Zanr zanr) {
        this.knjiga = knjiga;
        this.zanr = zanr;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String getTableName() {
        return "kategorija";
    }

    @Override
    public boolean daLiAutoinkrement() {
        return false;
    }

    @Override
    public void setObjectId(long aLong) {
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(KnjigaID, ZanrID)";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        return knjiga.getKnjigaID() + ", " + zanr.getZanrID();
    }

    @Override
    public String getIdName() {
        return "";
    }

    @Override
    public ArrayList<DomenskiObjekat> vratiListuPoRS(ResultSet rs) throws Exception {
        ArrayList<DomenskiObjekat> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                String pismoS = rs.getString("Pismo");
                Pismo pismo = Pismo.getPismo(pismoS);
                Knjiga k = new Knjiga(rs.getInt("KnjigaID"), rs.getString("NazivKnjige"), rs.getString("Izdavac"), rs.getInt("GodinaIzdavanja"), pismo, rs.getDouble("Cena"));
                
                Zanr z = new Zanr(rs.getInt("ZanrID"), rs.getString("NazivZanra"));
                
                lista.add(new Kategorija(k, z));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public String setQueryForUpdate() {
        //promeni zanr za odredjenu knjigu
        return "UPDATE kategorija SET ZanrID = " + zanr.getZanrID() + " WHERE KnjigaID = " + knjiga.getKnjigaID();
    }

    @Override
    public String prepareQueryForSelect() {
        return "SELECT * FROM kategorija kat JOIN knjiga k ON kat.KnjigaID = k.KnjigaID JOIN zanr z ON kat.ZanrID = z.ZanrID";
    }

    @Override
    public long getId() {
        return -1;
    }

   
    
    
    
}
