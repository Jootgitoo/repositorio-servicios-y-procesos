package com.psp.dos;

public class Singleton {
    //crear referencia como est�tica
    private static Singleton instance = null;

    private static int numInstancias = 0;

    // Poner el constructor privado para que no se puedan crear m�s instancias
    private Singleton(){
        numInstancias++;
    }

    // creador sincronizado para protegerse de posibles problemas multi-hilo
    // garantizar que solo habr� una �nica instancia
    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
    }
    // crear m�todo p�blico y est�tico que me permita obtener la referencia a la clase
    public static Singleton getInstance() {
        if (instance == null) createInstance();
        return instance;
    }

    public static int getInstaciasConcurrentes(){
        return numInstancias;
    }

}

