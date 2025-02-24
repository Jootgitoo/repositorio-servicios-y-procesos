package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Peticion extends Thread{

    private Socket socket;

    //Clase serializable para el paso de objetos
    private PlatoComida platoComida;

    public Peticion(Socket socket, PlatoComida platoComida){
        this.socket = socket;
        this.platoComida = platoComida;
    }

    @Override
    public void run(){

        try {
            escuchar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void escuchar() throws IOException, ClassNotFoundException, InterruptedException {

        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        System.out.println("Conexion con el cliente exitosa");

        //Para leer la peticion del cliente
        ois = new ObjectInputStream(socket.getInputStream());

        //Para enviar datos al cliente
        oos = new ObjectOutputStream(socket.getOutputStream());

        boolean salir = false;
        while (!salir){

            //Recogemos la primera peticion del cliente (NOMBRES_PLATOS_DISPONIBLES)
            String peticionCliente = (String) ois.readObject();

            if( peticionCliente.equals("NOMBRES_PLATOS_DISPONIBLES") ){
                //Recogemos los platos de comida
                List<PlatoComida> listaPlatosDisponibles = platoComida.obtenerNombrePlatos();

                //Le enviamos los platos
                if(listaPlatosDisponibles.isEmpty()){ //Si no hya platos disponibles...
                    oos.writeObject("No hay platos disponibles, vuelva otro dia");
                    oos.writeObject("fin_programa");
                    oos.flush();

                } else { //Si hay platos disponibles...

                    for(PlatoComida p: listaPlatosDisponibles){
                        oos.writeObject("Plato disponible: " +p.getNombre());
                    }
                    oos.writeObject("fin_peticion");
                    oos.flush();

                }

                //Sleep para hacer el programa mas despacio
                Thread.sleep(3000);

            } else if ( peticionCliente.equals("UNIDADES_PLATO") ) {

                String nombrePlato = (String) ois.readObject();
                String SudPlato = (String) ois.readObject();
                int udPlato = Integer.parseInt(SudPlato);
                String platosDevueltos = platoComida.devolverPlatosPedidos(nombrePlato, udPlato);
                oos.writeObject(platosDevueltos);
                oos.writeObject("fin_programa");

            }

        }

        //Cerramos
        oos.close();
        ois.close();
        socket.close();
    }
}