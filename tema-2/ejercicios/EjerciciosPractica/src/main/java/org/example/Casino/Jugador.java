package org.example.Casino;

public class Jugador extends Thread{

    private int idJugador;
    private int dineroJugador;
    private int numeroAApostar;

    public Jugador(int idJugador){
        this.idJugador = idJugador;
        this.dineroJugador = 100;
        this.numeroAApostar = 0;
    }


    @Override
    public void run(){
        this.numeroAApostar = numeroAleatorio();
        this.dineroJugador -= 10;
        System.out.println("Jugador " +this.idJugador+ " apuesto al numero " +this.numeroAApostar);



    }

    private int numeroAleatorio(){
        int numero = (int) (Math.random() * 10) + 1;
        return numero;
    }
}
