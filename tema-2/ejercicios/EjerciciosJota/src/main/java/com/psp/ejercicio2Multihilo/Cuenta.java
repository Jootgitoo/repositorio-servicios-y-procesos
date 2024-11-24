package com.psp.ejercicio2Multihilo;

public class Cuenta {
    private static Cuenta instance = null;

        public boolean abierto;
        private int maximo;
        public int saldo;
        private Cuenta(){
            this.maximo = 5000;
            this.saldo = 0;
            abierto = true;
        }

        private synchronized static void createInstance() {
            if (instance == null) {
                instance = new Cuenta();
            }
        }
        public static Cuenta getInstance() {
            if (instance == null) {
                createInstance();
            }
            return instance;
        }

    public synchronized void ingresar(int tiempoEsperado) {
            if(tiempoEsperado<90) {
                if (getSaldo() < getMaximo()) {
                    setSaldo(getSaldo() + 500);
                    System.out.println("Ingresa ha añadido saldo. Saldo actual de la cuenta: " + getSaldo());
                } else {
                    System.out.println("Ingresa no puede ingresar mas dinero. Saldo de la cuenta: " + getSaldo());
                }
            }else{
                setAbierto(false);
                System.out.println("El banco ha cerrado, el cliente que ingresa ha esperado más de 90 segundos");
            }

    }

    public synchronized void retirar(Cobra cobra) {
            if(cobra.getAcumulado()<6000) {
                if (0 < getMaximo()) {
                    setSaldo(getSaldo() - 300);
                    cobra.setAcumulado(cobra.getAcumulado() + 300);
                    System.out.println("Cobra ha sacado dinero de la cuenta. Saldo actual de la cuenta: " + getSaldo());
                } else {
                    System.out.println("Cobra no puede sacar mas dinero. Saldo de la cuenta: " + getSaldo());
                }
            }else{
                setAbierto(false);
                System.out.println("El banco ha cerrado, el cliente que cobra ha sacado "+cobra.getAcumulado());
            }
    }

    public int getMaximo() {
        return maximo;
    }

    public synchronized int getSaldo() {
        return saldo;
    }

    public synchronized void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public synchronized boolean isAbierto() {
        return abierto;
    }

    public synchronized void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }
}
