package es.jorge.uno;

import java.io.File;
import java.io.IOException;

public class Ejercicio1 {

    /**
     * Lanza un proceso que ejecta la clase maximo pasandole 2 numeros y t devuelve cual es mayor
     * @param num1 int que va a comprar
     * @param num2 int que va a comparar
     * @throws IOException
     * @throws InterruptedException
     */
    public void lanzarProceso(int num1, int num2) throws IOException, InterruptedException {

        Process process;

        String classPath = ".;./target/classes";

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "es.jorge.uno.Maximo", String.valueOf(num1), String.valueOf(num2));

        pb.redirectError(new File("files" +File.separator+ "error_jorgeHerrera.txt"));
        pb.redirectOutput(new File("files" +File.separator+ "max_jorgeHerrera.txt"));

        process = pb.start();

        int salida = process.waitFor();

        if(salida == 0){
            System.out.println("Proceso terminado correctamente");
        } else {
            System.out.println("Codigo error: " +salida);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Ejercicio1 lanzador = new Ejercicio1();

        //Le pasamos al lanzador dos numeros en este caso 50, 50.
        // La salida tiene que ser que son iguales
        lanzador.lanzarProceso(50, 50);
    }
}
