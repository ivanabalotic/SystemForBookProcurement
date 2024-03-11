/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Korisnik;
import interfejsi.DomenskiObjekat;
import java.util.ArrayList;
import so.SistemskeOperacije;
import validacija.ValidacijaKorisnika;

/**
 *
 * @author Iva
 */
public class RegistrujSeSO extends SistemskeOperacije {
    public RegistrujSeSO(Korisnik k) {
        super();
        odo=k;
        validator=new ValidacijaKorisnika();
    }

    @Override
    protected void operation() throws Exception {
        ArrayList<DomenskiObjekat> korisnici = db.vratiSve(Korisnik.class, "","");
        if(korisnici.isEmpty()){
            odo=db.insert(odo);
            return;
        }

        for (DomenskiObjekat domenskiObjekat : korisnici) {
            Korisnik k=(Korisnik) domenskiObjekat;
            Korisnik zaUbacivanje=(Korisnik) odo;
            
            if(k.getUsername().matches(zaUbacivanje.getUsername()) || k.getJmbg().matches(zaUbacivanje.getJmbg())){
                throw new Exception("Proverite JMBG ili promenite korisnicko ime!");
            }    
        }
        odo=db.insert(odo);
    }
}
