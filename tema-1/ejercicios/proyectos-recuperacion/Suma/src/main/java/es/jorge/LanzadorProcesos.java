package es.jorge;

import java.io.File;
import java.io.IOException;

public class LanzadorProcesos {

    public void lanzarProceso(int n1, int n2, String fsalida) throws IOException, InterruptedException {
        Process process;

        String classPath = ".;./target/classes";

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "es.jorge.Suma", String.valueOf(n1), String.valueOf(n2));

        pb.redirectError(new File("files" + File.separator + "error.txt"));
        pb.redirectOutput(new File("files" +File.separator+ fsalida));

        process = pb.start();

        int exitValue = process.waitFor();

        if(exitValue == 0){
            System.out.println("Proceso correcto");
        } else {
            System.out.println("Error: " +exitValue);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        LanzadorProcesos l = new LanzadorProcesos();
        l.lanzarProceso(10, 20, "solucion_suma.txt");
    }
}