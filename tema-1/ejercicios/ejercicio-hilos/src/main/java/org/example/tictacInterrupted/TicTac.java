package org.example.tictacInterrupted;

import javax.swing.plaf.TableHeaderUI;

class TicTac {
    public synchronized void esperar() throws InterruptedException{
        wait();
    }

    public synchronized void avisar() throws InterruptedException{
        notifyAll();
    }

}