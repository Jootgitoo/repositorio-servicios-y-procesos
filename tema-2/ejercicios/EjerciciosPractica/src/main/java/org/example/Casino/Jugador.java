package org.example.Casino;

public class Jugador extends Thread{

    private int idJugador;
    private int dineroJugador;
    private int numeroAApostar;
    private final static int APUESTA = 10;

    Banca banca;

    public Jugador(int idJugador){
        this.idJugador = idJugador;
        this.dineroJugador = 100;
        this.numeroAApostar = 0;
        banca = Banca.getInstance();
    }


    @Override
    public void run(){

        while (dineroJugador > 0){

            this.numeroAApostar = (int) (Math.random() * 10) + 1;
            this.dineroJugador -= APUESTA;
            System.out.println("Jugador " +this.idJugador+ " apuesta al numero " +this.numeroAApostar);
            banca.apostar(APUESTA);

            int ganancias = banca.comprobarNumero(this.idJugador, this.numeroAApostar);
            this.dineroJugador += ganancias;
            System.out.println("Saldo del jugador " +this.idJugador+ ": " +this.dineroJugador);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Jugador: " +this.idJugador+ " sin dinero");




    }

}
