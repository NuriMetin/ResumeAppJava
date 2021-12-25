package com.company.resume.panel;

import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.UserSkill;
import com.company.main.Context;
import com.company.resume.config.Config;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hewlet-Packard
 */
public class SkillsPanel extends javax.swing.JPanel {

    private SkillDaoInter skillDao = Context.instanceSkillDao();
    private UserSkillDaoInter userSkillDao = Context.instanceUserSkillDao();

    public SkillsPanel() {
        initComponents();
    }

    public void fillUserComponents() {
        fillWindow();
    }

    private void fillWindow() {
        List<Skill> skills = skillDao.getAll();
        for (Skill skill : skills) {
            cbx_skill.addItem(skill);
        }

        fillTable();
    }
    private List<UserSkill> userSkills;

    private void fillTable() {
        userSkills = userSkillDao.getAllSkillsByUserId(Config.loggedInUser.getId());

        Vector<Vector> rows = new Vector<>();

        for (UserSkill userSkill : userSkills) {
            Vector row = new Vector();
            row.add(userSkill.getSkill());
            row.add(userSkill.getPower());
            rows.add(row);
        }

        Vector<String> columns = new Vector();
        columns.add("Skill");
        columns.add("Power");

        DefaultTableModel tblModel = new DefaultTableModel(rows, columns);

        tbl_skill.setModel(tblModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_skill = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txbx_skill = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        slider_power = new javax.swing.JSlider();
        cbx_skill = new javax.swing.JComboBox<>();
        btn_add = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_saveSkill = new javax.swing.JButton();

        tbl_skill.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_skill);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Skill:");

        txbx_skill.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txbx_skill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbx_skillActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Power");

        slider_power.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        slider_power.setMaximum(10);
        slider_power.setMinimum(1);
        slider_power.setMinorTickSpacing(1);
        slider_power.setPaintLabels(true);
        slider_power.setPaintTicks(true);
        slider_power.setSnapToTicks(true);
        slider_power.setValue(1);

        btn_add.setText("+");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_delete.setText("-");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_saveSkill.setText("Save");
        btn_saveSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveSkillActionPerformed(evt);
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
                        .addGap(10, 10, 10)
                        .addComponent(btn_add)
                        .addGap(53, 53, 53)
                        .addComponent(btn_delete)
                        .addGap(43, 43, 43)
                        .addComponent(btn_saveSkill)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbx_skill, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txbx_skill, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(slider_power, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slider_power, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txbx_skill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(cbx_skill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_delete)
                    .addComponent(btn_saveSkill))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txbx_skillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbx_skillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbx_skillActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int index = tbl_skill.getSelectedRow();
        UserSkill userSkill = userSkills.get(index);
        userSkillDao.deleteUserSkill(userSkill.getId());
        fillTable();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        String skillName = txbx_skill.getText();
        Skill skill = null;
        if (skillName != null && !skillName.trim().isEmpty()) {
            skill = new Skill(0, skillName);
            skillDao.insertSkill(skill);
            System.out.println(skill);
        } else {
            skill = (Skill) cbx_skill.getSelectedItem();
            System.out.println(skill);
        }
        int power = slider_power.getValue();
        UserSkill userSkill = new UserSkill(0, Config.loggedInUser, skill, power);
        userSkillDao.insertUserSkill(userSkill);
        fillWindow();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_saveSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveSkillActionPerformed
        // UserSkill userSkill = userSkills.get(tbl_skill.getSelectedRow());
        int index = tbl_skill.getSelectedRow();
        UserSkill userSkill = userSkills.get(index);

        String skillName = txbx_skill.getText();
        Skill skill = new Skill();
        if (skillName != null && !skillName.trim().isEmpty()) {
            skill.setName(skillName);
            skillDao.insertSkill(skill);
            System.out.println(skill);
        } else {
            skill = (Skill) cbx_skill.getSelectedItem();
            System.out.println(skill);
        }
        int power = slider_power.getValue();

        // UserSkill userSkill=new UserSkill(1,Config.loggedInUser,skill,8);;
        userSkill.setPower(power);
        userSkill.setSkill(skill);

        System.out.println(userSkill);
        userSkillDao.updateUserSkill(userSkill);

        fillWindow();
    }//GEN-LAST:event_btn_saveSkillActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_saveSkill;
    private javax.swing.JComboBox<Skill> cbx_skill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider slider_power;
    private javax.swing.JTable tbl_skill;
    private javax.swing.JTextField txbx_skill;
    // End of variables declaration//GEN-END:variables
}
