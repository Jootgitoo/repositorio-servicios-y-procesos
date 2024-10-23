package org.example.tictac;


public class Tic extends Thread{

	Tictac tictac;

	public Tic (Tictac tictac){
		this.tictac = tictac;
	}

	@Override
	public void run(){

		while(true){

			System.out.println("TIC");


			tictac.avisar();
			tictac.esperar();

		}

	}
}

