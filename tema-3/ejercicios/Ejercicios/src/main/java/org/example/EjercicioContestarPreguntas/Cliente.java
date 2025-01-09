package org.example.EjercicioContestarPreguntas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader bfr = null;
        PrintWriter pw = null;
        InputStreamReader isr = null;

        try{
            InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);
            socket = new Socket();
            socket.connect(direccion);

        }
    }

}
