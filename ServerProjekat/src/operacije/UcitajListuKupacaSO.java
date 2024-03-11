/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Kupac;
import so.SistemskeOperacije;

/**
 *
 * @author Iva
 */
public class UcitajListuKupacaSO extends SistemskeOperacije {
    public UcitajListuKupacaSO() {
        super();
    }
    
    @Override
    protected void operation() throws Exception {
        lista = db.vratiSve(Kupac.class, "", "");
    }
}
