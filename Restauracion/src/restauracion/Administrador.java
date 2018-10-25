package restauracion;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
/**
 *
 * @author familia pinillos
 */
public final class Administrador extends javax.swing.JFrame {

    public Administrador() {
        initComponents();
        diseño();
        listarMeseros();
        listarMesas();
        
    }
     
    private void diseño(){
        panelInsertamesero.setVisible(false);
        panelInsetaMesas.setVisible(false);
        //botones
        guardar.setBackground(new Color(1,28,28));        
    }
    
    /* metodo que crea los archivos del Menu por dia:
            Lo nombra por un dia de la semana ej Lunes .. Martes ,etc.. 
            su contenido son cada uno de los platos del dia  
    */
    public void crearMenu(){ 
        String dia = diaAgregar.getText();
        String ruta = "Dias/"+dia+".txt";
        String dato;
        String cadena; 
        FileWriter fichero = null;  //objeto principal (archivo)
        PrintWriter linea = null;   //objeto de contenido de archivo
        
        try{
            fichero = new FileWriter(ruta,true); //crea el archivo 
            linea = new PrintWriter(fichero); //apunta el PrintWriter al archivo creado
            // Inicia captura de datos del usuario
            cadena = dia + ";" ;
            dato = nombrePlato.getText();
            cadena = cadena + dato + ";";
            dato = desPlato.getText();
            cadena = cadena + dato + ";";
            int num = 0 ;
                try{
                    num  = Integer.parseInt(precioPlato.getText()); 
                    cadena = cadena + num + ";";    
                    linea.println(cadena); //escribiendo en el archivo
                }catch(NumberFormatException ece){
                    mensaje("El valor del precio no es un numero !!!!");
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
        String ruta = "Dias/"+dia+".txt";
        
        tabla.addColumn("Plato");
        tabla.addColumn("Descripcion ");
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
                fila[1] = dato[2];
                fila[2] = dato[3];
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
        String ruta = "Dias/"+dia+".txt";
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
        String ruta = "Dias/"+dia+".txt";
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
   /* 
    public void Escribir(File archivo,String linea){
        // Declaramos un buffer de escritura
        BufferedWriter escribir;
     */
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
        semana = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
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
        diaSel = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        verPlatos = new javax.swing.JTable();
        eliminarPlato = new javax.swing.JButton();
        eliminarTodosPlatos = new javax.swing.JButton();
        panelMeseros = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        verMeseros = new javax.swing.JTable();
        insertarMesero = new javax.swing.JButton();
        panelInsertamesero = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        idMesero = new javax.swing.JTextField();
        nombreMesero = new javax.swing.JTextField();
        guardarMesero = new javax.swing.JButton();
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

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");
        setAutoRequestFocus(false);
        setFocusCycleRoot(false);
        setIconImages(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

        panelMenus.setBackground(new java.awt.Color(204, 204, 204));
        panelMenus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel3.setText("CONFIGURACION DEL MENÚ");
        panelMenus.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        semana.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        semana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un dia:", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo", " " }));
        semana.setOpaque(false);
        semana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semanaActionPerformed(evt);
            }
        });
        panelMenus.add(semana, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 200, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Seleccione un dia para agregar menú:");
        panelMenus.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("______________________________________________________________");
        panelMenus.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 480, 20));

        panelAuxM.setBackground(new java.awt.Color(204, 204, 204));
        panelAuxM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Día a agregar:");
        panelAuxM.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Nombre del plato:");
        panelAuxM.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Descripcion del plato:");
        panelAuxM.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Precio del plato:");
        panelAuxM.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        diaAgregar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelAuxM.add(diaAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 340, 20));
        panelAuxM.add(nombrePlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 340, -1));
        panelAuxM.add(desPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 342, -1));
        panelAuxM.add(precioPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 342, -1));

        diaSel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        panelAuxM.add(diaSel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 170, 40));

        guardar.setBackground(new java.awt.Color(1, 28, 28));
        guardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setText("Agregar Plato");
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        panelAuxM.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 130, 130, 40));

        verPlatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plato", "Descripcion", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        verPlatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verPlatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(verPlatos);

        panelAuxM.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 530, 160));

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
        panelAuxM.add(eliminarPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 110, 40));

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
        panelAuxM.add(eliminarTodosPlatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 370, 130, 40));

        panelMenus.add(panelAuxM, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 610, 440));

        jTabbedPane1.addTab("Menu", panelMenus);
        panelMenus.getAccessibleContext().setAccessibleName("");

        panelMeseros.setBackground(new java.awt.Color(204, 204, 204));
        panelMeseros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel4.setText("ADMINISTRACION DE MESEROS");
        panelMeseros.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

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

        panelMeseros.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 560, 170));

        insertarMesero.setBackground(new java.awt.Color(51, 51, 51));
        insertarMesero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        insertarMesero.setForeground(new java.awt.Color(255, 255, 255));
        insertarMesero.setText("Registrar Mesero");
        insertarMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarMeseroActionPerformed(evt);
            }
        });
        panelMeseros.add(insertarMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 140, 40));

        panelInsertamesero.setBackground(new java.awt.Color(204, 204, 204));
        panelInsertamesero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addGap(57, 57, 57)
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
                .addContainerGap(72, Short.MAX_VALUE))
        );
        panelInsertameseroLayout.setVerticalGroup(
            panelInsertameseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsertameseroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInsertameseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(idMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInsertameseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(nombreMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(guardarMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMeseros.add(panelInsertamesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 560, 140));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Lista de meseros ");
        panelMeseros.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        eliminarMesero.setBackground(new java.awt.Color(51, 51, 51));
        eliminarMesero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eliminarMesero.setForeground(new java.awt.Color(255, 255, 255));
        eliminarMesero.setText("Eliminar Mesero");
        eliminarMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarMeseroActionPerformed(evt);
            }
        });
        panelMeseros.add(eliminarMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 130, 40));

        jTabbedPane1.addTab("Meseros", panelMeseros);

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

        jTabbedPane1.addTab("Mesas", panelMesas);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void insertarMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarMeseroActionPerformed
        panelInsertamesero.setVisible(true);
        limpiarCamposMeseros();
    }//GEN-LAST:event_insertarMeseroActionPerformed

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
        String n = nombrePlato.getText();
        String d = desPlato.getText();
        String p = precioPlato.getText();
         if ((a.equals(""))&&(n.equals(""))&&(d.equals(""))&&(p.equals(""))){
            mensaje("seleccione un plato!");
        }else{ 
            int confir = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar esta plato del menu del dia?","Si/No",0);
            if(confir  == 0){  
                String linea = a+";"+n+";"+d+";"+p+";";
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
            String nombre = ""+verPlatos.getValueAt(clic_tabla,0);
            String descripcion = ""+verPlatos.getValueAt(clic_tabla,1);
            String precio = ""+verPlatos.getValueAt(clic_tabla,2);
               
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cambiaMesas;
    private javax.swing.JButton cambiarMesas;
    private javax.swing.JTextField desPlato;
    private javax.swing.JLabel diaAgregar;
    private javax.swing.JLabel diaSel;
    private javax.swing.JButton eliminarMesero;
    private javax.swing.JButton eliminarPlato;
    private javax.swing.JButton eliminarTodosPlatos;
    private javax.swing.JButton guardar;
    private javax.swing.JButton guardarMesero;
    private javax.swing.JTextField idMesero;
    private javax.swing.JButton insertarMesero;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField nombreMesero;
    private javax.swing.JTextField nombrePlato;
    private javax.swing.JLabel numMesas;
    private javax.swing.JTextField numeroMesas;
    private javax.swing.JPanel panelAuxM;
    private javax.swing.JPanel panelInsertamesero;
    private javax.swing.JPanel panelInsetaMesas;
    private javax.swing.JPanel panelMenus;
    private javax.swing.JPanel panelMesas;
    private javax.swing.JPanel panelMeseros;
    private javax.swing.JTextField precioPlato;
    private javax.swing.JComboBox<String> semana;
    private javax.swing.JButton verMesas;
    private javax.swing.JTable verMeseros;
    private javax.swing.JTable verPlatos;
    // End of variables declaration//GEN-END:variables
}
