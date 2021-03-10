package de.diffcalc.exp4j.ast;

public class Constant implements Operation {
	private String c;
	
	public Constant(String c) {
		this.c = c;
	}

	public String toString(){
		return c;
 	}

	@Override
	public Double getNumericResult(Double val) {
		return Double.parseDouble(c);
	}

	// By Patrick & Nino
	@Override
	public Operation calcDerivative() {
		return new Constant("0");		// derivative of a constant is 0
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Constant)) return false;
		Constant abs = (Constant) o;
		return (c.equals(abs.c));
	}
	
	public int hashCode(){
		return 23 * (int) Double.parseDouble(c);
	}
}
