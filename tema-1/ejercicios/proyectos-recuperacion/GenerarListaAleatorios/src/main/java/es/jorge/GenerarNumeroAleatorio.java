package es.jorge;

import java.util.ArrayList;
import java.util.List;

public class GenerarNumeroAleatorio {

    public static List<Integer> generarNumerosAleatorios(int numerosAGenerar, int rangoMax){

        List<Integer> listaNumeros = new ArrayList<>();

        for(int i=0; i<numerosAGenerar; i++){

            int numero = (int) (Math.random() * rangoMax) + 1;

            listaNumeros.add(numero);
        }

        return listaNumeros;
    }

    public static void main(String[] args) {
        int numerosAGenerar = Integer.parseInt(args[0]);
        int rangoMaximo = Integer.parseInt(args[1]);

        List<Integer> listaNumeros = new ArrayList<>();
        listaNumeros =  GenerarNumeroAleatorio.generarNumerosAleatorios(numerosAGenerar, rangoMaximo);
        System.out.println(listaNumeros);
    }
}