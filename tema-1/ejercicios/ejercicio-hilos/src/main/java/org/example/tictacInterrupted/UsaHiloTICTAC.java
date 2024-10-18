package org.example.tictacInterrupted;

import org.example.tictac.HiloTAC;
import org.example.tictac.HiloTIC;

/**
 * Main hace uso de los hilos TIC TAC
 * �Se visualizan los texto TIC TAC de forma ordenada?
 * @author santa
 *
 */
public class UsaHiloTICTAC {
	
	public static void main (String[] args) {
		//Creo los hilos
		org.example.tictac.HiloTIC hTIC = new HiloTIC();
		org.example.tictac.HiloTAC hTAC = new HiloTAC();
		
		//los arranco
		hTIC.start();
		hTAC.start();

		try {
			Thread.currentThread().sleep(2000);

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		hTIC.interrupt();
		hTAC.interrupt();
		
	}

}
