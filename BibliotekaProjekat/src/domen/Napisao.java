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
public class Napisao implements DomenskiObjekat {
    private Knjiga knjiga;
    private Autor autor;

    public Napisao() {
    }

    public Napisao(Knjiga knjiga, Autor autor) {
        this.knjiga = knjiga;
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String getTableName() {
        return "napisao";
    }

    @Override
    public boolean daLiAutoinkrement() {
        return false;
    }

    @Override
    public void setObjectId(long aLong) {
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(KnjigaID, AutorID)";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        return knjiga.getKnjigaID() + ", " + autor.getAutorID();
    }

    @Override
    public String getIdName() {
        return "";
    }

    @Override
    public ArrayList<DomenskiObjekat> vratiListuPoRS(ResultSet rs) throws Exception {
        ArrayList<DomenskiObjekat> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                Autor a = new Autor(rs.getInt("AutorID"), rs.getString("ImeAutora"), rs.getString("PrezimeAutora"));
                
                String pisS = rs.getString("Pismo");
                Pismo pis = Pismo.getPismo(pisS);
                Knjiga k = new Knjiga(rs.getInt("KnjigaID"), rs.getString("NazivKnjige"), rs.getString("Izdavac"), rs.getInt("GodinaIzdavanja"), pis, rs.getDouble("Cena"));
                
                lista.add(new Napisao(k, a));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE napisao SET AutorID = " + autor.getAutorID() + " WHERE KnjigaID = " + knjiga.getKnjigaID();
    }

    @Override
    public String prepareQueryForSelect() {
        return "SELECT * FROM napisao n JOIN knjiga k ON n.KnjigaID = k.KnjigaID JOIN autor a ON a.AutorID = n.AutorID";
    }

    @Override
    public long getId() {
        return -1;
    }
    
    
}
