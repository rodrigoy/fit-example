package profit.test;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import profit.Registry;
import profit.application.EmitirOrdemFacade;
import profit.domain.Ordem;
import profit.domain.TipoOrdem;

public class EmitirOrdemDeCompraBookUnitTest {

	EmitirOrdemFacade facade;
	
	@Before
	public void setUpBefore() throws Exception {
		facade = Registry.getInstance(EmitirOrdemFacade.class);
	}
	
	@Test
	public void testEmitirOrdem30() {
		Ordem ordem = new Ordem("BBDC4", 11L, 30D, TipoOrdem.C);
		facade.setOrdem(ordem);
		facade.emitir();
	}

	@Test
	public void testEmitirOrdem40() {
		Ordem ordem = new Ordem("BBDC4", 100L, 40D, TipoOrdem.C);
		facade.setOrdem(ordem);
		facade.emitir();
	}

	@Test
	public void testEmitirOrdem41() {
		Ordem ordem = new Ordem("BBDC4", 1L, 41D, TipoOrdem.C);
		facade.setOrdem(ordem);
		facade.emitir();
	}
	
	@Test
	public void testEmitirOrdem43() {
		Ordem ordem = new Ordem("BBDC4", 1L, 39D, TipoOrdem.C);
		facade.setOrdem(ordem);
		facade.emitir();
	}	
	@Test
	public void verificarBook () {
		
		List<Ordem> book = facade.getBook("BBDC4", TipoOrdem.C);
		
		// A ordem do Book deve ser esta, independente da quantidade
		Assert.assertEquals(new Double(41), book.get(0).getValor());
		Assert.assertEquals(new Double(40), book.get(1).getValor());
		Assert.assertEquals(new Double(39), book.get(2).getValor());
		
	}
}
