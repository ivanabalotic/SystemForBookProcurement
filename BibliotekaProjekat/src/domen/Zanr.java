/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import interfejsi.DomenskiObjekat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Iva
 */
public class Zanr implements DomenskiObjekat {
    private long zanrID;
    private String nazivZanra;

    public Zanr() {
    }

    public Zanr(long zanrID, String nazivZanra) {
        this.zanrID = zanrID;
        this.nazivZanra = nazivZanra;
    }

    public String getNazivZanra() {
        return nazivZanra;
    }

    public void setNazivZanra(String nazivZanra) {
        this.nazivZanra = nazivZanra;
    }

    public long getZanrID() {
        return zanrID;
    }

    public void setZanrID(long zanrID) {
        this.zanrID = zanrID;
    }

    @Override
    public String getTableName() {
        return "zanr";
    }

    @Override
    public boolean daLiAutoinkrement() {
        return true;
    }

    @Override
    public void setObjectId(long id) {
        zanrID = id;
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "NazivZanra";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        return "'" + nazivZanra + "'";
    }

    @Override
    public String getIdName() {
        return "ZanrID";
    }

    @Override
    public ArrayList<DomenskiObjekat> vratiListuPoRS(ResultSet rs) throws Exception {
        ArrayList<DomenskiObjekat> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                lista.add(new Zanr(rs.getInt("ZanrID"), rs.getString("NazivZanra")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE zanr SET NazivZanra = '" + nazivZanra + "' WHERE ZanrID = " + zanrID;
    }

    @Override
    public String prepareQueryForSelect() {
        return "SELECT * FROM zanr";
    }

    @Override
    public long getId() {
        return zanrID;
    }

    @Override
    public String toString() {
        return nazivZanra; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
}
