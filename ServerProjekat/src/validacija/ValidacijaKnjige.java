/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validacija;

import domen.Knjiga;
import interfejsi.DomenskiObjekat;

/**
 *
 * @author Iva
 */
public class ValidacijaKnjige implements Validator{

    @Override
    public void validate(DomenskiObjekat value) throws Exception {
        try {
            Knjiga k = (Knjiga) value;

            if (k.getNazivKnjige().equals("")) {
                throw new Exception("Naziv ne sme biti prazan");
            }

            if (k.getIzdavac().equals("")) {
                throw new Exception("Izdavac ne sme biti prazan");
            }

            if (Double.compare(k.getCena(), 0.00) == -1 || Double.compare(k.getCena(), 0.00) == 0) {
                throw new Exception("Cena ne moze da bude manja ili jednaka 0");
            }
            
            if (Double.compare(k.getGodinaIzdavanja(), 0.00) == -1 || Double.compare(k.getGodinaIzdavanja(), 0.00) == 0) {
                throw new Exception("Godina ne moze da bude manja ili jednaka 0");
            }
            
            if (k.getListaAutora().size()<1) {
                throw new Exception("Mora imati bar 1 autora");
            }
            
            if (k.getListaZanrova().size()<1) {
                throw new Exception("Mora imati bar 1 zanr");
            }
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
