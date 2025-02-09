package es.jorge;

import java.io.File;
import java.io.IOException;

public class ProcessManager {

    public void ejecutarProceso(String fileName) throws InterruptedException, IOException {

        Process process;

        String classPath = ".;./target/classes";

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "es.jorge.CuentaPalabras", fileName);

        pb.redirectError(new File("file" +File.separator+ "error.txt"));
        pb.redirectOutput(new File("file" +File.separator+ "solucion.txt"));

        process = pb.start();

        int exitProces = process.waitFor();

        if(exitProces == 0){
            System.out.println("El proceso terminó correctamente");
        } else{
            System.out.println("Error: " +exitProces);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessManager l = new ProcessManager();
        l.ejecutarProceso("ficheroTexto.txt");
    }
}