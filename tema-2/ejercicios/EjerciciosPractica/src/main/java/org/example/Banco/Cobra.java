package org.example.Banco;

import org.example.CarrerasCoches.Carrera;

public class Cobra extends Thread{

    private int dineroRetirado = 0;

    private Cuenta cuenta;

    public Cobra(){
        cuenta = Cuenta.getInstance();
    }

    @Override
    public void run () {
        while (dineroRetirado < 6000) {

            if(cuenta.retirar()) {
                incrementar();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void incrementar(){
        this.dineroRetirado += 300;
    }

}
