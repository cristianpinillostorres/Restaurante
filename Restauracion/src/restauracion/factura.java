package restauracion;

import java.io.FileOutputStream;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author familia pinillos
 */
public final class factura {

    List<String[]> pedido = new ArrayList<>();
    private static Font fontBold = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);
    private static Font fontNormal = new Font(Font.FontFamily.COURIER, 11, Font.NORMAL);
    
    public factura(List<String[]> ped) {
        pedido = ped ;
        CrearPDF();
    }
    
     
    public void CrearPDF(){
        try{
            Document documento = new Document(new Rectangle( 350f, 550f));
            FileOutputStream archivo = new FileOutputStream("Factura/factura.pdf");  
            PdfWriter escribir = PdfWriter.getInstance(documento, archivo);
            
            documento.open();
  
            PdfPTable tabla = new PdfPTable(4); //Añadimos una tabla de 7 columnas. 
            tabla.setWidthPercentage(90);//Datos de porcentaje a la tabla (tamaño ancho).
            tabla.setWidths(new float[] {15, 60, 25, 25});//Datos del ancho de cada columna.
            tabla.setHorizontalAlignment(0);
         
            documento.add(getCabecera("Restauracion")); //añadimos el titulo a la factura
            documento.add(getInfo("__________________________________________")); 
            documento.add(getInfo(getTiempo())); //añadimos la hora a la factura
            documento.add(getInfo(" "));
            documento.add(getInfo("Nombre:"));
            documento.add(getInfo("Telefono:")); 
            documento.add(getInfo("__________________________________________")); 
            documento.add(getInfo("  "));
            
            //añadimos los titulos de las tabla
            tabla.addCell(addCelda("CAN"));
            tabla.addCell(addCelda("PRECIO"));
            tabla.addCell(addCelda("UNT"));
            tabla.addCell(addCelda("TOTAL"));
            //añadimos los datos a la factura 
            for (int i = 0; i<pedido.size(); i++){ 
                 tabla.addCell(getCelda(pedido.get(i)[1])); 
                 tabla.addCell(getCelda(pedido.get(i)[0])); 
                 tabla.addCell(getCelda(pedido.get(i)[2])); 
                 tabla.addCell(getCelda(pedido.get(i)[3])); 
             }
            //Añadimos la tabla 
            documento.add(tabla);   
            
            documento.add(getInfo("__________________________________________")); 
            documento.add(getInfo("  "));
            //Cerramos el documento.
            documento.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    private Paragraph getCabecera(String cabecera) {
        Paragraph parrafo = new Paragraph();
        Chunk chunk = new Chunk();
        parrafo.setAlignment(Element.ALIGN_CENTER);
        chunk.append( cabecera +"\n");
        chunk.setFont(fontBold);
        
        
        parrafo.add(chunk);
        
        return parrafo;
    }
    
    private Paragraph getInfo(String informacion) {
        Paragraph parrafo = new Paragraph();
        Chunk chunk = new Chunk();
        parrafo.setAlignment(Element.ALIGN_LEFT);
        chunk.append(informacion+"\n");
        chunk.setFont(fontNormal);
        chunk.getFont().setSize(10);
        parrafo.add(chunk);
        return parrafo;
      }
    
    private PdfPCell getCelda(String texto) throws DocumentException, IOException {
        Chunk chunk = new Chunk();
        chunk.append(texto);
        chunk.setFont(fontNormal);
        PdfPCell celda = new PdfPCell(new Paragraph(chunk));
        celda.setHorizontalAlignment(Element.ALIGN_LEFT);
        celda.setBorder(Rectangle.NO_BORDER);
        return celda;
     }
    private String getTiempo() {
        Date fecha = new Date();
        DateFormat FormatoFecha = new SimpleDateFormat("dd/mm/yyyy");
        DateFormat FormatoHora = new SimpleDateFormat("HH:mm:ss");
        String lineaFecha = "Fecha: "+FormatoFecha.format(fecha)+ " - " + " Hora:"+FormatoHora.format(fecha);

        return lineaFecha;
    }
    
    private PdfPCell addCelda(String texto) throws DocumentException, IOException {
      Chunk chunk = new Chunk();
      chunk.append(texto);
      chunk.setFont(fontBold);
      chunk.getFont().setSize(10);
      PdfPCell cell = new PdfPCell(new Paragraph(chunk));
      cell.setHorizontalAlignment(Element.ALIGN_LEFT);
      return cell;
     }
   
    
}
