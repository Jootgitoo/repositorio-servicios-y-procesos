package es.jorge.CarreraCamellos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Camello implements Serializable {

    private int id;
    private String nombre;
    private int distanciaRecorrida;
    List<Camello> listaCamellos = new ArrayList<>();

    public Camello(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public Camello(){
        listaCamellos.add( new Camello( 1, "Camello 1" ) );
        listaCamellos.add( new Camello( 2, "Camello 2" ) );
        listaCamellos.add( new Camello( 3, "Camello 3" ) );
        listaCamellos.add( new Camello( 4, "Camello 4" ) );
        listaCamellos.add( new Camello( 5, "Camello 5" ) );
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public List<Camello> getListaCamellos() {
        return listaCamellos;
    }

    public void setListaCamellos(List<Camello> listaCamellos) {
        this.listaCamellos = listaCamellos;
    }
}