package tareajavaio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A.M.D
 */

public class LeerEscribir {
    /**
     Funcion que recive un ruta donde esta almacenado un archivo de texto y
     devuelve un ArrayList con el texto.
     
     */
     public static ArrayList<String> leeFichero(String ruta) throws FileNotFoundException{
       ArrayList<String> salida = new ArrayList<String>();
        try {
            //Se crea un objeto de tipo file el cual representa un fichero.
            File rutaArchivo = new File(ruta);
            //comprobamos si existe el fichero y si es un archivo.
            if(rutaArchivo.exists() && rutaArchivo.isFile()){
                  /*Creamos un objeto de tipo FileReader el cual es una clase envoltorio 
                    de File especializada en la lectura y que no permite la escritura*/
                  FileReader archivo = new FileReader(rutaArchivo);
                  
                  /*Se instancia la clase BufferedReader que se usada para leer 
                   los caracteres del archivo linea a linea*/
                  BufferedReader entrada = new BufferedReader(archivo);
                  
                  /*creamos una variable string que almacenara la linea que
                  estamos leyendo del documento. El bucle leera el archivo linea
                  por linea hasta que llegue al final del documento y el metodo  
                  readline devuelva */
                  
                  String linea ="";
                  
                  while (((linea = entrada.readLine())) != null) {                    
                     salida.add(linea);
                 }  
                 //se cierra el flujo de entrada. 
                entrada.close();
            }    
           
        } catch (FileNotFoundException ex) {
           throw new FileNotFoundException("Fichero no encontrado");
        } catch (IOException ex) {
           throw new FileNotFoundException("Error de entrada/salida.");
        }
        return salida;
    }
     
     /**
      * 
      * 
       Funcion que recive una ruta ,un texto, y un modo en el que sera agregado
       el texto..
      */
    public static void EscribirArchivo(String ruta, String agregado, int modo) throws FileNotFoundException{
         //Se crea un objeto de tipo file el cual representa un fichero.
          File rutaArchivo = new File(ruta);
            try {
               //comprobamos si existe el fichero y si es un archivo.
                 if(rutaArchivo.exists() && rutaArchivo.isFile()){
              
                    /*Creamos un archivo de tipo fileWriter y ponemos la opcion append a true para poder añadir 
                     texto al documento*/
                    FileWriter escritura = new FileWriter(rutaArchivo,true);
                    //creamos un flujo de salida para escribir datos en el fichero
                    BufferedWriter salida = new BufferedWriter(escritura);
                    //agregamos texto al documento segun el modo indicado
                    if(modo == 1){
    
                      salida.append(" "+agregado);
                      
                    }else if(modo == 2 ){
                      salida.append("\n"+agregado);
                    }
                    //cerramos el flujo
                    salida.close();
              }
                    
             } catch (IOException ex) {
                     throw new FileNotFoundException("Error de entrada/salida.");
             }
     
        
    }
    
   private static int contarPalabras(String linea){
        int  numeroPalabras = 0;
        String tmp ="";
        StringTokenizer st = new StringTokenizer (linea);
        while (st.hasMoreTokens()) {            
            tmp = st.nextToken();
            numeroPalabras++; 
        }

        return numeroPalabras;
    }
   
   public static int crearFichero(String ruta) throws IOException{
       int control = -1;
       try {
          if(!new File(ruta).createNewFile()){
              control=0;
         }
       } catch (IOException ex) {
              throw new IOException("No se ha podido crear el fichero.");
       }
       return control;
   }
      
    public static void borrarFichero(String ruta) throws Exception{
    
       if( !new File(ruta).delete()){
           throw new Exception("No se ha podido borrar el fichero.");
       }
           
   }
    
   /**
    * Devuelve el numero de caracteres y palabras que tiene cada linea.
    * se usa la funcion contarPalabras dentro de ella para contar palabra.
    * 
    */ 

   public static ArrayList<String>caracteresPorlinea(String ruta){
       
       ArrayList<String> nCaractresPorlinea = new ArrayList<>();
       int nlinea  =0;
       int nCaractres =0;
       
       
       String linea ="";
       //Se crea un objeto de tipo file el cual representa un fichero.
       File rutaArchivo = new File(ruta);
       //comprobamos que la ruta exista.
         if(rutaArchivo.exists() && rutaArchivo.isFile()){
           try {
              //Usamos la clase envoltorio de solo lectura para file.
              FileReader  archivo = new FileReader(rutaArchivo);
             // usamos   BufferedReader para crear un flujo de emtrada y 
             //leer el fichero.
              BufferedReader entrada = new BufferedReader(archivo); 
               
              //contamos los caracteres de cada linea ignorando los espacios.
              while((linea = entrada.readLine())!=null){
                  for (int i = 0; i < linea.length(); i++) {
                    if( linea.charAt(i)!=' '){
                        nCaractres++;
                    }
                  }
                  nlinea++;
                  nCaractresPorlinea.add(nlinea+"º linea "+contarPalabras(linea)+" palabra/s."
                  +" Caractre/s "+nCaractres);  
              }
              entrada.close();
              
           } catch (FileNotFoundException ex) {
               Logger.getLogger(LeerEscribir.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(LeerEscribir.class.getName()).log(Level.SEVERE, null, ex);
           }     
           
         }  
         return nCaractresPorlinea;
     }
    
    
     public static ArrayList<String> listarFichero(String ruta) {
        ArrayList<String> lista = new ArrayList<String>();

            File dir = new File(ruta);
            if (dir.exists() && dir.isDirectory()) {
                File[] ficheros = dir.listFiles();          
                    for (int i = 0; i < ficheros.length; i++) {
                       lista.add(ficheros[i].getName());
                    }
            }

        return lista;
    }
   
    
    
    
    
}
