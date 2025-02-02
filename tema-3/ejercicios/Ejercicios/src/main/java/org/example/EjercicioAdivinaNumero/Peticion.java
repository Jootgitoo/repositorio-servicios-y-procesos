package org.example.EjercicioAdivinaNumero;

import java.net.Socket;

public class Peticion {

    Socket socket = null;

    public Peticion(Socket socket){
        this.socket = socket;
    }
}