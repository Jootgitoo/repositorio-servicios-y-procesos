package org.example.tictac;

public class TicTac {

    public synchronized void esperar() throws InterruptedException {
        wait();
    }

    public synchronized void seguir(){
        notifyAll();
    }
}
