package es.jorge;

import java.io.File;
import java.io.IOException;

public class ProcessManager {

    public void lanzarProceso(double temperaturaInicial, String unidadAConvertir, String fError, String fSalida) throws IOException, InterruptedException {

        Process process;

        String classPath = ".;./target/classes";

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "es.jorge.Conversion", String.valueOf(temperaturaInicial), unidadAConvertir);

        pb.redirectError(new File("files" +File.separator+ fError));
        pb.redirectOutput(new File("files" +File.separator+ fSalida));

        process = pb.start();

        int exitValue = process.waitFor();

        if(exitValue == 0){
            System.out.println("Proceso terminado correctamente");
        } else {
            System.out.println("Codigo de error: " +exitValue);
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessManager l = new ProcessManager();
        l.lanzarProceso(70, "fahrenheit", "error.txt", "solucion.txt");
    }
}