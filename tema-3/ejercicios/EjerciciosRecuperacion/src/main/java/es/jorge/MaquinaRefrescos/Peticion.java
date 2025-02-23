package es.jorge.MaquinaRefrescos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Peticion extends Thread{

    private Socket socket;

    //Clase serializable para el paso de objetos
    private Maquina maquina;

    public Peticion(Socket socket, Maquina maquina){
        this.socket = socket;
        this.maquina = maquina;
    }

    @Override
    public void run(){

        try {
            escuchar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void escuchar() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        System.out.println("Conexion con el cliente exitosa");

        //Para leer la peticion del cliente
        ois = new ObjectInputStream(socket.getInputStream());

        //Para enviar datos al cliente
        oos = new ObjectOutputStream(socket.getOutputStream());

        boolean salir = false;
        while (!salir){

            //Leo la peticion del cliente
            String peticionCliente;

            if( (peticionCliente = (String) ois.readObject()).equalsIgnoreCase("salir")){ //Si el cliente quiere salir

                oos.writeObject("saliendo");
                oos.writeObject("fin_respuesta");
                oos.flush();
                salir = true;

            } else {

                int numRefrescosPeticion = Integer.parseInt(peticionCliente);
                String respuestaMaquina = maquina.pedirRefrescos(numRefrescosPeticion);
                oos.writeObject(respuestaMaquina);
                oos.writeObject("Quedan " +maquina.getRefrescosRestantes()+ " refrescos");
                oos.writeObject("fin_respuestas");
                oos.flush();
            }
        }

        //Cerramos
        oos.close();
        ois.close();
        socket.close();
    }
}