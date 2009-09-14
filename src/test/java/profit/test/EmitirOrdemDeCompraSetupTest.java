package profit.test;

import profit.Registry;
import profit.application.EmitirOrdemFacade;
import profit.domain.Ordem;
import profit.domain.TipoOrdem;
import fitlibrary.SetUpFixture;

public class EmitirOrdemDeCompraSetupTest extends SetUpFixture {

	private EmitirOrdemFacade facade = Registry.getInstance(EmitirOrdemFacade.class);
		
	public void papelQuantidadeValor (String papel, Long quantidade, Double valor) {
		Ordem ordem = new Ordem(papel, quantidade, valor, TipoOrdem.C);
		facade.setOrdem(ordem);
		facade.emitir();
	}
	
	public EmitirOrdemDeCompraSetupTest profitDotTestDotEmitirOrdemDeCompraSetupTest() {
		return this;
	}
}
