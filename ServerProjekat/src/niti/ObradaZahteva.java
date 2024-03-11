/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.Autor;
import domen.Knjiga;
import domen.Korisnik;
import domen.Kupac;
import domen.Narudzbina;
import interfejsi.DomenskiObjekat;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import kom.KomunikacijaSaKlijentom;
import konstante.Operacije;
import logika.KontrolerServer;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Iva
 */
public class ObradaZahteva extends Thread{
    Socket soket;
    PokretanjeServera ps;
    boolean radi = true;

    public ObradaZahteva(Socket soket, PokretanjeServera ps) {
        this.soket = soket;
        this.ps = ps;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                KlijentskiZahtev kz = KomunikacijaSaKlijentom.getInstanca().prihvatiZahtev(soket);
                ServerskiOdgovor so = null;
                switch (kz.getOperacija()) {
                    case Operacije.PRIJAVI_SE:
                        so = prijaviKorisnika(kz);
                        break;
                    case Operacije.REGISTRUJ_SE:
                        so = registrujSe(kz);
                        break;
                    case Operacije.UNESI_KUPCA:
                        so = unesiKupca(kz);
                        break;
                    case Operacije.UNESI_KNJIGU:
                        so = unesiKnjigu(kz);
                        break;
                        
                    case Operacije.UNESI_AUTORA:
                        so = unesiAutora(kz);
                        break;
                        
                    case Operacije.UCITAJ_LISTU_AUTORA:
                        so = ucitajListuAutora();
                        break;
                    case Operacije.UCITAJ_LISTU_ZANROVA:
                        so = ucitajListuZanrova();
                        break;
                    case Operacije.UCITAJ_LISTU_KNJIGA:
                        so = ucitajListuKnjiga();
                        break;
                    case Operacije.UCITAJ_LISTU_KUPACA:
                        so = ucitajListuKupaca();
                        break;
                    case Operacije.KREIRAJ_NARUDZBENICU:
                        so = kreirajNarudzbenicu(kz);
                        break;
                    case Operacije.NADJI_NARUDZBINE:
                        so = nadjiNarudzbine();
                        break;
                    case Operacije.OBRADI_NARUDZBINU:
                        so = izmeniNarudzbinu(kz);
                        break;
                    case Operacije.STORNIRAJ_NARUDZBINU:
                        so = obrisiNarudzbinu(kz);
                        break;
                        
                    case Operacije.UGASI_KORISNIKA:
                        KontrolerServer.getInstanca().izbaciKlijenta(this, true);
                        so = new ServerskiOdgovor(Operacije.UGASI_KORISNIKA, null, null);
                        break;
                        
                    case Operacije.ODJAVI_KORISNIKA:
                        KontrolerServer.getInstanca().odjaviKlijenta(this);
                        so = new ServerskiOdgovor(Operacije.ODJAVI_KORISNIKA, null, null);
                        break;

                }
                
                KomunikacijaSaKlijentom.getInstanca().posaljiOdgovor(soket, so);
            } catch (IOException | ClassNotFoundException ex) {
                KontrolerServer.getInstanca().izbaciKlijenta(this, true);
            }
        }
    }

    public Socket getSoket() {
        return soket;
    }

    private ServerskiOdgovor prijaviKorisnika(KlijentskiZahtev kz) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try {
            Korisnik k = (Korisnik) kz.getParametar();
            DomenskiObjekat odo = KontrolerServer.getInstanca().prijaviKorisnika(k, soket);

            odgovor.setOperacija(Operacije.PRIJAVI_SE);
            odgovor.setOdgovor(odo);
        } catch (Exception e) {
            odgovor.setOdgovor(null);
            odgovor.setIzuzetak(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor registrujSe(KlijentskiZahtev kz) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try {
            Korisnik k = (Korisnik) kz.getParametar();
            DomenskiObjekat odo = KontrolerServer.getInstanca().registrujSe(k, soket);

            odgovor.setOperacija(Operacije.REGISTRUJ_SE);
            odgovor.setOdgovor(odo);
        } catch (Exception e) {
            odgovor.setOdgovor(null);
            odgovor.setIzuzetak(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor unesiKupca(KlijentskiZahtev kz) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try {
            Kupac k = (Kupac) kz.getParametar();
            DomenskiObjekat odo = KontrolerServer.getInstanca().unesiKupca(k);

            odgovor.setOperacija(Operacije.UNESI_KUPCA);
            odgovor.setOdgovor(odo);
        } catch (Exception e) {
            odgovor.setOdgovor(null);
            odgovor.setIzuzetak(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor unesiKnjigu(KlijentskiZahtev kz) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try {
            Knjiga k = (Knjiga) kz.getParametar();
            DomenskiObjekat odo = KontrolerServer.getInstanca().unesiKnjigu(k);

            odgovor.setOperacija(Operacije.UNESI_KNJIGU);
            odgovor.setOdgovor(odo);
        } catch (Exception e) {
            odgovor.setOdgovor(null);
            odgovor.setIzuzetak(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor ucitajListuAutora() {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        ArrayList<DomenskiObjekat> lista;
        
        try {
            lista = KontrolerServer.getInstanca().vratiAutore();

            odgovor.setOperacija(Operacije.UCITAJ_LISTU_AUTORA);
            odgovor.setOdgovor(lista);
        } catch (Exception e) {
            odgovor.setIzuzetak(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor ucitajListuZanrova() {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        ArrayList<DomenskiObjekat> lista;
        
        try {
            lista = KontrolerServer.getInstanca().vratiZanrove();

            odgovor.setOperacija(Operacije.UCITAJ_LISTU_ZANROVA);
            odgovor.setOdgovor(lista);
        } catch (Exception e) {
            odgovor.setIzuzetak(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor ucitajListuKnjiga() {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        ArrayList<DomenskiObjekat> lista;
        
        try {
            lista = KontrolerServer.getInstanca().vratiKnjige();

            odgovor.setOperacija(Operacije.UCITAJ_LISTU_KNJIGA);
            odgovor.setOdgovor(lista);
        } catch (Exception e) {
            odgovor.setIzuzetak(e);
        }
        return odgovor;
    }
    
    private ServerskiOdgovor ucitajListuKupaca() {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        ArrayList<DomenskiObjekat> lista;
        
        try {
            lista = KontrolerServer.getInstanca().vratiKupce();

            odgovor.setOperacija(Operacije.UCITAJ_LISTU_KUPACA);
            odgovor.setOdgovor(lista);
        } catch (Exception e) {
            odgovor.setIzuzetak(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor kreirajNarudzbenicu(KlijentskiZahtev kz) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try {
            Narudzbina n = (Narudzbina) kz.getParametar();
            DomenskiObjekat odo = KontrolerServer.getInstanca().kreirajNarudzbinu(n);

            odgovor.setOperacija(Operacije.KREIRAJ_NARUDZBENICU);
            odgovor.setOdgovor(odo);
        } catch (Exception e) {
            odgovor.setOdgovor(null);
            odgovor.setIzuzetak(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor nadjiNarudzbine() {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        ArrayList<DomenskiObjekat> lista;
        
        try {
            lista = KontrolerServer.getInstanca().vratiNarudzibe();

            odgovor.setOperacija(Operacije.NADJI_NARUDZBINE);
            odgovor.setOdgovor(lista);
        } catch (Exception e) {
            odgovor.setIzuzetak(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor izmeniNarudzbinu(KlijentskiZahtev kz) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try {
            Narudzbina n = (Narudzbina) kz.getParametar();
            DomenskiObjekat odo = KontrolerServer.getInstanca().izmeniNarudzbinu(n);

            odgovor.setOperacija(Operacije.OBRADI_NARUDZBINU);
            odgovor.setOdgovor(odo);
        } catch (Exception e) {
            odgovor.setOdgovor(null);
            odgovor.setIzuzetak(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor obrisiNarudzbinu(KlijentskiZahtev kz) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try {
            Narudzbina n = (Narudzbina) kz.getParametar();
//            boolean ret = KontrolerServer.getInstanca().stornirajNarudzbinu(n);
            DomenskiObjekat odo = KontrolerServer.getInstanca().stornirajNarudzbinu(n);            

            odgovor.setOperacija(Operacije.STORNIRAJ_NARUDZBINU);
            odgovor.setOdgovor(odo);
        } catch (Exception e) {
            odgovor.setOdgovor(false);
            odgovor.setIzuzetak(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor unesiAutora(KlijentskiZahtev kz) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try {
            Autor a = (Autor) kz.getParametar();
            DomenskiObjekat odo = KontrolerServer.getInstanca().unesiAutora(a);

            odgovor.setOperacija(Operacije.UNESI_AUTORA);
            odgovor.setOdgovor(odo);
        } catch (Exception e) {
            odgovor.setOdgovor(null);
            odgovor.setIzuzetak(e);
        }
        return odgovor;
    }



}
