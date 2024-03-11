/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domen.KonverterObjekta;
import interfejsi.DomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import properties.PropertyReader;

/**
 *
 * @author Iva
 */
public class DBBroker {
    Connection konekcija;
    
    public void otvoriKonekciju() throws Exception {
        try {
            konekcija = DriverManager.getConnection(PropertyReader.getInstanca().getURL(),PropertyReader.getInstanca().getUsername(),PropertyReader.getInstanca().getPassword());
            konekcija.setAutoCommit(false);
            System.out.println("Uspesno povezivanje sa bazom");
        } catch (SQLException ex) {
            System.out.println("Neuspesno povezivanje: " + ex.getMessage());
        } 
    }
    
     public void zatvoriKonekciju() throws Exception {
        if (konekcija != null) {
            try {
                konekcija.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Greska prilikom raskidanja konekcije sa bazom!\n" + ex.getMessage());
            }
        }
    }

    public void commit() throws Exception {
        if (konekcija != null) {
            try {
                konekcija.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Greska prilikom potvrdjivanja transakcije!\n" + ex.getMessage());
            }
        }
    }

    public void rollback() throws Exception {
        if (konekcija != null) {
            try {
                konekcija.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Greska prilikom ponistavanja transakcije!\n" + ex.getMessage());
            }
        }
    }
    
    public ArrayList<DomenskiObjekat> vratiSve(Class klasa, String where, String orderBy) throws Exception {
        Statement statement = konekcija.createStatement();

        DomenskiObjekat domain = KonverterObjekta.kreirajObjekat(klasa);

        String query = domain.prepareQueryForSelect();
        
        if (!where.equals("")) {
            query += " where " + where;
        }

        if (!orderBy.equals("")) {
            query += " order by " + orderBy;
        }
        
        ResultSet rs = statement.executeQuery(query);

        return domain.vratiListuPoRS(rs);

    }

    public DomenskiObjekat update(DomenskiObjekat odo) throws Exception {
        try {
            String upit = odo.setQueryForUpdate();

            System.out.println(upit);

            Statement statement = konekcija.createStatement();

            statement.executeUpdate(upit);
            System.out.println("Uspesno izmenjen " + odo.getTableName() + " u bazi!");
            return odo;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception(ex.getLocalizedMessage() + " Greska prilikom kreiranja " + odo.getTableName() + " u bazi!\n");
        }
    }

    public boolean remove(DomenskiObjekat odo) {
        try {
            String upit = "DELETE FROM " + odo.getTableName() + " WHERE " + odo.getIdName() + "= " + odo.getId();
            System.out.println(upit);
            Statement statement = konekcija.createStatement();
            statement.executeUpdate(upit);
           System.out.println("Uspesno obrisan " + odo.getTableName() + " iz baze!");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public DomenskiObjekat insert(DomenskiObjekat odo) throws Exception {
        try {
            String upit = "INSERT INTO " + odo.getTableName() + odo.vratiAtributeZaInsert() + " VALUES (" + odo.vratiVrednostiAtributaZaInsert() + ")";
            System.out.println( upit);
            Statement statement = konekcija.createStatement();
            statement.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);
            
            if (odo.daLiAutoinkrement()) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    odo.setObjectId(rs.getLong(1));
                }
            }

        } catch (SQLException ex) {
            throw new Exception(ex.getLocalizedMessage() + "Greska prilikom kreiranja " + odo.getTableName() + " u bazi!\n");
        }
        return odo;
    }

    public void testirajParametre(String url, String username, String password) throws SQLException{
        System.out.println("Testiranje parametara:");
        try {
            konekcija = DriverManager.getConnection(url,username,password);
        }catch (SQLException ex) {
            throw new SQLException("Parametri nisu ispravni");
        }
        
        System.out.println("Sve je u redu");
    }
  
    
    
    
}
