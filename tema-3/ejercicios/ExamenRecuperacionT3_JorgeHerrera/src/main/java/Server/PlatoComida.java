package Server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlatoComida implements Serializable {

    private String nombre;
    private int cantidad;

    public List<PlatoComida> listaPlatos = new ArrayList<>();

    public PlatoComida(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public PlatoComida(){
        listaPlatos.add( new PlatoComida( "Tortilla de patatas", 15));
        listaPlatos.add( new PlatoComida( "Ensaladilla Rusa", 25));
        listaPlatos.add( new PlatoComida( "Paella", 20));
        listaPlatos.add( new PlatoComida( "Pescado", 40));
    }

    public List<PlatoComida> obtenerNombrePlatos(){
        List<PlatoComida> platosComidaDisponibles = new ArrayList<>();

        for(PlatoComida p: listaPlatos){ //De todos los platos que hay en la lista

            if(p.getCantidad() > 0){ //Si tienen mas de 1 cant
                platosComidaDisponibles.add(p);
            }

        }

        return platosComidaDisponibles;
    }

    public String devolverPlatosPedidos(String nombrePlato, int cantidadSolicitada){

        String respuesta = "";

        for(PlatoComida p: listaPlatos){

            if(p.getNombre().equals(nombrePlato)){

                if(p.getCantidad() > cantidadSolicitada){

                    p.setCantidad( p.getCantidad() - cantidadSolicitada );

                    respuesta = "Aqui tiene " +cantidadSolicitada+ " unidades de " +nombrePlato;

                } else {
                    respuesta = "No hay suficientes platos, le enviamos " +p.getCantidad() + " platos restantes";

                    p.setCantidad( p.getCantidad() - cantidadSolicitada);
                }
                break;

            } else {
                respuesta = "El plato no existe en nuestro menú";
            }
        }

        return respuesta;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}