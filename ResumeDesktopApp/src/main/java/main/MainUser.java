/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import com.company.dao.inter.CountryDaoInter;
import com.company.entity.User;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.main.Context;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Hewlet-Packard
 */
public class MainUser extends javax.swing.JFrame {

    private UserDaoInter userDao = Context.instanceUserDao();
    private CountryDaoInter countryDao = Context.instanceCountryDao();
    User loggedUser;

    public MainUser() {
        initComponents();
        loggedUser = userDao.getById(1);
        fillUserComponents();
    }

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private void fillUserComponents() {
        txbx_name.setText(loggedUser.getName());
        txbx_surname.setText(loggedUser.getSurname());
        txtAreaProfile.setText(loggedUser.getProfileDescription());
        txbx_adress.setText(loggedUser.getAddress());
        txbx_email.setText(loggedUser.getEmail());
        txbx_phone.setText(loggedUser.getPhone());

        Date dt = loggedUser.getBirthDate();
        String dtStr = sdf.format(dt);
        txbx_birthdate.setText(dtStr);

        List<Country> countries = countryDao.getAll();
        
        for(Country c : countries){
            cbCountry.addItem(c);
            cbNationality.addItem(c);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUserInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txbx_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txbx_surname = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        tpUserInfo = new javax.swing.JTabbedPane();
        pnlProfile = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaProfile = new javax.swing.JTextArea();
        pnlSkills = new javax.swing.JPanel();
        pnlEmploymentHistory = new javax.swing.JPanel();
        txbx_address = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");
        jLabel1.setMaximumSize(new java.awt.Dimension(35, 22));
        jLabel1.setMinimumSize(new java.awt.Dimension(35, 22));
        jLabel1.setPreferredSize(new java.awt.Dimension(35, 22));

        jLabel2.setText("Surname");
        jLabel2.setMaximumSize(new java.awt.Dimension(35, 22));
        jLabel2.setMinimumSize(new java.awt.Dimension(35, 22));
        jLabel2.setPreferredSize(new java.awt.Dimension(35, 22));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUserInfoLayout = new javax.swing.GroupLayout(pnlUserInfo);
        pnlUserInfo.setLayout(pnlUserInfoLayout);
        pnlUserInfoLayout.setHorizontalGroup(
            pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUserInfoLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txbx_surname, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlUserInfoLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(txbx_name, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(43, 43, 43))
        );
        pnlUserInfoLayout.setVerticalGroup(
            pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txbx_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txbx_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        txtAreaProfile.setColumns(20);
        txtAreaProfile.setRows(5);
        jScrollPane1.setViewportView(txtAreaProfile);

        javax.swing.GroupLayout pnlProfileLayout = new javax.swing.GroupLayout(pnlProfile);
        pnlProfile.setLayout(pnlProfileLayout);
        pnlProfileLayout.setHorizontalGroup(
            pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        pnlProfileLayout.setVerticalGroup(
            pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
        );

        tpUserInfo.addTab("Profile", pnlProfile);

        javax.swing.GroupLayout pnlSkillsLayout = new javax.swing.GroupLayout(pnlSkills);
        pnlSkills.setLayout(pnlSkillsLayout);
        pnlSkillsLayout.setHorizontalGroup(
            pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );
        pnlSkillsLayout.setVerticalGroup(
            pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        tpUserInfo.addTab("Skills", pnlSkills);

        javax.swing.GroupLayout pnlEmploymentHistoryLayout = new javax.swing.GroupLayout(pnlEmploymentHistory);
        pnlEmploymentHistory.setLayout(pnlEmploymentHistoryLayout);
        pnlEmploymentHistoryLayout.setHorizontalGroup(
            pnlEmploymentHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );
        pnlEmploymentHistoryLayout.setVerticalGroup(
            pnlEmploymentHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        tpUserInfo.addTab("Employment History", pnlEmploymentHistory);

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

        javax.swing.GroupLayout txbx_addressLayout = new javax.swing.GroupLayout(txbx_address);
        txbx_address.setLayout(txbx_addressLayout);
        txbx_addressLayout.setHorizontalGroup(
            txbx_addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txbx_addressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txbx_addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(txbx_addressLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txbx_adress, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(txbx_addressLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txbx_phone))
                    .addGroup(txbx_addressLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txbx_email))
                    .addGroup(txbx_addressLayout.createSequentialGroup()
                        .addGroup(txbx_addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23)
                        .addGroup(txbx_addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbNationality, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbCountry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txbx_birthdate))))
                .addContainerGap(492, Short.MAX_VALUE))
        );
        txbx_addressLayout.setVerticalGroup(
            txbx_addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txbx_addressLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(txbx_addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txbx_adress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txbx_addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txbx_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txbx_addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txbx_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txbx_addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txbx_birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txbx_addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txbx_addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        tpUserInfo.addTab("Details", txbx_address);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpUserInfo, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpUserInfo))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        try {
            String name = txbx_name.getText();
            String surname = txbx_surname.getText();
            String profileDescription = txtAreaProfile.getText();
            String address = txbx_adress.getText();
            String phone = txbx_phone.getText();
            String email = txbx_email.getText();

            java.util.Date dt = sdf.parse(txbx_birthdate.getText());
            long dateNum = dt.getTime();
            java.sql.Date dtSql = new java.sql.Date(dateNum);
            Country country = (Country) cbCountry.getSelectedItem();
            Country nationality = (Country) cbNationality.getSelectedItem();
            loggedUser.setBirthDate(dtSql);
            loggedUser.setName(name);
            loggedUser.setSurname(surname);
            loggedUser.setProfileDescription(profileDescription);
            loggedUser.setAddress(address);
            loggedUser.setPhone(phone);
            loggedUser.setEmail(email);
            loggedUser.setBirthPlace(country);
            loggedUser.setNationality(nationality);

            userDao.updateUser(loggedUser);
        } catch (Exception exp) {
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void txbx_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbx_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbx_phoneActionPerformed

    private void txbx_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbx_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbx_emailActionPerformed

    private void txbx_birthdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbx_birthdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbx_birthdateActionPerformed

    private void txbx_adressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbx_adressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbx_adressActionPerformed

    private void cbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCountryActionPerformed

    private void cbNationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNationalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNationalityActionPerformed

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
            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Country> cbCountry;
    private javax.swing.JComboBox<Country> cbNationality;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlEmploymentHistory;
    private javax.swing.JPanel pnlProfile;
    private javax.swing.JPanel pnlSkills;
    private javax.swing.JPanel pnlUserInfo;
    private javax.swing.JTabbedPane tpUserInfo;
    private javax.swing.JPanel txbx_address;
    private javax.swing.JTextField txbx_adress;
    private javax.swing.JTextField txbx_birthdate;
    private javax.swing.JTextField txbx_email;
    private javax.swing.JTextField txbx_name;
    private javax.swing.JTextField txbx_phone;
    private javax.swing.JTextField txbx_surname;
    private javax.swing.JTextArea txtAreaProfile;
    // End of variables declaration//GEN-END:variables
}
