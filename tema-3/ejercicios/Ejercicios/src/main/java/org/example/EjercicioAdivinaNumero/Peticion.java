package org.example.EjercicioAdivinaNumero;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Peticion extends Thread{

    Socket socket;
    NumeroAleatorio claseNumAleatorio;

    //Para hablar al cliente
    ObjectOutputStream oos = null;

    //Para recoger la informacion del cliente
    ObjectInputStream ois = null;

    //Guardo en esta variable el numero aleatorio creado
    int numeroAleatorioServidor;

    public Peticion(Socket socket){
        this.socket = socket;
        this.numeroAleatorioServidor = claseNumAleatorio.crearNumeroAleatorio();
    }

    @Override
    public void run(){
        try {
            escuchar();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void escuchar() throws IOException, ClassNotFoundException {

        System.out.println("Conexion con el cliente exitosa");

        while (true) {
            ois = new ObjectInputStream(socket.getInputStream());

            //Escucho el numero del usuario
            String sNumeroUsuario = (String) ois.readObject();

            //Lo transformo en un String
            int numeroUsuario = Integer.parseInt(sNumeroUsuario);

            //Comprobamos si el usuario ha acertado el numero
            if (numeroUsuario < numeroAleatorioServidor) {

                oos.writeObject("El numero indicado es menor");

            } else if (numeroUsuario == numeroAleatorioServidor) {

                oos.writeObject("Has acertado el numero! :)");
                oos.writeObject("fin_juego");

            } else if (numeroUsuario > numeroAleatorioServidor) {

                oos.writeObject("El numero indicado es mayor");

            } else {
                oos.writeObject("Opcion default");
            }
        }
    }
}



























