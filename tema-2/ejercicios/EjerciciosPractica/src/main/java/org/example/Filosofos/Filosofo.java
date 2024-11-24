package org.example.Filosofos;

public class Filosofo extends Thread{

    private int id;
    Cubiertos cubiertos;
    private int cubiertoIzquierda;
    private int cubiertoDerecha;

    public Filosofo(int idFilosofo){
        cubiertos = Cubiertos.getInstance();

        this.id = idFilosofo;
        if (idFilosofo == 0){
            cubiertoIzquierda = 0;
            cubiertoDerecha = cubiertos.arrayCubiertos.length-1;
        } else {
            cubiertoIzquierda = idFilosofo;
            cubiertoDerecha = idFilosofo - 1;
        }
    }



    @Override
    public void run(){

        boolean comiendo;

        while (true){

            comiendo = cubiertos.comer(this.id, this.cubiertoIzquierda, this.cubiertoDerecha);

            if(comiendo){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cubiertos.soltarCubiertos(this.cubiertoIzquierda, this.cubiertoDerecha);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
