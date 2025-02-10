package es.jorge.dos;

import java.io.File;
import java.io.IOException;

public class Ejercicio2 {

    /**
     * Lanza un proceso que ejecuta el comando dir en el cmd
     * @throws IOException
     * @throws InterruptedException
     */
    public void lanzarProceso() throws IOException, InterruptedException {

        Process process;

        String classPath = "/C";

        ProcessBuilder pb = new ProcessBuilder("cmd", "-dir", classPath);

        pb.redirectError(new File("files" +File.separator+ "BORRARerror_jorgeHerrera.txt"));
        pb.redirectOutput(new File("files" +File.separator+ "BORRARmax_jorgeHerrera.txt"));

        process = pb.start();

        process = pb.start();

        int salida = process.waitFor();

        if(salida == 0){
            System.out.println("Proceso terminado correctamente");
        } else {
            System.out.println("Codigo error: " +salida);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Ejercicio2 lanzador = new Ejercicio2();
        lanzador.lanzarProceso();
    }

}