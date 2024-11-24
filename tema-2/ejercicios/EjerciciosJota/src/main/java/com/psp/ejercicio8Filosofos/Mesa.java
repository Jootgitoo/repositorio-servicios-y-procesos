package com.psp.ejercicio8Filosofos;

public class Mesa {
    private static Mesa instance = null;

    private static final int NUM_FILOSOFOS = 5;
        public boolean[] cubiertos = new boolean[5];
        private Mesa(){
            fillArray();
        }

        private synchronized static void createInstance() {
            if (instance == null) {
                instance = new Mesa();
            }
        }
        public static Mesa getInstance() {
            if (instance == null) {
                createInstance();
            }
            return instance;
        }


    public synchronized void comer(int cubiertoDer, int cubiertoIzq) {
        if(isCubiertoLibre(cubiertoDer) && isCubiertoLibre(cubiertoIzq)) {
            this.cubiertos[cubiertoDer] = false;
            this.cubiertos[cubiertoIzq] = false;
        }
    }
    public synchronized void dejarCubiertos(int cubiertoDer, int cubiertoIzq) {
        this.cubiertos[cubiertoDer] = true;
        this.cubiertos[cubiertoIzq] = true;
        System.out.println("Palillos liberados: "+cubiertoDer+" y "+cubiertoIzq);
    }


        private void fillArray(){
            for (int i = 0; i<this.cubiertos.length;i++){
                cubiertos[i]=true;
            }
        }

    public synchronized boolean isCubiertoLibre(int pos) {
            return this.cubiertos[pos];
    }
}
