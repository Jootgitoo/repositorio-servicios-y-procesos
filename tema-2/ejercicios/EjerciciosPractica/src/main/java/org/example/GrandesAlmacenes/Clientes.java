package org.example.GrandesAlmacenes;

public class Clientes extends Thread {

    private int id;
    private int intentos;
    private boolean entrado;
    private final static int INTENTOS_MAX = 10;

    Puerta puerta;

    public Clientes(int id){
        this.id = id;
        this.intentos = 0;
        this.entrado = false;
        puerta = Puerta.getInstance();
    }

    @Override
    public void run(){

        intentos++;
        this.entrado = puerta.entrar();

        if (entrado){
            puerta.cogerProducto(this.id);
        } else {
            intentos++;
            this.entrado = puerta.entrar();

        }

    }
}
