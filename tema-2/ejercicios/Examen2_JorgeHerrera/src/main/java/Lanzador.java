import java.util.ArrayList;

public class Lanzador {

    public static void main(String[] args) {

        int NUMERO_COCHES = 10;

        for (int i=0; i<NUMERO_COCHES; i++){
            Coche c = new Coche(i);
            c.start();
        }

    }
}
