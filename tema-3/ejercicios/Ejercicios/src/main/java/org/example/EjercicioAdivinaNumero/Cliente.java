package org.example.EjercicioAdivinaNumero;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    Socket socket = null;

    //Para hablar al servidor
    ObjectOutputStream oos = null;

    //Para ensordecer al servidor
    ObjectInputStream ois = null;

    //Para pedirle informacion al cliente por consola
    Scanner scanner = null;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cliente cliente = new Cliente();
        cliente.iniciarCliente();
    }

    public void iniciarCliente() throws IOException, ClassNotFoundException {

        //Direccion a donde me quiero conectar
        InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);

        //Inicio el socket
        socket = new Socket();

        //Me conecto
        socket.connect(direccion);
        System.out.println("Cliente conectado al servidor");
        System.out.println();

        scanner = new Scanner(System.in);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());


        boolean salir = false;
        while(!salir){


            //Le pedimos un número al cliente
            System.out.print("Indica un número: ");
            String numeroUsuario = scanner.nextLine();

            //Le mando el numero del usuario al servidor
            oos.writeObject(numeroUsuario);

            //Recojo la respuesta del servidor
            while (!salir){

                String respuestaServidor = (String) ois.readObject();

                if(respuestaServidor.equalsIgnoreCase("fin_juego")){
                    salir = true;
                }else {
                    System.out.println(respuestaServidor);
                }

            }
        }
        //close
        oos.close();
        ois.close();
        scanner.close();
        socket.close();
    }

}



















