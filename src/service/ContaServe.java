package service;

import java.util.List;
import java.util.Scanner;

import dados.BancoDados;
import entity.Conta;
import entity.MovimentoConta;

public class ContaServe {
	private static Scanner ler = new Scanner(System.in);
	private static BancoDados io = new BancoDados();

	public void cadastraCliente() {
		Integer codigoConta = null;
		String nomeCliente;
		Double saldoConta;
		Double limiteConta;
		Integer tipoConta;

		Boolean contaCadastrada = true;

		while (contaCadastrada) {
			System.out.print("Digite o codigo do cliente:");
			codigoConta = ler.nextInt();
			ler.nextLine();

			if (buscarContaPorCodigo(codigoConta) != null) {
				System.out.println("conta ja cadastrada");
			} else {
				contaCadastrada = false;
			}
		}

		System.out.printf("%nDigite o nome do cliente:");
		nomeCliente = ler.nextLine();

		System.out.printf("%nDigite o valor do deposito inicial:");
		saldoConta = ler.nextDouble();

		System.out.printf("%nDigite o limite da conta:");
		limiteConta = ler.nextDouble();

		System.out.printf("%nDigite o tipo da conta:");
		tipoConta = ler.nextInt();

		Conta conta = new Conta(codigoConta, nomeCliente, saldoConta, tipoConta, limiteConta);
		io.gravarDados("conta.csv", conta.toStringCSV());

	}

	public Conta buscarContaPorCodigo(Integer codigo) {

		List<Conta> contas = io.lerDadosContas("conta.csv");
		for (Conta conta : contas) {
			if (conta.getCodigoConta() == codigo) {
				return conta;
			}
		}
		return null;
	}

	public void ordenarContas() {
		List<Conta> contas = io.lerDadosContas("conta.csv");

		contas.sort((conta1, conta2) -> Integer.compare(conta1.getCodigoConta(), conta2.getCodigoConta()));

		io.sobrescreverDados("conta.csv");
		for (Conta conta : contas) {
			io.gravarDados("conta.csv", conta.toStringCSV());
		}
	}
	
	public void ordenarMovimentos() {
		List<MovimentoConta> movimentos = io.lerDadosMovimentos("movimentos.csv");

		movimentos.sort((movimento1, movimento2) -> Integer.compare(movimento1.getCodigoConta(), movimento2.getCodigoConta()));

		io.sobrescreverDados("movimentos.csv");
		for (MovimentoConta movimento : movimentos) {
			io.gravarDados("movimentos.csv", movimento.toStringCSV());
		}
	}

	public void movimentarConta(MovimentoConta movimento) {
		List<Conta> contas = io.lerDadosContas("conta.csv");

		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getCodigoConta() == movimento.getCodigoConta()) {
				if (movimento.getTipoMovimento() == 1) {
					contas.get(i).deposito(movimento.getValorMovimento());
					io.atualizarContas(contas);
					break;
				}
				if (movimento.getTipoMovimento() == 2) {
					if (regrasSaque(contas.get(i), movimento.getValorMovimento()) != null) {
						contas.set(i, regrasSaque(contas.get(i), movimento.getValorMovimento()));
						io.atualizarContas(contas);
					} else {
						System.out.println("Voce não tem saldo nem limite para esse saque");
					}
					break;
				}
			}
		}
	}

	public Conta regrasSaque(Conta conta, double valor) {
		if (valor > conta.getSaldoConta()) {
			if (valor > conta.getSaldoConta() + conta.getLimiteConta()) {
				return null;
			} else {
				double saldo = conta.getSaldoConta();
				conta.saque(saldo);
				conta.usarLimite(valor - saldo);
				return conta;
			}
		} else {
			conta.saque(valor);
			return conta;
		}
	}
	
	public void consultarHistoricoMovimentos(int codigoConta) {
		ordenarMovimentos();
		List<MovimentoConta> movimentos =  io.lerDadosMovimentos("movimentos.csv");
		boolean fim = false;
		
		for(MovimentoConta movimento: movimentos){
			if(movimento.getCodigoConta() == codigoConta) {
				System.out.println(movimento);
				fim = true;
			}else if(fim) {
				break;
			}
		}
		
	}

}
