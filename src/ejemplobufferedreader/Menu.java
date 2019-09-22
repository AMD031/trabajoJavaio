/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplobufferedreader;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author A.M.D
 */
public class Menu {
    
    private static Menu instance;
    private static ArrayList<String>opciones;
    
    
    private Menu(){
        Menu.opciones = new ArrayList<>();
        this.opcionesMenu();
        this.imprimeArray(opciones);
        this.GestionaMenu();
    }
   public static Menu getInstance(){
        if(instance == null){
            instance = new Menu();
         
        }
        return instance;
    }

    
   private void GestionaMenu(){
       try{
       Scanner sc = new Scanner(System.in);
       boolean salir = false;
       int opcion;
       while(!salir){
      
           opcion = sc.nextInt();
           String ruta ="";
           String palabra ="";
           switch(opcion){
               
               case 1:
                   System.out.println("Introduce ruta");
                  
                   ruta = sc.next();
                   sc.nextLine();
                   System.out.println("............................");
                   this.imprimeArray(LeerEscribir.leeFichero(ruta));
                   System.out.println(".............................");
                   this.imprimeArray(opciones);
               
                   break;
               case 2:
                   
                   System.out.println("Introduce ruta.");
                   ruta = sc.next();
                   System.out.println("introduce texto");
                   palabra = sc.next();
                   
                   LeerEscribir.EscribirArchivo(ruta,palabra,1);
                   this.imprimeArray(opciones);
                   break;
               case 3:
                   System.out.println("Introduce ruta.");
                   ruta = sc.next();
                   sc.nextLine();
                   System.out.println("introduce texto");
                   palabra = sc.next();
                   sc.nextLine();
                   
                   LeerEscribir.EscribirArchivo(ruta,palabra,2);
                   this.imprimeArray(opciones);
                   break;
               case 4:
                   System.out.println("Introduce ruta.");
                   ruta = sc.next();
                   sc.nextLine();
                   this.imprimeArray(LeerEscribir.caracteresPorlinea(ruta));
                   this.imprimeArray(opciones);
                   break;
               case 5:
                    System.out.println("Ruta de fichero a crear.");
                   ruta = sc.next();
                   sc.nextLine();
                   
                   if(LeerEscribir.crearFichero(ruta) ==0){
                       System.out.println("Se ha creado con existo.");
                   }else{
                       System.out.println("No se ha podido crear.");
                   }
                   
                   break;
               case 6:
                   System.out.println("Ruta fichero a borrar.");
                   ruta = sc.next();
                   sc.nextLine();
                   if(LeerEscribir.borrarFichero(ruta) == 0){
                       System.out.println("Se ha borrado con existo.");
                   }else{
                       System.out.println("No se ha podido borrar.");
                   }
                   break;     
                   
               case 7:
                   salir=true;
                   break;
                   
                   
           }
        
       }   
      }catch(InputMismatchException e){
        this.imprimeArray(opciones);
        this.GestionaMenu();
      }
    }

    private void opcionesMenu(){
        opciones.add("1 Leer fichero");
        opciones.add("2 Agregar texto sin salto de linea.");
        opciones.add("3 Agregar texto con salto de linea.");
        opciones.add("4 Contar palabras y caracteres por linea");
        opciones.add("5 Crear fichero.");
        opciones.add("6 Borrar fichero.");
        opciones.add("7 Salir");
    }
    
    private void imprimeArray(ArrayList<String>opciones){
        for(String opcion : opciones){
            System.out.println(opcion);
        }     
    }
    
    
        
        
        
 }
    
    
    
    
    

