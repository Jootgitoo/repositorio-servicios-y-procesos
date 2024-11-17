package org.example.Casino;

public class Banca {

    private int dineroBanca = 500;
    
     private static Banca instance = null;
     
         private Banca(){
     
         }
     
         private synchronized static void createIntance(){
             if (instance == null){
                 instance = new Banca();
             }
         }
     
         public static Banca getInstance(){
             if (instance == null){
                 createIntance();
             }
             return instance;
         }
    
    private synchronized void numeroAleatorio(){
        int numero = (int) (Math.random() * 10) + 1;
    }


}
