/*
 * Em um Banco haver� arquivos de Contas, Movimento e Atualizado
- Criar um sistema que cadastre contas de 5 clientes;
- Gravar tamb�m o cadastro de movimento com 10 registros com c�digo conta,valor do movimento tipo de movimento e statusM;
- Ap�s gera��o dos cadastros(contas e movimento), processar e gerar Contas Atualizadas, 
  assim como suas consultas.
............................................................................................................................
.          ContasCorrentes                                                                                                .
...........................................................................................................................
. codContaC | nomeClientesC | saldoContaC | LimitecontaC |tipoContaC      .
..........................................................................................................................

 */

package entity;

public class Conta {

	private Integer codigoConta;
	private String nomeCliente;
	private Double saldoConta = 0.0;
	private Double limiteSaldo;
	private Double limiteDefinido;
	private Integer tipoConta;

	public Conta(Integer codigoConta, String nomeCliente, Double saldoConta, Integer tipoConta, Double limiteDefinido) {
		this.codigoConta = codigoConta;
		this.nomeCliente = nomeCliente;
		deposito(saldoConta);
		this.limiteDefinido = limiteDefinido;
		this.limiteSaldo = limiteDaConta(tipoConta, limiteDefinido, saldoConta);
		this.tipoConta = tipoConta;
	}

	public Integer getCodigoConta() {
		return codigoConta;
	}

	public void setCodigoConta(Integer codigoConta) {
		this.codigoConta = codigoConta;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Double getSaldoConta() {
		return saldoConta;
	}

	public Double getLimiteConta() {
		return limiteSaldo;
	}

	public Integer getTipoCota() {
		return tipoConta;
	}

	public void setTipoCota(Integer tipoCota) {
		this.tipoConta = tipoCota;
	}

	public Double getLimiteDefinido() {
		return limiteDefinido;
	}

	public void setLimiteDefinido(Double limiteDefinido) {
		this.limiteDefinido = limiteDefinido;
	}

	public String toStringCSV() {
		return codigoConta + "," + nomeCliente + "," + saldoConta + "," + limiteSaldo + "," + tipoConta;
	}

	public void deposito(Double valor) {
		this.saldoConta += valor;
	}

	public void saque(Double valor) {
		this.saldoConta -= valor;
	}

	public Double limiteDaConta(int tipo, Double limite, Double saldo) {
		switch (tipo) {
		case 1:
			return 0.0;
			
		case 2:
			return limite;

		case 3:
			return limite + (saldo * 0.5);

		case 4:
			return limite + saldo;

		default:
			throw new IllegalArgumentException("Unexpected value em metodo limiteDaConta: " + tipo);
		}
		
		
	}
	
	public void usarLimite(Double valor) {
		this.limiteSaldo -= valor;
	}
	

}
