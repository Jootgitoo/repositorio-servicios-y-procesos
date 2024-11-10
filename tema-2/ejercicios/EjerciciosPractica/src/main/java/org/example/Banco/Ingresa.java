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
            if (cuenta.ingresar()) {
                aumnentarContador();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();            }
        }

    }

    private void aumnentarContador(){
        this.contador += 2;
        System.out.println("En total has dormido "+this.contador+ " sgundos");
    }

}
