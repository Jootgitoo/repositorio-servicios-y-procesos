package org.example.Facturas;

public class Lanzador {
    public static void main(String[] args) {

        Empleado e1 = new Empleado(1);
        Empleado e2 = new Empleado(2);
        Empleado e3 = new Empleado(3);

        e1.start();
        e2.start();
        e3.start();

        try {
            e1.join();
            e2.join();
            e3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("El empleado 1 ha hecho " +e1.getNumeroFacturasGeneradas()+ " facturas");
        System.out.println("El empleado 2 ha hecho " +e2.getNumeroFacturasGeneradas()+ " facturas");
        System.out.println("El empleado 3 ha hecho " +e3.getNumeroFacturasGeneradas()+ " facturas");

    }
}
