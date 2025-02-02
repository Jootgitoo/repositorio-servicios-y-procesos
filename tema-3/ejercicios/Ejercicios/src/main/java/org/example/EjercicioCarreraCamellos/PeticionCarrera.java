package org.example.EjercicioCarreraCamellos;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PeticionCarrera extends Thread{

    //ATRIBUTOS

    //Para escribir la respuesta al cliente
    PrintWriter pw = null;
    ObjectOutputStream oos = null;

    //Para leer
    InputStream is = null;
    InputStreamReader isr = null;
    BufferedReader bfr = null;
    ObjectInputStream ois = null;

    Socket socket;
    Servidor srv;

    private final static int META = 100;

//--------------------------------------------------------------------------------------
   //CONSTRUCTOR

    public PeticionCarrera(Socket socket){
        this.socket = socket;
        this.srv = new Servidor();
    }

//----------------------------------------------------------------------------------
    //MÉTODOS

    @Override
    public void run(){
        try {
            escuchar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escuchar() throws IOException {

        //pw = new PrintWriter(socket.getOutputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());

        System.out.println("Conexion con el cliente exitosa");

        while(true){

            oos.writeObject("BIENVENIDO A LA CARRERA DE CAMELLOS");

            oos.writeObject("Que comienze la carrera");

            boolean salir = false;
            while(!salir){

                for(Jugador j : srv.listaJuagdores){

                    System.out.println("Entro al bucle for");

                    int distanciaAvanza = avanza();

                    j.getCamello().setDistanciaRecorrida( j.getCamello().getDistanciaRecorrida() + distanciaAvanza );

                    if( j.getCamello().getDistanciaRecorrida() >= META ){
                        oos.writeObject( j.getNombreJugador() + " ha ganado la carrera" );
                        oos.writeObject("Fin juego");

                        salir = true;
                        break;
                    } else {

                        int metrosRestantes = META - j.getCamello().getDistanciaRecorrida();

                        oos.writeObject( j.getCamello().getNombreCamello()+ " avanza " + distanciaAvanza + " metros \n" +
                                " le quedan "+metrosRestantes+ " matros para terminar");
                    }
                }
            }

        }

    }

    public int avanza(){
        int numero = (int) (Math.random() * 50) + 1;

        return numero;
    }
}





















