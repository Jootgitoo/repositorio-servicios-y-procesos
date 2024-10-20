package org.example.puente;

public class Vehiculo extends Thread{

    //ATRIBUTOS
    private int numeroVehiculo;
    private Puente puente;

//-----------------------------------------------------------------------------
    //CONSTRUCTOR

    public Vehiculo (int numeroVehiculo){
        this.numeroVehiculo = numeroVehiculo;
        puente = Puente.getInstance();
    }

//-----------------------------------------------------------------------------
    //MÉTODOS

    @Override
    public void run(){
        puente.puedePasar(numeroVehiculo);

        System.out.println("Vehículo " +numeroVehiculo+ " pasando el puente");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println( numeroVehiculo + " saliendo del puente");
        System.out.println();

        puente.avisar();

    }
}
