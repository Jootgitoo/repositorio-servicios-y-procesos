public class Coche extends Thread{

    private int id;
    private int huecoAparcado; //Posicion en la que ha aparcado el coche
    private int interrupcion;
    Parking parking;

    public Coche(int id){
        parking = Parking.getInstance();

        this.id = id;
        this.huecoAparcado = -1;
        this.interrupcion = 0;
    }


    @Override
    public void run(){

        this.huecoAparcado = parking.entrarParking(this.id); //Me devuelve la plaza que ha ocupado o un -1 si no ha conseguido plaza

        while (true){

            if( this.huecoAparcado != -1 && interrupcion < 10000 ){ // Si el coche ha aparcado permanece en el parking entre 1 y 3 segundos
                try {
                    Thread.sleep(1000 * (int) Math.random() * 3 + 1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                parking.salirParking(this.id, this.huecoAparcado);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                interrupcion += 1000;
                this.huecoAparcado = parking.entrarParking(this.id); //Me devuelve la plaza que ha ocupado o un -1 si no ha conseguido plaza
            } else {
                Thread.currentThread().interrupt();
            }

        }


    }
}
