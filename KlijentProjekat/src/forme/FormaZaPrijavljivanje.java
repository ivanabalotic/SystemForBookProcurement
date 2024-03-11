/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domen.Korisnik;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logika.KontrolerKlijent;
import niti.ObradaOdgovora;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Iva
 */
public class FormaZaPrijavljivanje extends javax.swing.JFrame {

    private static ResourceBundle bundle_sr_RS = ResourceBundle.getBundle("forme/Bundle_sr_RS");
    /**
     * Creates new form LoginForma
     */
    public FormaZaPrijavljivanje(boolean prvi) {
        initComponents();
        setLocationRelativeTo(null);
        
        postaviSliku();
        
        KontrolerKlijent.getInstanca().setLf(this);
        
        if (prvi) {
            ObradaOdgovora o = new ObradaOdgovora();
            o.start();
        }
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                KontrolerKlijent.getInstanca().posaljiZahtevZaGasenjeKorisnika();
                dispose();
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOtvoriNalog = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        txtKorIme = new javax.swing.JTextField();
        btnPrijavi = new javax.swing.JButton();
        lblJezik = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnOtvoriNalog.setText(bundle_sr_RS.getString("OTVORI NOVI NALOG")); // NOI18N
        btnOtvoriNalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtvoriNalogActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Prijava korisnika"));

        jLabel1.setText(bundle_sr_RS.getString("KORISNIČKO IME:")); // NOI18N

        jLabel2.setText(bundle_sr_RS.getString("LOZINKA:")); // NOI18N

        btnPrijavi.setText(bundle_sr_RS.getString("PRIJAVI SE")); // NOI18N
        btnPrijavi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrijaviActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKorIme, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtPass)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPrijavi)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKorIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrijavi)
                .addContainerGap())
        );

        lblJezik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJezikMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOtvoriNalog)
                        .addGap(18, 18, 18)
                        .addComponent(lblJezik, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOtvoriNalog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblJezik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtvoriNalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtvoriNalogActionPerformed
        // TODO add your handling code here:
        RegistracijaForma rf = new RegistracijaForma(bundle_sr_RS);
        rf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnOtvoriNalogActionPerformed

    private void btnPrijaviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrijaviActionPerformed
        // TODO add your handling code here:
        
        
        String korisnicko = txtKorIme.getText();
        String lozinka = String.copyValueOf(txtPass.getPassword());
        
        if(korisnicko.isEmpty() || lozinka.isEmpty()){
            JOptionPane.showMessageDialog(this, bundle_sr_RS.getString("MORATE POPUNITI SVA POLJA"));
            return;
        }
        
        Korisnik k = new Korisnik();
        k.setUsername(korisnicko);
        k.setPassword(lozinka);
        
        KontrolerKlijent.getInstanca().posaljiZahtevZaPrijavljivanje(k);
    }//GEN-LAST:event_btnPrijaviActionPerformed

    private void lblJezikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJezikMouseClicked
        // TODO add your handling code here:
        if (bundle_sr_RS == ResourceBundle.getBundle("forme/Bundle_en")) {
            bundle_sr_RS = ResourceBundle.getBundle("forme/Bundle_sr_RS");
        } else {
            bundle_sr_RS = ResourceBundle.getBundle("forme/Bundle_en");
        }
        
        postaviSliku();
        
        btnPrijavi.setText(bundle_sr_RS.getString("PRIJAVI SE"));
        jLabel2.setText(bundle_sr_RS.getString("LOZINKA:"));
        jLabel1.setText(bundle_sr_RS.getString("KORISNIČKO IME:"));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle_sr_RS.getString("PRIJAVA KORISNIKA")));
        btnOtvoriNalog.setText(bundle_sr_RS.getString("OTVORI NOVI NALOG"));
        
    }//GEN-LAST:event_lblJezikMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FormaZaPrijavljivanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormaZaPrijavljivanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormaZaPrijavljivanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormaZaPrijavljivanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormaZaPrijavljivanje().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOtvoriNalog;
    private javax.swing.JButton btnPrijavi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblJezik;
    private javax.swing.JTextField txtKorIme;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables

    public void ulogujKlijenta(ServerskiOdgovor so) {
        try {
            if (so.getIzuzetak() != null) {
                throw so.getIzuzetak();
            }

            Korisnik ulogovan = (Korisnik) so.getOdgovor();

            if (ulogovan != null && ulogovan.getKorisnikID() != 0) {
                JOptionPane.showMessageDialog(this, bundle_sr_RS.getString("DOBRODOŠLI!") );
                KlijentskaForma kf = new KlijentskaForma(ulogovan, bundle_sr_RS);
                kf.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, bundle_sr_RS.getString("Uneli ste nevazece podatke"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, bundle_sr_RS.getString("NEUSPENO"));
        }
    }

    private void postaviSliku() {
        String jezik;
        
        if (bundle_sr_RS == ResourceBundle.getBundle("forme/Bundle_en")) {
            jezik = "/slike/srb.png";
        } else {
            jezik = "/slike/eng.png";
        }
        
        ImageIcon ikona = new javax.swing.ImageIcon(getClass().getResource(jezik));
        Image img = ikona.getImage() ;  
        Image newimg = img.getScaledInstance(lblJezik.getWidth(), lblJezik.getHeight(), Image.SCALE_SMOOTH);
        ikona = new ImageIcon( newimg );
        lblJezik.setIcon(ikona);
    }

   
}
