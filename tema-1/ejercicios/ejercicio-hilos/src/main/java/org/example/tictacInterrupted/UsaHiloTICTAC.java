package org.example.tictacInterrupted;



/**
 * Main hace uso de los hilos TIC TAC
 * �Se visualizan los texto TIC TAC de forma ordenada?
 * @author santa
 *
 */
public class UsaHiloTICTAC {
	
	public static void main (String[] args) {

		TicTac avanzarParar = new TicTac();
		//Creo los hilos
		org.example.tictacInterrupted.HiloTAC hiloTaC = new HiloTAC(avanzarParar);
		org.example.tictacInterrupted.HiloTIC hiloTic = new HiloTIC(avanzarParar);
		
		//los arranco
		hiloTic.start();
		hiloTaC.start();




		
	}

}
