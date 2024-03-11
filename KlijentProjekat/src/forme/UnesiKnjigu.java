/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import domen.Autor;
import domen.Kategorija;
import domen.Knjiga;
import domen.Napisao;
import domen.Pismo;
import domen.Zanr;
import interfejsi.DomenskiObjekat;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logika.KontrolerKlijent;
import modeli.ModelTabeleAutori;
import modeli.ModelTabeleZanrovi;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Iva
 */
public class UnesiKnjigu extends javax.swing.JDialog {

    private static ResourceBundle bundle_sr_RS;
    HashMap<String, Zanr> zanrLista;
    HashMap<String, Enum> pismoLista;
    Autor nov = null;
    
    /**
     * Creates new form UnesiKnjigu
     */
    public UnesiKnjigu(javax.swing.JDialog parent, boolean modal, ResourceBundle bundle_sr_RS) {
        super(parent, modal);
        this.bundle_sr_RS = bundle_sr_RS;
        initComponents();
        setLocationRelativeTo(null);
        
        zanrLista = new HashMap<>();
        pismoLista = new HashMap<>();
        
        postaviSliku();
        
        KontrolerKlijent.getInstanca().setuKnjigu(this);
        
        tabelaAutora.setModel(new ModelTabeleAutori(bundle_sr_RS));
        tabelaZanrovi.setModel(new ModelTabeleZanrovi(bundle_sr_RS));
        
        try {
            popuniKombo();
        } catch (Exception ex) {
            Logger.getLogger(UnesiKnjigu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        addWindowListener(new WindowAdapter()
//        {
//            @Override
//            public void windowClosing(WindowEvent e)
//            {
//                if (parent != null) {
//                    parent.setEnabled(true);
//                }
//
//                dispose();
//            }
//        });
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
        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtGodina = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCena = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbPismo = new javax.swing.JComboBox();
        txtIzdavac = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbAutori = new javax.swing.JComboBox();
        btnDodajAutora = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAutora = new javax.swing.JTable();
        btnObrisiAutora = new javax.swing.JButton();
        btnNovAutor = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbZanrovi = new javax.swing.JComboBox();
        btnDodajZanr = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaZanrovi = new javax.swing.JTable();
        btnObrisiZanr = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        lblJezik = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle_sr_RS.getString("UNESI NOVU KNJIGU")));

        jLabel1.setText(bundle_sr_RS.getString("NAZIV KNJIGE:")); // NOI18N

        jLabel2.setText(bundle_sr_RS.getString("IZDAVAČ:")); // NOI18N

        jLabel3.setText(bundle_sr_RS.getString("GODINA IZDAVANJA:")); // NOI18N

        jLabel4.setText(bundle_sr_RS.getString("PISMO:")); // NOI18N

        jLabel5.setText(bundle_sr_RS.getString("CENA:")); // NOI18N

        cbPismo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNaziv))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGodina))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbPismo, 0, 191, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCena))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIzdavac)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIzdavac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGodina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbPismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle_sr_RS.getString("AUTORI")));

        jLabel6.setText(bundle_sr_RS.getString("AUTOR")); // NOI18N

        cbAutori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDodajAutora.setText(bundle_sr_RS.getString("DODAJ")); // NOI18N
        btnDodajAutora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajAutoraActionPerformed(evt);
            }
        });

        tabelaAutora.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaAutora);

        btnObrisiAutora.setText(bundle_sr_RS.getString("OBRIŠI AUTORA")); // NOI18N
        btnObrisiAutora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiAutoraActionPerformed(evt);
            }
        });

        btnNovAutor.setText(bundle_sr_RS.getString("DODAJ NOVOG AUTORA"));
        btnNovAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cbAutori, 0, 208, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDodajAutora))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnObrisiAutora, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNovAutor, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbAutori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodajAutora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnObrisiAutora)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle_sr_RS.getString("ZANROVI")));

        jLabel8.setText(bundle_sr_RS.getString("ŽANR")); // NOI18N

        cbZanrovi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDodajZanr.setText(bundle_sr_RS.getString("DODAJ")); // NOI18N
        btnDodajZanr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajZanrActionPerformed(evt);
            }
        });

        tabelaZanrovi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelaZanrovi);

        btnObrisiZanr.setText(bundle_sr_RS.getString("OBRIŠI ŽANR")); // NOI18N
        btnObrisiZanr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiZanrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cbZanrovi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDodajZanr))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnObrisiZanr)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbZanrovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodajZanr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnObrisiZanr)
                .addContainerGap())
        );

        btnSacuvaj.setText(bundle_sr_RS.getString("SAČUVAJ KNJIGU")); // NOI18N
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSacuvaj, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblJezik, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJezik, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSacuvaj)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajAutoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajAutoraActionPerformed
        // TODO add your handling code here:
        Autor autor = (Autor) cbAutori.getSelectedItem();
        Napisao nap = new Napisao(null, autor);
        ModelTabeleAutori mt = (ModelTabeleAutori) tabelaAutora.getModel();
        
        mt.dodajAutora(nap);
    }//GEN-LAST:event_btnDodajAutoraActionPerformed

    private void btnObrisiAutoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiAutoraActionPerformed
        // TODO add your handling code here:
        int red = tabelaAutora.getSelectedRow();
        if (red != -1) {
            ModelTabeleAutori mt = (ModelTabeleAutori) tabelaAutora.getModel();
            mt.obrisiAutora(red);
        } else {
            JOptionPane.showMessageDialog(this, bundle_sr_RS.getString("ODABERI AUTORA"));
        }
    }//GEN-LAST:event_btnObrisiAutoraActionPerformed

    private void btnDodajZanrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajZanrActionPerformed
        // TODO add your handling code here:
        String zanrS = (String) cbZanrovi.getSelectedItem();
        
        Zanr zanr = zanrLista.get(zanrS);
        
        Kategorija k = new Kategorija(null, zanr);
        ModelTabeleZanrovi mt = (ModelTabeleZanrovi) tabelaZanrovi.getModel();
        
        mt.dodajZanr(k);
    }//GEN-LAST:event_btnDodajZanrActionPerformed

    private void btnObrisiZanrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiZanrActionPerformed
        // TODO add your handling code here:
        int red = tabelaZanrovi.getSelectedRow();
        if (red != -1) {
            ModelTabeleZanrovi mt = (ModelTabeleZanrovi) tabelaZanrovi.getModel();
            mt.obrisiZanr(red);
        } else {
            JOptionPane.showMessageDialog(this, bundle_sr_RS.getString("ODABERI ZANR"));
        }
    }//GEN-LAST:event_btnObrisiZanrActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        // TODO add your handling code here:
        String naziv = txtNaziv.getText();
        String izdavac = txtIzdavac.getText();
        String godinaS = txtGodina.getText();
        String cenaS = txtCena.getText();

