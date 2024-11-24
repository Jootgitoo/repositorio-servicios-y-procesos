package org.example.ProductoConsumidorNumeros;

import java.util.LinkedList;

public class ColaNumeros {

    LinkedList<Integer> listaNumeros = new LinkedList<Integer>();

     private static ColaNumeros instance = null;

     private ColaNumeros(){
         rellenarLista();
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

     private void rellenarLista(){
         for(int i=0; i<10; i++){
             int numero = -1;
             listaNumeros.add(numero);
         }
     }

    public boolean addNumero(int numero){
         boolean huecoLibre = false;

         for (int i=0; i<listaNumeros.size() && huecoLibre == false; i++){
            if (listaNumeros.get(i) == -1){
                huecoLibre = true;
                listaNumeros.set(i, numero);
                System.out.println("Numero: " +numero+ " introducido con exito");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
         }
         return huecoLibre;
    }

    public int leerNumero(){
         boolean estaVacia = true;
         int numero = -1;
         for (int i=0; i<listaNumeros.size(); i++){
             if (listaNumeros.get(i) != -1){
                 estaVacia = false;
                 numero = listaNumeros.get(i);
                 listaNumeros.set(i, -1);

             }
         }
         return numero;

    }
}
