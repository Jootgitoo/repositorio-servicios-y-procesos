package org.example.Banco;

import org.example.CarrerasCoches.Carrera;

public class Cobra extends Thread{

    private int dineroRetirado = 0;
    private Cuenta cuenta;

    public Cobra(){
        cuenta = Cuenta.getInstance();
    }

    @Override
    public void run (){
        while (dineroRetirado < 6000){
            cuenta.retirar(this);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public int getDineroRetirado() {
        return dineroRetirado;
    }

    public void setDineroRetirado(int dineroRetirado) {
        this.dineroRetirado = dineroRetirado;
    }
}
