/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restauracion;

import java.awt.Color;

import javax.swing.JButton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author familia pinillos
 */
public final class verMesas extends javax.swing.JFrame implements Runnable {
    public  boolean estado = false;
    private int filas = 0; 
    private int columnas = 0;
    private int fil = 0 ;
    private int col = 0 ; 
    int numeroMesas;
    private int id = 1 , cont , aux = 0;
    JButton[][] cuadro;
    JButton[][] cuadroAux;
    
        
    public verMesas() {
        initComponents();
        listarMesas();
        verMatriz(); 
    }
    
    public void listarMesas(){
        String ruta = "Mesas/mesas.txt";
        File archivo = null;  //apuntar al archivo almancenado DD
        FileReader contenido = null;  //acceder a todo el contenido del archivo
        BufferedReader linea = null; //accede linea a linea al contenido
        
        try{
            archivo = new File(ruta);
            contenido = new FileReader(archivo);
            linea = new BufferedReader(contenido);
            
            String cadena=""; //variable captura los datos del archivo
            while((cadena=linea.readLine()) != null){ //recorre todo el archivo
                String dato[] = cadena.split(";");
                 numeroMesas = Integer.parseInt(dato[0]);
            }
         }catch(IOException e){
           System.out.print("Error creando archivo");
        }
        finally{
            try{
                if(contenido != null){
                    contenido.close();
                }
            }catch(IOException e1){
                System.out.print("Error cerrando archivo");
            }
        }
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
        if(numeroMesas == 10){ filas = 3; columnas =3; aux = 1; x =100; y =35 ; l =250 ; h =135 ; aum = 30 ; ai = 100; ax= 380; }
        if(numeroMesas == 11){ filas = 3; columnas =3; aux = 2; x =100; y =35 ; l =250 ; h =135 ; aum = 30 ; ai = 100; ax= 100; } 
        if(numeroMesas == 12){ filas = 3; columnas =3; aux = 3; x =100; y =35 ; l =250 ; h =135 ; aum = 30 ; ai = 100; ax= 100; }
        if(numeroMesas == 13){ filas = 2; columnas =5; aux = 3; x =30 ; y =80 ; l =120 ; h =120 ; aum = 20 ; ai = 30; ax= 30;} 
        if(numeroMesas == 14){ filas = 3; columnas =4; aux = 2; x =75; y =25 ; l =200 ; h =135 ; aum = 30 ; ai = 75; ax= 75; } 
        if(numeroMesas == 15){ filas = 3; columnas =4; aux = 3; x =75; y =25 ; l =200 ; h =135 ; aum = 30 ; ai = 75; ax= 75; }
        if(numeroMesas == 16){ filas = 3; columnas =4; aux = 4; x =75; y =25 ; l =200 ; h =135 ; aum = 30 ; ai = 75; ax= 75; }
        if(numeroMesas == 17){ filas = 3; columnas =5; aux = 2; x =20; y =25 ; l =170 ; h =135 ; aum = 30 ; ai = 20; ax= 20; }
        if(numeroMesas == 18){ filas = 3; columnas =5; aux = 3; x =20; y =25 ; l =170 ; h =135 ; aum = 30 ; ai = 20; ax= 20; } 
        if(numeroMesas == 19){ filas = 3; columnas =5; aux = 4; x =20; y =25 ; l =170 ; h =135 ; aum = 30 ; ai = 20; ax= 20; }   
        if(numeroMesas == 20){ filas = 3; columnas =5; aux = 5; x =20; y =25 ; l =170 ; h =135 ; aum = 30 ; ai = 20; ax= 20; } 
        if(numeroMesas == 21){ filas = 3; columnas =6; aux = 3; x =20; y =25 ; l =140 ; h =135 ; aum = 30 ; ai = 20; ax= 20; }  
        if(numeroMesas == 22){ filas = 3; columnas =6; aux = 4; x =20; y =25 ; l =140 ; h =135 ; aum = 30 ; ai = 20; ax= 20; } 
        if(numeroMesas == 23){ filas = 3; columnas =6; aux = 5; x =20; y =25 ; l =140 ; h =135 ; aum = 30 ; ai = 20; ax= 20; } 
        if(numeroMesas == 24){ filas = 3; columnas =6; aux = 6; x =20; y =25 ; l =140 ; h =135 ; aum = 30 ; ai = 20; ax= 20; }
        if(numeroMesas == 25){ filas = 4; columnas =5; aux = 5; x =25; y =15 ; l =160 ; h =110 ; aum = 20 ; ai = 25; ax= 25; }
        if(numeroMesas == 26){ filas = 4; columnas =6; aux = 2; x =15; y =15 ; l =150 ; h =110 ; aum = 20 ; ai = 15; ax= 15; }
        if(numeroMesas == 27){ filas = 4; columnas =6; aux = 3; x =15; y =15 ; l =150 ; h =110 ; aum = 20 ; ai = 15; ax= 15; }
        if(numeroMesas == 28){ filas = 4; columnas =6; aux = 4; x =15; y =15 ; l =150 ; h =110 ; aum = 20 ; ai = 15; ax= 15; }
        if(numeroMesas == 29){ filas = 4; columnas =6; aux = 5; x =15; y =15 ; l =150 ; h =110 ; aum = 20 ; ai = 15; ax= 15; } 
        if(numeroMesas == 30){ filas = 4; columnas =6; aux = 6; x =15; y =15 ; l =150 ; h =110 ; aum = 20 ; ai = 15; ax= 15; }
        if(numeroMesas == 31){ filas = 4; columnas =7; aux = 3; x =20; y =15 ; l =120 ; h =110 ; aum = 20 ; ai = 20; ax= 20; } 
        if(numeroMesas == 32){ filas = 4; columnas =7; aux = 4; x =20; y =15 ; l =125 ; h =110 ; aum = 20 ; ai = 20; ax= 20; } 
        if(numeroMesas == 33){ filas = 4; columnas =7; aux = 5; x =20; y =15 ; l =125 ; h =110 ; aum = 20 ; ai = 20; ax= 20; } 
        if(numeroMesas == 34){ filas = 4; columnas =7; aux = 6; x =20; y =15 ; l =125 ; h =110 ; aum = 20 ; ai = 20; ax= 20; }  
        if(numeroMesas == 35){ filas = 4; columnas =7; aux = 7; x =20; y =15 ; l =125 ; h =110 ; aum = 20 ; ai = 20; ax= 20; }  
        if(numeroMesas == 36){ filas = 4; columnas =8; aux = 4; x =15; y =25 ; l =110 ; h =110 ; aum = 16 ; ai = 15; ax= 15; }  
        if(numeroMesas == 38){ filas = 4; columnas =8; aux = 6; x =15; y =25 ; l =110 ; h =110 ; aum = 16 ; ai = 15; ax= 15; }  
        if(numeroMesas == 39){ filas = 4; columnas =8; aux = 7; x =15; y =25 ; l =110 ; h =110 ; aum = 16 ; ai = 15; ax= 15; }  
        if(numeroMesas == 40){ filas = 4; columnas =8; aux = 8; x =15; y =25 ; l =110 ; h =110 ; aum = 16 ; ai = 15; ax= 15; } 
        
           
        //termina de validar las sillas y columnas 
        cuadro = new JButton[filas][columnas];
    
        for (int i = 0 ;  i<filas ; i++){
             for(int j = 0 ;  j<columnas ; j++){
                cuadro[i][j]= new JButton();//crea el boton
                cuadro[i][j].setBounds(x,y,l,h); //cordenadas en el panel
                cuadro[i][j].setBorderPainted(true);
                cuadro[i][j].setName("Mesa"+id);//nombreVariable
                cuadro[i][j].setText("Mesa "+id);//texto del boton
                cuadro[i][j].setFont(new java.awt.Font("Tahoma", 1, 15)); //fuente 
                cuadro[i][j].setBackground(new Color(114,216,114)); //color

                panelMesas.add(cuadro[i][j]);                
                id ++;
                x+=l+aum; // ubicacion en el panell no cambiar                 
          }
            x = ai; // ubicacion , no cambiar 
            y+=h+aum;// ubicacion , no cambiar  
        }   
        if ((aux>0)&&(aux<9)){
             fil = 1 ;
             col = aux ; 
            int k  = ax ,z = ay  ;
            cuadroAux = new JButton[fil][col];
        for (int i = 0 ;  i<fil ; i++){
             for(int j = 0 ;  j<col ; j++){
                cuadroAux[i][j]= new JButton();
                cuadroAux[i][j].setBackground(new Color(114,216,114));
                cuadroAux[i][j].setBorderPainted(true);
                cuadroAux[i][j].setBounds(k,z,l,h);   
                cuadroAux[i][j].setText("Mesa "+id);
                cuadroAux[i][j].setName("Mesa"+id);       
                cuadroAux[i][j].setFont(new java.awt.Font("Tahoma", 1,15)); 

                panelAux.add(cuadroAux[i][j]);             
                id ++;
                
                k+=l+aum; // ubicacion en el panel no cambiar  
 
            }
            k= ax; // ubicacion , no cambiar 
            z+=h + aum;// ubicacion , no cambiar 
        }   
      }  
    }
    
   
       
       
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelMesas = new javax.swing.JPanel();
        panelAux = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1099, 750));

        jPanel2.setBackground(new java.awt.Color(210, 223, 236));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(6, 77, 175), 6));
        jPanel2.setPreferredSize(new java.awt.Dimension(770, 680));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMesas.setBackground(new java.awt.Color(210, 223, 236));

        javax.swing.GroupLayout panelMesasLayout = new javax.swing.GroupLayout(panelMesas);
        panelMesas.setLayout(panelMesasLayout);
        panelMesasLayout.setHorizontalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        panelMesasLayout.setVerticalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        jPanel2.add(panelMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1030, 540));

        panelAux.setBackground(new java.awt.Color(210, 223, 236));
        panelAux.setPreferredSize(new java.awt.Dimension(200, 350));

        javax.swing.GroupLayout panelAuxLayout = new javax.swing.GroupLayout(panelAux);
        panelAux.setLayout(panelAuxLayout);
        panelAuxLayout.setHorizontalGroup(
            panelAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        panelAuxLayout.setVerticalGroup(
            panelAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel2.add(panelAux, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 1030, 150));

        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(6, 77, 175));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mesas del restaurante");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1051, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelAux;
    private javax.swing.JPanel panelMesas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
    }





}
