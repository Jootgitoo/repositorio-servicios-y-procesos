package org.example.EjercicioLibreria;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class Peticion extends Thread{

    Socket socket;
    ServidorLibreria srv;

    public Peticion(Socket socket){
        this.socket = socket;
        srv = new ServidorLibreria();
    }

    @Override
    public void run(){
        try {
            //Cuando se inicia el hilo se ejecuta el método escuchar
            escuchar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escuchar() throws IOException {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader bfr = null;
        OutputStream os = null;
        PrintWriter pw = null;

        System.out.println("Conexion con el cliente recibida");

        while (true){

            //Escucho lo que me pida el cliente
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            bfr = new BufferedReader(isr);

            pw = new PrintWriter(socket.getOutputStream());

            String snumeroLibros;
            if ( (snumeroLibros = bfr.readLine()) != null ){ //Nos manda un numero de libros
                int numeroLibros = Integer.parseInt(snumeroLibros);

                //Obtengo los libros
                List<Libro> listaLibrosDevueltos = srv.obtenerLibrosPedidos(numeroLibros);

                //Se los devuelvo
                if( listaLibrosDevueltos.isEmpty() ){

                    pw.println("No hay mas libros disponibles. Vuelva otro dia");

                } else {

                    for (Libro l : listaLibrosDevueltos) {
                        pw.println("Titulo: " + l.getTitulo());
                    }
                }
            }
        }


    }
}