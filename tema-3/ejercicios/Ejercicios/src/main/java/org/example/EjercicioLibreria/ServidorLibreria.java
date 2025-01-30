package org.example.EjercicioLibreria;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorLibreria {

    //ATRIBUTOS
    List<Libro> listaLibros = new ArrayList<>();
//----------------------------------------------------------------
    //MÉTODOS

    public ServidorLibreria(){
        rellenarListaLibros(listaLibros);
    }

//----------------------------------------------------------------

    //MÉTODOS
    public static void main(String[] args) throws IOException {
        ServidorLibreria servidor = new ServidorLibreria();
        servidor.crearServidor();
    }

    public void rellenarListaLibros(List<Libro>lista){
        Libro l1 = new Libro(2, "Libro 1");
        Libro l2 = new Libro(1, "Libro 2");
        Libro l3 = new Libro(2, "Libro 3");
        Libro l4 = new Libro(0, "Libro 4");
        Libro l5 = new Libro(1, "Libro 5");


        listaLibros.add(l1);
        listaLibros.add(l2);
        listaLibros.add(l3);
        listaLibros.add(l4);
        listaLibros.add(l5);
    }

    public void crearServidor() throws IOException {
        ServerSocket socketEscucha = null;

        socketEscucha = new ServerSocket(9876);
        System.out.println("Arrancando el servidor");

        //Creamos un servidor infinito (Bucle infinito)
        while (true){
            try {

                //Establezco la conexion
                Socket conexion = socketEscucha.accept();

                //Creamos un hilo que manejar la conexion con el cliente
                Peticion hilo = new Peticion(conexion);

                hilo.start();
            } catch (IOException e){
                e.printStackTrace();
                throw e;
            }
        }
    }

    public List<Libro> obtenerLibrosPedidos(int numeroLibros){
        List<Libro> listaAux = new ArrayList<>();

        //Contamos los libros que llevamos en la lista
        int cont = 0;

        for(int i=0; i<listaLibros.size(); i++){
            if(cont < numeroLibros){
                listaAux.add( listaLibros.get(i) );
                listaLibros.get(i).setCantidad( listaLibros.get(i).getCantidad() - 1 );
                cont++;
            } else {
                break;
            }
        }

        return listaLibros;
    }

}