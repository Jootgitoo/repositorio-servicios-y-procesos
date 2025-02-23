package es.jorge.AdivinaNumero;

import java.io.Serializable;

public class Numero implements Serializable {

    private int numero;

    public Numero(){
        this.numero = (int) (Math.random() * 10) + 1;
    }


    public String adivinaNumero(int numeroUsuario){
        String respuesta;

        if( numeroUsuario > this.numero ){

            respuesta = "El número indicado es mayor al que hay que adivinar";

        } else if (numeroUsuario < this.numero) {

            respuesta = "El número del usuario es menor al que hay que adivinar";

        } else {

            respuesta = "Enhorabuena. Has acertado el número!";

        }

        return respuesta;

    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}