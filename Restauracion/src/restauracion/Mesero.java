/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restauracion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author familia pinillos
 */
public class Mesero extends javax.swing.JFrame implements Runnable {
    JButton[] cuadro;
    JLabel[] letra;
    String hora, minutos, segundos, ampm;
    Thread h1;
    String nombre , rutaImagen ; 
    private int contador = 0 ; 
    private int id = 1 ;
    
    List<String[]> posiciones = new ArrayList<>(); 

    
        
    public Mesero(String Mesa) {
        initComponents();
        listarMeseros();
        verMatriz();
        h1 = new Thread(this);
        h1.start();
        mesaAtender.setText(Mesa);
    }
    
    public void listarMeseros(){
        String ruta = "Meseros/meseros.txt"; 
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
                
                nombre= dato[1];
                rutaImagen = dato[2];
                posiciones.add(new String[]{nombre , rutaImagen}); // Guardar la posicion de la primera letra en el arrayList
                contador++ ; 

            }
            cont.setText(String.valueOf(contador));
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
        int x = 25 ;  
        int y = 25 ; 
        int aum = 180 ;
        
        int a = 25 ; 
        int b =180 ;
        int avan = 180;
           
        //termina de validar las sillas y columnas 
        cuadro = new JButton[contador];
        letra = new JLabel[contador];
        
        
        for (int i = 0 ;  i<contador ; i++){
           
                cuadro[i]= new JButton();
                letra[i] = new JLabel();
                ImageIcon foto = new ImageIcon(posiciones.get(i)[1]);
                cuadro[i].setIcon(foto);
                
                cuadro[i].setBorderPainted(true);
                cuadro[i].setBounds(x,y,150,150);   
                letra[i].setBounds(a,b,150,26); 
 

                letra[i].setText(posiciones.get(i)[0]); 
                
                
                cuadro[i].setName("Mesero "+id);
                letra[i].setName(""+id); 
                
                cuadro[i].setFont(new java.awt.Font("Tahoma", 1, 20)); 
                letra[i].setFont(new java.awt.Font("Tahoma", 1, 20));
                //este es el evento 
                Controlar bt = new Controlar();
                cuadro[i].addActionListener(bt);
                panelMesas.add(cuadro[i]);
                panelMesas.add(letra[i]);
                
                
                id ++;
                x+=aum; // ubicacion en el panell no cambiar    
                a+=avan;
           
        }   
          x= 25 ;
          a = 25 ;
          y+=aum;// ubicacion , no cambiar 
          b+=avan;
     }
    private class Controlar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //String sillas ="";
            //String s;
                for (int i = 0 ;  i<contador ; i++){
                        if(e.getSource().equals(cuadro[i])){ // si le da click al boton : 
                           
                           TormarPedido nuevoPedido = new TormarPedido(mesaAtender.getText(),cuadro[i].getName());
                           nuevoPedido.setVisible(true);
                                                 
                        }   
                    }                
        }
       
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelMesas = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mesaAtender2 = new javax.swing.JLabel();
        mesaAtender = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        fecha = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        mesaAtender1 = new javax.swing.JLabel();
        cont = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(810, 609));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jPanel2.setBackground(new java.awt.Color(231, 224, 224));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 6));
        jPanel2.setPreferredSize(new java.awt.Dimension(770, 680));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMesas.setBackground(new java.awt.Color(231, 224, 224));

        javax.swing.GroupLayout panelMesasLayout = new javax.swing.GroupLayout(panelMesas);
        panelMesas.setLayout(panelMesasLayout);
        panelMesasLayout.setHorizontalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelMesasLayout.setVerticalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        jPanel2.add(panelMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 760, 410));

        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Meseros del restaurante");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mesa :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        mesaAtender2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        mesaAtender2.setForeground(new java.awt.Color(255, 255, 255));
        mesaAtender2.setText("20");
        jPanel1.add(mesaAtender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 80, 30));

        mesaAtender.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        mesaAtender.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(mesaAtender, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 80, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 80));

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fecha.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 330, 29));

        lbHora.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbHora.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 10, 130, 27));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 800, 50));

        mesaAtender1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        mesaAtender1.setForeground(new java.awt.Color(255, 255, 255));
        mesaAtender1.setText("20");
        jPanel2.add(mesaAtender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 80, 30));

        cont.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Mesero.this.dispose();
      Mesas ventana1 =  new Mesas();
      ventana1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cont;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel mesaAtender;
    private javax.swing.JLabel mesaAtender1;
    private javax.swing.JLabel mesaAtender2;
    private javax.swing.JPanel panelMesas;
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
