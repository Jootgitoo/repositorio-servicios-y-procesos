package com.psp.ejercicio11GrandesAlmacenes;

public class GrandesAlmacenes {
    private static GrandesAlmacenes instance = null;
    private int unidades;
    private boolean puertaDisponibles;
        private GrandesAlmacenes(){
            this.puertaDisponibles = true;
            this.unidades=100;
        }
        
        private synchronized static void createInstance() {
            if (instance == null) {
                instance = new GrandesAlmacenes();
            }
        }
        public static GrandesAlmacenes getInstance() {
            if (instance == null) {
                createInstance();
            }
            return instance;
        }

    public synchronized boolean comprarProducto() {
        setPuertaDisponibles(false);
        boolean comprado = true;
        if(getUnidades()>0){
            setUnidades(getUnidades()-1);
        }else{
            comprado= false;
        }
        setPuertaDisponibles(true);
        return comprado;
    }

    public synchronized boolean isPuertaDisponibles() {
        return puertaDisponibles;
    }

    public synchronized void setPuertaDisponibles(boolean puertaDisponibles) {
        this.puertaDisponibles = puertaDisponibles;
    }

    public synchronized int getUnidades() {
        return unidades;
    }

    public synchronized void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}
