package es.jorge;

import java.io.File;
import java.io.IOException;

public class ProcessManager {

    public void lanzarProceso(String fileName, String palabra, String fError, String fSolucion) throws IOException, InterruptedException {

        Process process;

        String classPath = ".;./target/classes";

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "es.jorge.BuscarPalabra", fileName, palabra);

        pb.redirectError(new File("files" +File.separator+ fError));
        pb.redirectOutput(new File("files" +File.separator+ fSolucion));

        process = pb.start();

        int exitValue = process.waitFor();

        if(exitValue == 0){
            System.out.println("Proceso terminado correctamente");
        } else {
            System.out.println("Codigo error: " +exitValue);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessManager l = new ProcessManager();
        l.lanzarProceso("texto.txt", "preocupación", "error.txt", "solucion.txt");
    }

    /**
     * Si alguna vez alguna palabra cuenta de menos es por que termina en , o .
     */
}
























