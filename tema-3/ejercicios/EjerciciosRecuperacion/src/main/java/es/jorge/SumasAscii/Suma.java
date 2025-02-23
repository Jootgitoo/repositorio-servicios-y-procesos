package es.jorge.SumasAscii;

import java.io.Serializable;

public class Suma implements Serializable {

    public int calcularValoresAscii (String linea){
        int sumaValoresAscii = 0;

        for (int i=0; i< linea.length(); i++){
            char caracter = linea.charAt(i); //Obtenemos el caracter en la posicion i
            int valorAscii = (int) caracter; //Obtenemos el valor Ascii del caracter
            sumaValoresAscii += valorAscii;
        }
        return sumaValoresAscii;
    }
}