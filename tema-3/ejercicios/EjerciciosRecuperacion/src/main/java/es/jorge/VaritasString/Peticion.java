package es.jorge.VaritasString;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Peticion extends Thread{

    private Socket socket;

    //Clase serializable para el paso de objetos
    private Varitas varitas;

    public Peticion(Socket socket, Varitas varitas){
        this.socket = socket;
        this.varitas = varitas;
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

            //Leo la peticion
            String peticionCliente = (String) ois.readObject();

            //Obtengo la varita
            Varitas varita = varitas.obtenerVarita();

            if(varita == null){
                salir = false;
            }

            //Se la envio al cliente
            oos.writeObject(varita);
        }

        //Cerramos
        oos.close();
        ois.close();
        socket.close();
    }
}