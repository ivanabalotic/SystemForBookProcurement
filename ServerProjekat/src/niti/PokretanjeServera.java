/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import forme.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.KontrolerServer;

/**
 *
 * @author Iva
 */
public class PokretanjeServera extends Thread{
    ServerskaForma sf;
    ServerSocket server;
    private static int port = 9000;
    private static int portN = -1;
    boolean radi = true;
    
    
    public PokretanjeServera(ServerskaForma sf) {
        this.sf = sf;
        try {
            server = new ServerSocket(9000);
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void proveriPort(int p) throws IOException{
        try {
            ServerSocket so = new ServerSocket(p);
            portN = p;
            so.close();
        } catch (IOException e) {
            throw new IOException("Port nije slobodan");
        } 
        
    }
    
    public static void postaviPort(int port) {
        if(portN == -1){
            return;
        }
        port = portN;
    }

    @Override
    public void run() {
            try {
                sf.uspesnoPokretanje();
                while(radi){
                    Socket soket = server.accept();
                    System.out.println("Klijent se povezao");
                    ObradaZahteva oz = new ObradaZahteva(soket, this);
                    oz.start();
                    KontrolerServer.getInstanca().dodajKlijenta(oz);
                    
                }
            } catch (IOException ex) {
                sf.neuspesnoPokretanje();
                //Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    public void pokreni() {
        radi = true;
    }
    
    public void zaustavi() {
        KontrolerServer.getInstanca().odjaviSveKlijente();
        radi = false;
    }

    public boolean isRadi() {
        return radi;
    }
    
    
    
}
