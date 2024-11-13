package org.example.JugadorArbitro;

import org.example.Constructora.Almacen;

import java.util.ArrayList;
import java.util.Random;

public class Arbitro {

    private ArrayList<Jugador> listaJugadores;
    private int numeroAAdivinar;


    private static Arbitro instance = null;

    private Arbitro(){

    }

    private synchronized static void createIntance(){
        if (instance == null){
            instance = new Arbitro();
        }
    }

    public static Arbitro getInstance(){
        if (instance == null){
            createIntance();
        }
        return instance;
    }

    private void generarNumeroAleatorio(){
         this.numeroAAdivinar = 1 + (int) (10 * Math.random());
         System.out.println("Numero a adivinar: " +this.numeroAAdivinar);

    }



    private int generarTurno(){

        int numeroTurno = (int) (Math.random() * listaJugadores.size()) + 1;
        return numeroTurno;
    }

    public void numeroJugadores(Jugador jugador){
        listaJugadores = new ArrayList<Jugador>();
        listaJugadores.add(jugador);
    }


    public int numeroJugador(){
        return 1 + (int) (10 * Math.random());
    }

    public synchronized boolean adivinaNumero(int id){
        int numeroTurno = generarTurno();
        boolean numeroAcertado = false;
        if(numeroTurno == id){
            int numeroJugador = numeroJugador();
            if (numeroJugador == this.numeroAAdivinar){
                numeroAcertado = true;
                System.out.println("");
                System.out.println("El jugador: " +id+ "ha acertado el numero");
                System.out.println("El numero a adivinar era " +this.numeroAAdivinar);
                System.out.println("");
            } else {
                numeroAcertado = false;
                System.out.println("");
                System.out.println("El jugador: "+id+ "ha fallado");
                System.out.println("Ha dicho el numero: " +numeroJugador);
                System.out.println("");
            }
        }
        return numeroAcertado;
    }


}