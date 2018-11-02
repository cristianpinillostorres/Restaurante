/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restauracion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author familia pinillos
 */
public class Restauracion {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Administrador ventana =  new Administrador();
      ventana.setVisible(true);
      Mesas ventana1 =  new Mesas();
      ventana1.setVisible(true);
    }
    
      
    
}
