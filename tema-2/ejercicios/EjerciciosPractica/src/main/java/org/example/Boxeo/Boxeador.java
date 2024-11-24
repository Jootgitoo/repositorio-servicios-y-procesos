package org.example.Boxeo;

public class Boxeador extends Thread{

    private int id;
    private int golpesDados;
    private int golpesRecibidos;
    private int contadorNoqueo;
    private int rival;

    Ring ring;

    public Boxeador(int id){
        ring = Ring.getInstance();

        this.id = id;
        this.golpesDados = 0;
        this.golpesRecibidos = 0;
        this.contadorNoqueo = 0;
        this.rival = (int) (Math.random() * 4) + 1;
    }

    @Override
    public void run(){

        boolean sePuedeConvatir = true;
        while (sePuedeConvatir){

            if(this.contadorNoqueo >= 3){
                System.out.println("Boxeador " +this.id+ " está noqueado");
                this.contadorNoqueo = 0;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                 sePuedeConvatir = ring.luchar();
                 this.golpesDados++;
 //                boxeadorRival.setGolpesRecibidos( boxeadorRival.getGolpesRecibidos() + 1);
 //                boxeadorRival.setContadorNoqueo(boxeadorRival.getContadorNoqueo() + 1);
                System.out.println("");
              //  System.out.println("Boxeador " +this.id+ " golpea al boxeador " +idRival);
            }

        }

        System.out.println("Boxeador: "+this.id+ " ha golpeado: " +this.golpesDados+ " y ha recibido: " +this.golpesRecibidos);

    }

    public int getContadorNoqueo() {
        return contadorNoqueo;
    }

    public int getGolpesDados() {
        return golpesDados;
    }

    public int getGolpesRecibidos() {
        return golpesRecibidos;
    }

    public void setGolpesDados(int golpesDados) {
        this.golpesDados = golpesDados;
    }

    public void setGolpesRecibidos(int golpesRecibidos) {
        this.golpesRecibidos = golpesRecibidos;
    }

    public void setContadorNoqueo(int contadorNoqueo) {
        this.contadorNoqueo = contadorNoqueo;
    }

    public void setRival(int rival) {
        this.rival = rival;
    }

    public int getRival() {
        return rival;
    }
}
