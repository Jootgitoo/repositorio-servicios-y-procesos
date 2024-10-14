package org.example.saludo;

public class Aula extends Thread {

    private String nombre;

    private Saludar saludo;

    private boolean esProfesor;

    public Aula (String nombreAlumno, boolean esProfesor){
        this.nombre = nombreAlumno;

        //Así para coger la misma instancia
        saludo = Saludar.getInstance();

        this.esProfesor = esProfesor;
    }

    @Override
    public void run(){
        if (esProfesor == true){
            saludo.responderSaludo();
        } else {
            saludo.saludarProfe(nombre);
        }
    }

}
