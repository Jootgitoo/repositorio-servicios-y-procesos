package com.psp.ejercicio10Cola;

import java.util.LinkedList;

public class Cola {
    private final static int TAMAÑO_MAX=10;
    private static Cola instance = null;
    public boolean llena;

    private static  Object object = new Object();
    public boolean vacia;

    LinkedList<Integer> cola = new LinkedList<Integer>();
        private Cola(){
            vacia=true;
            llena=false;
        }

        private synchronized static void createInstance() {
            if (instance == null) {
                instance = new Cola();
            }
        }
        public static Cola getInstance() {
            if (instance == null) {
                createInstance();
            }
            return instance;
        }

        public int leer(){

            int leido=0;
            if(cola.size()>0){
                leido=cola.getFirst();
                synchronized (object) {
                    cola.removeFirst();
                }
                setLlena(false);
            }else{
                setVacia(true);
            }
            return leido;
        }

        public boolean escribir(int numeroProducido){
            boolean vuelta = false;
            if(cola.size() < TAMAÑO_MAX){

                synchronized (object) {
                    cola.add(numeroProducido);
                    vuelta=true;
                }
                setVacia(false);
            }else{
               setLlena(true);
            }

            return vuelta;
        }

    public boolean isLlena() {
        synchronized (object) {
            return llena;
        }

    }

    public void setLlena(boolean llena) {
            synchronized (object) {
                this.llena = llena;
            }
    }

    public boolean isVacia() {
        synchronized (object) {
            return vacia;
        }

    }

    public void setVacia(boolean vacia) {
            synchronized (object) {
                this.vacia = vacia;
            }
    }
}
