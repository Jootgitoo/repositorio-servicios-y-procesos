package Servidor;

import Objeto.Evento;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

    //Lista con todos los eventos
    public List<Evento> listaEventos = new ArrayList<>();


    public Servidor(){
        rellenarListaEventos(listaEventos);
    }

    public static void main(String[] args) throws IOException {
        Servidor servidor = new Servidor();
        servidor.crearServidor();
    }


    public void rellenarListaEventos(List<Evento> listaEventos){

        Evento e1 = new Evento("Concierto", 15);
        Evento e2 = new Evento("Teatro", 25);
        Evento e3 = new Evento("Cine", 20);
        Evento e4 = new Evento("Deportes", 40);


        listaEventos.add(e1);
        listaEventos.add(e2);
        listaEventos.add(e3);
        listaEventos.add(e4);

    }

    public void crearServidor() throws IOException {
        ServerSocket socketEscucha = null;

        socketEscucha = new ServerSocket(5555);
        System.out.println("Arrancando el servidor");


        while (true){
            try {

                Socket conexion = socketEscucha.accept();

                Peticion hilo = new Peticion(conexion);

                hilo.start();
            } catch (IOException e){
                e.printStackTrace();
                throw e;
            }
        }
    }

    public List<String> listarNombreEventos(){
        List<String> listaNombreEventos = new ArrayList<>();

        for(Evento e : listaEventos){

            if (e.getEntradasEvento() > 0){
                String nombreEvento = "Evento: " +e.getNombeEvento();
                listaNombreEventos.add(nombreEvento);
            }

        }
        return listaNombreEventos;
    }

    public List<Evento> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(List<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }

    public String eventoYNumeroEntradas(int numeroEvento, int numeroEntradas){
        String respuesta;

        if( listaEventos.get(numeroEvento).getEntradasEvento() >= numeroEntradas){
            respuesta = "Aqui tiene sus " +numeroEntradas+ "entradas";

            listaEventos.get(numeroEvento).setEntradasEvento( listaEventos.get(numeroEvento).getEntradasEvento() - numeroEntradas );
        } else {
            respuesta = "No hay suficiente entradas";
        }

        return respuesta;
    }

}