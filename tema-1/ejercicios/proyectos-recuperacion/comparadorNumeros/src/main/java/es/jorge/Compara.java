package es.jorge;

public class Compara {

    public static String compararNumeros(int num1, int num2){

        String solucion;

        if(num1 > num2){
            solucion = num1 + " es mayor que " +num2;
        } else if (num1 < num2) {
            solucion = num1 + " es menor que " +num2;
        } else {
            solucion = num1 + " es igual que " +num2;
        }

        return solucion;
    }


    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        String resultado = Compara.compararNumeros(num1, num2);
        System.out.println(resultado);
    }
}