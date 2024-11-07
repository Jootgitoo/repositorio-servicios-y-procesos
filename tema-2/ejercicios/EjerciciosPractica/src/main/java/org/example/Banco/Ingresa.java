package org.example.Banco;

import org.example.CarrerasCoches.Carrera;

public class Ingresa extends Thread{

    private Cuenta cuenta;
    int contador = 0;

    public Ingresa(){
        cuenta = Cuenta.getInstance();

    }

    @Override
    public void run (){
        while (contador < 90){
            cuenta.ingresar();
            contador+= 2;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
