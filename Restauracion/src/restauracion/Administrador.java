package restauracion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;
/**
 *
 * @author familia pinillos
 */
public final class Administrador extends javax.swing.JFrame implements Runnable{

    String hora, minutos, segundos, ampm;
    Thread h1;
    
    public Administrador() {
        initComponents();
        diseño();
        listarMeseros();
        listarMesas();
        listarTipos();
        h1 = new Thread(this);
        h1.start();
        
    }
     
    private void diseño(){
        panelInsertamesero.setVisible(false);
        panelInsetaMesas.setVisible(false);
        //botones
        
        
                
    }
    
    /* metodo que crea los archivos del Menu por dia:
            Lo nombra por un dia de la semana ej Lunes .. Martes ,etc.. 
            su contenido son cada uno de los platos del dia  
    */
    public void crearMenu(){ 
        String dia = diaAgregar.getText();
        String ruta = "Menu/Dias/"+dia+".txt";
        String dato;
        String cadena; 
        FileWriter fichero = null;  //objeto principal (archivo)
        PrintWriter linea = null;   //objeto de contenido de archivo
        
        try{
            fichero = new FileWriter(ruta,true); //crea el archivo 
            linea = new PrintWriter(fichero); //apunta el PrintWriter al archivo creado
            // Inicia captura de datos del usuario
            cadena = dia + ";" ;
             
            int cod = 0;
            int num = 0 ;
            try{
                cod  = Integer.parseInt(codigoPlato.getText());     
                cadena = cadena + cod + ";";
                dato = labelTipo.getText();
                cadena = cadena + dato + ";";
                dato = nombrePlato.getText();
                cadena = cadena + dato + ";";
                dato = desPlato.getText();
                cadena = cadena + dato + ";";
                num  = Integer.parseInt(precioPlato.getText()); 
                cadena = cadena + num + ";";    
                linea.println(cadena); //escribiendo en el archivo
            }catch(NumberFormatException ece){
                    mensaje("El valor del precio o del codigo no son numeros !!!!");
                    
            }
                    listarPlatos();
            }catch(IOException e){
                    System.out.print("Error creando archivo");
            }
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
    
    public void listarPlatos(){
        DefaultTableModel tabla = new DefaultTableModel();
        
        String dia = diaAgregar.getText();
        String ruta = "Menu/Dias/"+dia+".txt";
        tabla.addColumn("codigo");
        tabla.addColumn("Plato");
        tabla.addColumn("Descripcion ");
        tabla.addColumn("Precio ");
        tabla.addColumn("tipo");
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
                fila[3] = dato[5];
                fila[4] = dato[2];
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
  
    public void eliminar(String lineaBorrar){
        String dia = diaAgregar.getText();
        String ruta = "Menu/Dias/"+dia+".txt";
        System.out.print(ruta);
        try{
            File archivo = new File(ruta);
            File archivoTemporal = new File(archivo.getAbsolutePath() + ".tmp");//crea el archivo temporal
            
            BufferedReader linea  = new BufferedReader(new FileReader(archivo));
            PrintWriter escribir  = new PrintWriter(new FileWriter(archivoTemporal));
            
            String cadena= null; //variable captura los datos del archivo
            while((cadena=linea.readLine()) != null){ //recorre todo el archivo
                if (!cadena.trim().equals(lineaBorrar)) {
                    escribir.println(cadena);
                    escribir.flush();
                }
            }
            
            escribir.close();
            linea.close();
            //elimiona el archivo original 
            if (!archivo.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            //remplaza el nombre del archivo temporal con el nombre que tenia el archivo original 
            if (!archivoTemporal.renameTo(archivo)){
                System.out.println("Could not rename file");
            }
            }catch (FileNotFoundException ex) {
                    ex.printStackTrace();
            }catch (IOException ex) {
                   ex.printStackTrace();
            }
    }
    
    public void eliminarTodosPlatos(){
        String dia = diaAgregar.getText();
        String ruta = "Menu/Dias/"+dia+".txt";
        System.out.print(ruta);
        File archivo = new File(ruta);
        File archivoTemporal = new File(archivo.getName() + ".tmp");//crea el archivo temporal   

        try{
            if(archivo.exists()){
                    // Capturo el nombre del fichero antiguo
                    String nArchivo = archivo.getName();
                    // Borro el fichero antiguo
                    archivo.delete();
                    //Renombro el fichero auxiliar con el nombre del fichero antiguo
                    archivoTemporal.renameTo(archivo);
            }else{
               System.out.println("Fichero no Existe");
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
   
   //-----------------------------------------------------------------------------------
    public void crearTipo(){ 
        String ruta = "Menu/Tipos/tipos.txt";
        String dato;
        String cadena=""; 
        FileWriter fichero = null;  //objeto principal (archivo)
        PrintWriter linea = null;   //objeto de contenido de archivo
        
        try{
            fichero = new FileWriter(ruta,true); //crea el archivo 
            linea = new PrintWriter(fichero); //apunta el PrintWriter al archivo creado
            // Inicia captura de datos del usuario
            int cod = 0;
            try{
                cod  = Integer.parseInt(codigoTipo.getText());     
                cadena = cadena + cod + ";";
                dato = nombreTipo.getText();
                cadena = cadena + dato + ";";
                    
                linea.println(cadena); //escribiendo en el archivo
            }catch(NumberFormatException ece){
                    mensaje("El valor del codigo no es un numero!!!!");
                    
            }
                    listarPlatos();
            }catch(IOException e){
                    System.out.print("Error creando archivo");
            }
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
        
    public void listarTipos(){
        DefaultListModel lista = new DefaultListModel();
        listaTipos.setModel(lista);
        String ruta = "Menu/Tipos/tipos.txt";
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
                lista.addElement(dato[1]);
                tipos.addItem(dato[1]);
                
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
      
    public void crearMeseros(){
        String ruta = "Meseros/meseros.txt";
        String dato;
        String cadena = ""; 
        FileWriter fichero = null;  //objeto principal (archivo)
        PrintWriter linea = null;   //objeto de contenido de archivo
        
        try{
            fichero = new FileWriter(ruta,true); //crea el archivo 
            linea = new PrintWriter(fichero); //apunta el PrintWriter al archivo creado
            // Inicia captura de datos del usuario
            
            int num = 0 ;
                try{
                    if ( validarId(idMesero.getText(),0) == true){
                        mensaje("el id del mesero no esta disponible!");
                    }else{
                        num  = Integer.parseInt(idMesero.getText());
                        cadena = num + ";";
                        dato = nombreMesero.getText();
                        cadena = cadena + dato + ";";
                        linea.println(cadena); //escribiendo en el archivo
                    }
                }catch(NumberFormatException ece){
                    mensaje("El valor del id no es un numero !!!!");
            }
                    listarMeseros();
            }catch(IOException e){
                    System.out.print("Error creando archivo");
            }
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
    
    public void listarMeseros(){
        DefaultTableModel tabla = new DefaultTableModel();
        String ruta = "Meseros/meseros.txt";
        
        tabla.addColumn("Id");
        tabla.addColumn("Nombre del Mesero");
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
                fila[0] = dato[0];
                fila[1] = dato[1];
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
        verMeseros.setModel(tabla);
        verMeseros.setRowHeight(20);
    }   
    
    public boolean validarId(String filtro, int index ){
        String ruta = "Meseros/meseros.txt";
        boolean existe = false;
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
                if(dato[index].equals(filtro)){
                     existe = true;   
                }
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
                
            }
        }
        return existe ; 
    }
    
    public void eliminarMeseros(String lineaBorrar){
        String ruta = "Meseros/meseros.txt";
        try{
            File archivo = new File(ruta);
            File archivoTemporal = new File(archivo.getAbsolutePath() + ".tmp");//crea el archivo temporal
            
            BufferedReader linea  = new BufferedReader(new FileReader(archivo));
            PrintWriter escribir  = new PrintWriter(new FileWriter(archivoTemporal));
            
            String cadena= null; //variable captura los datos del archivo
            while((cadena=linea.readLine()) != null){ //recorre todo el archivo
                if (!cadena.trim().equals(lineaBorrar)) {
                    escribir.println(cadena);
                    escribir.flush();
                }
            }
            
            escribir.close();
            linea.close();
            //elimiona el archivo original 
            if (!archivo.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            //remplaza el nombre del archivo temporal con el nombre que tenia el archivo original 
            if (!archivoTemporal.renameTo(archivo)){
                System.out.println("Could not rename file");
            }
            }catch (FileNotFoundException ex) {
                    ex.printStackTrace();
            }catch (IOException ex) {
                   ex.printStackTrace();
            }
    }
// ---------------------------------------------------------------------------
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
                numMesas.setText(dato[0]);
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
    
    public void numeroMesas(){
            
        String ruta = "Mesas/mesas.txt";
        String dato;
        String cadena = ""; 
        FileWriter fichero = null;  //objeto principal (archivo)
        PrintWriter linea = null;   //objeto de contenido de archivo
        
        try{
            fichero = new FileWriter(ruta,false); //crea el archivo 
            linea = new PrintWriter(fichero); //apunta el PrintWriter al archivo creado
            // Inicia captura de datos del usuario
            
            int num = 0 ;
                try{
                    num  = Integer.parseInt(numeroMesas.getText()); 
                    cadena = num + ";";
                    linea.println(cadena); //escribiendo en el archivo
                }catch(NumberFormatException ece){
                    mensaje("El valor del id no es un numero !!!!");
            }
                    numMesas.setText(String.valueOf(num));
                    
            }catch(IOException e){
                    System.out.print("Error creando archivo");
            }
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
    
    //otros metodos
    private void mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
    public void limpiar(){
        labelTipo.setText("");
        codigoPlato.setText("");
        nombrePlato.setText("");
        desPlato.setText("");
        precioPlato.setText("");
    } 
    public void limpiarCamposMeseros(){
 
        idMesero.setText("");
        nombreMesero.setText("");
            }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelMenus = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelAuxM = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        diaAgregar = new javax.swing.JLabel();
        nombrePlato = new javax.swing.JTextField();
        desPlato = new javax.swing.JTextField();
        precioPlato = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        tipos = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        codigoPlato = new javax.swing.JTextField();
        limpiarCamposMenu = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        semana = new javax.swing.JComboBox<>();
        panelVerMenus = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        verPlatos = new javax.swing.JTable();
        eliminarPlato = new javax.swing.JButton();
        eliminarTodosPlatos = new javax.swing.JButton();
        diaSel = new javax.swing.JLabel();
        panelTiposMenu = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        nombreTipo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        codigoTipo = new javax.swing.JTextField();
        eliminarTipo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaTipos = new javax.swing.JList<>();
        agregarTipo = new javax.swing.JButton();
        editarTipo = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        panelMeseros = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelInsertamesero = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        idMesero = new javax.swing.JTextField();
        nombreMesero = new javax.swing.JTextField();
        guardarMesero = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        verMeseros = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        eliminarMesero = new javax.swing.JButton();
        panelMesas = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        verMesas = new javax.swing.JButton();
        numMesas = new javax.swing.JLabel();
        cambiaMesas = new javax.swing.JButton();
        panelInsetaMesas = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        numeroMesas = new javax.swing.JTextField();
        cambiarMesas = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        fecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");
        setAutoRequestFocus(false);
        setFocusCycleRoot(false);
        setIconImages(null);

        jPanel1.setBackground(new java.awt.Color(96, 157, 97));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(89, 133, 111));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51), 5));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        panelMenus.setBackground(new java.awt.Color(190, 234, 190));
        panelMenus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        panelMenus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel3.setText("CONFIGURACION DEL MENÚ");
        panelMenus.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("______________________________________________________________");
        panelMenus.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 480, 20));

        panelAuxM.setBackground(new java.awt.Color(201, 233, 201));
        panelAuxM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        panelAuxM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Día a agregar:");
        panelAuxM.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Tipo de plato:");
        panelAuxM.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Descripcion del plato:");
        panelAuxM.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Precio del plato:");
        panelAuxM.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        diaAgregar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelAuxM.add(diaAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 340, 20));
        panelAuxM.add(nombrePlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 340, -1));
        panelAuxM.add(desPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 340, -1));
        panelAuxM.add(precioPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 340, -1));

        guardar.setBackground(new java.awt.Color(51, 51, 51));
        guardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setText("Agregar Plato");
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        panelAuxM.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 130, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Codigo del plato:");
        panelAuxM.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        tipos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo:" }));
        tipos.setOpaque(false);
        tipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiposActionPerformed(evt);
            }
        });
        panelAuxM.add(tipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 170, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Nombre del plato:");
        panelAuxM.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        panelAuxM.add(codigoPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 340, -1));

        limpiarCamposMenu.setBackground(new java.awt.Color(51, 51, 51));
        limpiarCamposMenu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        limpiarCamposMenu.setForeground(new java.awt.Color(255, 255, 255));
        limpiarCamposMenu.setText("Limpiar Campos");
        limpiarCamposMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        limpiarCamposMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarCamposMenuActionPerformed(evt);
            }
        });
        panelAuxM.add(limpiarCamposMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 140, 40));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Tipo de plato:");
        panelAuxM.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        panelAuxM.add(labelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 130, 20));

        panelMenus.add(panelAuxM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 560, 260));

        semana.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        semana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un dia:", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo", " " }));
        semana.setOpaque(false);
        semana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semanaActionPerformed(evt);
            }
        });
        panelMenus.add(semana, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 210, -1));

        panelVerMenus.setBackground(new java.awt.Color(201, 233, 201));
        panelVerMenus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        verPlatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        verPlatos.setGridColor(new java.awt.Color(204, 204, 204));
        verPlatos.setSelectionBackground(new java.awt.Color(153, 153, 153));
        verPlatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verPlatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(verPlatos);
        if (verPlatos.getColumnModel().getColumnCount() > 0) {
            verPlatos.getColumnModel().getColumn(0).setPreferredWidth(35);
            verPlatos.getColumnModel().getColumn(1).setPreferredWidth(120);
            verPlatos.getColumnModel().getColumn(2).setPreferredWidth(200);
            verPlatos.getColumnModel().getColumn(3).setPreferredWidth(65);
            verPlatos.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        eliminarPlato.setBackground(new java.awt.Color(51, 51, 51));
        eliminarPlato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eliminarPlato.setForeground(new java.awt.Color(255, 255, 255));
        eliminarPlato.setText("Eliminar");
        eliminarPlato.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eliminarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPlatoActionPerformed(evt);
            }
        });

        eliminarTodosPlatos.setBackground(new java.awt.Color(51, 51, 51));
        eliminarTodosPlatos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eliminarTodosPlatos.setForeground(new java.awt.Color(255, 255, 255));
        eliminarTodosPlatos.setText("Eliminar Todos");
        eliminarTodosPlatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eliminarTodosPlatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTodosPlatosActionPerformed(evt);
            }
        });

        diaSel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout panelVerMenusLayout = new javax.swing.GroupLayout(panelVerMenus);
        panelVerMenus.setLayout(panelVerMenusLayout);
        panelVerMenusLayout.setHorizontalGroup(
            panelVerMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerMenusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelVerMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVerMenusLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVerMenusLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelVerMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVerMenusLayout.createSequentialGroup()
                                .addComponent(eliminarPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eliminarTodosPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVerMenusLayout.createSequentialGroup()
                                .addComponent(diaSel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157))))))
        );
        panelVerMenusLayout.setVerticalGroup(
            panelVerMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerMenusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(diaSel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelVerMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarTodosPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMenus.add(panelVerMenus, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 500, 510));

        panelTiposMenu.setBackground(new java.awt.Color(201, 233, 201));
        panelTiposMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        panelTiposMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("CONFIGURACION DE TIPOS DE MENU");
        panelTiposMenu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));
        panelTiposMenu.add(nombreTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 110, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Codigo:");
        panelTiposMenu.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Nombre:");
        panelTiposMenu.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));
        panelTiposMenu.add(codigoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 110, -1));

        eliminarTipo.setBackground(new java.awt.Color(51, 51, 51));
        eliminarTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eliminarTipo.setForeground(new java.awt.Color(255, 255, 255));
        eliminarTipo.setText("Eliminar");
        eliminarTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eliminarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTipoActionPerformed(evt);
            }
        });
        panelTiposMenu.add(eliminarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 80, 30));

        listaTipos.setBackground(new java.awt.Color(241, 245, 238));
        listaTipos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jScrollPane3.setViewportView(listaTipos);

        panelTiposMenu.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 160, 160));

        agregarTipo.setBackground(new java.awt.Color(51, 51, 51));
        agregarTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        agregarTipo.setForeground(new java.awt.Color(255, 255, 255));
        agregarTipo.setText("Agregar");
        agregarTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        agregarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTipoActionPerformed(evt);
            }
        });
        panelTiposMenu.add(agregarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 90, 30));

        editarTipo.setBackground(new java.awt.Color(51, 51, 51));
        editarTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editarTipo.setForeground(new java.awt.Color(255, 255, 255));
        editarTipo.setText("Editar");
        editarTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        editarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarTipoActionPerformed(evt);
            }
        });
        panelTiposMenu.add(editarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 80, 30));

        panelMenus.add(panelTiposMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 560, 240));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Seleccione un dia para agregar menú:");
        panelMenus.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jTabbedPane1.addTab("Menu ", panelMenus);
        panelMenus.getAccessibleContext().setAccessibleName("");

        panelMeseros.setBackground(new java.awt.Color(190, 234, 190));
        panelMeseros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel4.setText("ADMINISTRACION DE MESEROS");
        panelMeseros.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        panelInsertamesero.setBackground(new java.awt.Color(201, 233, 201));
        panelInsertamesero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Id del Mesero :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Nombre del Mesero :");

        guardarMesero.setBackground(new java.awt.Color(51, 51, 51));
        guardarMesero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        guardarMesero.setForeground(new java.awt.Color(255, 255, 255));
        guardarMesero.setText("Registrar");
        guardarMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarMeseroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInsertameseroLayout = new javax.swing.GroupLayout(panelInsertamesero);
        panelInsertamesero.setLayout(panelInsertameseroLayout);
        panelInsertameseroLayout.setHorizontalGroup(
            panelInsertameseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsertameseroLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelInsertameseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(guardarMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInsertameseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelInsertameseroLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(idMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelInsertameseroLayout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(nombreMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        panelInsertameseroLayout.setVerticalGroup(
            panelInsertameseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsertameseroLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelInsertameseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(idMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(panelInsertameseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(nombreMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(guardarMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        panelMeseros.add(panelInsertamesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 510, 300));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("______________________________________________________________________");
        panelMeseros.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 550, 20));

        jPanel4.setBackground(new java.awt.Color(201, 233, 201));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));

        verMeseros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lista de meseros"
            }
        ));
        verMeseros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verMeserosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(verMeseros);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Lista de meseros ");

        eliminarMesero.setBackground(new java.awt.Color(51, 51, 51));
        eliminarMesero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eliminarMesero.setForeground(new java.awt.Color(255, 255, 255));
        eliminarMesero.setText("Eliminar Mesero");
        eliminarMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarMeseroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eliminarMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eliminarMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panelMeseros.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 490, 300));

        jTabbedPane1.addTab("Meseros ", panelMeseros);

        panelMesas.setBackground(new java.awt.Color(204, 204, 204));
        panelMesas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel14.setText("ASIGNACION DE LAS MESAS");
        panelMesas.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        verMesas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        verMesas.setText("ver mesas ");
        verMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verMesasActionPerformed(evt);
            }
        });
        panelMesas.add(verMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 130, 40));

        numMesas.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        panelMesas.add(numMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 60, 20));

        cambiaMesas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cambiaMesas.setText("cambiar numero de mesas");
        cambiaMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiaMesasActionPerformed(evt);
            }
        });
        panelMesas.add(cambiaMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 200, 40));

        panelInsetaMesas.setBackground(new java.awt.Color(200, 200, 200));
        panelInsetaMesas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Ingrese nuevo numero de mesas: ");

        cambiarMesas.setText("Cambiar");
        cambiarMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarMesasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInsetaMesasLayout = new javax.swing.GroupLayout(panelInsetaMesas);
        panelInsetaMesas.setLayout(panelInsetaMesasLayout);
        panelInsetaMesasLayout.setHorizontalGroup(
            panelInsetaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsetaMesasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numeroMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cambiarMesas, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelInsetaMesasLayout.setVerticalGroup(
            panelInsetaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsetaMesasLayout.createSequentialGroup()
                .addGroup(panelInsetaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInsetaMesasLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelInsetaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numeroMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(panelInsetaMesasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cambiarMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelMesas.add(panelInsetaMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 490, 70));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("El numero actual de mesas es: ");
        panelMesas.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelMesas.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, -1, -1));

        jTabbedPane1.addTab("Mesas ", panelMesas);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1130, 680));

        jPanel3.setBackground(new java.awt.Color(0, 102, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fecha.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 300, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMINISTRADOR");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 14, -1, -1));

        lbHora.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        lbHora.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, 110, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void semanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semanaActionPerformed
        String [] dias = {"","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        
        panelAuxM.setVisible(true);
        int index = semana.getSelectedIndex();
        if(index == 0 ){
            mensaje("Seleccione un dia ! ");
            diaAgregar.setText("");
        }else{
        diaAgregar.setText(dias[index]);
        diaSel.setText(dias[index]);
        listarPlatos();
        limpiar();
        }
    
    }//GEN-LAST:event_semanaActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        crearMenu();
        listarPlatos();
        limpiar();
    }//GEN-LAST:event_guardarActionPerformed

    private void verMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verMesasActionPerformed
        VerMesas m;
        m = new VerMesas(numMesas.getText());
        m.setVisible(true);        
    }//GEN-LAST:event_verMesasActionPerformed

    private void guardarMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarMeseroActionPerformed
        crearMeseros();
        listarMeseros();
        limpiarCamposMeseros();
        panelInsertamesero.setVisible(false);
    }//GEN-LAST:event_guardarMeseroActionPerformed

    private void cambiaMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiaMesasActionPerformed
        panelInsetaMesas.setVisible(true);
    }//GEN-LAST:event_cambiaMesasActionPerformed

    private void cambiarMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarMesasActionPerformed
        
        numeroMesas();
        panelInsetaMesas.setVisible(false);
        numeroMesas.setText("");
    }//GEN-LAST:event_cambiarMesasActionPerformed

    private void eliminarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPlatoActionPerformed
        String a = diaAgregar.getText();
        String t = labelTipo.getText();
        String c = codigoPlato.getText();
        String n = nombrePlato.getText();
        String d = desPlato.getText();
        String p = precioPlato.getText();
         if ((n.equals(""))&&(d.equals(""))&&(p.equals(""))&&(c.equals(""))&&(t.equals(""))){
            mensaje("seleccione un plato!");
        }else{ 
            int confir = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar esta plato del menu del dia?","Si/No",0);
            if(confir  == 0){  
                String linea = a+";"+c+";"+t+";"+n+";"+d+";"+p+";";
                eliminar(linea);
                listarPlatos();
                limpiar();
            }else{
                limpiar();
            }
        }
    }//GEN-LAST:event_eliminarPlatoActionPerformed

    private void verPlatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verPlatosMouseClicked
          int clic_tabla = verPlatos.rowAtPoint(evt.getPoint());
          try{
            String codigo = ""+verPlatos.getValueAt(clic_tabla,0);
            String tipo = ""+verPlatos.getValueAt(clic_tabla,4);
            String nombre = ""+verPlatos.getValueAt(clic_tabla,1);
            String descripcion = ""+verPlatos.getValueAt(clic_tabla,2);
            String precio = ""+verPlatos.getValueAt(clic_tabla,3);
            
            codigoPlato.setText(codigo);
            labelTipo.setText(tipo);
            nombrePlato.setText(nombre);
            desPlato.setText(descripcion);
            precioPlato.setText(precio);

        }catch(Exception ex){
        }
    }//GEN-LAST:event_verPlatosMouseClicked

    private void eliminarMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarMeseroActionPerformed
        String i = idMesero.getText();
        String n = nombreMesero.getText();
        
        if ((i.equals(""))&&(n.equals(""))){
            mensaje("seleccione un empleado!");
        }else{
            int confir = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este empleado?","Si/No",0);
            if(confir  == 0){
                String linea = i+";"+n+";";
                eliminarMeseros(linea);
                listarMeseros();
                limpiarCamposMeseros();
            }else{
                listarMeseros();
                }
        }        
    }//GEN-LAST:event_eliminarMeseroActionPerformed

    private void verMeserosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMeserosMouseClicked
        int clic_tabla = verMeseros.rowAtPoint(evt.getPoint());
          try{
            String id = ""+verMeseros.getValueAt(clic_tabla,0);
            String nombre = ""+verMeseros.getValueAt(clic_tabla,1);
            
            idMesero.setText(id);
            nombreMesero.setText(nombre);
            

        }catch(Exception ex){
        } 
    }//GEN-LAST:event_verMeserosMouseClicked

    private void eliminarTodosPlatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarTodosPlatosActionPerformed
        eliminarTodosPlatos();
        listarPlatos();
        limpiar();
    }//GEN-LAST:event_eliminarTodosPlatosActionPerformed

    private void tiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiposActionPerformed
        
        int index = tipos.getSelectedIndex();
        String dato = (String)tipos.getSelectedItem();
        if(index == 0 ){
            mensaje("Seleccione un tipo ! ");
            labelTipo.setText("");
        }else{
        labelTipo.setText(dato);
        }
    }//GEN-LAST:event_tiposActionPerformed

    private void limpiarCamposMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarCamposMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_limpiarCamposMenuActionPerformed

    private void eliminarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarTipoActionPerformed

    private void agregarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTipoActionPerformed
        crearTipo();
        listarTipos();
    }//GEN-LAST:event_agregarTipoActionPerformed

    private void editarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarTipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarTipo;
    private javax.swing.JButton cambiaMesas;
    private javax.swing.JButton cambiarMesas;
    private javax.swing.JTextField codigoPlato;
    private javax.swing.JTextField codigoTipo;
    private javax.swing.JTextField desPlato;
    private javax.swing.JLabel diaAgregar;
    private javax.swing.JLabel diaSel;
    private javax.swing.JButton editarTipo;
    private javax.swing.JButton eliminarMesero;
    private javax.swing.JButton eliminarPlato;
    private javax.swing.JButton eliminarTipo;
    private javax.swing.JButton eliminarTodosPlatos;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JButton guardarMesero;
    private javax.swing.JTextField idMesero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel lbHora;
    private javax.swing.JButton limpiarCamposMenu;
    private javax.swing.JList<String> listaTipos;
    private javax.swing.JTextField nombreMesero;
    private javax.swing.JTextField nombrePlato;
    private javax.swing.JTextField nombreTipo;
    private javax.swing.JLabel numMesas;
    private javax.swing.JTextField numeroMesas;
    private javax.swing.JPanel panelAuxM;
    private javax.swing.JPanel panelInsertamesero;
    private javax.swing.JPanel panelInsetaMesas;
    private javax.swing.JPanel panelMenus;
    private javax.swing.JPanel panelMesas;
    private javax.swing.JPanel panelMeseros;
    private javax.swing.JPanel panelTiposMenu;
    private javax.swing.JPanel panelVerMenus;
    private javax.swing.JTextField precioPlato;
    private javax.swing.JComboBox<String> semana;
    private javax.swing.JComboBox<String> tipos;
    private javax.swing.JButton verMesas;
    private javax.swing.JTable verMeseros;
    private javax.swing.JTable verPlatos;
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
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }
}