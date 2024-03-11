/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import interfejsi.DomenskiObjekat;
import java.util.ArrayList;
import validacija.Validator;

/**
 *
 * @author Iva
 */
public abstract class SistemskeOperacije {
    protected Validator validator;
    protected DBBroker db;
    protected DomenskiObjekat odo;
    protected ArrayList<DomenskiObjekat> lista;
//    protected boolean ret;
    
    public SistemskeOperacije() {
        db = new DBBroker();
    }

    protected void proveriUslove() throws Exception{
        if(validator!=null){
            validator.validate(odo);
        }
    }
    
    protected abstract void operation()throws Exception;
    
    public void izvrsi() throws Exception{
        db.otvoriKonekciju();
        
        proveriUslove();

        try {
            operation();
            db.commit();
        } catch (Exception ex) {
            db.rollback();
            throw ex;
        }finally{
            db.zatvoriKonekciju();
        }
    }

    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public DBBroker getDb() {
        return db;
    }

    public void setDb(DBBroker db) {
        this.db = db;
    }

    public DomenskiObjekat getOdo() {
        return odo;
    }

    public void setOdo(DomenskiObjekat odo) {
        this.odo = odo;
    }

    public ArrayList<DomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(ArrayList<DomenskiObjekat> lista) {
        this.lista = lista;
    }

//    public boolean isRet() {
//        return ret;
//    }
//
//    public void setRet(boolean ret) {
//        this.ret = ret;
//    }
  
    
    
  
}
