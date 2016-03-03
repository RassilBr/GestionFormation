/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.formation.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author rassil
 */
public class Session extends javax.swing.JFrame {

    private int id_form=1;
    private int id_emp=1;
    
    
    public Session() {
        initComponents();
        remplir(id_form);
         setLocationRelativeTo(null);
    }
    
    public void setidemp(int x){this.id_emp=x;}
    
    public void setid(int x){this.id_form=x;}
    
    public void remplir(int x){
    
        String sql="select * from session where id_form="+x;
        ResultSet rs=Rselect.select(sql);
        session_tab.setModel(DbUtils.resultSetToTableModel(rs));
        
        
        try {
            String sql1="select nom_form from formation where id_form="+x;
        ResultSet rs1=Rselect.select(sql1);
        if(rs1.next()){
            
            String nom=rs1.getString("nom_form");
            jLabel1.setText("Liste des session de Formation : "+nom);
            
            }
                
                }
        catch(SQLException ex){JOptionPane.showMessageDialog(this, ex);}
        
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInscri = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        session_tab = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion Formation");
        setResizable(false);

        jInscri.setText("Inscription");
        jInscri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInscriActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Liste des session de Formation :");

        session_tab = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        session_tab.setFont(new java.awt.Font("Palatino Linotype", 1, 12));
        session_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }

        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };
        });
        session_tab.getTableHeader().setReorderingAllowed(false);
        session_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                session_tabMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(session_tab);

        jMenu1.setText("utilisateur");

        jMenuItem1.setText("Deconnection");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Option");

        jMenuItem2.setText("Menu Principale");
        jMenuItem2.setActionCommand("Menu Proncipale");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Quitter");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jInscri)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jInscri)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jInscriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInscriActionPerformed

        inscrit();
        
        
    }//GEN-LAST:event_jInscriActionPerformed

    public void inscrit(){
    
       int i=session_tab.getSelectedRow();
       if(i!=-1){
       
           String sql="select nom_emp,prenom_emp,date_naiss_emp from employe where id_emp="+id_emp;
           ResultSet rs=Rselect.select(sql);
           int id_sess=(int) session_tab.getValueAt(i,0);
           try{
           if(rs.next())
           {
           String nom=rs.getString(1);
           String pnom=rs.getString(2);
           String date=rs.getString(3);
           
              System.out.println(nom+"  "+pnom+" "+date+" "+id_sess+" "+id_emp+" "+id_form);
              String sql1="INSERT INTO `inscrit` (`id_sess`, `id_emp`, `nom_emp`, `prenom_emp`, `date_naiss_emp`,"
                   + " `nom_entrep`) VALUES ( '"+id_sess+"', '"+id_emp+"', '"+nom+"', '"+pnom+"', '"+date+"', 'fst')";

            Rselect.Insert(sql1);
            JOptionPane.showMessageDialog(this,"L'inscription a cette formation est terminé");
            this.hide();
            Choix_form form=new Choix_form(id_emp);
            form.setVisible(true);
                      
           }
           }catch(SQLException ex){ 
           JOptionPane.showMessageDialog(this,ex);
           }
       
       
       }else JOptionPane.showMessageDialog(this,"Selection une session");
    
    
    
    }
    
    private void session_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_session_tabMouseClicked

    }//GEN-LAST:event_session_tabMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.hide();
        new MenuPrincipale().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Session().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jInscri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable session_tab;
    // End of variables declaration//GEN-END:variables
}
