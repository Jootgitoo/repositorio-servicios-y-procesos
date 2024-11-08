package org.example.Banco;

public class Cuenta {

    private int dineroCuenta;

    private static Cuenta instance = null;

    private Cuenta(){

    }

    private synchronized static void createInstance(){
        if (instance == null){
            instance = new Cuenta();
        }
    }

    public static Cuenta getInstance(){
        if(instance == null){
            createInstance();
        }
        return instance;
    }

    public synchronized boolean ingresar(){
        boolean ingresa;
        if(dineroCuenta <= 4500){
            dineroCuenta += 500;
            ingresa = true;
            System.out.println("Has ingresado dinero. Dinero actual de la cuenta " + dineroCuenta);
        } else {
            ingresa = false;
        }
        return ingresa;
    }

    public synchronized boolean retirar(){
        boolean retira;
        if(dineroCuenta > 300){
            dineroCuenta-=300;
            System.out.println("Has retirado dinero. Dinero actual de la cuenta " + dineroCuenta);
            retira = false;
        } else{
            retira = true;
        }
        return retira;

    }
}
