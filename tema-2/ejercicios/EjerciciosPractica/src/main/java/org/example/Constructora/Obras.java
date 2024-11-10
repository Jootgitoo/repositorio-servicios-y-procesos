package org.example.Constructora;

public class Obras extends Thread{

    public int idObra;
    public int contadorObra;

    Almacen almacen;

    public Obras(int idObra){
        this.idObra = idObra;
        this.contadorObra = 0;
        almacen = Almacen.getInstance();
    }


    @Override
    public void run(){
        while (this.contadorObra < 120){

            almacen.gastarLote(this.idObra);
            aumentarContador();

            if (this.idObra == 1){

                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else if (this.idObra == 2) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    private void aumentarContador(){
        this.contadorObra += 2;
    }
}
