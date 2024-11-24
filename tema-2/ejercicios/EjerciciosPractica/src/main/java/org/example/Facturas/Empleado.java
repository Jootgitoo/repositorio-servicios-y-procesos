package org.example.Facturas;

public class Empleado extends Thread{

    private int id;
    private int consumoEmpleado;
    private long tiempoInicio;
    private int numeroFacturasGeneradas;

    Tarifa tarifa;

    public Empleado(int idEmpleado){
        this.id = idEmpleado;
        this.consumoEmpleado = generarConsumo();
        tarifa = Tarifa.getInstance();
        this.tiempoInicio = System.currentTimeMillis();
    }



    @Override
    public void run(){

        while ((System.currentTimeMillis()-tiempoInicio)<3*60*1000){
            tarifa.crearFactura(this.id, this.consumoEmpleado);
            numeroFacturasGeneradas++;
            try {
                Thread.sleep(1000 * this.id);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            setConsumoEmpleado(generarConsumo());

        }

    }

    private int generarConsumo(){
        return (int) (Math.random() * 50) +1;
    }

    public void setConsumoEmpleado(int consumoEmpleado) {
        this.consumoEmpleado = consumoEmpleado;
    }

    public int getNumeroFacturasGeneradas() {
        return numeroFacturasGeneradas;
    }
}
