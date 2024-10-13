package org.example.carreraPersonas2;

public class Pistoletazo {

    public synchronized void esperar() throws InterruptedException {
        this.wait();
    }

    public synchronized void avisar() {
        notifyAll();
    }

}