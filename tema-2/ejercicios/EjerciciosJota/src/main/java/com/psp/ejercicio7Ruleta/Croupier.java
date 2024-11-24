package com.psp.ejercicio7Ruleta;

public class Croupier extends Thread {

    private Banca banca;
    private int numeroElegido;
    public Croupier(){
        this.banca = Banca.getInstance();
    }
    @Override
    public void run() {
        while(true){
            setNumeroElegido(generarNumero());
            banca.setNumCroupier(getNumeroElegido());
            System.out.println("Croupier: Hagan sus apuestas");
            banca.abrirApuestas();
            try {
                this.sleep(3000);
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }

    public int generarNumero(){
        return 1 + (int) (10 * Math.random());
    }

    public int getNumeroElegido() {
        return numeroElegido;
    }

    public void setNumeroElegido(int numeroElegido) {
        this.numeroElegido = numeroElegido;
    }
}
