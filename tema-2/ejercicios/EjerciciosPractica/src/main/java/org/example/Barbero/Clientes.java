package org.example.Barbero;

public class Clientes extends Thread{
    private int id;
    Sillas sillas;

    public Clientes(int id){
        this.id = id;
        sillas = Sillas.getInstance();
    }


    @Override
    public void run(){

        try {
            sillas.elegirSilla(this.id);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



}
