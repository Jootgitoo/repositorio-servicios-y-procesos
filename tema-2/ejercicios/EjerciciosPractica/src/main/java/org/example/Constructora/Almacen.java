package org.example.Constructora;

public class Almacen {

    private static final int CAPACIDAD_ALMACEN = 6000;
    private int capacidadActual = 0;

    private static Almacen instance = null;

    private Almacen(){

    }

    private synchronized static void createInstance(){
        if(instance == null){
            instance = new Almacen();
        }
    }
    public static Almacen getInstance(){
        if(instance == null){
            createInstance();
        }
        return instance;
    }


    public synchronized boolean addLote(){
        boolean addLote;

        if( capacidadActual < (CAPACIDAD_ALMACEN - 450 )){
            capacidadActual += 450;
            addLote = true;
            System.out.println("Lote añadido con exito. Capacidad actual: " +this.capacidadActual);
        } else {
            addLote = false;
            System.out.println("No se ha podido añadir el lote. Capacidad actual: " +this.capacidadActual);
        }

        return addLote;
    }

    public synchronized void gastarLote(int idObra){

        if(idObra == 1 && capacidadActual > 200){
            capacidadActual -= 200;
            System.out.println("Se ha utilizado un lote de 200 ladrillos. Capacidad actual: " +this.capacidadActual);

        } else if (idObra == 2 && capacidadActual > 400) {
            capacidadActual -= 400;
            System.out.println("Se ha utilizado un lote de 400 ladrillos. Capacidad actual: " +this.capacidadActual);

        }

    }

}
