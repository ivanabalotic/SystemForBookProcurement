/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Iva
 */
public enum Pismo  {
    CIRILICA("Cirilica"),
    LATINICA("Latinica");

    private String pismo;

    private Pismo(String pismo) {
        this.pismo = pismo;
    }

    public static Pismo getPismo(String vrednost){
        if (vrednost.equals("Cirilica")) {
            return CIRILICA;
        }
        
        if (vrednost.equals("Latinica")) {
            return LATINICA;
        }
        
        return null;
    }

    @Override
    public String toString() {
        return pismo; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    
    
}
