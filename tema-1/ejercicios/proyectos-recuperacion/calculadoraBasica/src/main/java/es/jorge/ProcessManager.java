package es.jorge;

import java.io.File;
import java.io.IOException;

public class ProcessManager {

    public void calcularProceso(String operador, int num1, int num2) throws IOException, InterruptedException {

        //Variable process
        Process process;

        //Clase donde ejecutamos
        String classPath = ".;./target/classes";

        //Creacion pb
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "es.jorge.Calculadora", operador, String.valueOf(num1), String.valueOf(num2));

        //Rederigimos la salida
        pb.redirectError(new File("files" + File.separator + "error.txt"));
        pb.redirectOutput(new File("files" +File.separator+ "solucion.txt"));

        process = pb.start();

        int exitValues = process.waitFor();

        if(exitValues == 0){
            System.out.println("Proceso exitoso");
        } else{
            System.out.println("Error: " +exitValues);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessManager l = new ProcessManager();
        l.calcularProceso("+", 5, 10);
    }


}