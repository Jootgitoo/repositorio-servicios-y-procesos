package org.example.ProductoConsumidorNumeros;

public class ProducirNumero extends Thread{

    int numero;
    ColaNumeros colaNumeros;
    public ProducirNumero(){
        colaNumeros = ColaNumeros.getInstance();
        this.numero = (int) (Math.random() * 10) + 1;
    }


    @Override
    public void run(){
        while (true){
            if (!colaNumeros.addNumero(this.numero)){
                try {
                    Thread.sleep(3000);
                    colaNumeros.addNumero(this.numero);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
