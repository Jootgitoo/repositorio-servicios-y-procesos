package com.psp.ejercicio6Boxeo;

public class Boxeador extends Thread{
    private Ring ring;
    private int rival;
    private int numBoxeador;
    private int golpesRecibidos;
    private int golpesDados;
    private boolean noqueado;
    public Boxeador(int numBoxeador){
        this.ring = Ring.getInstance();
        this.numBoxeador = numBoxeador;
        this.rival = generaRival();
        this.golpesDados = 0;
        this.golpesRecibidos = 0;
        this.noqueado  =false;
    }
    @Override
    public void run() {
        while(ring.getNumCombates()<101){
                try {
                    if(isNoqueado()){
                        this.sleep(1000);
                        ring.despertarBoxeador(this);
                        setNoqueado(false);
                    }else{
                        ring.combatir(this);
                        this.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
        System.out.println("Boxeador "+getNumBoxeador()+
                " [golpesDados="+getGolpesDados()+" golpesRecibidos="+getGolpesRecibidos()+"]");

    }

    public int generaRival(){
        return 1 + (int) (4 * Math.random());
    }

    public int getRival() {
        return rival;
    }

    public void setRival(int rival) {
        this.rival = rival;
    }

    public int getNumBoxeador() {
        return numBoxeador;
    }

    public void setNumBoxeador(int numBoxeador) {
        this.numBoxeador = numBoxeador;
    }

    public int getGolpesRecibidos() {
        return golpesRecibidos;
    }

    public void setGolpesRecibidos(int golpesRecibidos) {
        this.golpesRecibidos = golpesRecibidos;
    }

    public int getGolpesDados() {
        return golpesDados;
    }

    public void setGolpesDados(int golpesDados) {
        this.golpesDados = golpesDados;
    }

    public boolean isNoqueado() {
        return noqueado;
    }

    public void setNoqueado(boolean noqueado) {
        this.noqueado = noqueado;
    }
}
