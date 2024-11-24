package com.psp.ejercicio5Facturas;

public class Empleado extends Thread{

    private Tarifa tarifa;
    private int numEmpleado;
    private int consumo;
    private long tiempoInicio;
    public Empleado(int numEmpleado){
        this.tarifa = Tarifa.getInstance();
        this.numEmpleado = numEmpleado;
        this.consumo = generarConsumo();
        this.tiempoInicio = System.currentTimeMillis();
    }
    @Override
    public void run() {
        while((System.currentTimeMillis()-tiempoInicio)<3*60*1000) {

            double importe = tarifa.calcularConsumo(this);

            System.out.printf("Factura FAC%d con importe %.2f€ generada por el Empleado %d\n",
                    tarifa.getNumFactura(),importe,getNumEmpleado());
            try {
                this.sleep(1000 * this.numEmpleado);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            setConsumo(generarConsumo());
        }
    }

    private int generarConsumo(){
        return 1 + (int) (50 * Math.random());
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public long getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(long tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }
}
