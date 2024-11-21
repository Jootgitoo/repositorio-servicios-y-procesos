package org.example.Filosofos;

public class Cubiertos {
    private static Cubiertos instance = null;
    
    private Cubiertos(){
    }

    private synchronized static void createInstance(){

        if (instance == null){
            instance = new Cubiertos();
        }

    }

    public static Cubiertos getInstance(){

        if (instance == null){

            createInstance();
        }
        return instance;
    }
}
