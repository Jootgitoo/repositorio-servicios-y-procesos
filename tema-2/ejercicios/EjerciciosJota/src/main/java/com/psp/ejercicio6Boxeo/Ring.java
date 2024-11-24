package com.psp.ejercicio6Boxeo;

public class Ring {
    private static Ring instance = null;
    private int numCombates;
    private int[] golpesRecibidos = {0,0,0,0};

        private Ring(){
            this.numCombates = 0;
        }

        private synchronized static void createInstance() {
            if (instance == null) {
                instance = new Ring();
            }
        }
        public static Ring getInstance() {
            if (instance == null) {
                createInstance();
            }
            return instance;
        }

    public synchronized int getNumCombates() {
        return numCombates;
    }

    public void setNumCombates(int numCombates) {
        this.numCombates = numCombates;
    }

    public synchronized void combatir(Boxeador boxeador) {
        if(comprobarKO(boxeador.getNumBoxeador())>=3){
            System.out.println("--Boxeador "+boxeador.getNumBoxeador()+" esta noqueado");
            boxeador.setNoqueado(true);
        }else{
            System.out.println("Boxeador "+boxeador.getNumBoxeador()+" pega a Boxeador "+boxeador.getRival());
            boxeador.setGolpesDados(boxeador.getGolpesDados()+1);
            golpesRecibidos[boxeador.getRival()-1]++;
            setNumCombates(getNumCombates()+1);
        }
    }

    public synchronized int comprobarKO(int numBoxeador){
            return golpesRecibidos[numBoxeador-1];
    }

    public synchronized void despertarBoxeador(Boxeador boxeador){
            boxeador.setGolpesRecibidos(boxeador.getGolpesRecibidos() + golpesRecibidos[boxeador.getNumBoxeador()-1]);
            golpesRecibidos[boxeador.getNumBoxeador()-1]=0;
    }

    public int[] getGolpesRecibidos() {
        return golpesRecibidos;
    }

    public void setGolpesRecibidos(int[] golpesRecibidos) {
        this.golpesRecibidos = golpesRecibidos;
    }
}
