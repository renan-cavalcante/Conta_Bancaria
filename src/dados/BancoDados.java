package dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Conta;
import entity.MovimentoConta;

public class BancoDados {
	public File caminhoDoArquivo(String extensao) {
		File nomeArquivo = new File(System.getProperty("user.dir") + "//src//dados//" + extensao);
		if (!nomeArquivo.exists()) {
			try {
				FileWriter criaArquivo = new FileWriter(nomeArquivo);
				criaArquivo.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		return nomeArquivo;
	}

	public void gravarDados(String extensao, List<MovimentoConta> dados) {
		File arquivo = caminhoDoArquivo(extensao);

		try (BufferedWriter io = new BufferedWriter(new FileWriter(arquivo, true))) {

			for(MovimentoConta dado : dados) {
				io.write(dado.toStringCSV());
				io.newLine();
			}
			

		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void gravarDados(String extensao, String dados) {
		File arquivo = caminhoDoArquivo(extensao);

		try (BufferedWriter io = new BufferedWriter(new FileWriter(arquivo, true))) {

			io.write(dados);
			io.newLine();

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void sobrescreverDados(String extensao) {
		File arquivo = caminhoDoArquivo(extensao);

		try (BufferedWriter io = new BufferedWriter(new FileWriter(arquivo))) {

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public List<Conta> lerDadosContas(String extensao) {
		File arquivo = caminhoDoArquivo(extensao);
		List<Conta> contas = new ArrayList<>();

		try (BufferedReader io = new BufferedReader(new FileReader(arquivo))) {
			String linha = io.readLine();
			while (linha != null && !linha.isEmpty()) {
				String[] conteudo = linha.split(",");
				Conta conta = new Conta(Integer.parseInt(conteudo[0]), conteudo[1], Double.parseDouble(conteudo[2]), Integer.parseInt(conteudo[3]),
						Double.parseDouble(conteudo[4]));
				contas.add(conta);
				linha = io.readLine();
			}

		} catch (IOException e) {
			System.out.println(e);
		}
		return contas;
	}

	public List<MovimentoConta> lerDadosMovimentos(String extensao) {
		File arquivo = caminhoDoArquivo(extensao);
		List<MovimentoConta> movimentos = new ArrayList<>();

		try (BufferedReader io = new BufferedReader(new FileReader(arquivo))) {
			String linha = io.readLine();
			while (linha != null) {
				String[] conteudo = linha.split(",");
				MovimentoConta movimento = new MovimentoConta(Integer.parseInt(conteudo[0]),
						Double.parseDouble(conteudo[1]), Integer.parseInt(conteudo[2]), Integer.parseInt(conteudo[3]));
				movimentos.add(movimento);
				linha = io.readLine();
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		return movimentos;
	}

	public void atualizarContas(List<Conta> contasAtualiazar){
		File arquivo = caminhoDoArquivo("conta.csv");

		try (BufferedWriter io = new BufferedWriter(new FileWriter(arquivo))) {
			for(Conta conta: contasAtualiazar) {
				io.write(conta.toStringCSV());
				io.newLine();
			}
			

		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
