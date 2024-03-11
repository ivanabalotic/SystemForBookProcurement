/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Zanr;
import so.SistemskeOperacije;

/**
 *
 * @author Iva
 */
public class UcitajListuZanrovaSO extends SistemskeOperacije {
    public UcitajListuZanrovaSO() {
        super();
    }
    
    @Override
    protected void operation() throws Exception {
        lista = db.vratiSve(Zanr.class, "", "");
    }
  
}
