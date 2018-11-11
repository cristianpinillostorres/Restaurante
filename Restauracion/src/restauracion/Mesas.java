/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restauracion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javax.swing.DefaultListModel;
/**
 *
 * @author familia pinillos
 */
public final class Mesas extends javax.swing.JFrame implements Runnable {
    
    String hora, minutos, segundos, ampm;
    Thread h1;
    
    public  boolean estado = false;
    private int filas = 0; 
    private int columnas = 0;
    private int fil = 0 ;
    private int col = 0 ; 
    int numeroMesas;
    private int id = 1 , cont , aux = 0  ;

    List<String[]> ocupadas = new ArrayList<>();
    
    JButton[][] cuadro;
    JButton[][] cuadroAux;
    
        
    public Mesas() {
        initComponents();
        listarMesas();
        buscarOcupadas();
        verMatriz();
        h1 = new Thread(this);
        h1.start();
        
      
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
    public void buscarOcupadas(){
        String ruta = "Mesas/mesasOcupadas.txt"; 
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
                
                String mesa = dato[0];
                String estad= dato[1];
                String hor = dato[2];
                ocupadas.add(new String[]{mesa, estad,hor}); // Guardar la posicion de la primera letra en el arrayList 
                
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
    
    public void guardarMesa(String cadena){ 
        
        String ruta = "Mesas/mesasOcupadas.txt";
        FileWriter fichero = null;  //objeto principal (archivo)
        PrintWriter linea = null;   //objeto de contenido de archivo
        try{
            fichero = new FileWriter(ruta,true); //crea el archivo 
            linea = new PrintWriter(fichero); //apunta el PrintWriter al archivo creado   
            linea.println(cadena); //escribiendo en el archivo      
        }catch(IOException e){
            System.out.print("Error creando archivo");            }
        finally{
            try{
                if(fichero != null){
                    fichero.close();
                }
           }catch(IOException e1){
                System.out.print("Error cerrando archivo");
           }
        }
    }
    
    public void buscarPedidos(String mesa){
        DefaultListModel modelo = new DefaultListModel();
        String ruta = "Pedidos/pedido"+mesa+".txt";
        File archivo = null;  //apuntar al archivo almancenado DD
        FileReader contenido = null;  //acceder a todo el contenido del archivo
        BufferedReader linea = null; //accede linea a linea al contenido
         
        try{
            archivo = new File(ruta);
            contenido = new FileReader(archivo);
            linea = new BufferedReader(contenido);
            modelo.addElement(" Can         Plato");
            String cadena=""; //variable captura los datos del archivo
            while((cadena=linea.readLine()) != null){ //recorre todo el archivo
                String dato[] = cadena.split(";");
                String lista = "  "+dato[1]+"           "+dato[0];
                modelo.addElement(lista);
                
            }
        }catch(IOException e){
        }
        finally{
            try{
                if(contenido != null){
                    contenido.close();
                }
            }catch(IOException e1){}
        }
        pedidos.setModel(modelo);
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
                cuadro[i][j]= new JButton();//crea el boton
                cuadro[i][j].setBounds(x,y,l,h); //cordenadas en el panel
                cuadro[i][j].setBorderPainted(true);
                cuadro[i][j].setName("Mesa"+id);//nombreVariable
                cuadro[i][j].setText("Mesa "+id);//texto del boton
                cuadro[i][j].setFont(new java.awt.Font("Tahoma", 1, tam)); //fuente 
                cuadro[i][j].setBackground(new Color(114,216,114)); //color
                
                //este es el evento 
                Controlar bt = new Controlar();
                Control boton = new Control();
                cuadro[i][j].addActionListener(bt);
                cuadro[i][j].addMouseListener(boton);
                panelMesas.add(cuadro[i][j]);                
                id ++;
                x+=l+aum; // ubicacion en el panell no cambiar 
                
                //valida si hay una mesa oucpada y desabilita el boton 
                 for (int t = 0 ; t < ocupadas.size() ; t ++){
                     if ((ocupadas.get(t)[0]) == null ? cuadro[i][j].getName() == null : (ocupadas.get(t)[0]).equals(cuadro[i][j].getName())){
                    cuadro[i][j].setBackground(new Color(255,51,51));
                    cuadro[i][j].setForeground(Color.white);  // pone el color de letra balnco ...
                    cuadro[i][j].setFont(new java.awt.Font("Tahoma", 1, tam)); 
                    cuadro[i][j].setEnabled(false);
                 }        
            }
                 
                 
          }
            x = ai; // ubicacion , no cambiar 
            y+=h+aum;// ubicacion , no cambiar  
        }   
        if ((aux>0)&&(aux<7)){
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
                cuadroAux[i][j].setFont(new java.awt.Font("Tahoma", 1, tam)); 
                //este es el evento 
                Controlar bt = new Controlar();
                Control boton = new Control();
                cuadroAux[i][j].addActionListener(bt);
                cuadroAux[i][j].addMouseListener(boton);
                panelAux.add(cuadroAux[i][j]);             
                id ++;
                
                k+=l+aum; // ubicacion en el panel no cambiar  
                
                for (int t = 0 ; t < ocupadas.size() ; t ++){
                     if ((ocupadas.get(t)[0]) == null ? cuadroAux[i][j].getName() == null : (ocupadas.get(t)[0]).equals(cuadroAux[i][j].getName())){
                         
                    cuadroAux[i][j].setBackground(new Color(255,51,51));
                    cuadroAux[i][j].setForeground(Color.white);  // pone el color de letra blanco ...
                    cuadroAux[i][j].setFont(new java.awt.Font("Tahoma", 1, tam)); 
                    cuadroAux[i][j].setEnabled(false);
                    
                 }   
                }
            }

            k= ax; // ubicacion , no cambiar 
            z+=h + aum;// ubicacion , no cambiar 
            
        }   
        
        }  
    }
    
    private class Controlar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0 ;  i<filas ; i++){
                for (int j = 0 ;  j<columnas ; j++){                
                    if(e.getSource().equals(cuadro[i][j])){ // si le da click al boton : 
                        cuadro[i][j].setBackground(new Color(255,51,51));
                        cuadro[i][j].setForeground(Color.white);  // pone el color de letra balnco ...
                        estado = true;
                        String s = (cuadro[i][j].getName())+";"+estado+";"+lbHora.getText()+";"; // guarda el nombre del boton o ( el numero de mesa) ...                        
                        guardarMesa(s);    
                        Mesero ventana1 =  new Mesero(cuadro[i][j].getName());
                        ventana1.setVisible(true);
                        dispose();
                    }   
                }   
            }
            for (int i = 0 ;  i<fil ; i++){
                for (int j = 0 ;  j<col ; j++){     
                    if(e.getSource().equals(cuadroAux[i][j])){     
                        cuadroAux[i][j].setBackground(new Color(255,51,51));
                        cuadroAux[i][j].setForeground(Color.white); 
                        estado = true ; 
                        String si = (cuadroAux[i][j].getName())+";"+estado+";"+lbHora.getText()+";"; // guarda el nombre del boton o ( el numero de mesa) ...    
                        guardarMesa(si);
                        Mesero ventana1 =  new Mesero(cuadroAux[i][j].getName());
                        ventana1.setVisible(true);    
                    }   
                }   
            }    
        }
    }
    private class Control implements MouseListener{
        @Override
        public void mouseEntered(MouseEvent evt) {
            String nombre="";
            String [] estado = new String [ocupadas.size()];
            String [] horas = new String [ocupadas.size()];
            for(int i = 0 ;  i<filas ; i++){
                for (int j = 0 ;  j<columnas ; j++){ 
                   if(evt.getSource().equals(cuadro[i][j])){ 
                        for (int t = 0 ; t < ocupadas.size() ; t ++){
                            estado[t] = ocupadas.get(t)[0];
                            horas[t]= ocupadas.get(t)[2];
                            if (estado[t].equals(cuadro[i][j].getName())){
                                
                                nombre = cuadro[i][j].getText(); 
                                titulo.setText(nombre);
                                buscarPedidos(cuadro[i][j].getName());
                                }else {
                                    nombre = cuadro[i][j].getText();
                                    titulo.setText(nombre);
                                    buscarPedidos(cuadro[i][j].getName());
                                    
                            }     
                        }
                    }   
                }
            }    
            for (int i = 0 ;  i<fil ; i++){
                for (int j = 0 ;  j<col ; j++){
                    if(evt.getSource().equals(cuadroAux[i][j])){ 
                        for (int t = 0 ; t < ocupadas.size() ; t ++){
                            estado[t] = ocupadas.get(t)[0];
                            horas[t]= ocupadas.get(t)[2];
                            if (estado[t].equals(cuadro[i][j].getName())){
                                pedidos.setVisible(true);
                                nombre = cuadroAux[i][j].getText(); 
                                titulo.setText(nombre);
                                buscarPedidos(cuadroAux[i][j].getName());
                                }else {
                                    nombre = cuadroAux[i][j].getText();
                                    titulo.setText(nombre);
                                    buscarPedidos(cuadroAux[i][j].getName());
                                   
                                    
                                 
                            }     
                        }
                    }
                }   
            } 
            
        }      
        @Override
        public void mouseReleased(MouseEvent arg0){}
        @Override
        public void mousePressed(MouseEvent arg0){}
        @Override
        public void mouseExited(MouseEvent arg0){}
        @Override
        public void mouseClicked(MouseEvent arg0){}
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
        lbHora = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pedidos = new javax.swing.JList<>();
        horalabel = new javax.swing.JLabel();

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
            .addGap(0, 710, Short.MAX_VALUE)
        );
        panelMesasLayout.setVerticalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        jPanel2.add(panelMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 710, 380));

        panelAux.setBackground(new java.awt.Color(210, 223, 236));
        panelAux.setPreferredSize(new java.awt.Dimension(200, 350));

        javax.swing.GroupLayout panelAuxLayout = new javax.swing.GroupLayout(panelAux);
        panelAux.setLayout(panelAuxLayout);
        panelAuxLayout.setHorizontalGroup(
            panelAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        panelAuxLayout.setVerticalGroup(
            panelAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jPanel2.add(panelAux, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 710, 140));

        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(6, 77, 175));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mesas del restaurante");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 29, -1, -1));

        lbHora.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbHora.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 40, 116, 27));

        fecha.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 320, 29));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 90));

        jPanel3.setBackground(new java.awt.Color(6, 77, 175));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 710, 1110, 50));

        jPanel4.setBackground(new java.awt.Color(114, 216, 114));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 30, 20));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 650, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("No Disponible");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 650, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Disponible");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 650, -1, -1));

        jPanel6.setBackground(new java.awt.Color(192, 208, 224));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));

        titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        pedidos.setBackground(new java.awt.Color(192, 208, 224));
        jScrollPane1.setViewportView(pedidos);

        horalabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(horalabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(horalabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, 320, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel horalabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHora;
    private javax.swing.JPanel panelAux;
    private javax.swing.JPanel panelMesas;
    private javax.swing.JList<String> pedidos;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        Calendar calendar = Calendar.getInstance();
        String [] dias = {"","Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        String [] meses = {"","Enero","Febrero","Marzo","Abril","Mayo","junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        fecha.setText(dias[(calendar.get(7))]+" - "+(calendar.get(5))+" de "+meses[(calendar.get(2)+1)]+" del "+(calendar.get(1))+" ,");
        
        while (ct == h1) {
            calcula();
            lbHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    public void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY);
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }




}
