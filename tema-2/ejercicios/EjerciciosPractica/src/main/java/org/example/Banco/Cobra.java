package org.example.Banco;

import org.example.CarrerasCoches.Carrera;

public class Cobra extends Thread{

    private int dineroRetirado = 0;

    private Cuenta cuenta;

    public Cobra(){
        cuenta = Cuenta.getInstance();
        this.dineroRetirado = 0;
    }

    @Override
    public void run () {
        while (dineroRetirado < 6000) {
            if(cuenta.retirar()) {
                incrementar();
                comprobarDineroRetirado();
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
        System.out.println("En total has retirado " +this.dineroRetirado);
        System.out.println("");


    }

    private void comprobarDineroRetirado(){
        if (this.dineroRetirado >= 6000){
            System.out.println("Como hemos retirado 6000 termina el programa");
            System.exit(0);
        }
    }

}
