package org.example.ProductoConsumidorNumeros;

public class ColaNumeros {

    private static final int SIZE_MAX_LIST = 10;

    private int[] listaNumeros = new int[SIZE_MAX_LIST];

    private static ColaNumeros instance = null;

     private ColaNumeros(){

     }

     private synchronized static void createIntance(){
         if (instance == null){
             instance = new ColaNumeros();
         }
     }

     public static ColaNumeros getInstance(){
         if (instance == null){
             createIntance();
         }
         return instance;
     }

    public synchronized void addNumero(int numero) throws InterruptedException {
         boolean vacia = false;
         int ultimaPosicionVacia = 0;

         for (int i=0; i< listaNumeros.length; i++){
            if (listaNumeros[i] == 0){
                vacia = true;
                ultimaPosicionVacia = i;
            } else {
                vacia = false;
            }
        }

        if (vacia){

            listaNumeros[ultimaPosicionVacia] = numero;

        } else {
            System.out.println("No se ha podido añadir ningún numero");
            Thread.sleep(1000);
            addNumero(numero);

        }

    }

    public synchronized void leerNumero() throws InterruptedException {

        boolean vacia = false;
        int primerNumero = 0;

        //Examino si la cola está vacia
         for (int i=0; i<listaNumeros.length; i++){
            if (listaNumeros[i] == 0){
                vacia = true;
                System.out.println("No se ha podido leer ningún numero por que la cola está vacia");

            } else {
                vacia = false;
                if (primerNumero == 0){
                    primerNumero = listaNumeros[i];
                    listaNumeros[i] = 0;
                }
            }
         }

         if(vacia){
             Thread.sleep(2000);
         } else {
             System.out.println("Numero leido: " +primerNumero);


         }

    }
}
