package com.psp.ejercicio5Facturas;

public class Main {
    public static void main(String[] args) {
        Empleado e1 = new Empleado(1);
        Empleado e2 = new Empleado(2);
        Empleado e3 = new Empleado(3);
        e1.start();e2.start();e3.start();
    }
}
