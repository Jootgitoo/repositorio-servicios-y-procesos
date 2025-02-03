package org.example.EjercicioCarreraCamellos;

public class Camello {

    String nombreCamello;
    int distanciaRecorrida;


    public Camello(){

    }
    public Camello(String nombreCamello){
        this.nombreCamello = nombreCamello;
        distanciaRecorrida = 0;
    }

    public String getNombreCamello() {
        return nombreCamello;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public void setNombreCamello(String nombreCamello) {
        this.nombreCamello = nombreCamello;
    }
}