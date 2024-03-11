/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import db.DBBroker;
import domen.Autor;
import domen.Knjiga;
import domen.Korisnik;
import domen.Kupac;
import domen.Narudzbina;
import forme.ServerskaForma;
import interfejsi.DomenskiObjekat;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kom.KomunikacijaSaKlijentom;
import konstante.Operacije;
import niti.ObradaZahteva;
import operacije.KreirajNarudzbinuSO;
import operacije.PrijaviSeSO;
import operacije.NadjiNarudzbineSO;
import operacije.ObradiNarudzbinuSO;
import operacije.RegistrujSeSO;
import operacije.StornirajNarudzbinuSO;
import operacije.UcitajListuAutoraSO;
import operacije.UcitajListuKnjigaSO;
import operacije.UcitajListuKupacaSO;
import operacije.UcitajListuZanrovaSO;
import operacije.UnesiAutoraSO;
import operacije.UnesiKnjiguSO;
import operacije.UnesiKupcaSO;
import so.SistemskeOperacije;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Iva
 */
public class KontrolerServer {
    private static KontrolerServer instanca;
    DBBroker db;
    ArrayList<ObradaZahteva> listaUlogovanih;
    HashMap<Socket, Korisnik> ulogovani;
    ServerskaForma sf;
    
    private KontrolerServer() {
        db = new DBBroker();
        listaUlogovanih = new ArrayList<>();
        ulogovani = new HashMap<>();
    }

    public static KontrolerServer getInstanca() {
        if (instanca == null) {
            instanca = new KontrolerServer();
        }
        KomunikacijaSaKlijentom.getInstanca();
        return instanca;
    }

    public DomenskiObjekat prijaviKorisnika(Korisnik k, Socket s) throws Exception {
        SistemskeOperacije so = new PrijaviSeSO(k);
        so.izvrsi();
        
        Korisnik ulogovan = (Korisnik) so.getOdo();
        
        for (Map.Entry<Socket, Korisnik> entry : ulogovani.entrySet()) {
            Korisnik korisnik = entry.getValue();

            if (k.equals(korisnik)) {
                throw new Exception("Korisnik je već ulogovan!");
            }
        }
        
        if (ulogovan != null && ulogovan.getKorisnikID() != 0) {
            ulogovani.put(s, ulogovan);
            osveziTabelu();
        }
        
        return so.getOdo();
    }

    public DomenskiObjekat registrujSe(Korisnik k, Socket s) throws Exception {
        SistemskeOperacije so = new RegistrujSeSO(k);
        so.izvrsi();
        
        Korisnik ulogovan = (Korisnik) so.getOdo();
        
        if (ulogovan != null && ulogovan.getKorisnikID() != 0) {
            ulogovani.put(s, ulogovan);
            osveziTabelu();
        }
        
        return so.getOdo();
    }

    public DomenskiObjekat unesiKupca(Kupac k) throws Exception {
        SistemskeOperacije so = new UnesiKupcaSO(k);
        so.izvrsi();
        return so.getOdo();
    }

    public DomenskiObjekat unesiKnjigu(Knjiga k) throws Exception {
        SistemskeOperacije so = new UnesiKnjiguSO(k);
        so.izvrsi();
        return so.getOdo();
    }

    public ArrayList<DomenskiObjekat> vratiAutore() throws Exception {
        SistemskeOperacije so = new UcitajListuAutoraSO();
        so.izvrsi();
        return so.getLista();
    }

    public ArrayList<DomenskiObjekat> vratiZanrove() throws Exception {
        SistemskeOperacije so = new UcitajListuZanrovaSO();
        so.izvrsi();
        return so.getLista();
    }

    public ArrayList<DomenskiObjekat> vratiKnjige() throws Exception {
        SistemskeOperacije so = new UcitajListuKnjigaSO();
        so.izvrsi();
        return so.getLista();
    }
    
    public ArrayList<DomenskiObjekat> vratiKupce() throws Exception {
        SistemskeOperacije so = new UcitajListuKupacaSO();
        so.izvrsi();
        return so.getLista();
    }

    public DomenskiObjekat kreirajNarudzbinu(Narudzbina n) throws Exception {
        SistemskeOperacije so = new KreirajNarudzbinuSO(n);
        so.izvrsi();
        return so.getOdo();
    }

    public ArrayList<DomenskiObjekat> vratiNarudzibe() throws Exception {
        SistemskeOperacije so = new NadjiNarudzbineSO();
        so.izvrsi();
        return so.getLista();
    }

    public DomenskiObjekat izmeniNarudzbinu(Narudzbina n) throws Exception {
        SistemskeOperacije so = new ObradiNarudzbinuSO(n);
        so.izvrsi();
        return so.getOdo();
    }

    public DomenskiObjekat stornirajNarudzbinu(Narudzbina n) throws Exception {
        SistemskeOperacije so = new StornirajNarudzbinuSO(n);
        so.izvrsi();
//        return so.isRet();
        return so.getOdo();
    }

    public void testirajParametre(String url, String user, String pass) throws SQLException {
        db.testirajParametre(url, user, pass);
    }

    public void dodajKlijenta(ObradaZahteva oz) {
        listaUlogovanih.add(oz);
    }

    public void izbaciKlijenta(ObradaZahteva klijentNit, boolean osvezi) {
        klijentNit.interrupt();
        try {
            listaUlogovanih.remove(klijentNit);
            ulogovani.remove(klijentNit.getSoket());
        } catch (Exception e) {
        }
        
        if (osvezi) {
            osveziTabelu();
        }
    }

    public void odjaviSveKlijente() {
        ArrayList<ObradaZahteva> zaIzbacivanje = new ArrayList<>();
        for (ObradaZahteva klijent : listaUlogovanih) {
            zaIzbacivanje.add(klijent);
            ServerskiOdgovor so = new ServerskiOdgovor(Operacije.ODJAVI_SVE_KLIJENTE, null, null);
            KomunikacijaSaKlijentom.getInstanca().posaljiOdgovor(klijent.getSoket(), so);
        }
        for (ObradaZahteva klijentZaIzb : zaIzbacivanje) {
            izbaciKlijenta(klijentZaIzb, false);
        }
        
        osveziTabelu();
    }

    public void setSf(ServerskaForma sf) {
        this.sf = sf;
    }

    private void osveziTabelu() {
        ArrayList<String> lista = new ArrayList<>();
        for (Map.Entry<Socket, Korisnik> entry : ulogovani.entrySet()) {
            Korisnik val = entry.getValue();
            lista.add(val + "");
        }
        sf.postaviTabelu(lista);
        
    }

    public void odjaviKlijenta(ObradaZahteva klijentNit) {
        ulogovani.remove(klijentNit.getSoket());
        
        osveziTabelu();
    }

    public DomenskiObjekat unesiAutora(Autor a) throws Exception {
        SistemskeOperacije so = new UnesiAutoraSO(a);
        so.izvrsi();
        return so.getOdo();
    }

    

}
