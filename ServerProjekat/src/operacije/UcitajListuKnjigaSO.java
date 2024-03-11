/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Knjiga;
import so.SistemskeOperacije;

/**
 *
 * @author Iva
 */
public class UcitajListuKnjigaSO extends SistemskeOperacije {
    public UcitajListuKnjigaSO() {
        super();
    }
    
    @Override
    protected void operation() throws Exception {
        lista = db.vratiSve(Knjiga.class, "", "");
    }
}
