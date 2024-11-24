package com.psp.ejercicio4jugador;

public class Arbitro {

    private static Arbitro instance = null;

    private int numeroGanador;
    public boolean finalizado;

    public int turnoActual;

        private Arbitro(){
            this.numeroGanador = 1 + (int) (10 * Math.random());
            this.finalizado = false;
            this.turnoActual = generarNuevoTurno(0);
        }

        private synchronized static void createInstance() {
            if (instance == null) {
                instance = new Arbitro();
            }
        }
        public static Arbitro getInstance() {
            if (instance == null) {
                createInstance();
            }
            return instance;
        }

        public synchronized void comprobarNumero(Jugador jugador){
            if(jugador.getIdJugador() == getTurnoActual()){

                System.out.println("El jugador "+jugador.getIdJugador()+" dice: "+ jugador.getNumeroDicho());
                //Genero ya el siguiente turno en caso de que falle poder decir a quien le toca
                setTurnoActual(generarNuevoTurno(getTurnoActual()));

                if(jugador.getNumeroDicho() == getNumeroGanador()){

                    System.out.println("Jugador "+jugador.getIdJugador()+" gana, adivinó el numero!!!");
                    setFinalizado(true);

                }else{
                    System.out.println("Le toca jugar al Jugador "+getTurnoActual());
                }
            }

        }

    public int getNumeroGanador() {
        return numeroGanador;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public synchronized void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public synchronized int getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(int turnoActual) {
        this.turnoActual = turnoActual;
    }
    public int generarNuevoTurno(int turnoActual) {

        int nuevoTurno;

        do {
            nuevoTurno = 1 + (int) (3 * Math.random());
        } while (nuevoTurno == getTurnoActual());

        return nuevoTurno;

    }

}
