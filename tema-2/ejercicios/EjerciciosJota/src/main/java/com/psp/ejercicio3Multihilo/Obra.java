package com.psp.ejercicio3Multihilo;

public class Obra extends Thread{


    private Almacen almacen;
    public int ladrillosUsa;
    private int segundosDescanso;
    private int num;
    public Obra(int num,int ladrillosUsados, int segundosDescanso){
        almacen = Almacen.getInstance();
        this.num=num;
        this.segundosDescanso = segundosDescanso;
        this.ladrillosUsa = ladrillosUsados;
    }

    @Override
    public void run() {
        while(!almacen.isObraParada()) {
            almacen.usarLadrillos(this);
            try {
                this.sleep(this.segundosDescanso * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized int getLadrillosUsa() {
        return ladrillosUsa;
    }

    public void setLadrillosUsa(int ladrillosUsa) {
        this.ladrillosUsa = ladrillosUsa;
    }

    public synchronized int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
