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


     public synchronized boolean luchar(){

         if(numeroCombates < 10) {
             numeroCombates++;
            return true;
         } else {
            return false;
         }
     }





}
