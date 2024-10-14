package org.example.saludo;

public class Saludar {

    private static Saludar instance = null;

    //El constructor siempre es privado para que no se creen mas instancias
    private Saludar(){
    }

    //De aqui hasta la siguiente marca se hace siempre igual pero obviamente poniendo el nombre que toque
    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new Saludar();
        }
    }
    public static Saludar getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    //Estos métodos no van a funcionar por que tanto el wait como el notifyAll
    //necesitan estar sincronizados
    public synchronized void saludarProfe(String nombreAlumno){

        //El wait solo funciona dentro de un try catch
        try{
           wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(nombreAlumno + " Buenos dias profesor");
    }

    public synchronized void responderSaludo(){
        System.out.println("Profesor --> Buenos dias clase");
        notifyAll();
    }


}
