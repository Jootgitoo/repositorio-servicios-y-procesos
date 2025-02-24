package Cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {

    Socket socket = null;

    //Para leer los datos del servidor
    ObjectInputStream ois = null;

    //Para enviar peticiones al servidor
    ObjectOutputStream oos = null;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Cliente c = new Cliente();
        c.lanzarCliente();

    }

    public void lanzarCliente() throws IOException, ClassNotFoundException {

        InetSocketAddress direccion = new InetSocketAddress("localhost", 5555);

        socket = new Socket();

        socket.connect(direccion);

        System.out.println("Cliente.Cliente --> Server.Servidor conectado correctamente");

        //Para hablar al servidor
        oos = new ObjectOutputStream( socket.getOutputStream() );

        //Recogemos la info del servidor
        ois = new ObjectInputStream( socket.getInputStream() );

        boolean salir = false;
        while(!salir){
            System.out.println("Bienvenido a nuestra app para predir comida \n");

            //Preguntamos al servidor el numero de platos disponibles
            oos.writeObject("NOMBRES_PLATOS_DISPONIBLES");
            oos.flush();

            System.out.println("===== LISTA PLATOS =====");
            //Recogemos los platos disponibles
            boolean leer = true;
            while(leer){
                String respuestaServidor = (String) ois.readObject();

                if( respuestaServidor.equals("fin_programa") ){
                    //leer = false;
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                } else if( respuestaServidor.equals("fin_peticion") ) {

                    leer = false;
                } else {

                    System.out.println(respuestaServidor);
                }

            }
            System.out.println("========================================================== \n");

            //Envio la segunda peticion
            int udSolicitadas = (int) (Math.random() * 9) + 1;
            oos.writeObject("UNIDADES_PLATO");
            oos.writeObject("Pescado");
            oos.writeObject("40");
            oos.flush();

            //Recojo la segunda peticion
            leer = true;
            while(leer){
                String respuesta = (String) ois.readObject();

                if( respuesta.equals("fin_programa") ){
                    //leer = false;
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                } else {

                    System.out.println(respuesta);
                }
            }



        }

        oos.close();
        ois.close();
        socket.close();
    }
}