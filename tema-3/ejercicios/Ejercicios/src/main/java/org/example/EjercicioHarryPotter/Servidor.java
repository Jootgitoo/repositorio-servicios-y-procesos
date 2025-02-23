package org.example.EjercicioHarryPotter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Servidor {

    //ATRIBUTOS
    List<Varita> listaVaritas = new ArrayList<>();

//------------------------------------------------------------------------------------------------------------
    //CONSTRUCTOR

    public Servidor(){
        rellenarListaVaritas(listaVaritas);
    }

//------------------------------------------------------------------------------------------------------------
    //MÉTODOS

    public static void main(String[] args) throws IOException {
        Servidor servidor = new Servidor();
        servidor.crearServidor();

    }


    /**
     * Rellenar la lista de varitas
     * @param listaVaritas lista de varitas a rellenar
     */
    public void rellenarListaVaritas(List<Varita> listaVaritas){
        Varita v1 = new Varita(1, "Varita de Saúco");
        Varita v2 = new Varita(0, "Varita de Acebo y Pluma de Fénix");
        Varita v3 = new Varita(1, "Varita de Vid y Pelo de Unicornio");
        Varita v4 = new Varita(2, "Varita de Fresno y Nervio de Dragón");
        Varita v5 = new Varita(1, "Varita de Cerezo y Pluma de Fénix");
        Varita v6 = new Varita(3, "Varita de Nogal y Pelo de Thestral");
        Varita v7 = new Varita(0, "Varita de Abeto y Pelo de Unicornio");
        Varita v8 = new Varita(0, "Varita de Sauce y Nervio de Dragón");
        Varita v9 = new Varita(0, "Varita de Espino y Pluma de Fénix");
        Varita v10 = new Varita(1, "Varita de Tejo y Pluma de Fénix");

        listaVaritas.add(v1);
        listaVaritas.add(v2);
        listaVaritas.add(v3);
        listaVaritas.add(v4);
        listaVaritas.add(v5);
        listaVaritas.add(v6);
        listaVaritas.add(v7);
        listaVaritas.add(v8);
        listaVaritas.add(v9);
        listaVaritas.add(v10);

    }


    /**
     * Creo un servidor
     * @throws IOException
     */
    public void crearServidor() throws IOException {
        ServerSocket socketEscucha = null;


        //Puerto por el que va a escuchar nuestro servidor
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


    /**
     * Obtienes una varita si es q hay disponibles
     * @return Varita obtenida de la lista
     */
    public synchronized Varita obtenerVarita(){
        Varita var = null;
        for(Varita v : listaVaritas){
            if (v.getNumero() > 0){
                v.setNumero( v.getNumero() - 1);
                var = v;
                break;
            }
        }
        return var;
    }



}
