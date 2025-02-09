package es.jorge;

public class SacarFactorial {

    public static int factorial(int num){

        int solucionFactorial = 1;

        for(int i=1; i<num; i++){
            solucionFactorial *= i;
        }

        return solucionFactorial;
    }

    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        int solucionFactorial = SacarFactorial.factorial(num);

        System.out.println("El factorial de " +num+ " es " +solucionFactorial);
    }
}