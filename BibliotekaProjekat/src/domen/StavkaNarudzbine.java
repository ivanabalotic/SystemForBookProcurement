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
public class StavkaNarudzbine implements DomenskiObjekat {
    private Narudzbina narudzbina;
    private long stavkaNarudzbineID;
    private double ukupanIznosStavkeNarudzbine;
    private Knjiga knjiga;
    private int kolicina;
    private String izmene;
    private double cena;
    private String jedinicaMere;

    public StavkaNarudzbine() {
    }

    public StavkaNarudzbine(Narudzbina narudzbina, long stavkaNarudzbineID, double ukupanIznosStavkeNarudzbine, Knjiga knjiga, int kolicina, double cena, String jedinicaMere) {
        this.narudzbina = narudzbina;
        this.stavkaNarudzbineID = stavkaNarudzbineID;
        this.ukupanIznosStavkeNarudzbine = ukupanIznosStavkeNarudzbine;
        this.knjiga = knjiga;
        this.kolicina = kolicina;
        izmene = "";
        this.cena = cena;
        this.jedinicaMere = jedinicaMere;
    }
    
    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Narudzbina getNarudzbina() {
        return narudzbina;
    }

    public void setNarudzbina(Narudzbina narudzbina) {
        this.narudzbina = narudzbina;
    }

    public long getStavkaNarudzbineID() {
        return stavkaNarudzbineID;
    }

    public void setStavkaNarudzbineID(long stavkaNarudzbineID) {
        this.stavkaNarudzbineID = stavkaNarudzbineID;
    }

    public double getUkupanIznosStavkeNarudzbine() {
        return ukupanIznosStavkeNarudzbine;
    }

    public void setUkupanIznosStavkeNarudzbine(double ukupanIznosStavkeNarudzbine) {
        this.ukupanIznosStavkeNarudzbine = ukupanIznosStavkeNarudzbine;
    }

    @Override
    public String getTableName() {
        return "stavkanarudzbine";
    }

    @Override
    public boolean daLiAutoinkrement() {
        return true;
    }

    @Override
    public void setObjectId(long id) {
        stavkaNarudzbineID = id;
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(NarudzbinaID, UkupanIznosStavkeNarudzbine, KnjigaID, Kolicina, Cena, JedinicaMere)";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        return narudzbina.getNarudzbinaID() + ", " + ukupanIznosStavkeNarudzbine + ", " + knjiga.getKnjigaID() + ", " + kolicina + ", " + cena + ", '" + jedinicaMere + "' "; 
    }

    @Override
    public String getIdName() {
        return "StavkaNarudzbineID";
    }

    @Override
    public ArrayList<DomenskiObjekat> vratiListuPoRS(ResultSet rs) throws Exception {
        ArrayList<DomenskiObjekat> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                String pismoS = rs.getString("Pismo");
                Pismo pismo = Pismo.getPismo(pismoS);
                Knjiga k = new Knjiga(rs.getInt("KnjigaID"), rs.getString("NazivKnjige"), rs.getString("Izdavac"), rs.getInt("GodinaIzdavanja"), pismo, rs.getDouble("k.Cena"));
                
                Kupac kup = new Kupac(rs.getInt("KupacID"), rs.getString("ImeKupca"), rs.getString("PrezimeKupca"), rs.getString("Adresa"), rs.getString("brojTelefona"), rs.getString("Email"));
                Korisnik kor = new Korisnik(rs.getInt("KorisnikID"), rs.getString("ImeKorisnika"), rs.getString("PrezimeKorisnika"), rs.getString("JMBG"), rs.getString("Username"), rs.getString("Password"));
                Narudzbina n = new Narudzbina(rs.getInt("NarudzbinaID"), rs.getDate("DatumIzdavanja"), rs.getDouble("UkupanIznos"), kor, kup, rs.getString("Status"));

                lista.add(new StavkaNarudzbine(n, rs.getInt("StavkaNarudzbineID"), rs.getDouble("UkupanIznosStavkeNarudzbine"), k, rs.getInt("Kolicina"), rs.getDouble("UkupanIznos"), rs.getString("JedinicaMere")));
            }
        } catch (SQLException e) {

        }

        return lista;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE stavkanarudzbine SET UkupanIznosStavkeNarudzbine = " + ukupanIznosStavkeNarudzbine + ", Kolicina = " + kolicina + " WHERE StavkaNarudzbineID = " + stavkaNarudzbineID + " AND NarudzbinaID = " + narudzbina.getNarudzbinaID();
    }

    @Override
    public String prepareQueryForSelect() {
        return "SELECT * FROM stavkanarudzbine sn JOIN narudzbina n ON sn.NarudzbinaID = n.NarudzbinaID JOIN knjiga k ON k.KnjigaID = sn.KnjigaID JOIN kupac kup ON n.KupacID = kup.KupacID JOIN korisnik kor ON kor.KorisnikID = n.KorisnikID";
    }

    @Override
    public long getId() {
        return stavkaNarudzbineID;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getIzmene() {
        return izmene;
    }

    public void setIzmene(String izmene) {
        this.izmene = izmene;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(String jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    
 

    
    
    
}
