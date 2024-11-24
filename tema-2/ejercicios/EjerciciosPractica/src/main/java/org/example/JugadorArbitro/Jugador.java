package org.example.JugadorArbitro;

public class Jugador extends Thread{

    private int id;
    Arbitro arbitro;

    public Jugador(int id){
        this.id = id;
        arbitro = Arbitro.getInstance();
    }

    @Override
    public void run(){
        arbitro.numeroJugadores(this);

        boolean numeroAdivinado = false;
        while (!numeroAdivinado){
            numeroAdivinado = arbitro.adivinaNumero(this.id);
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
