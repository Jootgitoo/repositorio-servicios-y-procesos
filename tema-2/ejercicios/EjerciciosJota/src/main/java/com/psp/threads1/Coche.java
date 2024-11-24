package com.psp.threads1;

import java.util.Random;

public class Coche extends Thread implements Comparable<Coche>{
    private Carrera carrera;
    private Random r = new Random();
    public String nombre;
    public int distanciaRecorrida;
    public int distanciaIteracion;

    public Coche(String nombre){
        this.distanciaIteracion=r.nextInt(1,51);
        this.distanciaRecorrida=0;
        this.nombre=nombre;
        this.carrera = Carrera.getInstance();

    }

    @Override
    public void run() {
        while(!carrera.isAcabar()) {
            try {
                this.setDistanciaRecorrida((int)this.getDistanciaRecorrida()+this.getDistanciaIteracion());
                carrera.avanzar(this);
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public int getDistanciaIteracion() {
        return distanciaIteracion;
    }

    public void setDistanciaIteracion(int distanciaIteracion) {
        this.distanciaIteracion = distanciaIteracion;
    }

    @Override
    public int compareTo(Coche c) {
        //ordenacion ascendente
        return Integer.valueOf(this.distanciaRecorrida).compareTo((int)c.getDistanciaRecorrida());
    }

}
