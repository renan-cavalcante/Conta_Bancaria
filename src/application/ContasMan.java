package application;

import java.io.IOException;
import java.util.Scanner;

import service.ContaServe;
import service.MovimentosServe;

public class ContasMan {
	private static ContaServe contaServe = new ContaServe();
	private static MovimentosServe movimentoServe = new MovimentosServe();
	private static Scanner ler = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
			
		int opcao;
		
		do {
			System.out.println("-----------------------------------/r/n"
					+ "				MENU/n"
					+ "-----------------------------------/r/n"
					+ "/n"
					+ "1 - cadastrar conta/n"
					+ "2 - Fazer saque/n"
					+ "3 - Fazer deposito/n"
					+ "4 - Consultar extrato"
					+ "9 - finalizar/n");
			
			opcao = ler.nextInt();
			
			switch (opcao) {
				case 1:
					contaServe.cadastraCliente();
					break;
				case 2:
					movimentoServe.cadastraMovimento(1);
					break;
				case 3:
					movimentoServe.cadastraMovimento(2);
					break;
				case 4:
					System.out.println("Digite o codigo da conta:");
					int codigo = ler.nextInt();
					contaServe.consultarHistoricoMovimentos(codigo);
				case 9:
					break;
				default:
					System.out.println("Opção invalida");
			}
		}while(opcao != 9);
		
	}

}
