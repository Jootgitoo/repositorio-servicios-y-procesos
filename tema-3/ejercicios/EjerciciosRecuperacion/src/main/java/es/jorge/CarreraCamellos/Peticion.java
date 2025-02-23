package es.jorge.CarreraCamellos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Peticion extends Thread{

    private final static int DISTANCIA_CARRERA = 100;

    private Socket socket;

    //Clase serializable para el paso de objetos
    private Camello camello;

    public Peticion(Socket socket, Camello camello){
        this.socket = socket;
        this.camello = camello;
    }

    @Override
    public void run(){

        try {
            escuchar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void escuchar() throws IOException, ClassNotFoundException, InterruptedException {

        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        System.out.println("Conexion con el cliente exitosa");

        //Para leer la peticion del cliente
        ois = new ObjectInputStream(socket.getInputStream());

        //Para enviar datos al cliente
        oos = new ObjectOutputStream(socket.getOutputStream());

        boolean salir = false;
        while (!salir){

            //Escuchamos la peticion del cliente
            String peticionCliente = (String) ois.readObject();

            oos.writeObject("Comenzando carrera");

            for(Camello c : camello.listaCamellos){
                int numero = (int) (Math.random() * 9) + 1;
                oos.writeObject(c.getNombre() +" avanza "+ numero + " metros");
                oos.flush();

                c.setDistanciaRecorrida( c.getDistanciaRecorrida() + numero );
                oos.writeObject("Ha recorrido " +c.getDistanciaRecorrida()+ " metros");
                oos.flush();

                if( c.getDistanciaRecorrida() >= 100 ){
                    oos.writeObject(c.getNombre() + " ha ganado la carrera!");
                    oos.writeObject("fin_juego");
                }
                oos.writeObject("fin_peticion");

                Thread.sleep(1000);
            }
        }

        //Cerramos
        oos.close();
        ois.close();
        socket.close();
    }
}