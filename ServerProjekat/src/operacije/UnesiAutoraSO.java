/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Autor;
import interfejsi.DomenskiObjekat;
import java.util.ArrayList;
import so.SistemskeOperacije;
import validacija.ValidacijaAutora;

/**
 *
 * @author Iva
 */
public class UnesiAutoraSO extends SistemskeOperacije {
    public UnesiAutoraSO(Autor a) {
        super();
        odo = a;
        validator = new ValidacijaAutora();
    }

    @Override
    protected void operation() throws Exception {
        SistemskeOperacije so = new UcitajListuAutoraSO();
        so.izvrsi();
        
        ArrayList<DomenskiObjekat> autori = so.getLista();
        
        if (!autori.contains(odo)) {
            odo = db.insert(odo);
        } else {
            throw new Exception("Uneti autor vec postoji u bazi!");
        }
    }
    
}
