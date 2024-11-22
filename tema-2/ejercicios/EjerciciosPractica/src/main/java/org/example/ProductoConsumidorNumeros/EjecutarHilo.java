package org.example.ProductoConsumidorNumeros;

public class EjecutarHilo {
    public static void main(String[] args) {

        for (int i=0; i<10; i++){
            ProducirNumero pn = new ProducirNumero();
            pn.start();
        }

        for (int i=0; i<5; i++){
            LeerNumeros ln = new LeerNumeros();
            ln.start();
        }


    }



}
