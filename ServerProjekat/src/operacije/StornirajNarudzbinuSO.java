 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Narudzbina;
import so.SistemskeOperacije;

/**
 *
 * @author Iva
 */
public class StornirajNarudzbinuSO extends SistemskeOperacije {
    public StornirajNarudzbinuSO(Narudzbina n) {
        super();
        odo=n;
    }

    @Override
    protected void operation() throws Exception {
//        Narudzbina narudzbina = (Narudzbina) odo;
//        ArrayLists<DomenskiObjekat> stavke = db.vratiSve(StavkaNarudzbine.class, "sn.NarudzbinaID ="+narudzbina.getNarudzbinaID(), "");
//        for (DomenskiObjekat st : stavke) {
//            db.remove(st);
//        }
//        ret = db.remove(odo);

        odo = db.update(odo);
    }
}
