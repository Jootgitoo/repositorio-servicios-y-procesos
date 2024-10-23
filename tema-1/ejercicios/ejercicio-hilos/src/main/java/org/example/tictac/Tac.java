package org.example.tictac;

public class Tac extends Thread{

	Tictac tictac;

	public Tac (Tictac tictac){
		this.tictac = tictac;
	}

	@Override
	public void run(){
		while(true){

			System.out.println("TAC");


			tictac.avisar();
			tictac.esperar();
		}
	}


}