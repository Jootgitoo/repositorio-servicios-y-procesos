package org.example.ProductoConsumidorNumeros;

public class EjecutarHilo {
    public static void main(String[] args) {

        ProducirNumero pn = new ProducirNumero();
        LeerNumeros ln = new LeerNumeros();

        pn.start();
        ln.start();

    }



}
