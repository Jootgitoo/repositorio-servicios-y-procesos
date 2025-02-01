package org.example.EjercicioMaquinaRefrescos;

import java.io.*;
import java.net.Socket;

public class Peticion extends Thread{

    private int numeroRefrescosTotal = 100;
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

        try {
            System.out.println("Conexion con el cliente recibida!");

            while(true){
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
                if(numeroRefrescosUsuario >= 1 && numeroRefrescosUsuario <= 10 && numeroRefrescosUsuario < numeroRefrescosTotal){ //Si es valido...

                    //Restamos los refrescos que se lleva el usuario a los que quedan en la máquina
                    numeroRefrescosTotal -= numeroRefrescosUsuario;


                    //SOLUCION --> DEVOLVEMOS AL USUARIO
                    //Devolvemos la informacion
                    os = socket.getOutputStream();
                    pw = new PrintWriter(os, true);

                    pw.println("Le damos sus refrescos: " +numeroRefrescosUsuario + "\nRefrescos restantes: " + numeroRefrescosTotal +"\n");

                    //pw.println("Refrescos restantes: " +numeroRefrescosTotal + "\n");



                } else{ //Si no es valido
                    os = socket.getOutputStream();
                    pw = new PrintWriter(os, true);
                    //SOLUCION --> DEVOLVEMOS AL USUARIO
                    //Devolvemos la solucion al usuario
                    pw.println("No hay suficientes refrescos, le enviamos los " +numeroRefrescosTotal+ " refrescos restantes"+ "\n");

                    //Restamos los refrescos restantes y nos quedamos a 0
                    numeroRefrescosTotal -= numeroRefrescosUsuario;
                    //pw.println("Refrescos restantes: " +numeroRefrescosTotal);

                    pw.println("salir");

                }
            }

        } catch (IOException e) {
            System.out.println("Error al aceptar la conexion "+ e.getMessage());
            e.printStackTrace();
            throw e;
        }

    }

}

























