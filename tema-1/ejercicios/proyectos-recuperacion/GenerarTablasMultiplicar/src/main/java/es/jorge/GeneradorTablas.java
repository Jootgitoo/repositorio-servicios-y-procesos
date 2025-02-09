package es.jorge;

import java.util.ArrayList;
import java.util.List;

public class GeneradorTablas {

    public static List<String> generarTabla(int num){

        List<String> tablaMultiplicar = new ArrayList<>();

        for(int i=0; i<= 10; i++){
            int sol = num * i;
            tablaMultiplicar.add( num + " * " +i+ " = " +sol);
        }

        return tablaMultiplicar;
    }

    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        List<String> listaSolucion = new ArrayList<>();
        listaSolucion = GeneradorTablas.generarTabla(num);

        for(String s : listaSolucion){
            System.out.println(s);
        }
    }
}


















