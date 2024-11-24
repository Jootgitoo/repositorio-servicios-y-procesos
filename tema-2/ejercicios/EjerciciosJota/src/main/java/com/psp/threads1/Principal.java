package com.psp.threads1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<Coche> listaCoches = new ArrayList<>();
        Coche c1 = new Coche("Ford");
        Coche c2 = new Coche("Opel");
        Coche c3 = new Coche("Seat");
        listaCoches.add(c1);
        listaCoches.add(c2);
        listaCoches.add(c3);

        for (Coche c : listaCoches){
            c.start();
        }
        try {
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(listaCoches);
        System.out.println("--------PODIO--------");

        System.out.println("ORO: "+listaCoches.get(2).getNombre()+" con "+listaCoches.get(2).getDistanciaRecorrida()+" m");
        System.out.println("PLATA: "+listaCoches.get(1).getNombre()+" con "+listaCoches.get(1).getDistanciaRecorrida()+" m");
        System.out.println("BRONCE: "+listaCoches.get(0).getNombre()+" con "+listaCoches.get(0).getDistanciaRecorrida()+" m");
    }
}
