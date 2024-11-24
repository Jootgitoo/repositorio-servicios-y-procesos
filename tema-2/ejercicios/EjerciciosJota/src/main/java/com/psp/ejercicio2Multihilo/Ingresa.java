package com.psp.ejercicio2Multihilo;

public class Ingresa extends Thread{
    public Cuenta cuenta;
    public int contTiempo;
    public Ingresa(){
        cuenta = Cuenta.getInstance();
        contTiempo=0;
    }
    @Override
    public void run() {
        while(cuenta.isAbierto()) {
            cuenta.ingresar(this.contTiempo);
            try {
                this.sleep(2000);
                contTiempo = contTiempo + 2;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
