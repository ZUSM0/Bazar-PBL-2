/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.uefs.ecomp.bazar.view;

import java.awt.CardLayout;

/**
 *
 * @author less
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public TelaPrincipal() {
        initComponents();
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
        NaveBar = new javax.swing.JPanel();
        btnVender = new javax.swing.JButton();
        btnLeiloes = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        JMain = new javax.swing.JPanel();
        JMeusLeiloes = new javax.swing.JPanel();
        JVender = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        JComprar = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Leil�o");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 200));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("L e i l � o");

        NaveBar.setBackground(new java.awt.Color(204, 204, 204));

        btnVender.setBackground(new java.awt.Color(204, 204, 204));
        btnVender.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        btnVender.setForeground(new java.awt.Color(0, 0, 0));
        btnVender.setText("Quero Vender");
        btnVender.setBorderPainted(false);
        btnVender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVender.setOpaque(true);
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        btnLeiloes.setBackground(new java.awt.Color(204, 204, 204));
        btnLeiloes.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        btnLeiloes.setForeground(new java.awt.Color(0, 0, 0));
        btnLeiloes.setText("Meus Leil�es");
        btnLeiloes.setBorderPainted(false);
        btnLeiloes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLeiloes.setOpaque(true);
        btnLeiloes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeiloesActionPerformed(evt);
            }
        });

        btnComprar.setBackground(new java.awt.Color(204, 204, 204));
        btnComprar.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        btnComprar.setForeground(new java.awt.Color(0, 0, 0));
        btnComprar.setText("Quero Comprar");
        btnComprar.setBorderPainted(false);
        btnComprar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnComprar.setOpaque(true);
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(204, 204, 204));
        btnSair.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        btnSair.setForeground(new java.awt.Color(0, 0, 0));
        btnSair.setText("Sair");
        btnSair.setBorderPainted(false);
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSair.setOpaque(true);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NaveBarLayout = new javax.swing.GroupLayout(NaveBar);
        NaveBar.setLayout(NaveBarLayout);
        NaveBarLayout.setHorizontalGroup(
            NaveBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NaveBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLeiloes)
                .addGap(20, 20, 20)
                .addComponent(btnVender)
                .addGap(20, 20, 20)
                .addComponent(btnComprar)
                .addGap(20, 20, 20)
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NaveBarLayout.setVerticalGroup(
            NaveBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NaveBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NaveBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVender)
                    .addComponent(btnComprar)
                    .addComponent(btnLeiloes)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JMain.setBackground(new java.awt.Color(205, 205, 205));
        JMain.setLayout(new java.awt.CardLayout());

        JMeusLeiloes.setBackground(new java.awt.Color(205, 205, 205));

        javax.swing.GroupLayout JMeusLeiloesLayout = new javax.swing.GroupLayout(JMeusLeiloes);
        JMeusLeiloes.setLayout(JMeusLeiloesLayout);
        JMeusLeiloesLayout.setHorizontalGroup(
            JMeusLeiloesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 694, Short.MAX_VALUE)
        );
        JMeusLeiloesLayout.setVerticalGroup(
            JMeusLeiloesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        JMain.add(JMeusLeiloes, "meusLeioes");

        JVender.setBackground(new java.awt.Color(205, 205, 205));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setText("Cadastrar Leil�o:");

        jButton1.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        jButton1.setText("Cadastrar Produto");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tipo de Leil�o:");

        javax.swing.GroupLayout JVenderLayout = new javax.swing.GroupLayout(JVender);
        JVender.setLayout(JVenderLayout);
        JVenderLayout.setHorizontalGroup(
            JVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JVenderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JVenderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(JVenderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        JVenderLayout.setVerticalGroup(
            JVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JVenderLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(JVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 222, Short.MAX_VALUE))
        );

        JMain.add(JVender, "vender");

        JComprar.setBackground(new java.awt.Color(205, 205, 205));
        JComprar.setPreferredSize(new java.awt.Dimension(694, 372));

        javax.swing.GroupLayout JComprarLayout = new javax.swing.GroupLayout(JComprar);
        JComprar.setLayout(JComprarLayout);
        JComprarLayout.setHorizontalGroup(
            JComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 694, Short.MAX_VALUE)
        );
        JComprarLayout.setVerticalGroup(
            JComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        JMain.add(JComprar, "comprar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NaveBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(JMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NaveBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(JMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        // TODO add your handling code here:
        CardLayout cardVender = (CardLayout) JMain.getLayout();
        cardVender.show(JMain, "vender");
    }//GEN-LAST:event_btnVenderActionPerformed

    private void btnLeiloesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeiloesActionPerformed
        // TODO add your handling code here:
        CardLayout cardLeil�es = (CardLayout) JMain.getLayout();
        cardLeil�es.show(JMain, "meusLeioes");
    }//GEN-LAST:event_btnLeiloesActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
        CardLayout cardComprar = (CardLayout) JMain.getLayout();
        cardComprar.show(JMain, "comprar");
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JComprar;
    private javax.swing.JPanel JMain;
    private javax.swing.JPanel JMeusLeiloes;
    private javax.swing.JPanel JVender;
    private javax.swing.JPanel NaveBar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnLeiloes;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVender;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
