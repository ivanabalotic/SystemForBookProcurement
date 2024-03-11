/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validacija;

import domen.Autor;
import interfejsi.DomenskiObjekat;

/**
 *
 * @author Iva
 */
public class ValidacijaAutora implements Validator {

    @Override
    public void validate(DomenskiObjekat value) throws Exception {
        try {
            Autor a = (Autor) value;

            if (a.getImeAutora().isEmpty()) {
                throw new Exception("Ime ne sme biti prazno");
            }

            if (a.getPrezimeAutora().isEmpty()) {
                throw new Exception("Prezime ne sme biti prazno");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
