/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Kupac;
import interfejsi.DomenskiObjekat;
import java.util.ArrayList;
import so.SistemskeOperacije;
import validacija.ValidacijaKupca;

/**
 *
 * @author Iva
 */
public class UnesiKupcaSO extends SistemskeOperacije {

    public UnesiKupcaSO(Kupac k) {
        super();
        odo = k;
        validator = new ValidacijaKupca();
    }
    
    @Override
    protected void operation() throws Exception {

        ArrayList<DomenskiObjekat> kupci = db.vratiSve(Kupac.class, "", "");
        if (!kupci.contains(odo)) {
            odo = db.insert(odo);
        } else {
            throw new Exception("Uneti kupac vec postoji u bazi!");
        }
    }
    
}
