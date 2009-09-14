package profit.domain;

public class Divisao {
	
	public Double execute(Double dividendo, Double divisor) throws Exception {
		if (divisor == 0) throw new Exception("Divis�o por zero.");
		return dividendo / divisor;
	}

}
