/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import domen.Autor;
import domen.Knjiga;
import domen.Korisnik;
import domen.Kupac;
import domen.Narudzbina;
import forme.FormaZaPrijavljivanje;
import forme.NarudzbineForma;
import forme.RegistracijaForma;
import forme.UnesiAutora;
import forme.UnesiKnjigu;
import forme.UnesiKupca;
import forme.UnesiNarudzbinu;
import javax.swing.JOptionPane;
import kom.KomunikacijaSaServerom;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Iva
 */
public class KontrolerKlijent {
    private static KontrolerKlijent instanca;
    private FormaZaPrijavljivanje lf;
    private RegistracijaForma rf;
    UnesiKnjigu uKnjigu;
    UnesiKupca uKupca;
    UnesiAutora uAutora;
    UnesiNarudzbinu uNarudzbinu;
    NarudzbineForma nf;

    private KontrolerKlijent() {
        
    }

    public static KontrolerKlijent getInstanca() {
        if (instanca == null) {
            instanca = new KontrolerKlijent();
        }
        KomunikacijaSaServerom.getInstanca();
        return instanca;
    }

    public void posaljiZahtevZaVracanjeNarudzbina() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.NADJI_NARUDZBINE);
        
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void posaljiZahtevZaStorniranjeNarudzbine(Narudzbina n) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.STORNIRAJ_NARUDZBINU);
        kz.setParametar(n);
        
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void posaljiZahtevZaVracanjeKnjiga() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_LISTU_KNJIGA);
        
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void posaljiZahtevZaVracanjeAutora() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_LISTU_AUTORA);
        
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }
    
    public void posaljiZahtevZaVracanjeZanrova() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_LISTU_ZANROVA);
        
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void posaljiZahtevZaKreiranjeNarudzbine(Narudzbina narudzbina) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.KREIRAJ_NARUDZBENICU);
        kz.setParametar(narudzbina);
        
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void posaljiZahtevZaObraduNarudzbine(Narudzbina narudzbina) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRADI_NARUDZBINU);
        kz.setParametar(narudzbina);
        
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void posaljiZahtevZaUnosKupca(Kupac k) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UNESI_KUPCA);
        kz.setParametar(k);
        
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void posaljiZahtevZaUnesKnjige(Knjiga k) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UNESI_KNJIGU);
        kz.setParametar(k);
        
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void posaljiZahtevZaPrijavljivanje(Korisnik k) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.PRIJAVI_SE, k);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }
    
    public void posaljiZahtevZaResitraciju(Korisnik noviKor) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.REGISTRUJ_SE);
        kz.setParametar(noviKor);
        
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }
    
    public void posaljiZahtevZaVracanjeKupaca() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_LISTU_KUPACA);
        
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }
    
    public void posaljiZahtevZaUnosAutora(Autor autor) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.UNESI_AUTORA, autor);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }
    
    public void posaljiZahtevZaGasenjeKorisnika() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UGASI_KORISNIKA);
        
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }
    
    public void posaljiZahtevZaOdjavuKorisnika() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.ODJAVI_KORISNIKA);
        
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void setLf(FormaZaPrijavljivanje lf) {
        this.lf = lf;
    }

    public void ulogujKlijenta(ServerskiOdgovor so) {
        if (lf != null) {
            lf.ulogujKlijenta(so);
        }
    }

    public void registrujKor(ServerskiOdgovor so) {
        if (rf != null) {
            rf.registrujKorisnika(so);
        }
    }

    public void setRf(RegistracijaForma rf) {
        this.rf = rf;
    }

    public void unesiKnjigu(ServerskiOdgovor so) {
        if (uKnjigu != null) {
            uKnjigu.unesiKnjigu(so);
        }
    }

    public void setuKnjigu(UnesiKnjigu uKnjigu) {
        this.uKnjigu = uKnjigu;
    }

    public void unesiKupca(ServerskiOdgovor so) {
        if (uKupca != null) {
            uKupca.unesiKupca(so);
        }
    }

    public void setuKupca(UnesiKupca uKupca) {
        this.uKupca = uKupca;
    }

    public void obradiNarudzbinu(ServerskiOdgovor so) {
        if (uNarudzbinu != null) {
            uNarudzbinu.obradiNarudzbinu(so);
        }
    }

    public void setuNarudzbinu(UnesiNarudzbinu uNarudzbinu) {
        this.uNarudzbinu = uNarudzbinu;
    }

    public void kreirajNarudzbenicu(ServerskiOdgovor so) {
        if (uNarudzbinu != null) {
            uNarudzbinu.unesiNarudzbinu(so);
        }
    }

    public void vratiZanrove(ServerskiOdgovor so) {
        if (uKnjigu != null) {
            uKnjigu.postaviZanrove(so);
        }
    }

    public void vratiAutore(ServerskiOdgovor so) {
        if (uKnjigu != null) {
            uKnjigu.postaviAutore(so);
        }
    }

    public void vratiKnjige(ServerskiOdgovor so) {
        if (uNarudzbinu != null) {
            uNarudzbinu.postaviKnjige(so);
        }
    }
    
    public void vratiKupce(ServerskiOdgovor so) {
        if (uNarudzbinu != null) {
            uNarudzbinu.postaviKupce(so);
        }
    }

    public void stornirajNarudzbinu(ServerskiOdgovor so) {
        if (nf != null) {
            nf.stornirajNarudzbinu(so);
        }
    }

    public void setNf(NarudzbineForma nf) {
        this.nf = nf;
    }

    public void vratiNarudzbine(ServerskiOdgovor so) {
        if (nf != null) {
            nf.postaviNarudzbine(so);
        }
    }

    public void odjaviSve() {
        JOptionPane.showMessageDialog(null, "Server je zaustavljen\nOdjavljeni ste");
        System.exit(0);
    }

    public void unesiAutora(ServerskiOdgovor so) {
        if (uAutora != null) {
            uAutora.unesiAutora(so);
        }
    }

    public void setuAutora(UnesiAutora uAutora) {
        this.uAutora = uAutora;
    }


    
}
