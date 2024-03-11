/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import javax.swing.JOptionPane;
import kom.KomunikacijaSaServerom;
import konstante.Operacije;
import logika.KontrolerKlijent;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Iva
 */
public class ObradaOdgovora extends Thread {

    public ObradaOdgovora() {
    }

    @Override
    public void run() {
        while (true) {

            ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();

            switch (so.getOperacija()) {
                case Operacije.ODJAVI_SVE_KLIJENTE:
                    KontrolerKlijent.getInstanca().odjaviSve();
                    break;

                case Operacije.KREIRAJ_NARUDZBENICU:
                    KontrolerKlijent.getInstanca().kreirajNarudzbenicu(so);
                    break;

                case Operacije.PRIJAVI_SE:
                    KontrolerKlijent.getInstanca().ulogujKlijenta(so);
                    break;

                case Operacije.NADJI_NARUDZBINE:
                    KontrolerKlijent.getInstanca().vratiNarudzbine(so);
                    break;

                case Operacije.OBRADI_NARUDZBINU:
                    KontrolerKlijent.getInstanca().obradiNarudzbinu(so);
                    break;

                case Operacije.REGISTRUJ_SE:
                    KontrolerKlijent.getInstanca().registrujKor(so);
                    break;

                case Operacije.STORNIRAJ_NARUDZBINU:
                    KontrolerKlijent.getInstanca().stornirajNarudzbinu(so);
                    break;

                case Operacije.UCITAJ_LISTU_AUTORA:
                    KontrolerKlijent.getInstanca().vratiAutore(so);
                    break;

                case Operacije.UCITAJ_LISTU_KNJIGA:
                    KontrolerKlijent.getInstanca().vratiKnjige(so);
                    break;

                case Operacije.UCITAJ_LISTU_ZANROVA:
                    KontrolerKlijent.getInstanca().vratiZanrove(so);
                    break;

                case Operacije.UNESI_KNJIGU:
                    KontrolerKlijent.getInstanca().unesiKnjigu(so);
                    break;

                case Operacije.UNESI_KUPCA:
                    KontrolerKlijent.getInstanca().unesiKupca(so);
                    break;
                    
                case Operacije.UCITAJ_LISTU_KUPACA:
                    KontrolerKlijent.getInstanca().vratiKupce(so);
                    break;
                    
                case Operacije.UNESI_AUTORA:
                    KontrolerKlijent.getInstanca().unesiAutora(so);
                    break;
                        
                case Operacije.UGASI_KORISNIKA:
                    break;
                    
                case Operacije.ODJAVI_KORISNIKA:
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, so.getIzuzetak().getMessage());
                    break;

            }
        }

    }


    
    
    
    
    
    
}
