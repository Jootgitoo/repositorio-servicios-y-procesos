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
        this.sillas.cortarPelo(this.id);
    }

}
