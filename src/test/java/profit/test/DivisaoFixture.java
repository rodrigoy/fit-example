package profit.test;

import profit.domain.Divisao;
import fit.ColumnFixture;

public class DivisaoFixture extends ColumnFixture {
	
	public Double dividendo;
	public Double divisor;
	
	private Divisao facade = new Divisao();
	
	public Double resultado() throws Exception {
		return facade.execute(dividendo, divisor);
	}
	
}
