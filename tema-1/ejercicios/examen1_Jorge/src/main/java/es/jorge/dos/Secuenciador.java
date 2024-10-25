package es.jorge.dos;

public class Secuenciador {

    private int contador = 0;



    private static Secuenciador instance = null;



    private Secuenciador(){

    }

    private static synchronized void createInstance(){

        if (instance == null){
            instance = new Secuenciador();
        }

    }

    public static Secuenciador getInstance(){

        if (instance == null){
            createInstance();
        }
        return instance;
    }



    private synchronized void esperarPar() throws InterruptedException {

        if (contador % 2 == 1){ //Esto dice si el numero es impar
            wait(); //Tiene que entrar porque estamos en el metodo par
        }

    }

    private synchronized void esperarImpar(){

        if(contador % 2 == 0){ //Esto dice que si el numero es par
            try {
                wait(); //Tiene que entrar porque estamos en el metodo impar
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


    private void siguiente(){
        contador++;
        notifyAll();
    }

}
