package org.example.Boxeo;

public class Ring {

    int numeroCombates = 0;
    private final static int COMBATES_MAXIMOS = 100;

     private static Ring instance = null;
     
     private Ring(){

     }

     private synchronized static void createIntance(){
         if (instance == null){
             instance = new Ring();
         }
     }

     public static Ring getInstance(){
         if (instance == null){
             createIntance();
         }
         return instance;
     }


     private int establecerRival (){
        int numero = (int) (Math.random() * 4) + 1;
        return numero;
     }

     private void incrementarCombate(){
         numeroCombates++;
     }


}
