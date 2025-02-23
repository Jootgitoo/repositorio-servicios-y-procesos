package es.jorge.SumasAscii;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Peticion extends Thread{

    private Suma suma;

    private Socket socket;

    public Peticion(Socket socket, Suma suma){
        this.socket = socket;
        this.suma = suma;
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

        //Lee la peticion del cliente --> Lee la linea de caracteres para devolver la suma
        ois = new ObjectInputStream(socket.getInputStream());

        //Le devuelvo el salir para que se cierre la conexion con el cliente
        oos = new ObjectOutputStream(socket.getOutputStream());

        boolean salir = false;
        while(!salir) {

            String peticionCliente;

            if ((peticionCliente = (String) ois.readObject()).equalsIgnoreCase("salir")) {

                String respuesta = "salir";
                oos.writeObject(respuesta);
                oos.flush();

                salir = true;

            } else {
                //Calculo la solucion
                int sumaCalculada = suma.calcularValoresAscii(peticionCliente);

                //Se la envio al cliente
                String respuesta = "La suma es: " + sumaCalculada;
                oos.writeObject(respuesta);
                oos.flush();
            }

        }

        //Cerramos
        oos.close();
        ois.close();
        socket.close();
    }
}


















