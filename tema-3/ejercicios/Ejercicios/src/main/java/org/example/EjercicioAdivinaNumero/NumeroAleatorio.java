package org.example.EjercicioAdivinaNumero;

public class NumeroAleatorio {

    private int numeroAleatorio;

    public NumeroAleatorio(){
        this.numeroAleatorio = crearNumeroAleatorio();
    }

    public int crearNumeroAleatorio(){
        return (int) (Math.random() * 10) + 1;
    }


    public int getNumeroAleatorio() {
        return numeroAleatorio;
    }

}