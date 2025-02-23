package es.jorge.ContestarPreguntas;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Peticion extends Thread{

    private Socket socket;

    //Clase serializable para el paso de objetos
    private Preguntas preguntas;

    public Peticion(Socket socket, Preguntas preguntas){
        this.socket = socket;
        this.preguntas = preguntas;
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

            //Leemos la pregunta del cliente
            String preguntaCliente;
            String respuesta;
            if( (preguntaCliente = (String) ois.readObject()).equalsIgnoreCase("salir")){

                respuesta = "salir";
                salir = true;

            } else {

                //Obtenemos la respuesta
                respuesta = preguntas.obtenerRespuesta(preguntaCliente);

            }

            //Se la devolvemos al cliente
            oos.writeObject(respuesta);
            oos.flush();
        }

        //Cerramos
        oos.close();
        ois.close();
        socket.close();
    }
}




















