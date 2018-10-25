/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restauracion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author familia pinillos
 */
public class Mesas extends javax.swing.JFrame {

    private int filas = 0; 
    private int columnas = 0;
    int numeroMesas;
    private int id = 1 , cont , aux = 0 ;

    
    JButton[][] cuadro;
    JButton[][] cuadroAux;
    
    public Mesas(String numero ) {
        initComponents();
        numeroMesas = Integer.parseInt(numero);
        verMatriz();
    }
    
    
     public void verMatriz(){
        
        int l = 0;
        int h = 0; 
        int x = 0 ; //25 
        int y = 0 ; //15
        int aum = 0 ; //10 
        int ay = 0 ;
        int ai = 0 ;
        int ax = 0 ;
        if(numeroMesas == 1){ filas = 1; columnas =0; aux = 0; x =60 ; y =80 ; l =150 ; h =150 ; aum = 60 ;}
        if(numeroMesas == 2){ filas = 1; columnas =2; aux = 0; x =60 ; y =80 ; l =150 ; h =150 ; aum = 60 ;}
        if(numeroMesas == 3){ filas = 1; columnas =2; aux = 1; x =60 ; y =80 ; l =150 ; h =150 ; aum = 60 ; ay = 80;}
        if(numeroMesas == 4){ filas = 2; columnas =2; aux = 0; x =60 ; y =40 ; l =170 ; h =110 ; aum = 50 ; ai = 40;}
        if(numeroMesas == 5){ filas = 2; columnas =2; aux = 1; x =60 ; y =40 ; l =170 ; h =110 ; aum = 50 ; ai = 60; ay =115; ax= 0;}
        if(numeroMesas == 6){ filas = 2; columnas =3; aux = 0; x =30 ; y =40 ; l =130 ; h =90 ; aum = 40 ;  ai = 30;}
        if(numeroMesas == 7){ filas = 2; columnas =3; aux = 1; x =30 ; y =40 ; l =130 ; h =90 ; aum = 40 ; ai = 30; ay = 105; ax= 30;}
        if(numeroMesas == 8){ filas = 2; columnas =3; aux = 2; x =30 ; y =40 ; l =130 ; h =90 ; aum = 40 ; ai = 30; ay = 40; ax= 30;}
        if(numeroMesas == 9){ filas = 3; columnas =3; aux = 0; x =50 ; y =20 ; l =130 ; h =90 ; aum = 20 ; ai = 50;}
        if(numeroMesas == 10){ filas = 3; columnas =3; aux = 1; x =50 ; y =20 ; l =130 ; h =90 ; aum = 20 ; ai = 50; ay = 130; ax= 7;} 
        if(numeroMesas == 11){ filas = 3; columnas =3; aux = 2; x =50 ; y =20 ; l =130 ; h =90 ; aum = 20 ; ai = 50; ay = 20; ax= 7;} 
        if(numeroMesas == 12){ filas = 3; columnas =3; aux = 3; x =50 ; y =20 ; l =130 ; h =90 ; aum = 20 ; ai = 50; ay = 20; ax= 7;} 
        if(numeroMesas == 13){ filas = 4; columnas =3; aux = 1; } 
        if(numeroMesas == 14){ filas = 4; columnas =3; aux = 2; }  
        if(numeroMesas == 15){ filas = 4; columnas =3; aux = 3; } 
        if(numeroMesas == 16){ filas = 4; columnas =4; aux = 0; }  
        if(numeroMesas == 17){ filas = 4; columnas =4; aux = 1;  } 
        if(numeroMesas == 18){ filas = 4; columnas =4; aux = 2; } 
        if(numeroMesas == 19){ filas = 4; columnas =4; aux = 3; } 
        if(numeroMesas == 20){ filas = 4; columnas =5; aux = 0; } 
        if(numeroMesas == 21){ filas = 4; columnas =5; aux = 1; } 
        if(numeroMesas == 22){ filas = 4; columnas =5; aux = 2; } 
        if(numeroMesas == 23){ filas = 4; columnas =5; aux = 3; } 
        if(numeroMesas == 24){ filas = 4; columnas =6; aux = 0; } 
        if(numeroMesas == 25){ filas = 4; columnas =6; aux = 1; } 
        if(numeroMesas == 26){ filas = 4; columnas =6; aux = 2; } 
        if(numeroMesas == 27){ filas = 4; columnas =4; aux = 3; }  
        if(numeroMesas == 28){ filas = 4; columnas =7; aux = 1; } 
        if(numeroMesas == 29){ filas = 4; columnas =7; aux = 1; } 
        if(numeroMesas == 30){ filas = 5; columnas =6; aux = 0; } 
           
        //termina de validar las sillas y columnas 
        cuadro = new JButton[filas][columnas];
        
        
        for (int i = 0 ;  i<filas ; i++){
             for(int j = 0 ;  j<columnas ; j++){
                cuadro[i][j]= new JButton();
                cuadro[i][j].setBackground(new Color(0,204,51));
                cuadro[i][j].setBorderPainted(false);
                cuadro[i][j].setBounds(x,y,l,h);   
 
                cuadro[i][j].setText("Mesa "+id);
                cuadro[i][j].setName(""+id);       
                cuadro[i][j].setFont(new java.awt.Font("Tahoma", 1, 18)); 
               
                Controlar bt = new Controlar();
                cuadro[i][j].addActionListener(bt);
                panelMesas.add(cuadro[i][j]);
                
                System.out.print(""+id);
                id ++;
                x+=l+aum; // ubicacion en el panell no cambiar  
            }

            x = ai; // ubicacion , no cambiar 
            y+=h+aum;// ubicacion , no cambiar 
        }   
        
        if ((aux>0)&&(aux<4)){
            int f = aux ;
            int c = 1 ; 
            int k  = ax ,z = ay  ;
            cuadroAux = new JButton[filas][columnas];
        for (int i = 0 ;  i<f ; i++){
             for(int j = 0 ;  j<c ; j++){
                cuadroAux[i][j]= new JButton();
                cuadroAux[i][j].setBackground(new Color(0,204,51));
                cuadroAux[i][j].setBorderPainted(false);
                cuadroAux[i][j].setBounds(k,z,l,h);   
               
                cuadroAux[i][j].setText("Mesa "+id);
                cuadroAux[i][j].setName(""+id);       
                cuadroAux[i][j].setFont(new java.awt.Font("Tahoma", 1, 18)); 
               
                Controlar bt = new Controlar();
                cuadroAux[i][j].addActionListener(bt);
                panelAux.add(cuadroAux[i][j]);
                
                System.out.print(""+id);
                id ++;
                
                k+=l+aum; // ubicacion en el panell no cambiar  
            }

            k= ax; // ubicacion , no cambiar 
            z+=h + aum;// ubicacion , no cambiar 
        }   
        
        }
        
        
        
    }
    
    
  
