package org.example.Fabrica;

public class Fabrica extends Thread{

    private static final int LOTE = 450;
    private static final int MAXIMOS_LADRILLOS = 13500;
    private int contadorLotes = 0;

    Almacen almacen;

    public Fabrica(){
        almacen = Almacen.getInstance();
    }

    @Override
    public void run(){
        while (contadorLotes <= 13500){

            if (almacen.addLote() ){
                contadorLotes += 450;
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