//        Pismo pismo = (Pismo) cbPismo.getSelectedItem();

        String pis = (String) cbPismo.getSelectedItem();
        Pismo pismo = (Pismo) pismoLista.get(pis);

        ModelTabeleAutori mta = (ModelTabeleAutori) tabelaAutora.getModel();
        ModelTabeleZanrovi mtz = (ModelTabeleZanrovi) tabelaZanrovi.getModel();

        ArrayList<Napisao> listaAutora = mta.getLista();
        ArrayList<Kategorija> listaZanrova = mtz.getLista();

        try {
            int godina = Integer.parseInt(godinaS);
            Double cena = Double.parseDouble(cenaS);

            Knjiga knj = new Knjiga(-1, naziv, izdavac, godina, pismo, cena, listaAutora, listaZanrova);

            KontrolerKlijent.getInstanca().posaljiZahtevZaUnesKnjige(knj);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, bundle_sr_RS.getString("CENA I/ILI GODINA NISU U DOBROM OBLIKU"));
        }


    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void lblJezikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJezikMouseClicked
        // TODO add your handling code here:
        if (bundle_sr_RS == ResourceBundle.getBundle("forme/Bundle_en")) {
            bundle_sr_RS = ResourceBundle.getBundle("forme/Bundle_sr_RS");
        } else {
            bundle_sr_RS = ResourceBundle.getBundle("forme/Bundle_en");
        }
        
        postaviSliku();
        
        btnSacuvaj.setText(bundle_sr_RS.getString("SAČUVAJ KNJIGU"));
        btnObrisiZanr.setText(bundle_sr_RS.getString("OBRIŠI ŽANR"));
        btnDodajZanr.setText(bundle_sr_RS.getString("DODAJ"));
        btnNovAutor.setText(bundle_sr_RS.getString("DODAJ NOVOG AUTORA"));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle_sr_RS.getString("ZANROVI")));
        jLabel8.setText(bundle_sr_RS.getString("ŽANR"));
        btnObrisiAutora.setText(bundle_sr_RS.getString("OBRIŠI AUTORA"));
        btnDodajAutora.setText(bundle_sr_RS.getString("DODAJ"));
        jLabel6.setText(bundle_sr_RS.getString("AUTOR"));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle_sr_RS.getString("AUTORI")));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle_sr_RS.getString("UNESI NOVU KNJIGU")));
        jLabel1.setText(bundle_sr_RS.getString("NAZIV KNJIGE:")); // NOI18N
        jLabel2.setText(bundle_sr_RS.getString("IZDAVAČ:")); // NOI18N
        jLabel3.setText(bundle_sr_RS.getString("GODINA IZDAVANJA:")); // NOI18N
        jLabel4.setText(bundle_sr_RS.getString("PISMO:")); // NOI18N
        jLabel5.setText(bundle_sr_RS.getString("CENA:"));
