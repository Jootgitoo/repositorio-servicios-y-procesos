package org.example.puente;

public class Vehiculo extends Thread{

    private String sitioEntrada;
    private int idVehiculo;
    private Puente puente;

    public Vehiculo(String sitioEntrada, int idVehiculo){

        this.sitioEntrada = sitioEntrada;
        this.idVehiculo = idVehiculo;
        puente = Puente.getInstance();
    }


    @Override
    public void run(){

        puente.pasoVehiculos(sitioEntrada, idVehiculo);
    }


}
