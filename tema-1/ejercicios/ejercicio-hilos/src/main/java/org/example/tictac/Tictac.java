package org.example.tictac;

public class Tictac {

    public synchronized void esperar(){
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void avisar(){
        notifyAll();
    }
}
