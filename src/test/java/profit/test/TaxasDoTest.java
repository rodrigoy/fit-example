package profit.test;

import profit.Registry;
import profit.domain.Ordem;
import profit.domain.TipoOrdem;
import fitlibrary.DoFixture;

public class TaxasDoTest extends DoFixture {
	
	public void taxaDaBovespa(Double valor) {
		Registry.setTaxaBovespa(valor);
	}
	
	public void taxaDaCLBC (Double valor) {
		Registry.setTaxaCLBC(valor);
	}
	
	public boolean quandoOValorDaOrdemForAsTaxasTotalizam (Double valorOrdem,
			Double taxas) {
		
		Ordem ordem = new Ordem("BBDC4", 10L, valorOrdem / 10, TipoOrdem.C);
		return ordem.getTaxas().equals(taxas);
	}
	
	public TaxasDoTest profitDotTestDotTaxasDoTest() {
		return this;
	}
	
}
