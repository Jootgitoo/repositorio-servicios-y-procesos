package org.example.alternando;
/**
 * Main hace uso de los hilos TIC TAC
 * �Se visualizan los texto TIC TAC de forma ordenada?
 * @author santa
 *
 */
public class UsaHiloTICTAC {
	
	public static void main (String[] args) {
		
		TicTac tictac = new TicTac();
		//Creo los hilos
		HiloTIC hTIC = new HiloTIC(tictac);
		HiloTAC hTAC = new HiloTAC(tictac);
		
		//los arranco
		hTIC.start();
		hTAC.start();
		
	}

}
