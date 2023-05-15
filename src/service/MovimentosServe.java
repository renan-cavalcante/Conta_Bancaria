package service;

import java.util.Scanner;

import dados.BancoDados;
import entity.MovimentoConta;

public class MovimentosServe{
	private static Scanner ler = new Scanner(System.in);
	private static BancoDados io = new BancoDados();
	private static ContaServe contaServe = new ContaServe();

	public void cadastraMovimento(int tipoMovimento) {
		Integer codigoConta = null;
		Double valorMovimento;
		Integer status;

		Boolean contaCadastrada = true;

		while (contaCadastrada) {
			System.out.print("Digite o codigo da conta:");
			codigoConta = ler.nextInt();

			if (contaServe.buscarContaPorCodigo(codigoConta) == null) {
				System.out.println("A conta n�o existe");
			} else {
				contaCadastrada = false;
			}
		}
		
		System.out.printf("%nDigite o valor do movimento:");
		valorMovimento = ler.nextDouble();
		
		System.out.printf("%nDigite o status");
		status = ler.nextInt();
		
		MovimentoConta movimento = new MovimentoConta(codigoConta, valorMovimento, tipoMovimento, status);
		io.gravarDados("movimentosRegistrados.csv", movimento.toStringCSV());
		contaServe.movimentarConta(movimento);
	}
}
