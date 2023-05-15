/*
 * ..............................................................................................................
.          MovimentoContas                                                                             .
.............................................................................................................
. codContaM | ValorMovimentoM | TipoMovimentoM |statusM     .
.............................................................................................................
   int                           double                              int                         int

 */

package entity;

public class MovimentoConta {
	
	private Integer codigoConta;
	private Double valorMovimento;
	private Integer tipoMovimento;// mudar para enum
	private Integer status;	//mudar para enum
	
	public MovimentoConta(Integer codigoConta, Double valorMovimento, Integer tipoMovimento, Integer status) {
		this.codigoConta = codigoConta;
		this.valorMovimento = valorMovimento;
		this.tipoMovimento = tipoMovimento;
		this.status = status;
	}

	public Integer getCodigoConta() {
		return codigoConta;
	}

	public Double getValorMovimento() {
		return valorMovimento;
	}

	public Integer getTipoMovimento() {
		return tipoMovimento;
	}

	public Integer getStatus() {
		return status;
	}
	
	public String toStringCSV() {
		return codigoConta+","+valorMovimento+","+tipoMovimento+","+status;
	}
	
}
