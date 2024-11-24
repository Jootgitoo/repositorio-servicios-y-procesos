package com.psp.threads1;

import java.util.Date;
import java.util.Random;

public class Carrera {
        public boolean acabar=false;
        //private static Object lockobject = new Object();
        private static Carrera instance = null;
        private Random r = new Random(System.currentTimeMillis());
        public int metros = r.nextInt(1,1001);

        private Carrera(){
        }
        private synchronized static void createInstance() {
            if (instance == null) {
                instance = new Carrera();
            }
        }
        public static Carrera getInstance() {
            if (instance == null) {
                createInstance();
            }
            return instance;
        }

    public synchronized boolean isAcabar() {
        return acabar;
    }

    public void setAcabar(boolean acabar) {
        this.acabar = acabar;
    }

    public int getMetros() {
        return metros;
    }

    public synchronized void avanzar(Coche coche) {
            if (coche.getDistanciaRecorrida() < getMetros()) {
                double porcentaje = (coche.getDistanciaRecorrida()/getMetros())*100;
                System.out.printf("%s ha recorrido un %.2f %%\n", coche.nombre, porcentaje);
            }else{
                System.out.println(coche.nombre+" ha ganado la carrera!!!");
                setAcabar(true);
            }
    }
}
