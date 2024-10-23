package org.example.puente;

public class UsarPuente {

    public static void main(String[] args) {

        Vehiculo v1 = new Vehiculo("Norte", 1);
        Vehiculo v2 = new Vehiculo("Sur", 2);
        Vehiculo v3 = new Vehiculo("Norte", 3);
        Vehiculo v4 = new Vehiculo("Norte", 4);
        Vehiculo v5 = new Vehiculo("Sur", 5);


        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v5.start();
    }
}
