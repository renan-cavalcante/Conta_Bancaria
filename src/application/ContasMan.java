package application;

import java.io.IOException;

import service.ContaServe;
import service.MovimentosServe;

public class ContasMan {
	private static ContaServe contaServe = new ContaServe();
	private static MovimentosServe movimentoServe = new MovimentosServe();
	
	public static void main(String[] args) throws IOException {
		
		movimentoServe.cadastraMovimento();
		contaServe.atualiarContas();

	}

}
