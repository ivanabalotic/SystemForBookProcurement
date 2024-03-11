/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import interfejsi.DomenskiObjekat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Iva
 */
public class Knjiga implements DomenskiObjekat {
    private long knjigaID;
    private String nazivKnjige;
    private String izdavac;
    private int godinaIzdavanja;
    private Pismo pismo; 
    private double cena;
    private ArrayList<Napisao> listaAutora;
    private ArrayList<Kategorija> listaZanrova;

    public Knjiga() {
    }

    public Knjiga(long knjigaID, String nazivKnjige, String izdavac, int godinaIzdavanja, Pismo pismo, double cena) {
        this.knjigaID = knjigaID;
        this.nazivKnjige = nazivKnjige;
        this.izdavac = izdavac;
        this.godinaIzdavanja = godinaIzdavanja;
        this.pismo = pismo;
        this.cena = cena;
    }

    public Knjiga(long knjigaID, String nazivKnjige, String izdavac, int godinaIzdavanja, Pismo pismo, double cena, ArrayList<Napisao> listaAutora, ArrayList<Kategorija> listaZanrova) {
        this.knjigaID = knjigaID;
        this.nazivKnjige = nazivKnjige;
        this.izdavac = izdavac;
        this.godinaIzdavanja = godinaIzdavanja;
        this.pismo = pismo;
        this.cena = cena;
        this.listaAutora = listaAutora;
        this.listaZanrova = listaZanrova;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public long getKnjigaID() {
        return knjigaID;
    }

    public void setKnjigaID(long knjigaID) {
        this.knjigaID = knjigaID;
    }

    public String getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(String izdavac) {
        this.izdavac = izdavac;
    }

    public int getGodinaIzdavanja() {
        return godinaIzdavanja;
    }

    public void setGodinaIzdavanja(int godinaIzdavanja) {
        this.godinaIzdavanja = godinaIzdavanja;
    }

    public Pismo getPismo() {
        return pismo;
    }

    public void setPismo(Pismo pismo) {
        this.pismo = pismo;
    }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    @Override
    public String getTableName() {
        return "knjiga";
    }

    @Override
    public boolean daLiAutoinkrement() {
        return true;
    }

    @Override
    public void setObjectId(long id) {
        knjigaID = id;
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(NazivKnjige, Izdavac, GodinaIzdavanja, Pismo, Cena)";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        return "'" + nazivKnjige + "', '" + izdavac + "', " + godinaIzdavanja + ", '" + pismo.toString() + "', " + cena; 
    }

    @Override
    public String getIdName() {
        return "KnjigaID";
    }

    @Override
    public ArrayList<DomenskiObjekat> vratiListuPoRS(ResultSet rs) throws Exception {
        ArrayList<DomenskiObjekat> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                String pismoS = rs.getString("Pismo");
                Pismo pis = Pismo.getPismo(pismoS);
                lista.add(new Knjiga(rs.getInt("KnjigaID"), rs.getString("NazivKnjige"), rs.getString("Izdavac"), rs.getInt("GodinaIzdavanja"), pis, rs.getDouble("Cena")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE knjiga SET NazivKnjige = '" + nazivKnjige + "', Izdavac = '" + izdavac + "', GodinaIzdavanja = " + godinaIzdavanja + ", Pismo = '" + pismo + "', Cena = " + cena + " WHERE KnjigaID = " + knjigaID;
    }
    
    @Override
    public String prepareQueryForSelect() {
        return "SELECT * FROM knjiga";
    }

    @Override
    public long getId() {
        return knjigaID;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Knjiga other = (Knjiga) obj;
        if (this.godinaIzdavanja != other.godinaIzdavanja) {
            return false;
        }
        if (!Objects.equals(this.nazivKnjige, other.nazivKnjige)) {
            return false;
        }
        return Objects.equals(this.izdavac, other.izdavac);
    }

    @Override
    public String toString() {
        return nazivKnjige; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public ArrayList<Napisao> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(ArrayList<Napisao> listaAutora) {
        this.listaAutora = listaAutora;
    }

    public ArrayList<Kategorija> getListaZanrova() {
        return listaZanrova;
    }

    public void setListaZanrova(ArrayList<Kategorija> listaZanrova) {
        this.listaZanrova = listaZanrova;
    }

    
    
    
}
