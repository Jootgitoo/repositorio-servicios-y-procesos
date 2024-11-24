package com.psp.ejercicio7Ruleta;

public class Banca {

    private static int dinero = 5000;
    private static Banca instance = null;
    public boolean crupierListo;
    private int numCroupier;

        private Banca(){
        }

        private synchronized static void createInstance() {
            if (instance == null) {
                instance = new Banca();
            }
        }
        public static Banca getInstance() {
            if (instance == null) {
                createInstance();
            }
            return instance;
        }


    public synchronized int apostar(int numeroElegido) throws InterruptedException {
                this.wait();

            abrirApuestas();
        int ganancias=0;
            if(numeroElegido == getNumCroupier() && (dinero-50)>0){
                ganancias=50;
                setDinero(getDinero()-50);
            }else if (numeroElegido == getNumCroupier()){
                ganancias=getDinero();
            }
            return ganancias;
    }

    public synchronized static int getDinero() {
        return dinero;
    }

    public synchronized static void setDinero(int dinero) {
        Banca.dinero = dinero;
    }

    public int getNumCroupier() {
        return numCroupier;
    }

    public void setNumCroupier(int numCroupier) {
        this.numCroupier = numCroupier;
    }

    public synchronized void abrirApuestas() {
        notifyAll();
    }
}
