/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Iva
 */
public class ServerskiOdgovor implements Serializable{
    private int operacija;
    private Object odgovor;
    private Exception izuzetak;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(int operacija, Object odgovor, Exception izuzetak) {
        this.operacija = operacija;
        this.odgovor = odgovor;
        this.izuzetak = izuzetak;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Exception getIzuzetak() {
        return izuzetak;
    }

    public void setIzuzetak(Exception izuzetak) {
        this.izuzetak = izuzetak;
    }

    
}
