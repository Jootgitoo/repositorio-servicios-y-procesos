package com.psp.ejercicio8Filosofos;

public class Filosofo extends Thread{

    private Mesa mesa;
    private int cubiertoIzq;
    private int cubiertoDer;
    private int num;
    public Filosofo(int num){
        this.mesa = Mesa.getInstance();
        this.num = num;
        if(this.num == 0) {
            this.cubiertoIzq = 0;
            this.cubiertoDer = mesa.cubiertos.length-1;
        }else{
            this.cubiertoIzq = num;
            this.cubiertoDer = num-1;
        }
    }

    @Override
    public void run() {
        while (true){
            if(mesa.isCubiertoLibre(this.cubiertoDer) && mesa.isCubiertoLibre(this.cubiertoIzq)){
                mesa.comer(this.cubiertoDer, this.cubiertoIzq);
                System.out.println("El filosofo "+num+" esta comiendo con los palillos "+cubiertoDer+" y "+cubiertoIzq);
                try {
                    this.sleep(1000);
                    mesa.dejarCubiertos(this.cubiertoDer, this.cubiertoIzq);
                    System.out.println("El filosofo "+ num+" ha dejado de comer y esta pensando");
                    this.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
