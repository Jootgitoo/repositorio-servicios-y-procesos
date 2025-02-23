package es.jorge.AdivinaNumero;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Peticion extends Thread{

    private Socket socket;

    //Clase serializable para el paso de objetos
    private Numero numero;

    public Peticion(Socket socket, Numero numero){
        this.socket = socket;
        this.numero = numero;
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

            //Escucho la peticion del cliente
            String peticionCliente = (String) ois.readObject();

            int numeroCliente = Integer.parseInt(peticionCliente);
            String respuesta = numero.adivinaNumero(numeroCliente);

            oos.writeObject(respuesta);
            oos.writeObject("fin_peticion");
            oos.flush();

        }

        //Cerramos
        oos.close();
        ois.close();
        socket.close();
    }
}