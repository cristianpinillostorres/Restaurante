/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restauracion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author familia pinillos
 */
public class VerMesas extends javax.swing.JFrame {

    private int filas = 0; 
    private int columnas = 0;
    int numeroMesas;
    private int id = 1 , cont , aux = 0 ;

    
    JButton[][] cuadro;
    JButton[][] cuadroAux;
    
        ImageIcon iconolbl = new ImageIcon("src/iconos/m.jpg");
        
    public VerMesas(String numero ) {
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
        int tam = 18 ;
        if(numeroMesas == 1){ filas = 1; columnas =1; aux = 0; x =250 ; y =80 ; l =250 ; h =250 ; aum = 60 ;}
        if(numeroMesas == 2){ filas = 1; columnas =2; aux = 0; x =70 ; y =80 ; l =250 ; h =250 ; aum = 50 ;}
        if(numeroMesas == 3){ filas = 1; columnas =3; aux = 0; x =20 ; y =80 ; l =190 ; h =250 ; aum = 50 ;}
        if(numeroMesas == 4){ filas = 2; columnas =2; aux = 0; x =100 ; y =20 ; l =230 ; h =150 ; aum = 45 ; ai = 100;}
        if(numeroMesas == 5){ filas = 2; columnas =2; aux = 1; x =100 ; y =20 ; l =230 ; h =150 ; aum = 40 ; ai = 100; ay = 15; ax= 250;}
        if(numeroMesas == 6){ filas = 2; columnas =3; aux = 0; x =70 ; y =30 ; l =170 ; h =150 ; aum = 30 ; ai = 70; ay = 5; ax= 70;}
        if(numeroMesas == 7){ filas = 2; columnas =3; aux = 1; x =70 ; y =30 ; l =170 ; h =150 ; aum = 30 ; ai = 70; ay = 5; ax= 270;}
        if(numeroMesas == 8){ filas = 2; columnas =3; aux = 2; x =70 ; y =30 ; l =170 ; h =150 ; aum = 30 ; ai = 70; ay = 5; ax= 70;}
        if(numeroMesas == 9){ filas = 2; columnas =3; aux = 3;  x =70 ; y =30 ; l =170 ; h =150 ; aum = 30 ; ai = 70; ay = 5; ax= 70;} 
        if(numeroMesas == 10){ filas = 3; columnas =3; aux = 1; x =70 ; y =20 ; l =170 ; h =100 ; aum = 30 ; ai = 70; ay = 20; ax= 270;} 
        if(numeroMesas == 11){ filas = 3; columnas =3; aux = 2; x =70 ; y =20 ; l =170 ; h =100 ; aum = 30 ; ai = 70; ay = 20; ax= 70;} 
        if(numeroMesas == 12){ filas = 3; columnas =3; aux = 3; x =70 ; y =20 ; l =170 ; h =100 ; aum = 30 ; ai = 70; ay = 20; ax= 70;} 
        if(numeroMesas == 13){ filas = 2; columnas =5; aux = 3; x =30 ; y =80 ; l =120 ; h =120 ; aum = 20 ; ai = 30; ay = 0; ax= 30;} 
        if(numeroMesas == 14){ filas = 3; columnas =4; aux = 2; x =15; y =15 ; l =150 ; h =100 ; aum = 26 ; ai = 15; ay = 5; ax= 15; tam = 15;} 
        if(numeroMesas == 15){ filas = 3; columnas =4; aux = 3; x =15; y =15 ; l =150 ; h =100 ; aum = 26 ; ai = 15; ay = 5; ax= 15; tam = 15;}
        if(numeroMesas == 16){ filas = 3; columnas =4; aux = 4; x =15; y =15 ; l =150 ; h =100 ; aum = 26 ; ai = 15; ay = 5; ax= 15; tam = 15;}
        if(numeroMesas == 17){ filas = 3; columnas =5; aux = 2; x =15; y =15 ; l =120 ; h =100 ; aum = 22 ; ai = 15; ay = 5; ax= 15; tam = 15;}
        if(numeroMesas == 18){ filas = 3; columnas =5; aux = 3; x =15; y =15 ; l =120 ; h =100 ; aum = 22 ; ai = 15; ay = 5; ax= 15; tam = 15;} 
        if(numeroMesas == 19){ filas = 3; columnas =5; aux = 4; x =15; y =15 ; l =120 ; h =100 ; aum = 22 ; ai = 15; ay = 5; ax= 15; tam = 15;}   
        if(numeroMesas == 20){ filas = 3; columnas =5; aux = 5; x =15; y =15 ; l =120 ; h =100 ; aum = 22 ; ai = 15; ay = 5; ax= 15; tam = 15;} 
        if(numeroMesas == 21){ filas = 3; columnas =6; aux = 3; x =15; y =15 ; l =93 ; h =95 ; aum = 22 ; ai = 15; ay = 0; ax= 15; tam = 11;}  
        if(numeroMesas == 22){ filas = 3; columnas =6; aux = 4; x =15; y =15 ; l =93 ; h =95 ; aum = 22 ; ai = 15; ay = 0; ax= 15; tam = 11;} 
        if(numeroMesas == 23){ filas = 3; columnas =6; aux = 5; x =15; y =15 ; l =93 ; h =95 ; aum = 22 ; ai = 15; ay = 0; ax= 15; tam = 11;} 
        if(numeroMesas == 24){ filas = 3; columnas =6; aux = 6; x =15; y =15 ; l =93 ; h =95 ; aum = 22 ; ai = 15; ay = 0; ax= 15; tam = 11;} 
        if(numeroMesas == 25){ filas = 4; columnas =5; aux = 5; x =15; y =15 ; l =115 ; h =70 ; aum = 22 ; ai = 15; ay = 0; ax= 15; tam = 11;} 
        if(numeroMesas == 26){ filas = 4; columnas =6; aux = 2; x =15; y =15 ; l =93 ; h =70 ; aum = 22 ; ai = 15; ay = 15; ax= 15; tam = 11;}  
        if(numeroMesas == 27){ filas = 4; columnas =6; aux = 3; x =15; y =15 ; l =93 ; h =70 ; aum = 22 ; ai = 15; ay = 15; ax= 15; tam = 11;} 
        if(numeroMesas == 28){ filas = 4; columnas =6; aux = 4; x =15; y =15 ; l =93 ; h =70 ; aum = 22 ; ai = 15; ay = 15; ax= 15; tam = 11;} 
        if(numeroMesas == 29){ filas = 4; columnas =6; aux = 5; x =15; y =15 ; l =93 ; h =70 ; aum = 22 ; ai = 15; ay = 15; ax= 15; tam = 11;}  
        if(numeroMesas == 30){ filas = 4; columnas =6; aux = 6; x =15; y =15 ; l =93 ; h =70 ; aum = 22 ; ai = 15; ay = 10; ax= 15; tam = 11;} 
           
        //termina de validar las sillas y columnas 
        cuadro = new JButton[filas][columnas];
        
        
        for (int i = 0 ;  i<filas ; i++){
             for(int j = 0 ;  j<columnas ; j++){
                cuadro[i][j]= new JButton();
                cuadro[i][j].setIcon(iconolbl);
                cuadro[i][j].setBackground(new Color(139,94,48));
                cuadro[i][j].setForeground(new Color(255,255,255));
                cuadro[i][j].setBorderPainted(false);
                cuadro[i][j].setBounds(x,y,l,h);   
 
                cuadro[i][j].setText("Mesa "+id);
                cuadro[i][j].setName(""+id);       
                cuadro[i][j].setFont(new java.awt.Font("Tahoma", 1, tam)); 
               
                panelMesas.add(cuadro[i][j]);
                
                
                id ++;
                x+=l+aum; // ubicacion en el panell no cambiar  
            }

            x = ai; // ubicacion , no cambiar 
            y+=h+aum;// ubicacion , no cambiar 
        }   
        
        if ((aux>0)&&(aux<7)){
            int f = 1 ;
            int c = aux ; 
            int k  = ax ,z = ay  ;
            cuadroAux = new JButton[f][c];
        for (int i = 0 ;  i<f ; i++){
             for(int j = 0 ;  j<c ; j++){
                cuadroAux[i][j]= new JButton();
                cuadroAux[i][j].setIcon(iconolbl);
                cuadroAux[i][j].setBackground(new Color(139,94,48));
                cuadroAux[i][j].setForeground(new Color(255,255,255));
                cuadroAux[i][j].setBorderPainted(false);
                cuadroAux[i][j].setBounds(k,z,l,h);   
               
                cuadroAux[i][j].setText("Mesa "+id);
                cuadroAux[i][j].setName(""+id);       
                cuadroAux[i][j].setFont(new java.awt.Font("Tahoma", 1, tam)); 
               
                
                panelAux.add(cuadroAux[i][j]);
                
                
                id ++;
                
                k+=l+aum; // ubicacion en el panell no cambiar  
            }

            k= ax; // ubicacion , no cambiar 
            z+=h + aum;// ubicacion , no cambiar 
        }   
        
        }
        
        
        
    }
      public void cuadroactionPerformed(ActionEvent e) {
            String sillas ="";
            String s; 
                for (int i = 0 ;  i<filas ; i++){
                    for (int j = 0 ;  j<columnas ; j++){   
                        
                        if(e.getSource().equals(cuadro[i][j])){
                            cuadro[i][j].setBackground(new Color(204,0,0));
                            cuadro[i][j].setForeground(Color.RED); ; 
                            
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
    
    
  
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelMesas = new javax.swing.JPanel();
        panelAux = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jPanel2.setBackground(new java.awt.Color(239, 231, 231));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 6));
        jPanel2.setPreferredSize(new java.awt.Dimension(770, 680));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMesas.setBackground(new java.awt.Color(239, 231, 231));

        javax.swing.GroupLayout panelMesasLayout = new javax.swing.GroupLayout(panelMesas);
        panelMesas.setLayout(panelMesasLayout);
        panelMesasLayout.setHorizontalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        panelMesasLayout.setVerticalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        jPanel2.add(panelMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 730, 380));

        panelAux.setBackground(new java.awt.Color(239, 231, 231));
        panelAux.setPreferredSize(new java.awt.Dimension(200, 350));

        javax.swing.GroupLayout panelAuxLayout = new javax.swing.GroupLayout(panelAux);
        panelAux.setLayout(panelAuxLayout);
        panelAuxLayout.setHorizontalGroup(
            panelAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        panelAuxLayout.setVerticalGroup(
            panelAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        jPanel2.add(panelAux, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 730, 190));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/comida.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1310, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(VerMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelAux;
    private javax.swing.JPanel panelMesas;
    // End of variables declaration//GEN-END:variables
}
