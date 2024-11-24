package org.example.ProductoConsumidorNumeros;


public class LeerNumeros extends Thread {

    ColaNumeros colaNumeros;

    public LeerNumeros(){
        colaNumeros = ColaNumeros.getInstance();
    }

    @Override
    public void run(){

        while (true){
            int numero = colaNumeros.leerNumero();

            if(numero == -1){
                System.out.println("No he podido leer");
            } else {
                System.out.println("Numero leido: " +numero);

            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
