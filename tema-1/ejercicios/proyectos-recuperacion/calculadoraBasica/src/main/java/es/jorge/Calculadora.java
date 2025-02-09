package es.jorge;

public class Calculadora {

    public static String calcular(String operador, int num1, int num2){

        String solucion;

        switch (operador){
            case "+":
                int suma = num1 + num2;
                solucion = "La suma de " +num1+ " y "+num2+ " es = " +suma;
            break;

            case "-":
                int resta = num1 - num2;
                solucion = "La resta de " +num1+ " y "+num2+ " es = " +resta;
            break;

            case "*":
                int multi = num1 * num2;
                solucion = "La multiplicacion de " +num1+ " y "+num2+ " es = " +multi;
            break;

            case "/":
                int div = num1 / num2;
                solucion = "La division de " +num1+ " y "+num2+ " es = " +div;
            break;

            default:
                solucion = "Operador no valido";
            break;
        }

        return solucion;
    }

    public static void main(String[] args) {
        String operador = args[0];
        int num1 = Integer.parseInt(args[1]);
        int num2 = Integer.parseInt(args[2]);
        String resultado = Calculadora.calcular(operador, num1, num2);
        System.out.println(resultado);
    }
}