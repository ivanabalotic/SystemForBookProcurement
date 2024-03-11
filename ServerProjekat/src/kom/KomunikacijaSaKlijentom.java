/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Iva
 */
public class KomunikacijaSaKlijentom {
    private static KomunikacijaSaKlijentom instanca;

    private KomunikacijaSaKlijentom() {
    }

    public static KomunikacijaSaKlijentom getInstanca() {
        if (instanca == null) {
            instanca = new KomunikacijaSaKlijentom();
        }

        return instanca;
    }

    public KlijentskiZahtev prihvatiZahtev(Socket soket) throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(soket.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaKlijentom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KomunikacijaSaKlijentom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kz;

    }
    
    public void posaljiOdgovor(Socket soket, ServerskiOdgovor so) {
        try {
            ObjectOutputStream ous = new ObjectOutputStream(soket.getOutputStream());
            ous.writeObject(so);
            
            //out.flush();
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaKlijentom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
