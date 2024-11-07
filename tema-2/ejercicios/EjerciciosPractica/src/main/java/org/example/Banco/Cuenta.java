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

    public synchronized void ingresar(){
        if(dineroCuenta < 5000){
            dineroCuenta += 500;
            System.out.println("Has ingresado dinero. Dinero actual de la cuenta " + dineroCuenta);

        }
    }

    public synchronized void retirar(Cobra cobra){
        if(dineroCuenta > 300){
            dineroCuenta-=300;
            cobra.setDineroRetirado( cobra.getDineroRetirado() + 300 );
            System.out.println("Has retirado dinero. Dinero actual de la cuenta " + dineroCuenta);

        }
    }
}
