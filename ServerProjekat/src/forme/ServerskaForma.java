/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logika.KontrolerServer;
import modeli.ModelTabeleAktivnihKor;
import niti.PokretanjeServera;

/**
 *
 * @author Iva
 */
public class ServerskaForma extends javax.swing.JFrame {

    private static ResourceBundle bundle_sr_RS = ResourceBundle.getBundle("forme/Bundle_sr_RS");
    PokretanjeServera ps;
    boolean prvoPokretanje = true;

    /**
     * Creates new form ServerskaForma
     */
    public ServerskaForma() {
        initComponents();
        jPanel1.setBackground(Color.WHITE);
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        
        txtStatus.setForeground(Color.red);
        btnZaustavi.setVisible(false);
        ps = new PokretanjeServera(this);
        
        KontrolerServer.getInstanca().setSf(this);
        
        ulogovani.setModel(new ModelTabeleAktivnihKor(bundle_sr_RS));
        
        postaviSliku("/slike/eng.png");
        postaviSliku2();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ps.zaustavi();
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

        jPanel1 = new javax.swing.JPanel();
        btnPokreni = new javax.swing.JButton();
        btnZaustavi = new javax.swing.JButton();
        txtStatus = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblJezik = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ulogovani = new javax.swing.JTable();
        txtPozadina = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miKonfiguracija = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPokreni.setText(bundle_sr_RS.getString("POKRENI SERVER")); // NOI18N
        btnPokreni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniActionPerformed(evt);
            }
        });

        btnZaustavi.setText(bundle_sr_RS.getString("ZAUSTAVI SERVER")); // NOI18N
        btnZaustavi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZaustaviActionPerformed(evt);
            }
        });

        txtStatus.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtStatus.setText(bundle_sr_RS.getString("SERVER NIJE POKRENUT!")); // NOI18N

        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        lblStatus.setText(bundle_sr_RS.getString("STATUS SERVERA:")); // NOI18N

        lblJezik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJezikMouseClicked(evt);
            }
        });

        ulogovani.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(ulogovani);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblStatus)
                        .addGap(18, 18, 18)
                        .addComponent(txtStatus))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPokreni)
                        .addGap(18, 18, 18)
                        .addComponent(btnZaustavi)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(391, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPozadina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblJezik, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJezik, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(txtPozadina, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStatus)
                            .addComponent(txtStatus))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPokreni)
                            .addComponent(btnZaustavi))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jMenu1.setText(bundle_sr_RS.getString("BAZA")); // NOI18N

        miKonfiguracija.setText(bundle_sr_RS.getString("KONFIGURISI BAZU")); // NOI18N
        miKonfiguracija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKonfiguracijaActionPerformed(evt);
            }
        });
        jMenu1.add(miKonfiguracija);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miKonfiguracijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKonfiguracijaActionPerformed
        // TODO add your handling code here:
        KonfiguracijaDijalog kd = new KonfiguracijaDijalog(this, true, bundle_sr_RS);
        kd.setVisible(true);
    }//GEN-LAST:event_miKonfiguracijaActionPerformed

    private void btnPokreniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniActionPerformed
        // TODO add your handling code here:
        if (prvoPokretanje) {
            ps.start();
            prvoPokretanje = false;
            return;
        }

        uspesnoPokretanje();
        ps.run();
        ps.pokreni();
        
    }//GEN-LAST:event_btnPokreniActionPerformed

    private void btnZaustaviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZaustaviActionPerformed
        // TODO add your handling code here:
        txtStatus.setText(bundle_sr_RS.getString("SERVER NIJE POKRENUT!"));
        txtStatus.setForeground(Color.red);
        btnPokreni.setEnabled(true);
        btnZaustavi.setVisible(false);
        ps.zaustavi();
    }//GEN-LAST:event_btnZaustaviActionPerformed

    private void lblJezikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJezikMouseClicked
        // TODO add your handling code here:
        if (bundle_sr_RS == ResourceBundle.getBundle("forme/Bundle_en")) {
            bundle_sr_RS = ResourceBundle.getBundle("forme/Bundle_sr_RS");
            postaviSliku("/slike/eng.png");
        } else {
            bundle_sr_RS = ResourceBundle.getBundle("forme/Bundle_en");
            postaviSliku("/slike/srb.png");
        }

        jMenu1.setText(bundle_sr_RS.getString("BAZA"));

        btnPokreni.setText(bundle_sr_RS.getString("POKRENI SERVER"));
        btnZaustavi.setText(bundle_sr_RS.getString("ZAUSTAVI SERVER"));
        lblStatus.setText(bundle_sr_RS.getString("STATUS SERVERA"));
        miKonfiguracija.setText(bundle_sr_RS.getString("KONFIGURISI BAZU"));

        if (ps.isRadi()) {
            txtStatus.setText(bundle_sr_RS.getString("SERVER JE POKRENUT!"));
        } else {
            txtStatus.setText(bundle_sr_RS.getString("SERVER NIJE POKRENUT!"));
        }
        
        ModelTabeleAktivnihKor mt = (ModelTabeleAktivnihKor) ulogovani.getModel();
        mt.setBundle_sr_RS(bundle_sr_RS);
    }//GEN-LAST:event_lblJezikMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerskaForma().setVisible(true);
            }
        });
    }

    public void uspesnoPokretanje() {
        txtStatus.setText(bundle_sr_RS.getString("SERVER JE POKRENUT!"));
        txtStatus.setForeground(new Color(0,153,0));
        btnPokreni.setEnabled(false);
        btnZaustavi.setVisible(true);
    }

    public void neuspesnoPokretanje() {
        JOptionPane.showMessageDialog(this, bundle_sr_RS.getString("NEUSPESNO POKRETANJE SERVERA"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPokreni;
    private javax.swing.JButton btnZaustavi;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJezik;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenuItem miKonfiguracija;
    private javax.swing.JLabel txtPozadina;
    private javax.swing.JLabel txtStatus;
    private javax.swing.JTable ulogovani;
    // End of variables declaration//GEN-END:variables


    private void postaviSliku(String jezik) {
        ImageIcon ikona = new javax.swing.ImageIcon(getClass().getResource(jezik));
        Image img = ikona.getImage() ;  
        Image newimg = img.getScaledInstance(lblJezik.getWidth(), lblJezik.getHeight(), Image.SCALE_SMOOTH);
        ikona = new ImageIcon( newimg );
        lblJezik.setIcon(ikona);
    }

    private void postaviSliku2() {
        ImageIcon ikona = new javax.swing.ImageIcon(getClass().getResource("/slike/pozadina2.jpg"));
        Image img = ikona.getImage() ;  
        Image newimg = img.getScaledInstance(txtPozadina.getWidth(), txtPozadina.getHeight(), Image.SCALE_SMOOTH);
        ikona = new ImageIcon( newimg );
        txtPozadina.setIcon(ikona);
    }

    public void postaviTabelu(ArrayList<String> lista) {
        ModelTabeleAktivnihKor mt = (ModelTabeleAktivnihKor) ulogovani.getModel();
        mt.setLista(lista);
    }

    
}
