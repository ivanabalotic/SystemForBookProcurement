/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import interfejsi.DomenskiObjekat;

/**
 *
 * @author Iva
 */
public class KonverterObjekta {
    public static DomenskiObjekat kreirajObjekat(Class klasa){
       
        
        if(klasa == Korisnik.class)
            return new Korisnik(-1, "", "", "", "", "");
        if(klasa == Kupac.class)
            return new Kupac(-1, "", "", "", "", "");
        if(klasa == Knjiga.class)
            return new Knjiga(-1, "", "", 0, null, 0, null, null);
        if(klasa == StavkaNarudzbine.class)
            return new StavkaNarudzbine(null, -1, 0, null, 1, 0, "");
        if(klasa == Narudzbina.class)
            return new Narudzbina(-1, null, 0.0, null, null, null, "");
        if(klasa == Autor.class)
            return new Autor(-1, "", "");
        if(klasa == Kategorija.class)
            return new Kategorija(null, null);
        if(klasa == Napisao.class)
            return new Kategorija(null, null);
        if(klasa == Zanr.class)
            return new Zanr(-1, "");
        
        
        return null;
    }
}
