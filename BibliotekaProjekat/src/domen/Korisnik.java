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
public class Korisnik implements DomenskiObjekat {
    private long korisnikID;
    private String imeKorisnika;
    private String prezimeKorisnika;
    private String jmbg;
    private String username;
    private String password;

    public Korisnik() {
    }

    public Korisnik(long korisnikID, String imeKorisnika, String prezimeKorisnika, String jmbg, String username, String password) {
        this.korisnikID = korisnikID;
        this.imeKorisnika = imeKorisnika;
        this.prezimeKorisnika = prezimeKorisnika;
        this.jmbg = jmbg;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(long korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getImeKorisnika() {
        return imeKorisnika;
    }

    public void setImeKorisnika(String imeKorisnika) {
        this.imeKorisnika = imeKorisnika;
    }

    public String getPrezimeKorisnika() {
        return prezimeKorisnika;
    }

    public void setPrezimeKorisnika(String prezimeKorisnika) {
        this.prezimeKorisnika = prezimeKorisnika;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getTableName() {
        return "korisnik";
    }

    @Override
    public boolean daLiAutoinkrement() {
        return true;
    }

    @Override
    public void setObjectId(long id) {
        korisnikID = id;
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(ImeKorisnika, PrezimeKorisnika, JMBG, Username, Password)";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        return "'" + imeKorisnika + "', '" + prezimeKorisnika + "', '" + jmbg + "', '" + username + "', '" + password + "' ";
    }

    @Override
    public String getIdName() {
        return "KorisnikID";
    }

    @Override
    public ArrayList<DomenskiObjekat> vratiListuPoRS(ResultSet rs) throws Exception {
        ArrayList<DomenskiObjekat> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                lista.add(new Korisnik(rs.getInt("KorisnikID"), rs.getString("ImeKorisnika"), rs.getString("PrezimeKorisnika"), rs.getString("JMBG"), rs.getString("Username"), rs.getString("Password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE korisnik SET ImeKorisnika = '" + imeKorisnika + "', PrezimeKorisnika = '" + prezimeKorisnika + "', JMBG = '" + jmbg + "', Username = '" + username + "', Password = '" + password + "' WHERE KorisnikID = " + korisnikID;
    }

    @Override
    public String prepareQueryForSelect() {
        return "SELECT * FROM korisnik";
    }

    @Override
    public long getId() {
        return korisnikID;
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    @Override
    public String toString() {
        return imeKorisnika + " " + prezimeKorisnika; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    
}
