/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restauracion;

/**
 *
 * @author familia pinillos
 */
public class Ventana_Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_inicio
     */
    public Ventana_Inicio() {
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
        Administrador = new javax.swing.JButton();
        mesero = new javax.swing.JButton();
        caja = new javax.swing.JButton();
        cocina = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(796, 329));
        setSize(new java.awt.Dimension(796, 295));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(120, 184, 218));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 99, 151), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Administrador.setBackground(new java.awt.Color(120, 184, 218));
        Administrador.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Administrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/admin.png"))); // NOI18N
        Administrador.setBorder(null);
        Administrador.setBorderPainted(false);
        Administrador.setContentAreaFilled(false);
        Administrador.setMaximumSize(new java.awt.Dimension(1783, 1609));
        Administrador.setMinimumSize(new java.awt.Dimension(1783, 1609));
        Administrador.setPreferredSize(new java.awt.Dimension(1783, 1609));
        Administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdministradorActionPerformed(evt);
            }
        });
        jPanel1.add(Administrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 190, 130));

        mesero.setBackground(new java.awt.Color(120, 184, 218));
        mesero.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        mesero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mesero.png"))); // NOI18N
        mesero.setBorder(null);
        mesero.setBorderPainted(false);
        mesero.setContentAreaFilled(false);
        mesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meseroActionPerformed(evt);
            }
        });
        jPanel1.add(mesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 140, 110));

        caja.setBackground(new java.awt.Color(120, 184, 218));
        caja.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/caja.png"))); // NOI18N
        caja.setBorder(null);
        caja.setBorderPainted(false);
        caja.setContentAreaFilled(false);
        caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaActionPerformed(evt);
            }
        });
        jPanel1.add(caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 170, 140));

        cocina.setBackground(new java.awt.Color(120, 184, 218));
        cocina.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cocina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cocina.png"))); // NOI18N
        cocina.setBorder(null);
        cocina.setBorderPainted(false);
        cocina.setContentAreaFilled(false);
        cocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cocinaActionPerformed(evt);
            }
        });
        jPanel1.add(cocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 170, 140));

        jPanel2.setBackground(new java.awt.Color(29, 99, 151));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PROYECTO RESTAURACION");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 50));

        jLabel3.setBackground(new java.awt.Color(3, 27, 27));
        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(29, 99, 151));
        jLabel3.setText("COCINA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, -1));

        jLabel4.setBackground(new java.awt.Color(3, 27, 27));
        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(29, 99, 151));
        jLabel4.setText("CAJA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, -1, -1));

        jLabel5.setBackground(new java.awt.Color(3, 27, 27));
        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(29, 99, 151));
        jLabel5.setText("ADMINISTRADOR");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel6.setBackground(new java.awt.Color(3, 27, 27));
        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(29, 99, 151));
        jLabel6.setText("MESERO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 780, 290);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meseroActionPerformed
        Mesas mesa= new Mesas();
        mesa.setLocationRelativeTo(null);
        mesa.setVisible(true);
        
    }//GEN-LAST:event_meseroActionPerformed

    private void AdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdministradorActionPerformed
        Administrador admin = new Administrador();
        admin.setLocationRelativeTo(null);
        admin.setVisible(true);
        
    }//GEN-LAST:event_AdministradorActionPerformed

    private void cajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaActionPerformed

        
    }//GEN-LAST:event_cajaActionPerformed

    private void cocinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cocinaActionPerformed
        
        
    }//GEN-LAST:event_cocinaActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Administrador;
    private javax.swing.JButton caja;
    private javax.swing.JButton cocina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton mesero;
    // End of variables declaration//GEN-END:variables
}
