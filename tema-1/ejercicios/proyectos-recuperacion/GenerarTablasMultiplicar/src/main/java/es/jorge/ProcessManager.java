package es.jorge;

import java.io.File;
import java.io.IOException;

public class ProcessManager {

    public void lanzarProceso(int numero, String ficheroSalida) throws IOException, InterruptedException {

        Process process;

        String classPath = ".;./target/classes";

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "es.jorge.GeneradorTablas", String.valueOf(numero));

        pb.redirectError(new File("Files" + File.separator+ "error.txt"));
        pb.redirectOutput(new File("Files" + File.separator+ ficheroSalida));


        process = pb.start();

        int exitValue = process.waitFor();

        if(exitValue == 0){
            System.out.println("Proceso terminado correctamente");
        }else{
            System.out.println("Codigo error: " +exitValue);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessManager l = new ProcessManager();
        l.lanzarProceso(5, "solucionMultiplicacion.txt");
    }
}






















