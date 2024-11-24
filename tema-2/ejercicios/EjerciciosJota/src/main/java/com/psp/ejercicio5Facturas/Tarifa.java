package com.psp.ejercicio5Facturas;

public class Tarifa {
    private static Tarifa instance = null;

    private static int numFactura;
        private Tarifa(){
            this.numFactura = 0;
        }

        private synchronized static void createInstance() {
            if (instance == null) {
                instance = new Tarifa();
            }
        }
        public static Tarifa getInstance() {
            if (instance == null) {
                createInstance();
            }
            return instance;
        }
        public double calcularConsumo(Empleado empleado){
            setNumFactura(getNumFactura()+1);
            double importe;
            if(empleado.getConsumo()<15){
                importe = empleado.getConsumo()*1.5;
            }else if(empleado.getConsumo()>= 15 && empleado.getConsumo()< 30){
                importe = empleado.getConsumo()*2.1;
            }else{
                importe = empleado.getConsumo()*3;
            }
            return importe;
        }

    public synchronized int getNumFactura() {
        return numFactura;
    }

    public synchronized void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }
}
