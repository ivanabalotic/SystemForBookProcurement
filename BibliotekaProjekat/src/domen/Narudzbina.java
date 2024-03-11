/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import interfejsi.DomenskiObjekat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Iva
 */
public class Narudzbina implements DomenskiObjekat {
    private long narudzbinaID;
    private Date datumIzdavanja;
    private Double ukupanIznos;
    private Korisnik korisnik;
    private Kupac kupac;
    private ArrayList<StavkaNarudzbine> stavke;
    private String status;
    private String izmene;

    public Narudzbina() {
    }

    public Narudzbina(long narudzbinaID, Date datumIzdavanja, Double ukupanIznos, Korisnik korisnik, Kupac kupac, String status) {
        this.narudzbinaID = narudzbinaID;
        this.datumIzdavanja = datumIzdavanja;
        this.ukupanIznos = ukupanIznos;
        this.korisnik = korisnik;
        this.kupac = kupac;
        this.status = status;
        this.izmene = "";
    }
    
    public Narudzbina(long narudzbinaID, Date datumIzdavanja, Double ukupanIznos, Korisnik korisnik, Kupac kupac, ArrayList<StavkaNarudzbine> stavke, String status) {
        this.narudzbinaID = narudzbinaID;
        this.datumIzdavanja = datumIzdavanja;
        this.ukupanIznos = ukupanIznos;
        this.korisnik = korisnik;
        this.kupac = kupac;
        this.stavke = stavke;
        this.status = status;
        this.izmene = "";
    }

    public Double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(Double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public long getNarudzbinaID() {
        return narudzbinaID;
    }

    public void setNarudzbinaID(long narudzbinaID) {
        this.narudzbinaID = narudzbinaID;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    @Override
    public String getTableName() {
        return "Narudzbina";
    }

    @Override
    public boolean daLiAutoinkrement() {
        return true;
    }

    @Override
    public void setObjectId(long id) {
        narudzbinaID = id;
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(DatumIzdavanja, UkupanIznos, KorisnikID, KupacID, Status)";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        return "'" + new java.sql.Date(datumIzdavanja.getTime()).toString() + "' , " + ukupanIznos + ", " + korisnik.getKorisnikID() + ", " + kupac.getKupacID() + ", '" + status + "' ";
    }

    @Override
    public String getIdName() {
        return "NarudzbinaID";
    }

    @Override
    public ArrayList<DomenskiObjekat> vratiListuPoRS(ResultSet rs) throws Exception {
        ArrayList<DomenskiObjekat> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                Kupac kup = new Kupac(rs.getInt("KupacID"), rs.getString("ImeKupca"), rs.getString("PrezimeKupca"), rs.getString("Adresa"), rs.getString("brojTelefona"), rs.getString("Email"));
                Korisnik kor = new Korisnik(rs.getInt("KorisnikID"), rs.getString("ImeKorisnika"), rs.getString("PrezimeKorisnika"), rs.getString("JMBG"), rs.getString("Username"), rs.getString("Password"));
                lista.add(new Narudzbina(rs.getInt("NarudzbinaID"), rs.getDate("DatumIzdavanja"), rs.getDouble("UkupanIznos"), kor, kup, new ArrayList<>(), rs.getString("Status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE narudzbina SET DatumIzdavanja = '" + new java.sql.Date(datumIzdavanja.getTime()).toString() + "' , UkupanIznos = " + ukupanIznos + ", KorisnikID = " + korisnik.getKorisnikID() + ", KupacID = " + kupac.getKupacID() + ", Status = '" + status + "' WHERE NarudzbinaID = " + narudzbinaID;
    }

    @Override
    public String prepareQueryForSelect() {
        return "SELECT * FROM narudzbina n JOIN korisnik kor ON n.KorisnikID = kor.KorisnikID JOIN kupac kup ON kup.KupacID = n.KupacID";
    }

    public ArrayList<StavkaNarudzbine> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<StavkaNarudzbine> stavke) {
        this.stavke = stavke;
    }

    @Override
    public long getId() {
        return narudzbinaID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIzmene() {
        return izmene;
    }

    public void setIzmene(String izmene) {
        this.izmene = izmene;
    }

    
    
    
}
