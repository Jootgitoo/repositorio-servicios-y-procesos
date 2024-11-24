package com.psp.ejercicio3Multihilo;

public class Fabrica extends Thread{
    private Almacen almacen;
    public int ladrillosProducidos=0;
    private int loteMaximo = 13500;

    public Fabrica(){
        almacen = Almacen.getInstance();
    }

    @Override
    public void run() {
        while(!almacen.isFabricaCerrada()) {
            almacen.fabricar(this);
            try {
                this.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getLadrillosProducidos() {
        return ladrillosProducidos;
    }

    public void setLadrillosProducidos(int ladrillosProducidos) {
        this.ladrillosProducidos = ladrillosProducidos;
    }
}
