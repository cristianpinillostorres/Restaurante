/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restauracion;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ander
 */
public class TormarPedido extends javax.swing.JFrame implements Runnable {
    String hora, minutos, segundos, ampm;
    Thread h1;
    
    static double total;
    double sub_total;
    double iv;
    /**
     * Creates new form TormarPedido
     * @param mesaAtender
     * @param mesero
     */
    public TormarPedido(String mesaAtender , String mesero) {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        }catch(Exception e){
            e.printStackTrace();
        } 
        initComponents();
        h1 = new Thread(this);
        h1.start();
        mesaAtend.setText(mesaAtender);
        meseroAtender.setText(mesero);
        
        total = 0;
        sub_total = 0;
        iv = 0;
    }
    
    public void listarPlatos(){
        
        DefaultTableModel tabla = new DefaultTableModel();
        
        String dia = diaPedido.getText();
        String ruta = "Menu/Dias/"+dia+".txt";
        tabla.addColumn("Codigo");
        tabla.addColumn("Plato");
        tabla.addColumn("Descripcion ");
        tabla.addColumn("Tipo");
        tabla.addColumn("Precio ");
       
        Object fila[] = new Object[tabla.getColumnCount()];
        
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
                fila[0] = dato[1];
                fila[1] = dato[3];
                fila[2] = dato[4];
                fila[3] = dato[2];
                fila[4] = dato[5];
                tabla.addRow(fila);  
                

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
        verPlatos.setModel(tabla);
        verPlatos.setRowHeight(20);
    } 
    
    private void mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pedidos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JLabel();
        txtIva = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        quitarProduc = new javax.swing.JButton();
        quitarCantidad = new javax.swing.JButton();
        sumarCantidad = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cambios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        verPlatos = new javax.swing.JTable();
        cantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        diaPedido = new javax.swing.JLabel();
        anadir = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        observaciones = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        meseroAtender = new javax.swing.JLabel();
        meseroAtender1 = new javax.swing.JLabel();
        anadir1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        fecha = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        mesaAtend = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusCycleRoot(false);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(251, 192, 163));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 113, 40), 4));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(249, 184, 152));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plato", "Cantidad", "Precio Unitario", "Precio Total", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pedidos.setSelectionBackground(new java.awt.Color(255, 102, 0));
        jScrollPane2.setViewportView(pedidos);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 590, 270));

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("SUBTOTAL:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("IVA:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 40, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 102));
        jLabel8.setText("TOTAL:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, 40));

        txtSubTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSubTotal.setForeground(new java.awt.Color(0, 51, 255));
        jPanel1.add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 90, 40));

        txtIva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIva.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 100, 40));

        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 153, 102));
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 110, 40));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 590, 40));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("_______________");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 160, 20));

        jLabel5.setBackground(new java.awt.Color(255, 204, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PEDIDO ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        quitarProduc.setBackground(new java.awt.Color(245, 192, 192));
        quitarProduc.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        quitarProduc.setForeground(new java.awt.Color(255, 51, 51));
        quitarProduc.setText("X");
        quitarProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarProducActionPerformed(evt);
            }
        });
        jPanel3.add(quitarProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 50, 30));

        quitarCantidad.setBackground(new java.awt.Color(255, 51, 51));
        quitarCantidad.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        quitarCantidad.setForeground(new java.awt.Color(255, 255, 255));
        quitarCantidad.setText("-");
        quitarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarCantidadActionPerformed(evt);
            }
        });
        jPanel3.add(quitarCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 50, 30));

        sumarCantidad.setBackground(new java.awt.Color(0, 204, 102));
        sumarCantidad.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        sumarCantidad.setForeground(new java.awt.Color(255, 255, 255));
        sumarCantidad.setText("+");
        sumarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumarCantidadActionPerformed(evt);
            }
        });
        jPanel3.add(sumarCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 50, 30));

        jButton2.setBackground(new java.awt.Color(255, 51, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Enviar Pedido");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 150, 40));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 680, 450));

        cambios.setBackground(new java.awt.Color(249, 184, 152));
        cambios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        cambios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verPlatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Plato", "Descripcion", "Tipo", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(verPlatos);

        cambios.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 40, 560, 270));
        cambios.add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 51, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("- OBSERVACIONES:");
        cambios.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        diaPedido.setBackground(new java.awt.Color(255, 204, 51));
        diaPedido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        diaPedido.setForeground(new java.awt.Color(255, 255, 255));
        cambios.add(diaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 140, 20));

        anadir.setBackground(new java.awt.Color(255, 51, 0));
        anadir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        anadir.setForeground(new java.awt.Color(255, 255, 255));
        anadir.setText("AGREGAR");
        anadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirActionPerformed(evt);
            }
        });
        cambios.add(anadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 110, 40));

        jLabel10.setBackground(new java.awt.Color(255, 204, 51));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PLATOS - BEBIDAS - ADICIONALES - DEL DIA:");
        cambios.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, 332, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("- CANTIDAD POR PLATO Y/O BEBIDA:");
        cambios.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 240, -1));

        observaciones.setColumns(20);
        observaciones.setLineWrap(true);
        observaciones.setRows(6);
        observaciones.setSelectionColor(new java.awt.Color(255, 153, 51));
        jScrollPane3.setViewportView(observaciones);

        cambios.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 430, 70));

        jPanel4.add(cambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 590, 450));

        jPanel5.setBackground(new java.awt.Color(242, 113, 40));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        meseroAtender.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        meseroAtender.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(meseroAtender, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 460, 29));

        meseroAtender1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        meseroAtender1.setForeground(new java.awt.Color(255, 255, 255));
        meseroAtender1.setText("Atendido por:");
        jPanel5.add(meseroAtender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 130, 29));

        anadir1.setBackground(new java.awt.Color(255, 51, 0));
        anadir1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        anadir1.setForeground(new java.awt.Color(255, 255, 255));
        anadir1.setText("Atras");
        anadir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadir1ActionPerformed(evt);
            }
        });
        jPanel5.add(anadir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 40));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 1300, 60));

        jPanel7.setBackground(new java.awt.Color(242, 113, 40));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fecha.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 320, 30));

        lbHora.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        lbHora.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, 110, 30));

        mesaAtend.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        mesaAtend.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(mesaAtend, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 230, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tomar Pedido:");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirActionPerformed
        DefaultTableModel tabla = new DefaultTableModel();
        int filaSel = verPlatos.getSelectedRow();
        try{ 
            String codigo,plato,descripcion,tipo,precio,cant,importe,obs;
            double calcula=0.0,x=0.0,iva=0.0;
            int canti=0;
            
            if(filaSel==-1){
                JOptionPane.showMessageDialog (null,"Debe seleccionar un producto","Advertecia",JOptionPane.WARNING_MESSAGE);
            }else {
                tabla=(DefaultTableModel) verPlatos.getModel();
                codigo = verPlatos.getValueAt(filaSel,0).toString();
                plato = verPlatos.getValueAt(filaSel,1).toString();
                descripcion = verPlatos.getValueAt(filaSel,2).toString();
                tipo = verPlatos.getValueAt(filaSel,3).toString();
                precio = verPlatos.getValueAt(filaSel,4).toString();
                cant = cantidad.getText();
                obs = observaciones.getText();
                
                //CALCULOS
                
               x=(Double.parseDouble(precio)* Integer.parseInt(cant));
               importe =String.valueOf(x);
               
               tabla=(DefaultTableModel) pedidos.getModel();
               String filaelemento[] = {plato,cant,precio,importe,obs};
               tabla.addRow(filaelemento);
               
               calcula = (Double.parseDouble(precio)* Integer.parseInt(cantidad.getText()));
               
               total=(int) (total+calcula);
               iva=total*0.16;
               iv = (int) iva;
               sub_total=(int) (total-iva);
               
               txtTotal.setText(""+total);
               txtSubTotal.setText(""+sub_total);
               txtIva.setText(""+iv);
               
            }
        }catch (HeadlessException | NumberFormatException e){
             JOptionPane.showMessageDialog (null,"Seleccione un producto","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_anadirActionPerformed

    private void quitarProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarProducActionPerformed
        DefaultTableModel tabla = new DefaultTableModel();
        double x=0.0, ivaAct=0.0,subTotalAct=0.0,precioActual=0.0,importe=0.0;
        int filaSel;
        int resp;
        
        try {
           filaSel = pedidos.getSelectedRow();
           if(filaSel==-1){
               JOptionPane.showMessageDialog (null,"Debe seleccionar un producto","Advertecia",JOptionPane.WARNING_MESSAGE);
           }else{
             resp=JOptionPane.showConfirmDialog (null,"Esta seguro de eliminar este producto","Eliminar",JOptionPane.YES_NO_OPTION); 
             if(resp == JOptionPane.YES_OPTION){
                
                 
                importe=Double.parseDouble(pedidos.getValueAt(filaSel,3).toString());
                System.out.print(importe);
                tabla=(DefaultTableModel) pedidos.getModel();
                tabla.removeRow(pedidos.getSelectedRow());
                
                precioActual =Double.parseDouble(txtTotal.getText())- importe;
                total = precioActual;
                
                
                ivaAct=total*0.16;
                iv = (int) ivaAct;
                sub_total=(int) (total-ivaAct);

                txtTotal.setText(""+total);
                txtSubTotal.setText(""+sub_total);
                txtIva.setText(""+iv);
                
                
             }
           } 
        } catch (Exception e) {
        }
    }//GEN-LAST:event_quitarProducActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void quitarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarCantidadActionPerformed
        double x=0.0, ivaAct=0.0,subTotalAct=0.0,precioTotal=0.0;
        int filaSel ,cantidad=0 , preciounitario = 0,precioActual=0;
        int resp;
        // setValueAt(txtNombre.getText(), filaSeleccionada, 0);    
        try {
           filaSel = pedidos.getSelectedRow();
           if(filaSel==-1){
               JOptionPane.showMessageDialog (null,"Debe seleccionar un producto","Advertecia",JOptionPane.WARNING_MESSAGE);
           }else{
                cantidad=Integer.parseInt(pedidos.getValueAt(filaSel,1).toString());
                cantidad -- ; 
                preciounitario = Integer.parseInt(pedidos.getValueAt(filaSel,2).toString());
                precioTotal =Double.parseDouble(txtTotal.getText())-preciounitario;
                precioActual = cantidad * preciounitario ; 
                pedidos.setValueAt(cantidad, filaSel, 1);
                pedidos.setValueAt(precioActual, filaSel, 3);
                 
                total = precioTotal;
                ivaAct=total*0.16;
                iv = (int) ivaAct;
                sub_total=(int) (total-ivaAct);

                txtTotal.setText(""+total);
                txtSubTotal.setText(""+sub_total);
                txtIva.setText(""+iv);
             }
           
        } catch (Exception e) {
        }
    }//GEN-LAST:event_quitarCantidadActionPerformed

    private void sumarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumarCantidadActionPerformed
        double x=0.0, ivaAct=0.0,subTotalAct=0.0,precioActual=0.0;
        int filaSel ,cantidad=0 , preciounitario = 0;
        int resp;
        // setValueAt(txtNombre.getText(), filaSeleccionada, 0);    
        try {
           filaSel = pedidos.getSelectedRow();
           if(filaSel==-1){
               JOptionPane.showMessageDialog (null,"Debe seleccionar un producto","Advertecia",JOptionPane.WARNING_MESSAGE);
           }else{
                cantidad=Integer.parseInt(pedidos.getValueAt(filaSel,1).toString());
                cantidad ++ ; 
                preciounitario = Integer.parseInt(pedidos.getValueAt(filaSel,2).toString());
                precioActual =Double.parseDouble(txtTotal.getText())+preciounitario;
                pedidos.setValueAt(cantidad, filaSel, 1);
                pedidos.setValueAt(precioActual, filaSel, 3);
                 
                total = precioActual;
                ivaAct=total*0.16;
                iv = (int) ivaAct;
                sub_total=(int) (total-ivaAct);

                txtTotal.setText(""+total);
                txtSubTotal.setText(""+sub_total);
                txtIva.setText(""+iv);
             }
           
        } catch (Exception e) {
        }
    }//GEN-LAST:event_sumarCantidadActionPerformed

    private void anadir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anadir1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anadir;
    private javax.swing.JButton anadir1;
    private javax.swing.JPanel cambios;
    private javax.swing.JTextField cantidad;
    private javax.swing.JLabel diaPedido;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel mesaAtend;
    private javax.swing.JLabel meseroAtender;
    private javax.swing.JLabel meseroAtender1;
    private javax.swing.JTextArea observaciones;
    private javax.swing.JTable pedidos;
    private javax.swing.JButton quitarCantidad;
    private javax.swing.JButton quitarProduc;
    private javax.swing.JButton sumarCantidad;
    private javax.swing.JLabel txtIva;
    private javax.swing.JLabel txtSubTotal;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JTable verPlatos;
    // End of variables declaration//GEN-END:variables
 
    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        Calendar calendar = Calendar.getInstance();
        String [] dias = {"","Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        String [] meses = {"","Enero","Febrero","Marzo","Abril","Mayo","junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        fecha.setText(dias[(calendar.get(7))]+" - "+(calendar.get(5))+" de "+meses[(calendar.get(2)+1)]+" del "+(calendar.get(1))+" ,");
        diaPedido.setText(dias[(calendar.get(7))]);
        listarPlatos();
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