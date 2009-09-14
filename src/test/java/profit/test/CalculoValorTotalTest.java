package profit.test;

import profit.domain.Ordem;
import profit.domain.TipoOrdem;
import fitlibrary.CalculateFixture;

public class CalculoValorTotalTest extends CalculateFixture {

	public Double valorTotalPapelTipoQuantidadeValor (String papel, 
			String tipo, 
			Long quantidade, 
			Double valor) {
		
		Ordem ordem = new Ordem(papel, quantidade, valor, TipoOrdem.valueOf(tipo));
		return ordem.getValorTotal();
		
	}
}
