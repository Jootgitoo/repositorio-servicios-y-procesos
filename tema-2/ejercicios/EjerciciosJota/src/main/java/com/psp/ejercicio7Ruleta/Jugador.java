package com.psp.ejercicio7Ruleta;

public class Jugador extends Thread{

    private Banca banca;
    private int numeroElegido;
    private int saldo;
    private int idJugador;

    public Jugador(int idJugador){
        this.idJugador = idJugador;
        this.banca = Banca.getInstance();
    }

    @Override
    public void run() {
        while(getSaldo()>0){
            setNumeroElegido(generarNumero());
            System.out.println("El jugador "+idJugador+" apuesta");
            setSaldo(getSaldo()-10);
            try {
                saldo = saldo+banca.apostar(getNumeroElegido());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setCroupierListo(){
        banca.crupierListo = true;
    }

    public int generarNumero(){ return 1 + (int) (10 * Math.random());}

    public int getNumeroElegido() {
        return numeroElegido;
    }

    public void setNumeroElegido(int numeroElegido) {
        this.numeroElegido = numeroElegido;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
