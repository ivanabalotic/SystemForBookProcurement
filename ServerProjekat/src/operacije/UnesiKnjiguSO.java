/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Kategorija;
import domen.Knjiga;
import domen.Napisao;
import interfejsi.DomenskiObjekat;
import java.util.ArrayList;
import so.SistemskeOperacije;
import validacija.ValidacijaKnjige;

/**
 *
 * @author Iva
 */
public class UnesiKnjiguSO extends SistemskeOperacije {
    public UnesiKnjiguSO(Knjiga k) {
        super();
        odo = k;
        validator = new ValidacijaKnjige();
    }

    @Override
    protected void operation() throws Exception {
        SistemskeOperacije so = new UcitajListuKnjigaSO();
        so.izvrsi();
        
        ArrayList<DomenskiObjekat> knjige = so.getLista();
        
        if (!knjige.contains(odo)) {
            odo = db.insert(odo);
            
            for (Napisao n : ((Knjiga) odo).getListaAutora()) {
                n.setKnjiga((Knjiga) odo);
                db.insert(n);
            }
            
            for (Kategorija k : ((Knjiga) odo).getListaZanrova()) {
                k.setKnjiga((Knjiga) odo);
                db.insert(k);
            }
        } else throw new Exception("Uneta knjiga vec postoji u bazi!");
    }
    
    
}
