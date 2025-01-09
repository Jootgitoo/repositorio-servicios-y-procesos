package org.example.EjercicioSumasASCII;

import java.io.*;
import java.net.Socket;

public class Peticion extends Thread{

    Socket socket;

    public Peticion(Socket socket){
        this.socket = socket;
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


    //Escuchamos al cliente
    private void escuchar() throws IOException {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader bf = null;
        OutputStream os = null;
        PrintWriter pw = null;

        try{
            System.out.println("Conexion con el cliente recibida!");

            //Leemos lo q nos manda el cliente
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            bf = new BufferedReader(isr);

            //Escucho la primera linea (que indica el numero de lineas mas que va a recibir)
            String strNumeroLineas = bf.readLine();
            int numeroLineas = Integer.parseInt(strNumeroLineas);

            //Guardo la informacion de las lineas (cada cajón del array es una linea)
            String[] lineas = new String[numeroLineas];
            for (int i=0; i< numeroLineas; i++){
                lineas[i] = bf.readLine();
            }

            //Calculamos la suma de los valores ASCII de cada línea
            for(int i=0; i< lineas.length; i++){
                Integer sumaValoresAscii = calcularValoresAscii(lineas[i]);

                //Cuando calculemos la suma de una línea, se la mandamos al usuario
                os = socket.getOutputStream();
                pw = new PrintWriter(os);
                pw.write(sumaValoresAscii.toString() + "\n");
                pw.flush();
            }

        } catch (IOException e) {
            System.out.println("Error al aceptar conexion "+e.getMessage());
            e.printStackTrace();
            throw e;

        } finally {
            close(pw);
            close(os);
            close(bf);
            close(isr);
            close(is);
            try {
                if (null != socket) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private int calcularValoresAscii (String linea){
        int sumaValoresAscii = 0;

        for (int i=0; i< linea.length(); i++){
            char caracter = linea.charAt(i); //Obtenemos el caracter en la posicion i
            int valorAscii = (int) caracter; //Obtenemos el valor Ascii del caracter
            sumaValoresAscii += valorAscii;
        }
        return sumaValoresAscii;
    }

    /**
     * Método para cerrar el socket
     * @param socket Socket que vamos a cerrar
     */
    private static void close(Closeable socket) {
        try {
            if (null != socket) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
