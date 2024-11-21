package org.example.ProductoConsumidorNumeros;

public class ProducirNumero extends Thread{

    ColaNumeros colaNumeros;

    public ProducirNumero(){
        colaNumeros = ColaNumeros.getInstance();
    }

    public int crearNumero(){
        int numero = (int) (Math.random() * 10) + 1;
        return numero;
    }

    @Override
    public void run() {

        int numero = crearNumero();
        try {
            colaNumeros.addNumero(numero);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
