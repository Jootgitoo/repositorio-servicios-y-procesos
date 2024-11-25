public class Parking {

    private final static int PLAZAS_DISPONIBLES = 5;

    private boolean[] plazasParking = new boolean[PLAZAS_DISPONIBLES];

    private static Parking instance = null;

    private Parking(){
        rellenarPlazasParking();
    }

    private synchronized static void createInstance(){

        if (instance == null){
            instance = new Parking();
        }

    }

    public static Parking getInstance(){

        if (instance == null){

            createInstance();
        }
        return instance;
    }

    //True = está vacio y se puede aparcar
    private void rellenarPlazasParking(){
        for (int i=0; i<plazasParking.length; i++){
            plazasParking[i] = true;
        }
    }

    private void informacionParking(){
        int contadorPlazasLibres = 0;
        System.out.println("Plazas parking --> True = vacia, False = Ocupada");
        for(boolean p: plazasParking){
            if(p == true){
                contadorPlazasLibres++;
            }
            System.out.print("--->" +p+ " ");
        }
        System.out.println(); //Traza
        System.out.println("Numero plazas libres: " +contadorPlazasLibres);
        System.out.println("");
    }

    public synchronized int entrarParking(int idCoche){
        int huecoAparcado = -1;
        for(int i=0; i< plazasParking.length && huecoAparcado == -1; i++){

            if(plazasParking[i] == true){ //Hay plazas libres entonces aparca
                plazasParking[i] = false; //La plaza que ocupa se pone false0
                huecoAparcado = i; //Cojo el numero de la plaza --> 0,1,2...
                System.out.println("Coche " +idCoche+ " ha entrado al parking ocupando la plaza numero " +i);
                informacionParking();
                break;
            }
        }
        return huecoAparcado; //Devuelvo el numero de la plaza
    }

    public synchronized void salirParking(int idCoche, int huecoAparcadoCoche){

        plazasParking[huecoAparcadoCoche] = true;
        System.out.println("El coche " +idCoche+ " ha salido del parking de la plaza numero "+huecoAparcadoCoche);
        informacionParking();
    }

}
