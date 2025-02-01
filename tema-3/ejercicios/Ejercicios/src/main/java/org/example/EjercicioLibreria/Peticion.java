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
        ObjectInputStream ois = null;
        PrintWriter pw = null;

        System.out.println("Conexion con el cliente recibida");

        while (true){

            //Para escuchar lo que me pide el cliente
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            bfr = new BufferedReader(isr);


            //Para devolverle la informacion al cliente
            pw = new PrintWriter(socket.getOutputStream(), true);

            //Leemos el nombre del libro
            String nombreLibro = bfr.readLine();

            //Leemos cuantos libros quiere
            Integer numeroLibros = Integer.parseInt( bfr.readLine() );


            //Obtengo los libros
            List<Libro> listaLibrosDevueltos = srv.obtenerLibrosPedidos(nombreLibro, numeroLibros);

            //Se los devuelvo
            if( listaLibrosDevueltos.isEmpty() ){

                pw.println("No hay mas libros disponibles. Vuelva otro dia");
                pw.println("FIN_RESPUESTA");
                System.out.println("=====No hay mas libros=====");

            } else {

                for (Libro l : listaLibrosDevueltos) {
                    pw.println("Titulo: " + l.getTitulo() +"\n");
                }
                pw.println("FIN_RESPUESTA");

                System.out.println("=====Libros deuvletos=====");
            }

        }


    }
}