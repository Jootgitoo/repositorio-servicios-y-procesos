package org.example.tictac;

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

	private boolean meToca = false;

	@Override
	public void run() {
		while(true) {
			System.out.println("TIC");
			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				this.wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			notifyAll();

		}
	}
}
