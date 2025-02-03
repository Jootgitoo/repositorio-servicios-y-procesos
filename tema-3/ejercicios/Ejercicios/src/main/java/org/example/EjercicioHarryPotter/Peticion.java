package org.example.EjercicioHarryPotter;

import java.io.*;
import java.net.Socket;

public class Peticion extends Thread{

    Socket socket;
    private Servidor srv;

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

    private void escuchar() throws IOException {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader bf = null;
        PrintWriter pw = null;


        System.out.println("Conexion con el cliente recibida");

        while (true){
            //Leemos lo que nos manda el cliente
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            bf = new BufferedReader(isr);


            if( bf.readLine() != null ){ //Nos pide una varita

                //Obtengo la varita
                Varita v = srv.obtenerVarita();

                //Le devuelvo la barita
                pw = new PrintWriter(socket.getOutputStream(), true);
                if (v == null){ //Si la varita es null

                    pw.println("No quedan mas baritas");

                } else {

                    pw.println("Has obtenido: " +v);

                }
            }
        }

    }
}