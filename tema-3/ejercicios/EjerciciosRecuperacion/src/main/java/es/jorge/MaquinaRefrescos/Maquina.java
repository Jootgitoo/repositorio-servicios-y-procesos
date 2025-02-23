package es.jorge.MaquinaRefrescos;

import java.io.Serializable;

public class Maquina implements Serializable {

    private final static int REFRESCOS_TOTALES = 50;
    private int refrescosRestantes = REFRESCOS_TOTALES;

    public String pedirRefrescos(int numeroRefrescos){
        String respuesta;

        if(numeroRefrescos < 1 || numeroRefrescos > 10){
            respuesta = "Ingrese una cantidad adecuada (1-10) refrescos";

        } else if(refrescosRestantes >= numeroRefrescos){

            refrescosRestantes -= numeroRefrescos;

            respuesta = "Tome sus "+numeroRefrescos+ " refrescos";

        } else if(refrescosRestantes < numeroRefrescos){

            respuesta = "Le devuelvo los refrescos restantes " +numeroRefrescos;
        } else {
            respuesta = "Ninguna opcion del if";
        }

        return respuesta;
    }

    public int getRefrescosRestantes() {
        return refrescosRestantes;
    }

    public void setRefrescosRestantes(int refrescosRestantes) {
        this.refrescosRestantes = refrescosRestantes;
    }

}