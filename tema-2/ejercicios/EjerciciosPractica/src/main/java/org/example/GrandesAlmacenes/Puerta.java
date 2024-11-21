package org.example.GrandesAlmacenes;

public class Puerta {

    private  int unidadesProducto = 100;


    private static Puerta instance = null;

     private Puerta(){

     }

     private synchronized static void createIntance(){
         if (instance == null){
             instance = new Puerta();
         }
     }

     public static Puerta getInstance(){
         if (instance == null){
             createIntance();
         }
         return instance;
     }

     public synchronized boolean entrar(int idCliente){

         System.out.println("Cliente" +idCliente+ " ha entrado");
         return true;
     }

     public synchronized void cogerProducto(int idCliente){

         if (unidadesProducto > 0){
             unidadesProducto--;
             System.out.println("Cliente" +idCliente+ " ha cogido un producto");
         } else {
             System.out.println("No hay ningun prodcuto, me marcho");
         }
     }
}
