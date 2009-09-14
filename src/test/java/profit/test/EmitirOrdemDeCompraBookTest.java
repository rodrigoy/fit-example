package profit.test;

import java.util.List;

import profit.Registry;
import profit.application.EmitirOrdemFacade;
import profit.domain.Ordem;
import fitlibrary.ArrayFixture;

public class EmitirOrdemDeCompraBookTest extends ArrayFixture {

	private EmitirOrdemFacade facade = Registry.getInstance(EmitirOrdemFacade.class);
	
	public EmitirOrdemDeCompraBookTest() throws Exception {
		super();
		String papel = "BBDC4";
		List<Ordem> set = facade.getBook(papel);
		setActualCollection(set);
	}
	
}
