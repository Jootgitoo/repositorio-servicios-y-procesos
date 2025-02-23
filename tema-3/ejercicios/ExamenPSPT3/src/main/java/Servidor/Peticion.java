package Servidor;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Peticion extends Thread{

    Socket socket;
    Servidor srv;

    List<String> listaEventos = new ArrayList<>();

    public Peticion(Socket socket){
        this.socket = socket;
        this.srv = new Servidor();
    }

    @Override
    public void run(){
        try {
            escuchar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escuchar() throws IOException {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader bfr = null;
        ObjectInputStream ois = null;
        PrintWriter pw = null;

        System.out.println("Conexion con el cliente recibida");

        while (true){

            //Escucho la peticion del cliente
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            bfr = new BufferedReader(isr);
            String respuestaUsuario = bfr.readLine();
            pw = new PrintWriter( socket.getOutputStream(), true );

            System.out.println("Peticion listar eventos recogida");
            if(respuestaUsuario.equalsIgnoreCase("listar_eventos")){

                listaEventos = srv.listarNombreEventos();

                for(String s: listaEventos){
                    pw.println(s);
                }
            }

            //Recojo el numero del evento
            String numeroEventoUsuario = bfr.readLine();
            int numeroEvento = Integer.parseInt(numeroEventoUsuario);
            System.out.println("Numero evento leido con exito");

            //Recojo el numero de entradas
            String numeroEntradasUsuario = bfr.readLine();
            int numeroEntradas = Integer.parseInt(numeroEntradasUsuario);
            System.out.println("Numero entradas leido con exito");

            //Busco si hay entradas para ese evento y le devuelvo una respuesta al cliente
            String respuestaServidor = srv.eventoYNumeroEntradas(numeroEvento, numeroEntradas);
            pw.println(respuestaServidor);
        }
    }

}
