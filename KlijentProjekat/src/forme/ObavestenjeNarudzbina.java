/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import domen.Narudzbina;
import domen.StavkaNarudzbine;
import jasper.Pomocna;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Iva
 */
public class ObavestenjeNarudzbina extends javax.swing.JDialog {

    private static ResourceBundle bundle_sr_RS;
    Narudzbina n;
    /**
     * Creates new form ObavestenjeNarudzbina
     */
    public ObavestenjeNarudzbina(java.awt.Frame parent, boolean modal, Narudzbina n, boolean izmena, ResourceBundle bundle_sr_RS) {
        super(parent, modal);
        this.bundle_sr_RS = bundle_sr_RS;
        initComponents();
        setLocationRelativeTo(null);
        
        this.n = n;
        
        if (izmena) {
            txtObavestenje.setText(bundle_sr_RS.getString("USPESNO IZMENJENA NARUDZBINA"));
        }
        
        btnPrikaziRacun.setVisible(true);
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtObavestenje = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnPrikaziRacun = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtObavestenje.setText(bundle_sr_RS.getString("USPEŠNO UBAČENA NOVA NARUDŽBINA!")); // NOI18N

        jButton2.setText(bundle_sr_RS.getString("U REDU")); // NOI18N
        jButton2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jButton2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnPrikaziRacun.setText(bundle_sr_RS.getString("PRIKAŽI RAČUN")); // NOI18N
        btnPrikaziRacun.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                btnPrikaziRacunAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btnPrikaziRacun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziRacunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(txtObavestenje)
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrikaziRacun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txtObavestenje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnPrikaziRacun)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jButton2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2AncestorAdded

    private void btnPrikaziRacunAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btnPrikaziRacunAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrikaziRacunAncestorAdded

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPrikaziRacunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziRacunActionPerformed
        InputStream input = null;
        try {
//            String fajl = "/racun.pdf";
            
            ArrayList<Pomocna> lista = new ArrayList<>();
            for (StavkaNarudzbine sn : n.getStavke()) {
                if (!sn.getIzmene().equals("obrisi")) {
                    lista.add(new Pomocna(n.getKupac() + "", n.getKupac().getAdresa(), n.getKupac().getBrojTelefona(), n.getKupac().getEmail(), n.getKorisnik() + "", sn.getKnjiga() + "", sn.getKnjiga().getCena(), sn.getKolicina(), sn.getUkupanIznosStavkeNarudzbine(), n.getUkupanIznos()));
                }
            }
            
            JRBeanCollectionDataSource stavkeJRBeana = new JRBeanCollectionDataSource(lista);
            
            Map<String, Object> parametri = new HashMap();
            parametri.put("CollectionBeanParam", stavkeJRBeana);
            
            if (bundle_sr_RS == ResourceBundle.getBundle("forme/Bundle_en")) {
                input = new FileInputStream(new File("JasperReportEN.jrxml"));
            } else input = new FileInputStream(new File("JasperReport.jrxml"));
            
            JasperDesign jd = JRXmlLoader.load(input);
            
            JasperReport jr = JasperCompileManager.compileReport(jd);
            
//            JasperPrint jp = JasperFillManager.fillReport(jr, parametri, new JREmptyDataSource());
            
            JasperPrint jp = JasperFillManager.fillReport(jr, parametri, new JRBeanCollectionDataSource(lista));

//            JasperViewer.viewReport(jp);
            JasperViewer viewer = new JasperViewer(jp, false);
            viewer.setVisible(true);
            viewer.setAlwaysOnTop(true);

            OutputStream output = new FileOutputStream(new File("racun.pdf"));
            JasperExportManager.exportReportToPdfStream(jp, output);
            
            dispose();
        } catch (FileNotFoundException | JRException ex) {
            Logger.getLogger(ObavestenjeNarudzbina.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(ObavestenjeNarudzbina.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_btnPrikaziRacunActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrikaziRacun;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel txtObavestenje;
    // End of variables declaration//GEN-END:variables
}
