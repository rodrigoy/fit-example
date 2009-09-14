package profit.test;

import java.util.List;

import profit.Registry;
import profit.application.EmitirOrdemFacade;
import profit.domain.Ordem;
import fitlibrary.ArrayFixture;

public class EmitirOrdemDeCompraArrayBBDC4Test extends ArrayFixture {

	private EmitirOrdemFacade facade = Registry.getInstance(EmitirOrdemFacade.class);
	
	public EmitirOrdemDeCompraArrayBBDC4Test() throws Exception {
		super();
		String papel = "BBDC4";
		List<Ordem> set = facade.getBook(papel);
		setActualCollection(set);
	}
	
	public EmitirOrdemDeCompraArrayBBDC4Test profitDotTestDotEmitirOrdemDeCompraArrayBBDC4Test() {
		return this;
	}
	
}
