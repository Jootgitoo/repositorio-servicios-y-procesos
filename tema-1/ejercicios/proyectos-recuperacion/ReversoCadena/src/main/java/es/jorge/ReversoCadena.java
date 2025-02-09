package es.jorge;

public class ReversoCadena {

    public static String revertirCadena(String cadena){

        String cadenaInvertida = "";

        cadenaInvertida = new StringBuilder(cadena).reverse().toString();

        return cadenaInvertida;
    }

    public static void main(String[] args) {
        String cadena = args[0];

        String cadenaInvertida = ReversoCadena.revertirCadena(cadena);

        System.out.println(cadenaInvertida);
    }
}