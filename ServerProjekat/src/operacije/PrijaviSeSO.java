/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Korisnik;
import interfejsi.DomenskiObjekat;
import java.util.ArrayList;
import so.SistemskeOperacije;

/**
 *
 * @author Iva
 */
public class PrijaviSeSO extends SistemskeOperacije {
    
    public PrijaviSeSO(Korisnik k) {
        super();
        odo = k;
    }
    
    @Override
    protected void operation() throws Exception {
        ArrayList<DomenskiObjekat> korisnici = db.vratiSve(Korisnik.class, "", "");
        
        for (DomenskiObjekat domain : korisnici) {
            Korisnik k = (Korisnik)domain;
            if (odo.equals(k)) {
                odo = k;
                return;
            }
        }
    }
}
