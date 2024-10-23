package org.example.tictac;

public class UsarTicTac {

	public static void main(String[] args) {

		Tictac tictac = new Tictac();

		Tic tic = new Tic(tictac);
		Tac tac = new Tac(tictac);

		tic.start();
		tac.start();

	}
}