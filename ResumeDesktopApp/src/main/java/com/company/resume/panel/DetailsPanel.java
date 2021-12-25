/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.company.resume.panel;

import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.main.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.company.resume.config.Config;

/**
 *
 * @author Hewlet-Packard
 */
public class DetailsPanel extends javax.swing.JPanel {

    public DetailsPanel() {
        initComponents();
    }
    
    private CountryDaoInter countryDao = Context.instanceCountryDao();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void fillUserComponents() {
        User loggedInUser = Config.loggedInUser;
        fillWindow();
        txbx_adress.setText(loggedInUser.getAddress());
        txbx_email.setText(loggedInUser.getEmail());
        txbx_phone.setText(loggedInUser.getPhone());

        Date dt = loggedInUser.getBirthDate();
        String dtStr = sdf.format(dt);
        txbx_birthdate.setText(dtStr);
        cbCountry.setSelectedItem(loggedInUser.getBirthPlace());
    }

    private void fillWindow() {
        List<Country> countries = countryDao.getAll();
        for (Country c : countries) {
            cbCountry.addItem(c);
            cbNationality.addItem(c);
        }
    }

    public void fillUser(User user){
        
        try {
           
            String address = txbx_adress.getText();
            String phone = txbx_phone.getText();
            String email = txbx_email.getText();

            java.util.Date dt = sdf.parse(txbx_birthdate.getText());
            long dateNum = dt.getTime();
            java.sql.Date dtSql = new java.sql.Date(dateNum);
            Country country = (Country) cbCountry.getSelectedItem();
            Country nationality = (Country) cbNationality.getSelectedItem();
          
            user.setBirthDate(dtSql);
            user.setAddress(address);
            user.setPhone(phone);
            user.setEmail(email);
            user.setBirthPlace(country);
            user.setNationality(nationality);
            
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDetails = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txbx_adress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txbx_phone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txbx_email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txbx_birthdate = new javax.swing.JTextField();
        cbCountry = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbNationality = new javax.swing.JComboBox<>();

        jLabel3.setText("Address");

        txbx_adress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbx_adressActionPerformed(evt);
            }
        });

        jLabel4.setText("Phone");

        txbx_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbx_phoneActionPerformed(evt);
            }
        });

        jLabel5.setText("Email");

        txbx_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbx_emailActionPerformed(evt);
            }
        });

        jLabel6.setText("Birthdate");

        txbx_birthdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbx_birthdateActionPerformed(evt);
            }
        });

        cbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCountryActionPerformed(evt);
            }
        });

        jLabel7.setText("Birthplace");

        jLabel8.setText("Nationality");

        cbNationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNationalityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txbx_adress, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txbx_phone))
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txbx_email))
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23)
                        .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbNationality, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbCountry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txbx_birthdate))))
                .addContainerGap(482, Short.MAX_VALUE))
        );
        pnlDetailsLayout.setVerticalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txbx_adress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txbx_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txbx_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txbx_birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txbx_adressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbx_adressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbx_adressActionPerformed

    private void txbx_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbx_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbx_phoneActionPerformed

    private void txbx_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbx_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbx_emailActionPerformed

    private void txbx_birthdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbx_birthdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbx_birthdateActionPerformed

    private void cbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCountryActionPerformed

    private void cbNationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNationalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNationalityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Country> cbCountry;
    private javax.swing.JComboBox<Country> cbNationality;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JTextField txbx_adress;
    private javax.swing.JTextField txbx_birthdate;
    private javax.swing.JTextField txbx_email;
    private javax.swing.JTextField txbx_phone;
    // End of variables declaration//GEN-END:variables
}
