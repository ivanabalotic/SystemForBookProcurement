/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Narudzbina;
import domen.StavkaNarudzbine;
import so.SistemskeOperacije;
import validacija.ValidacijaNarudzbenice;

/**
 *
 * @author Iva
 */
public class ObradiNarudzbinuSO extends SistemskeOperacije {
    public ObradiNarudzbinuSO(Narudzbina n) {
        super();
        odo=n;
        validator=new ValidacijaNarudzbenice();
    }

    @Override
    protected void operation() throws Exception {
//        Narudzbina naruzbina = (Narudzbina) odo;
//        ArrayList<DomenskiObjekat> stavke = db.vratiSve(StavkaNarudzbine.class, "sn.narudzbinaID ="+naruzbina.getNarudzbinaID(), "");
//        for (DomenskiObjekat st : stavke) {
//            db.remove(st);
//        }

        odo = db.update(odo);
        for (StavkaNarudzbine st : ((Narudzbina) odo).getStavke()) {
            st.setNarudzbina((Narudzbina) odo);
            
            switch (st.getIzmene()) {
                case "dodaj":
                    db.insert(st);
                    break;
                    
                case "izmeni":
                    db.update(st);
                    break;
                    
                case "obrisi":
                    db.remove(st);
                    break;
                    
                default:
                    break;
            }
            
        }
    }
    
    
}
