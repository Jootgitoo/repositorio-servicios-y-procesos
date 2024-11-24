package com.psp.ejercicio2Multihilo;

public class Cobra extends Thread{
    private Cuenta cuenta;
    public int acumulado;
    public Cobra(){
        cuenta = Cuenta.getInstance();
        acumulado = 0;
    }

    @Override
    public void run() {
        while(cuenta.isAbierto()) {
            cuenta.retirar(this);
            try {
                this.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        cuenta.setAbierto(false);
    }

    public int getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(int acumulado) {
        this.acumulado = acumulado;
    }
}
