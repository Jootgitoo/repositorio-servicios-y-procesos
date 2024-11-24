package com.psp.ejercicio3Multihilo;

public class Almacen {
    private static Almacen instance = null;
        private int ladrillosAlmacen = 0;
        private boolean fabricaCerrada=false;
        private boolean obraParada=false;
        private long tiempoInicio = System.currentTimeMillis();
        private long tiempoActual;
        private Almacen(){}

        private synchronized static void createInstance() {
            if (instance == null) {
                instance = new Almacen();
            }
        }
        public static Almacen getInstance() {
            if (instance == null) {
                createInstance();
            }
            return instance;
        }

    public synchronized void fabricar(Fabrica fabrica) {
            if (fabrica.getLadrillosProducidos()<13500) {

                if (getLadrillosAlmacen() < 6000) {
                    setLadrillosAlmacen(getLadrillosAlmacen()+450);
                    System.out.println("La fabrica añade ladrillos al almacen. Ladrillos: "+getLadrillosAlmacen());
                    System.out.println("Ladrillos totales fabricados: "+fabrica.getLadrillosProducidos());
                }else{
                    System.out.println("No caben mas ladrillos en el almacen. Ladrillos: "+getLadrillosAlmacen());
                }
                fabrica.setLadrillosProducidos(fabrica.getLadrillosProducidos()+450);

            }else{
                setFabricaCerrada(true);
                System.out.println("La fabrica ha cerrado. Ladrillos totales fabricados: "+fabrica.getLadrillosProducidos());
            }
    }

    public synchronized void usarLadrillos(Obra obra) {
            if((System.currentTimeMillis()-tiempoInicio)<120000) {
                if ((getLadrillosAlmacen()-obra.getLadrillosUsa()) > 0) {
                    setLadrillosAlmacen(getLadrillosAlmacen() - obra.getLadrillosUsa());
                    System.out.println("La obra "+obra.getNum()+" usa ladrillos del almacen. Ladrillos: "+getLadrillosAlmacen());
                }else{
                    System.out.println("La obra "+obra.getNum()+" no puede coger suficientes ladrillos. Ladrillos: "+getLadrillosAlmacen());
                }
            }else{
                setObraParada(true);
                System.out.println("Las obras han parado");
            }
    }

    public synchronized int getLadrillosAlmacen() {
        return ladrillosAlmacen;
    }

    public synchronized void setLadrillosAlmacen(int ladrillosAlmacen) {
        this.ladrillosAlmacen = ladrillosAlmacen;
    }

    public synchronized boolean isFabricaCerrada() {
        return fabricaCerrada;
    }

    public synchronized void setFabricaCerrada(boolean fabricaCerrada) {
        this.fabricaCerrada = fabricaCerrada;
    }

    public synchronized boolean isObraParada() {
        return obraParada;
    }

    public synchronized void setObraParada(boolean obraParada) {
        this.obraParada = obraParada;
    }
}
