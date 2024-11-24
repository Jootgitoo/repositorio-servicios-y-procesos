package org.example.Facturas;

public class Tarifa {

    private int numeroFactura;
    private double importe;

    private static Tarifa instance = null;

    private Tarifa(){

    }

    private synchronized static void createIntance(){
        if (instance == null){
         instance = new Tarifa();
        }
    }

     public static Tarifa getInstance(){
        if (instance == null){
            createIntance();
        }
        return instance;
     }

    private void calcularImporte(int consumo){

        if (consumo < 15){
            this.importe = consumo * 1.5;
        } else if (consumo < 30 ){
            this.importe = consumo * 2.1;
        } else if (consumo > 30) {
            this.importe = consumo * 3;
        }

    }

    public void crearFactura(int idEmpleado, int consumo){
        numeroFactura++;
        calcularImporte(consumo);
        System.out.println("Factura FAC"+numeroFactura+ " con importe: " +this.importe+ "€ generada por el empleado " +idEmpleado);
    }
}
