package org.example.carreraRelevos;

public class Atleta extends Thread{

    private int dorsal;

    private Carrera carrera;

    public Atleta (int dorsalAtleta){
        this.dorsal = dorsalAtleta;

        carrera = Carrera.getInstance();
    }

    @Override
    public void run(){

        try {

            //Primero llamo a esperar relevo, este hará que paren todos los hilos menos el del turno actual
            carrera.esperarRelevo(dorsal);

            System.out.println("Esta corriendo el dorsal " +dorsal);

            //Saca la fecha actual en milisegundos
            long tiempoInicio = System.currentTimeMillis();

            //Calcula un número aleatorio entre 9000 y 11000
            int tiempoCarrera = 9000 + (int) (Math.random() * 2000);

            //Duerme el hilo en ese tiempo en Milisegundos
            Thread.sleep(tiempoCarrera);

            //Saca la fecha actual
            long tiempoFinal = System.currentTimeMillis();

            //Imprimimos el atleta con su dorsal y con esa formula calculamos el tiempo que ha tardado
            System.out.println("Atleta " +dorsal+ " termino de correr en " +(tiempoFinal - tiempoInicio) /1000.0 + " segundos");

            carrera.avisar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
