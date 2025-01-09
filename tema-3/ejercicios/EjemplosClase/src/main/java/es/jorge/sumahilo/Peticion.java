package es.jorge.sumahilo;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Peticion extends Thread {

    Socket socket; //Representa la conexión con un cliente

    //Inicializamos el Socket
    public Peticion(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //Cuando se inicia el hilo se ejecuta el método escuchar
            escuchar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Válida y convierte en un String un número entero
     * @param linea Línea que lee el método para extraer los datos
     * @return Devuelve el número leido en un int
     */
    private int extraerNumero(String linea) {
        /*
         * 1. Comprobar si es un numero
         * 2. Ver si el numero es correcto (32a75)
         * 3. Ver si tiene de 1 a 8 cifras
         */
        int numero;
        try {
            numero = Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            numero = 0;
        }
        /*
         * Si el numero es mayor de 100 millones tampoco es valido
         */
        if (numero >= 100000000) {
            numero = 0;
        }
        return numero;
    }


    /**
     * Realiza una operación matemática cualquiera pasada por parametros
     * @param op Operación que se va a realizar
     * @param n1 Numero que se va a utilizar
     * @param n2 Numero que se va a utilizar
     * @return Devuelve la solución de realizar la operación
     */
    private int calcular(String op, String n1, String n2) {
        int resultado = 0;

        //Como le pasas 3 string con el método charAt y
        // extraerNumero los conviertes en char e int
        // para poder llevar a cabo el método
        char simbolo = op.charAt(0);
        int num1 = this.extraerNumero(n1);
        int num2 = this.extraerNumero(n2);

        if (simbolo == '+') {
            resultado = num1 + num2;
            System.out.println("Resultado suma: "+num1+" + "+num2+" = "+resultado);
        } else if (simbolo == '-'){
            resultado = num1 - num2;
            System.out.println("Resultado resta: "+num1+" - "+num2+" = "+resultado);
        }  else if (simbolo == '*'){
            resultado = num1 * num2;
            System.out.println("Resultado multiplicación: "+num1+" * "+num2+" = "+resultado);
        }  else if (simbolo == '/'){
            resultado = num1 / num2;
            System.out.println("Resultado division: "+num1+" / "+num2+" = "+resultado);
        }
        return resultado;
    }


    /**
     * Manejas la comunicación con el cliente
     * @throws IOException
     */
    private void escuchar() throws IOException {

        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader bf = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            System.out.println("Conexion recibida!");

            //Leemos el mensaje que nos manda el cliente
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            bf = new BufferedReader(isr);
            String linea = bf.readLine();
            String num1 = bf.readLine();
            String num2 = bf.readLine();

            // Calculamos el resultado
            Integer result = this.calcular(linea, num1, num2);

            //La salida una vez realizada la operacion
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write(result.toString() + "\n");
            //Aseguramos que el contenido se ha enviado
            pw.flush();
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

    /**
     * Cerramos la conexion
     * @param stream Resucrso/objeto que se va a cerrar
     */
    private void close(Closeable stream) {
        try {
            if (null != stream) {
                stream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
