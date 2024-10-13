package com.psp.dos.multiplicador;

/**
 * Clase que realiza la multiplicaci�n de dos n�meros pasados como argumento
 * y muestra por pantalla el resultado de la multiplicaci�n
 *
 * @author Santa Ar�valo Ar�valo
 *
 */
public class Multiplicador {

    /**
     * Devuelve el resultado de multiplicar n1 y n2
     * @param n1 int
     * @param n2 int
     * @return int (n1 * n2)
     */
    public static int multiplicar(int n1, int n2) {
        return (n1 * n2);
    }

    /**
     * Multiplica dos n�meros pasados como argumento y muestra por pantalla el resultado de la multiplicaci�n
     * @param args String[0] = n1, String[1] = n2
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Error: please provide two arguments");
            return;
        }

        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);

        int resultado = multiplicar(n1, n2);

        System.out.println("El resultado de multiplicar: " + n1 + " * " + n2 + " es: " + resultado);
    }
}