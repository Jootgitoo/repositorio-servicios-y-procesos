package es.jorge.uno;

import java.io.File;
import java.io.IOException;

public class ProcessManager {

    public void minimoLanzador(int num1, int num2, String ficheroSalida) {

        Process process;

        try {

            String clase = ".;./target/classes";

            ProcessBuilder pb = new ProcessBuilder("java", "-cp", clase, "es.jorge.uno.Minimo", String.valueOf(num1), String.valueOf(num2));

            pb.redirectError(new File("files" + File.separator + "error_Jorge.txt"));
            pb.redirectOutput(new File("files" + File.separator + ficheroSalida));


            process = pb.start();

            int exitValue = process.waitFor();
            if(exitValue == 0){
                System.out.println("El proceso termino correctamente");
            } else {
                System.out.println("Error: " );
            }



        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        ProcessManager lanzador = new ProcessManager();
        lanzador.minimoLanzador(5, 100, "minimo_jorge.txt");
    }
}