//        tabelaAutora.setModel(new ModelTabeleAutori(bundle_sr_RS));
//        tabelaZanrovi.setModel(new ModelTabeleZanrovi(bundle_sr_RS));
        
        ModelTabeleAutori mta = (ModelTabeleAutori) tabelaAutora.getModel();
        mta.setBundle_sr_RS(bundle_sr_RS);
        
        ModelTabeleZanrovi mtz = (ModelTabeleZanrovi) tabelaZanrovi.getModel();
        mtz.setBundle_sr_RS(bundle_sr_RS);
        
        try {
            popuniKombo();
        } catch (Exception ex) {
            Logger.getLogger(UnesiKnjigu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_lblJezikMouseClicked

    private void btnNovAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovAutorActionPerformed
        // TODO add your handling code here:
        UnesiAutora ua = new UnesiAutora(this, true, bundle_sr_RS);
        ua.setVisible(true);
    }//GEN-LAST:event_btnNovAutorActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajAutora;
    private javax.swing.JButton btnDodajZanr;
    private javax.swing.JButton btnNovAutor;
    private javax.swing.JButton btnObrisiAutora;
    private javax.swing.JButton btnObrisiZanr;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cbAutori;
    private javax.swing.JComboBox cbPismo;
    private javax.swing.JComboBox cbZanrovi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblJezik;
    private javax.swing.JTable tabelaAutora;
    private javax.swing.JTable tabelaZanrovi;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtGodina;
    private javax.swing.JTextField txtIzdavac;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void popuniKombo() throws Exception {
        cbPismo.removeAllItems();
        
        for (Enum pismo : Pismo.values()) {
//            cbPismo.addItem(pismo);
            pismoLista.put(bundle_sr_RS.getString(pismo + ""), pismo);
            cbPismo.addItem(bundle_sr_RS.getString(pismo + ""));
        }
        
        KontrolerKlijent.getInstanca().posaljiZahtevZaVracanjeZanrova();
        
        KontrolerKlijent.getInstanca().posaljiZahtevZaVracanjeAutora();
       
    }

    public void unesiKnjigu(ServerskiOdgovor so) {
        try {
            if (so.getIzuzetak() != null) {
                throw so.getIzuzetak();
            }

            Knjiga k = (Knjiga) so.getOdgovor();

            if (k.getKnjigaID() != -1) {
                JOptionPane.showMessageDialog(this, bundle_sr_RS.getString("USPESNO UNETA KNJIGA"));
                
                if (this.getParent() != null) {
                    ((UnesiNarudzbinu) this.getParent()).osvezi2();
                }
                
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, bundle_sr_RS.getString("NIJE UNETA KNJIGA"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, bundle_sr_RS.getString("NIJE UNETA KNJIGA") + "\n" + ex.getMessage());
        }
    }

    public void postaviZanrove(ServerskiOdgovor so) {
        try {
            if (so.getIzuzetak() != null) {
                throw so.getIzuzetak();
            }

            cbZanrovi.removeAllItems();
            ArrayList<Zanr> zanrovi = (ArrayList<Zanr>) so.getOdgovor();
            
            for (Zanr zanr : zanrovi) {
//                cbZanrovi.addItem(zanr);

                zanrLista.put(bundle_sr_RS.getString(zanr.getNazivZanra()), zanr);
                cbZanrovi.addItem(bundle_sr_RS.getString(zanr.getNazivZanra()));
            }
            
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, bundle_sr_RS.getString("DOSLO JE DO GRESKE") + "\n" + e.getMessage());
        }

    }

    public void postaviAutore(ServerskiOdgovor so) {
        try {
            if (so.getIzuzetak() != null) {
                throw so.getIzuzetak();
            }

            cbAutori.removeAllItems();
            ArrayList<DomenskiObjekat> autori = (ArrayList<DomenskiObjekat>) so.getOdgovor();
            
            for (DomenskiObjekat domenskiObjekat : autori) {
                cbAutori.addItem(domenskiObjekat);
            }
            
            if (nov != null) {
                cbAutori.setSelectedItem(nov);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, bundle_sr_RS.getString("DOSLO JE DO GRESKE") + "\n" + e.getMessage());
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

    public void dodajAutora(Autor nov) {
        this.nov = nov;
        KontrolerKlijent.getInstanca().posaljiZahtevZaVracanjeAutora();
    }
    
}