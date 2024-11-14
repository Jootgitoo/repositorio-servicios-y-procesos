package org.example.Banco;

public class Ingresa extends Thread{

    private Cuenta cuenta;
    int segundosDormidosActuales = 0;

    public Ingresa(){
        cuenta = Cuenta.getInstance();

    }

    @Override
    public void run (){
        while (this.segundosDormidosActuales < 90){
            if (cuenta.ingresar()) {
                aumnentarContador();
                comprobarSegundosDormidos();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();            }
        }

    }

    private void aumnentarContador(){
        this.segundosDormidosActuales += 2;
        System.out.println("En total has dormido "+this.segundosDormidosActuales + " sgundos");
        System.out.println("");
    }

    private void comprobarSegundosDormidos(){
        if (this.segundosDormidosActuales >= 90){
            System.out.println("Como hemos dormido 90 segundos termina el programa");
            System.exit(0);
        }
    }

}
