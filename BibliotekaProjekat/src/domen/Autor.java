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
public class Autor implements DomenskiObjekat {
    private long autorID;
    private String imeAutora;
    private String prezimeAutora;

    public Autor() {
    }

    public Autor(long autorID, String imeAutora, String prezimeAutora) {
        this.autorID = autorID;
        this.imeAutora = imeAutora;
        this.prezimeAutora = prezimeAutora;
    }

    public String getPrezimeAutora() {
        return prezimeAutora;
    }

    public void setPrezimeAutora(String prezimeAutora) {
        this.prezimeAutora = prezimeAutora;
    }

    public long getAutorID() {
        return autorID;
    }

    public void setAutorID(long autorID) {
        this.autorID = autorID;
    }

    public String getImeAutora() {
        return imeAutora;
    }

    public void setImeAutora(String imeAutora) {
        this.imeAutora = imeAutora;
    }

    @Override
    public String getTableName() {
        return "autor";
    }

    @Override
    public boolean daLiAutoinkrement() {
        return true;
    }

    @Override
    public void setObjectId(long id) {
        autorID = id;
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(ImeAutora, PrezimeAutora)";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        return "'" + imeAutora + "', '" + prezimeAutora + "' ";
    }

    @Override
    public String getIdName() {
        return "AutorID";
    }

    @Override
    public ArrayList<DomenskiObjekat> vratiListuPoRS(ResultSet rs) throws Exception {
        ArrayList<DomenskiObjekat> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                lista.add(new Autor(rs.getInt("AutorID"), rs.getString("ImeAutora"), rs.getString("PrezimeAutora")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE autor SET ImeAutora = '" + imeAutora + "', PrezimeAutora = '" + prezimeAutora + "' WHERE AutorID = " + autorID;
    }

    @Override
    public String prepareQueryForSelect() {
        return "SELECT * FROM autor";
    }

    @Override
    public long getId() {
        return autorID;
    }

    @Override
    public String toString() {
        return imeAutora + " " + prezimeAutora; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        return this.autorID == other.autorID;
    }
    
    
}
