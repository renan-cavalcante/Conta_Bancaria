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
	private Double limiteConta;
	private Integer tipoConta;
	
	public Conta(Integer codigoConta, String nomeCliente, Double saldoConta, Double limiteConta, Integer tipoCota) {
		this.codigoConta = codigoConta;
		this.nomeCliente = nomeCliente;
		deposito(saldoConta);
		this.limiteConta = limiteConta;
		this.tipoConta = tipoCota;
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
		return limiteConta;
	}

	public Integer getTipoCota() {
		return tipoConta;
	}

	public void setTipoCota(Integer tipoCota) {
		this.tipoConta = tipoCota;
	}
	
	public String toStringCSV() {
		return codigoConta+","+nomeCliente+","+saldoConta+","+limiteConta+","+tipoConta;
	}
	
	public void deposito(Double valor) {
		this.saldoConta += valor;
	}
	
	public void saque(Double valor) {
		this.saldoConta -= valor;
	}
	
	
	
}
