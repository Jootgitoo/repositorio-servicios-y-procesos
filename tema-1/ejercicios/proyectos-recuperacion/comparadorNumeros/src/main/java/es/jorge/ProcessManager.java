package es.jorge;

import java.io.File;
import java.io.IOException;

public class ProcessManager {

    public void lanzarProceso(int num1, int num2, String fSalida) throws IOException, InterruptedException {

        //Creamos la variable process
        Process process;

        //Ruta donde ejecuta las clases
        String classPath = ".;./target/classes";

        //Inicializamos el proceso
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "es.jorge.Compara", String.valueOf(num1), String.valueOf(num2));

        //Redirigimos las salidas
        pb.redirectError(new File("files" + File.separator + "error.txt"));
        pb.redirectOutput(new File("files" + File.separator + "solucionComparador.txt"));

        //Iniciamos el proceso
        process = pb.start();

        int exitValue = process.waitFor();

        if(exitValue == 0){
            System.out.println("Proceso exitoso");
        } else {
            System.out.println("Codigo error: " +exitValue);
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessManager l = new ProcessManager();
        l.lanzarProceso(6,5, "solucion_comparacion.txt");
    }
}