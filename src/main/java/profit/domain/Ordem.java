package profit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import profit.Registry;

import com.sun.istack.internal.NotNull;

@Entity
public class Ordem implements Comparable<Ordem> {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column (length=5, nullable = false)
	String papel;
	
	@Column (precision=0, nullable = false)
	Long quantidade;
	
	@NotNull
	Double valor;
	
	@Enumerated(EnumType.STRING)
	TipoOrdem tipo = TipoOrdem.C;
	
	StatusOrdem status = StatusOrdem.EmAberto;
	
	public Ordem() {}
	
	public Ordem(String papel, Long quantidade, Double valor, TipoOrdem tipo) {
		this.papel = papel;
		this.quantidade = quantidade;
		this.valor = valor;
		this.tipo = tipo;
	}

	public String getPapel() {
		return papel;
	}
	
	public Long getQuantidade() {
		return quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public Double getValorTotal() {
		return quantidade * valor;
	}

	public StatusOrdem getStatus() {
		return status;
	}

	public int compareTo(Ordem comp) {
		return this.valor.compareTo(comp.valor) * -1;
	}

	/**
	 * Amigos... eu não me orgulho deste método...
	 * @return
	 */
	public Double getTaxas() {
		Double bovespa = Registry.getTaxaBovespa();
		Double clbc = Registry.getTaxaCLBC();
		Double taxaTotal = bovespa + clbc;
		return getValorTotal() * taxaTotal;
	}

	public void executar() {
		status = StatusOrdem.Executada;		
	}

	public void processar() {
		status = StatusOrdem.Processada;
	}

}
