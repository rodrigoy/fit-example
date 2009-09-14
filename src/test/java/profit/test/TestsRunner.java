package profit.test;

import java.io.IOException;

import fit.FileRunner;

public class TestsRunner {

	public static void main(String[] args) throws IOException {
		//run ("testOperacoes");
		//run ("emitindoOrdemDeCompra");
		//run ("calculosTaxas");
		run ("calculosValorTotal");
	}		
	
	private static void run (String test) throws IOException {
		new FileRunner().run(
				new String[] {
						"/home/rodrigoy/projetos/fit-example/src/main/fit/" + test + ".html",
						"/home/rodrigoy/projetos/fit-example/src/main/fit/" + test + "Results.html"});
	}

}
