package org.example.tictacInterrupted;

/**
 * Crear un hilo que visualice por pantalla 
 * en un bucle infinito la palabra TIC
 * Dentro del bucle, utiliza el m�todo sleep() 
 * para que nos de tiempo a ver las palabras 
 * que se visualizan cuando lo ejecutemos
 * 
 * @author santa
 *
 */
public class HiloTIC extends Thread {

	TicTac ticTac;

	public HiloTIC(TicTac tictac){
		this.ticTac = tictac;
	}

	@Override
	public void run() {
		while(!this.isInterrupted()) {

			try {

				System.out.println("TIC");

				this.sleep(500);

				ticTac.avisar();
				ticTac.esperar();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
