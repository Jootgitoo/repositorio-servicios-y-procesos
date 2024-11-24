package org.example.Casino;

public class Crupier extends Thread{

    Banca banca;

    public Crupier(){
        banca = Banca.getInstance();
    }



    @Override
    public void run(){

        while(!isInterrupted()){

            int numero = banca.numeroCrupier();
            System.out.println("Numero del Crupier: " +numero);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Crupier interrumpido");
                Thread.currentThread().interrupt(); // Restablece el estado de interrupción
                break;            }
        }

    }
}
