package org.example.Casino;

public class Banca {

    private int dineroBanca = 5000;

    private int numeroCrupier;

    private int apuestaJugador;

    private static Banca instance = null;
     
    private Banca(){

    }

    private synchronized static void createIntance(){
        if (instance == null){
             instance = new Banca();
        }
    }

    public static Banca getInstance(){
         if (instance == null){
             createIntance();
         }
         return instance;
    }
    
    public synchronized void apostar(int apuesta){
        dineroBanca += apuesta;
        this.apuestaJugador = apuesta;
    }

    public synchronized int numeroCrupier(){
        this.numeroCrupier = (int) (Math.random() * 10) + 1;
        return this.numeroCrupier;
    }

    public synchronized int comprobarNumero(int idJugador, int numeroJugador){
        int ganancias;
        if (this.numeroCrupier == numeroJugador && this.dineroBanca > (this.apuestaJugador * 5) ){
            ganancias = this.apuestaJugador * 5;
            System.out.println("El jugador " +idJugador+ " gana: " +ganancias);
        } else {
            ganancias = 0;
            System.out.println("El jugador " +idJugador+ " gana: " +ganancias);
        }
        return ganancias;
    }


}
