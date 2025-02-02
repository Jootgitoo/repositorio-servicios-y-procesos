package org.example.EjercicioCarreraCamellos;

public class Jugador {

    //ATRIBUTOS
    private int idJugador;
    private String nombreJugador;
    Camello camello;

//---------------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR
    public Jugador(){

    }

    public Jugador(int idJugador, String nombreJugador, Camello camelloJuagdor){
        this.idJugador = idJugador;
        this.nombreJugador = nombreJugador;
        this.camello = camelloJuagdor;
    }

//----------------------------------------------------------------------------------------------------------------------
    //MÉTODOS

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Camello getCamello() {
        return camello;
    }

    public void setCamello(Camello camello) {
        this.camello = camello;
    }
}