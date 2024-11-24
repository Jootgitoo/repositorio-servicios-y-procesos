package com.psp.ejercicio10Cola;

public class Lector extends Thread{

    private int numeroLeido;
    private Cola cola;
    public Lector(){
        this.cola = Cola.getInstance();
    }

    @Override
    public void run() {

        while(true) {
            int numLeido;
            numLeido = cola.leer();

            if (!cola.isVacia()) {

                System.out.println("He leido el numero " + numLeido);

            }else {

                System.out.println("La cola esta vacia");
                try {
                    this.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
