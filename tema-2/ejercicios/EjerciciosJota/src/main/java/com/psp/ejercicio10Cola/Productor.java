package com.psp.ejercicio10Cola;

public class Productor extends Thread{

    private int numeroProducido;
    private Cola cola;
    public Productor(){
        this.cola = Cola.getInstance();
    }

    @Override
    public void run() {

        while (true) {
            generarNumero();
            while(!cola.escribir(getNumeroProducido())) {
                cola.escribir(getNumeroProducido());
                if (cola.isLlena()) {
                    System.out.println("La cola esta llena");
                    try {
                        this.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }


    public void generarNumero(){
        setNumeroProducido(1 + (int) (10 * Math.random()));
    }
    public int getNumeroProducido() {
        return numeroProducido;
    }
    public void setNumeroProducido(int numeroProducido) {
        this.numeroProducido = numeroProducido;
    }
}
