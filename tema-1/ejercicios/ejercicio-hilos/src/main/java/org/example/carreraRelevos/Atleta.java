package org.example.carreraRelevos;

public class Atleta extends Thread{

    private int dorsal;

    private Carrera carrera;

    public Atleta (int dorsalAtleta){
        this.dorsal = dorsalAtleta;

        carrera = Carrera.getInstance();
    }

    @Override
    public void run(){

        carrera.correr(dorsal);
    }
}
