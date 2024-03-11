/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jasper;

/**
 *
 * @author Iva
 */
public class Pomocna {
    private String imeKupca;
    private String adresa;
    private String brojTelefona;
    private String email;
    private String korisnik;
    private String nazivKnjige;
    private double cenaPoKomadu;
    private int kolicina;
    private double ukupnaCena;
    private double ukupanIznosNarudz;

    public Pomocna() {
    }

    public Pomocna(String imeKupca, String adresa, String brojTelefona, String email, String korisnik, String nazivKnjige, double cenaPoKomadu, int kolicina, double ukupnaCena, double ukupanIznosNarudz) {
        this.imeKupca = imeKupca;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.korisnik = korisnik;
        this.nazivKnjige = nazivKnjige;
        this.cenaPoKomadu = cenaPoKomadu;
        this.kolicina = kolicina;
        this.ukupnaCena = ukupnaCena;
        this.ukupanIznosNarudz = ukupanIznosNarudz;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public String getImeKupca() {
        return imeKupca;
    }

    public void setImeKupca(String imeKupca) {
        this.imeKupca = imeKupca;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    public double getCenaPoKomadu() {
        return cenaPoKomadu;
    }

    public void setCenaPoKomadu(double cenaPoKomadu) {
        this.cenaPoKomadu = cenaPoKomadu;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getUkupanIznosNarudz() {
        return ukupanIznosNarudz;
    }

    public void setUkupanIznosNarudz(double ukupanIznosNarudz) {
        this.ukupanIznosNarudz = ukupanIznosNarudz;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    
    
    
    
    
    
    
    
}
