package org.example.EjercicioCarreraCamellos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {

    //Socket para conectarse
    Socket socket = null;

    //Para hablar al servidor
    PrintWriter pw = null;

    //Para recibir la informacion del servidor
    ObjectInputStream ois = null;

//--------------------------------------------------------------
    //MÉTODOS

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Cliente cliente = new Cliente();
        cliente.iniciarCliente();
    }


    public void iniciarCliente() throws IOException, ClassNotFoundException, InterruptedException {

        //Direccion a donde me quiero conectar
        InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);

        //Inicio el socket
        socket = new Socket();

        //Me conecto
        socket.connect(direccion);
        System.out.println("Cliente conectado al servidor");
        System.out.println();

        ois = new ObjectInputStream(socket.getInputStream());

        boolean salir = false;
        while(!salir){

            while(true){
                String inputServidor = (String) ois.readObject();
                System.out.println(inputServidor);


                if(inputServidor.equalsIgnoreCase("Fin juego")){
                    salir = true;
                    break;
                }
                Thread.sleep(1500);

                System.out.println();
            }
        }
        ois.close();
        socket.close();
    }

}

