    private class Controlar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String sillas ="";
            String s; 
                for (int i = 0 ;  i<filas ; i++){
                    for (int j = 0 ;  j<columnas ; j++){   
                        
                        if(e.getSource().equals(cuadro[i][j])){
                            cuadro[i][j].setBackground(new Color(204,0,0));
                            cuadro[i][j].setForeground(Color.white); 
                            
                            s = (cuadro[i][j].getName());
                            sillas = sillas+s+",";
                                                       
                        }   
                    }   
                 }
                int f = aux ;
                int c = 1 ;
                for (int i = 0 ;  i<f ; i++){
                    for (int j = 0 ;  j<c ; j++){   
                        if(e.getSource().equals(cuadroAux[i][j])){
                            cuadroAux[i][j].setBackground(new Color(204,0,0));
                            cuadroAux[i][j].setForeground(Color.white); 
                            
                            s = (cuadroAux[i][j].getName());
                            sillas = sillas+s+",";
                            
                           
                        }   
                    }   
                 }
                
                System.out.print(sillas);
               
        }
      
        
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
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelMesas = new javax.swing.JPanel();
        panelAux = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 204, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51), 6));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMesas.setBackground(new java.awt.Color(255, 204, 153));
        panelMesas.setPreferredSize(new java.awt.Dimension(500, 350));

        javax.swing.GroupLayout panelMesasLayout = new javax.swing.GroupLayout(panelMesas);
        panelMesas.setLayout(panelMesasLayout);
        panelMesasLayout.setHorizontalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelMesasLayout.setVerticalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jPanel2.add(panelMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        panelAux.setBackground(new java.awt.Color(255, 204, 153));
        panelAux.setPreferredSize(new java.awt.Dimension(200, 350));

        javax.swing.GroupLayout panelAuxLayout = new javax.swing.GroupLayout(panelAux);
        panelAux.setLayout(panelAuxLayout);
        panelAuxLayout.setHorizontalGroup(
            panelAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        panelAuxLayout.setVerticalGroup(
            panelAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jPanel2.add(panelAux, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 190, -1));

        jPanel4.setBackground(new java.awt.Color(255, 153, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("MESAS");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 80));

        jPanel6.setBackground(new java.awt.Color(0, 204, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 30, 20));

        jPanel7.setBackground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, 30, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("No Disponible");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Disponible");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel panelAux;
    private javax.swing.JPanel panelMesas;
    // End of variables declaration//GEN-END:variables
}
