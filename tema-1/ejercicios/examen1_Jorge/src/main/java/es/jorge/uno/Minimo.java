package es.jorge.uno;

public class Minimo {


    public static String calcularMinimo(int num1, int num2){

        String solucion;

        if (num1 < num2){
            solucion =  num1 + " es menor que " +num2;

        } else if (num2 < num1) {
            solucion =  num1 + " es menor que " +num2;

        } else if (num1 == num2) {
            solucion = num1 + " es igual que " +num2;
        } else {
            solucion = "Opcion default";
        }
        return solucion;
    }


    public static void main(String[] args) {

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        String resultado = Minimo.calcularMinimo(num1, num2);
        System.out.println(resultado);

    }

}
