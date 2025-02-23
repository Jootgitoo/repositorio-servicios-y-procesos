package es.jorge.VaritasString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Varitas implements Serializable {

    private String nombre;
    private int numero;

    public List<Varitas> listaVaritas = new ArrayList<>();

    public Varitas(){
        Varitas v1 = new Varitas("Varita 1", 1);
        Varitas v2 = new Varitas("Varita 2", 5);
        Varitas v3 = new Varitas("Varita 3", 1);
        Varitas v4 = new Varitas("Varita 4", 3);
        Varitas v5 = new Varitas("Varita 5", 1);

        listaVaritas.add(v1);
        listaVaritas.add(v2);
        listaVaritas.add(v3);
        listaVaritas.add(v4);
        listaVaritas.add(v5);

    }

    public synchronized Varitas obtenerVarita(){

        Varitas v = null;

        for(Varitas var: listaVaritas){
           if(var.getNumero() > 0){
               var.setNumero( var.getNumero() - 1 );
               v = var;
               break;
           }
        }

       return v;
    }

    public Varitas(String nombre, int numero){
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Varitas> getListaVaritas() {
        return listaVaritas;
    }

    public void setListaVaritas(List<Varitas> listaVaritas) {
        this.listaVaritas = listaVaritas;
    }
}