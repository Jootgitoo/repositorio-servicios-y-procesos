package es.jorge;

public class Conversion {

    public static double converison(double numero, String unidadAConvertir){

        double temperaturaConvertida = 0;

        switch (unidadAConvertir){

            case "celsius":
                temperaturaConvertida = (numero - 32 ) * 5/9;
            break;

            case "fahrenheit":
                temperaturaConvertida = (numero * 9/5 ) + 32;
            break;

            default:
                temperaturaConvertida = -1;
            break;
        }

        return temperaturaConvertida;
    }

    public static void main(String[] args) {

        double num = Double.parseDouble(args[0]);
        String ud = args[1];
        double temperaturaConvertida = Conversion.converison(num, ud);
        System.out.println("Solucion: " +num + " = " + temperaturaConvertida);
    }
}
















