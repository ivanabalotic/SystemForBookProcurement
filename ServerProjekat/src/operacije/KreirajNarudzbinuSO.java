/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Narudzbina;
import domen.StavkaNarudzbine;
import interfejsi.DomenskiObjekat;
import java.util.ArrayList;
import so.SistemskeOperacije;
import validacija.ValidacijaNarudzbenice;

/**
 *
 * @author Iva
 */
public class KreirajNarudzbinuSO extends SistemskeOperacije {
    public KreirajNarudzbinuSO(Narudzbina n) {
        super();
        odo=n;
        validator=new ValidacijaNarudzbenice();
    }

    @Override
    protected void operation() throws Exception {
        SistemskeOperacije so = new NadjiNarudzbineSO();
        so.izvrsi();

        ArrayList<DomenskiObjekat> narudzbenice = so.getLista();

        if (!narudzbenice.contains(odo)) {
            odo = db.insert(odo);
            for (StavkaNarudzbine st : ((Narudzbina) odo).getStavke()) {
                st.setNarudzbina((Narudzbina) odo);
                db.insert(st);
            }
        } else {
            throw new Exception("Uneta narudzbina vec postoji u bazi!");
        }
    }
    
        
    
}
