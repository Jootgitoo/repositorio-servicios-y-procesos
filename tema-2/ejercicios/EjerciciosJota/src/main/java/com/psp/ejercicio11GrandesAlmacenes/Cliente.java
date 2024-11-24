package com.psp.ejercicio11GrandesAlmacenes;

public class Cliente extends Thread{
    private GrandesAlmacenes almacenes;
    private int intentos;
    private int numCliente;
    public Cliente(int numCliente){
        this.almacenes = GrandesAlmacenes.getInstance();
        this.intentos=0;
        this.numCliente = numCliente;
    }

    @Override
    public void run() {
        while(getIntentos()<10) {
            if (almacenes.isPuertaDisponibles()) {
                System.out.println("El cliente "+this.numCliente+" ha pasado por la puerta");
                if(almacenes.comprarProducto()){
                    System.out.println("Cliente "+numCliente+": He conseguido un producto");
                }else{
                    System.out.println("Cliente "+numCliente+": He entrado pero ya no habia nada");
                }
                setIntentos(10);
            } else {
                System.out.println("El cliente "+this.numCliente+" NO ha pasado");
                setIntentos(getIntentos()-1);
                try {
                    this.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("El cliente "+this.numCliente+" se va");
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
}
