package profit.domain;

/*
 * Compra e Venda
 */
public enum TipoOrdem {
	C, V;

	public TipoOrdem inverse() {
		if (this.toString().equals("C")) {
			return TipoOrdem.V;
		} else {
			return TipoOrdem.C;
		}
	}
	
	public String order () {
		if (this.toString().equals("C")) {
			return "desc";
		} else {
			return "asc";
		}
	}
}
