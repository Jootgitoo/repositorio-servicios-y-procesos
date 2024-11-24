package org.example.Filosofos;

public class Cubiertos {

    private static Cubiertos instance = null;

    public boolean arrayCubiertos[] = new boolean[5];

    private Cubiertos(){
        rellenarCubiertos();
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

    private void rellenarCubiertos(){

        for (int i = 0; i< arrayCubiertos.length; i++){
            arrayCubiertos[i] = true;
        }

    }

    public boolean comer(int idFilosofo, int pos1, int pos2){
        boolean comiendo = false;
        if(arrayCubiertos[pos1] == true && arrayCubiertos[pos2] == true){
            arrayCubiertos[pos1] = false;
            arrayCubiertos[pos2] = false;
            comiendo = true;
            System.out.println("Filosofo " +idFilosofo+ " está comiendo con los cubiertos " +pos1+ " y " +pos2);
        } else {
            System.out.println("Filosofo " +idFilosofo+ " no puedo comer... Entonces pienso");
            comiendo = false;
        }
        return comiendo;
    }


    public void soltarCubiertos(int pos1, int pos2){
        arrayCubiertos[pos1] = true;
        arrayCubiertos[pos2] = true;

        System.out.println("Cubiertos " +pos1+ " y " +pos2+ " quedan libres");

    }



}
