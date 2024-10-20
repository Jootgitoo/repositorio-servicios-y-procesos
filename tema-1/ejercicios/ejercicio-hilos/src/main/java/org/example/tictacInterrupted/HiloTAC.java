package org.example.tictacInterrupted;

/**
 * Crear un hilo que visualice por pantalla 
 * en un bucle infinito la palabra TAC
 * Dentro del bucle, utiliza el m�todo sleep() 
 * para que nos de tiempo a ver las palabras 
 * que se visualizan cuando lo ejecutemos
 * 
 * @author santa
 *
 */
public class HiloTAC extends Thread {

	TicTac ticTac;

	public HiloTAC(TicTac ticTac){
		this.ticTac = ticTac;
	}
	
	@Override
	public void run() {
		while(!this.isInterrupted()) {

			try {
				System.out.println("TAC");

				this.sleep(500);

				ticTac.avisar();
				ticTac.esperar();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
