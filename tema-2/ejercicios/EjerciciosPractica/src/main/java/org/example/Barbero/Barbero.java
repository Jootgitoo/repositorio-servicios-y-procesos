package org.example.Barbero;

public class Barbero extends Thread{

    private int id;
    Sillas sillas;

    public Barbero(int id){
        this.id = id;
        sillas = Sillas.getInstance();
    }

    @Override
    public void run(){

        while (sillas.getContadorSillasOcupadas() > 0){
            try {
                this.sillas.cortarPelo(this.id);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
