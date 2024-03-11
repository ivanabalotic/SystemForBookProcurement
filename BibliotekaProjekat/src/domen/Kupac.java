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
public class Kupac implements DomenskiObjekat {
    private long kupacID;
    private String imeKupca;
    private String prezimeKupca;
    private String adresa;
    private String brojTelefona;
    private String email;

    public Kupac() {
    }

    public Kupac(long kupaciD, String imeKupca, String prezimeKupca, String adresa, String brojTelefona, String email) {
        this.kupacID = kupaciD;
        this.imeKupca = imeKupca;
        this.prezimeKupca = prezimeKupca;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getKupacID() {
        return kupacID;
    }

    public void setKupacID(long kupacID) {
        this.kupacID = kupacID;
    }

    public String getImeKupca() {
        return imeKupca;
    }

    public void setImeKupca(String imeKupca) {
        this.imeKupca = imeKupca;
    }

    public String getPrezimeKupca() {
        return prezimeKupca;
    }

    public void setPrezimeKupca(String prezimeKupca) {
        this.prezimeKupca = prezimeKupca;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String toString() {
        return imeKupca + " " + prezimeKupca; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getTableName() {
        return "kupac";
    }

    @Override
    public boolean daLiAutoinkrement() {
        return true;
    }

    @Override
    public void setObjectId(long id) {
        kupacID = id;
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(ImeKupca, PrezimeKupca, Adresa, BrojTelefona, Email)";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        return "'" + imeKupca + "', '" + prezimeKupca + "', '" + adresa + "', '" + brojTelefona + "', '" + email + "' ";
    }

    @Override
    public String getIdName() {
        return "KupacID";
    }

    @Override
    public ArrayList<DomenskiObjekat> vratiListuPoRS(ResultSet rs) throws Exception {
        ArrayList<DomenskiObjekat> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                lista.add(new Kupac(rs.getInt("KupacID"), rs.getString("ImeKupca"), rs.getString("PrezimeKupca"), rs.getString("Adresa"), rs.getString("brojTelefona"), rs.getString("Email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE kupac SET ImeKupca = '" + imeKupca + "', PrezimeKupca = '" + prezimeKupca + "', Adresa = '" + adresa + "', BrojTelefona = '" + brojTelefona + "', Email = '" + email + "'";
    }

    @Override
    public String prepareQueryForSelect() {
        return "SELECT * FROM kupac";
    }

    @Override
    public long getId() {
        return kupacID;
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
        final Kupac other = (Kupac) obj;
        if (this.kupacID != other.kupacID) {
            return false;
        }
        if (!Objects.equals(this.imeKupca, other.imeKupca)) {
            return false;
        }
        if (!Objects.equals(this.prezimeKupca, other.prezimeKupca)) {
            return false;
        }
        if (!Objects.equals(this.adresa, other.adresa)) {
            return false;
        }
        if (!Objects.equals(this.brojTelefona, other.brojTelefona)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }




    

    
    
    
    
    
}
