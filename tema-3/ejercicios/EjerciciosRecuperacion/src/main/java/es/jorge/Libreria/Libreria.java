package es.jorge.Libreria;

import java.util.ArrayList;
import java.util.List;

public class Libreria {

    private List<Libro> listaLibros = new ArrayList<>();

    public Libreria(){
        listaLibros.add(new Libro("Libro 1", 3));
        listaLibros.add(new Libro("Libro 2", 1));
        listaLibros.add(new Libro("Libro 3", 1));
        listaLibros.add(new Libro("Libro 4", 3));
        listaLibros.add(new Libro("Libro 5", 2));
    }

    public List<Libro> obtenerLibro(int numeroLibros){

        List<Libro> librosPedidos = new ArrayList<>();
        int librosAdd = 0;

        for(Libro l : listaLibros){

            if(librosAdd < numeroLibros && l.getUnidades() > 0){
                do {
                    l.setUnidades( l.getUnidades() - 1 );
                    librosPedidos.add(l);
                    librosAdd++;
                } while (l.getUnidades() > 0 && librosAdd < numeroLibros);

            }

        }

        return librosPedidos;
    }


    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }
}





















