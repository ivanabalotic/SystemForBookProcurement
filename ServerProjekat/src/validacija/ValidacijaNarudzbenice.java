/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validacija;

import domen.Narudzbina;
import interfejsi.DomenskiObjekat;

/**
 *
 * @author Iva
 */
public class ValidacijaNarudzbenice implements Validator {
    @Override
    public void validate(DomenskiObjekat value) throws Exception {
        try {
            Narudzbina n = (Narudzbina) value;

            if (n.getStavke().size()<1) {
                throw new Exception("Narudzbina mora imati bar jednu stavku");
            }
            
            if(Double.compare(n.getUkupanIznos(), 0.00) == -1 || Double.compare(n.getUkupanIznos(), 0.00)==0 ){
                throw new Exception("Ukupan iznos ne moze da bude manji ili jednak 0");
            }
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
