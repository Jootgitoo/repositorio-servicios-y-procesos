package org.example.EjercicioMaquinaRefrescos;

import java.io.*;
import java.net.Socket;

public class Peticion extends Thread{

    Socket socket;

    public Peticion (Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            escuchar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized boolean escuchar() throws IOException {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader bf = null;
        OutputStream os = null;
        PrintWriter pw = null;

        boolean pararServidor = false;
        int numeroRefrescos = 100;

        try {
            System.out.println("Conexion con el cliente recibida!");

            //Leemos lo que nos manda el cliente
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            bf = new BufferedReader(isr);

            //LEER --> LEEMOS DEL USUARIO
            //Leemos el numero del usuario
            String snumeroRefrescosUsuario = bf.readLine();
            int numeroRefrescosUsuario = Integer.parseInt(snumeroRefrescosUsuario);


            //OPERACIONES
            //Comprobamos si el número que ha pedido el usuario es válido
            if(numeroRefrescosUsuario >= 1 && numeroRefrescosUsuario <= 10 && numeroRefrescosUsuario < numeroRefrescos){ //Si es valido...

                //Restamos los refrescos que se lleva el usuario a los que quedan en la máquina
                numeroRefrescos -= numeroRefrescosUsuario;


                //SOLUCION --> DEVOLVEMOS AL USUARIO
                //Devolvemos la informacion
                os = socket.getOutputStream();
                pw = new PrintWriter(os, true);
                pw.write("Le damos sus refrescos: " +numeroRefrescosUsuario + "\n");


            } else{ //Si no es valido

                //Restamos los refrescos restantes y nos quedamos a 0
                numeroRefrescos -= numeroRefrescos;

                //SOLUCION --> DEVOLVEMOS AL USUARIO
                //Devolvemos la solucion al usuario
                pw.write("No hay suficientes refrescos, le enviamos los " +numeroRefrescos+ " refrescos restantes"+ "\n");

                //Cerramos la conexion
                pararServidor = true;

            }
            return pararServidor;

        } catch (IOException e) {
            System.out.println("Error al aceptar la conexion "+ e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            close(pw);
            close(os);
            close(bf);
            close(isr);
            close(is);

            try {
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private static void close(Closeable socket){
        if (socket != null){
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

























