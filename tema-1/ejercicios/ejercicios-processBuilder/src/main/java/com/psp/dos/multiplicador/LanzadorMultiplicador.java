package com.psp.dos.multiplicador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Creador de procesos que ejecuta la clase java com.psp.Multiplicador
 *
 * @author Santa Ar�valo Ar�valo
 *
 */
public class LanzadorMultiplicador {


    /**
     * Lanza proceso que ejecuta la clase java com.psp.Multiplicador, encargada de
     * realizar la multiplicaci�n de n1 y n2 Devuelve el resultado de la
     * multiplicaci�n por la salida estandar
     *
     * @param n1 número que se va a multiplicar
     * @param n2 número que se va a multiplicar
     * @param fResultado fichero donde se va a mostrar el resultado
     * @throws IOException
     * @throws InterruptedException
     */
    public void lanzarMultiplicador(int n1, int n2, String fResultado) throws IOException, InterruptedException {

        Process process;


        try {
            String classPath = ".;./target/classes";

            // Proceso que ejecuta la clase java Multiplicador
            //"java" --> Comando para ejecutar la JVM
            //"-cp" --> Es la opción de línea de comandos que significa "classpath". Se usa para especificar dónde Java debe buscar las clases y paquetes.
            //"classPath" -->   Es una variable que debe contener la ruta o rutas donde se encuentran las clases de tu aplicación
            //"com.psp.dos.multiplicador" --> Es el nombre completo de la clase principal que se va a ejecutar
            //String.valueOf(n1): Convierte el valor de n1 (presumiblemente un número) a una cadena. Este será el primer argumento para el programa Java.
            //String.valueOf(n2): Convierte el valor de n2 a una cadena. Este será el segundo argumento para el programa Java.
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "com.psp.dos.multiplicador.Multiplicador", String.valueOf(n1), String.valueOf(n2));

            //Cambiar salida de error estandar a error.log
            //File.separator = a añadir \ --> en este caso es "files2\error_*codigoDelError*.log
            pb.redirectError(new File("files2" + File.separator + "error_"+System.currentTimeMillis()+".log"));
            pb.redirectOutput(new File("files2" + File.separator + fResultado));
            process = pb.start();

            //el proceso padre, espera a que el proceso hijo termine
            //devuelve el valor de salida, del proceso hijo (de process)
            int exitValue = process.waitFor();
            System.out.println("Exit Value: "+exitValue);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Se ejecutan dos procesos, que realizan la multiplicaci�n de dos n�meros y
     * devuelven el resultado cada uno por salida est�ndar
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {
        LanzadorMultiplicador l = new LanzadorMultiplicador();
        l.lanzarMultiplicador(1, 51, "resultado1.txt");
    }
}