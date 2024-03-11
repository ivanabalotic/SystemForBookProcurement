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

/**
 *
 * @author Iva
 */
public class NadjiNarudzbineSO extends SistemskeOperacije {

    public NadjiNarudzbineSO() {
        super();
    }

    @Override
    protected void operation() throws Exception {
        ArrayList<DomenskiObjekat> listaNarudzbina = db.vratiSve(Narudzbina.class, "", "NarudzbinaID");
        ArrayList<DomenskiObjekat> listaStavkiNarudzbina = db.vratiSve(StavkaNarudzbine.class, "", "");

        for (DomenskiObjekat stavka : listaStavkiNarudzbina) {
            StavkaNarudzbine st = (StavkaNarudzbine) stavka;
            for (DomenskiObjekat narudzbina : listaNarudzbina) {
                Narudzbina n = (Narudzbina) narudzbina;
                if (st.getNarudzbina().getNarudzbinaID() == n.getNarudzbinaID()) {
                    n.getStavke().add(st);
                }
            }
        }
        lista = listaNarudzbina;

    }
}
