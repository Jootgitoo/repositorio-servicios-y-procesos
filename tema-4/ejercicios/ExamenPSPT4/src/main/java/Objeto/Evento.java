package Objeto;

public class Evento {

    private String nombeEvento;
    private int entradasEvento;


    public Evento(){

    }

    public Evento(String nombeEvento, int entradasEvento){
        this.nombeEvento = nombeEvento;
        this.entradasEvento = entradasEvento;
    }

    public String getNombeEvento() {
        return nombeEvento;
    }

    public void setNombeEvento(String nombeEvento) {
        this.nombeEvento = nombeEvento;
    }

    public int getEntradasEvento() {
        return entradasEvento;
    }

    public void setEntradasEvento(int entradasEvento) {
        this.entradasEvento = entradasEvento;
    }
}