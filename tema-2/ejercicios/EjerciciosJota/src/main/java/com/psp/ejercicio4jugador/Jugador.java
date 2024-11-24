package com.psp.ejercicio4jugador;

public class Jugador extends Thread{

    private Arbitro arbitro;
    public int idJugador;
    public int numeroDicho;
    public Jugador(int id){
        this.arbitro = Arbitro.getInstance();
        this.idJugador = id;
        this.numeroDicho=0;
    }

    @Override
    public void run() {
        while(!arbitro.isFinalizado()){
            setNumeroDicho(decirNumero());
            arbitro.comprobarNumero(this);
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int decirNumero(){
        return 1 + (int) (10 * Math.random());
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int id) {
        this.idJugador = id;
    }

    public int getNumeroDicho() {
        return numeroDicho;
    }

    public void setNumeroDicho(int numeroDicho) {
        this.numeroDicho = numeroDicho;
    }
}
