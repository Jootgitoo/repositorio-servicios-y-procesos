package com.psp.dos;

public class SycnronizationExample {

    public synchronized void lockedByThis(){
        System.out.println("Este metodo sincronizado esta bloqueado por la instancia actual del objeto, es decir, this");
    }

    public static synchronized void lockedByClassLock(){
        System.out.println("Este m�todo sincronizado est�tico est� bloqueado por el bloqueo de nivel de clase de esta clase, es decir, SychronizationExample.class");

    }

    public void lockedBySynchronizedBlock(){
        System.out.println("Esta linea es ejecutada sin bloqueo");

        Object obj = String.class; //class level lock of Stirng class

        synchronized(obj){
            System.out.println("Bloque sincronizado, bloqueado por un bloqueo representado mediante la variable obj");
        }
    }

}