package org.example.alternando;
class TicTac {
    public synchronized void esperar() throws InterruptedException {
        wait();
    }

    public synchronized void avisar() throws InterruptedException {
        notifyAll();
    }
}