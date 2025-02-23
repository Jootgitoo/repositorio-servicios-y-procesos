package es.jorge.ContestarPreguntas;

import java.io.Serializable;

public class Preguntas implements Serializable {

    public String obtenerRespuesta(String pregunta){

        String respuesta;

        switch (pregunta){
            case "¿cual es la capital de portugal?" :
                respuesta = "Lisboa";
            break;

            case "¿quien escribió don quijote de la mancha?" :
                respuesta = "Miguel de Cervantes";
            break;

            case "¿cual es el rio mas largo del mundo?" :
                respuesta = "Amazonas";
            break;

            case "¿en que año llegó el hombre a la luna?" :
                respuesta = "1969";
            break;

            case "¿cual es el idioma más hablado en el mundo?" :
                respuesta = "chino mandarín";
            break;

            default:
                respuesta = "No entiendo tu pregunta";
            break;

        }
        return respuesta;
    }
}