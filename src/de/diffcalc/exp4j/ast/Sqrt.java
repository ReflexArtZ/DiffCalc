package de.diffcalc.exp4j.ast;

public class Sqrt extends UnaryOperation {
	
	public Sqrt(Operation op) {
		super(op);
	}

	public String toString(){
		return "sqrt(" + op.toString() + ")";
 	}

	@Override
	public Double getNumericResult(Double val) {
		return Math.sqrt(op.getNumericResult(val));
	}

	// By Patrick & Nino
	@Override
	public Operation calcDerivative() {
		return new Division(op.calcDerivative(), new Product(new Constant("2"), new Sqrt(op)));		// sqrt(g(x))' = g*(x) / ( 2*sqrt(g(x)) )
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Sqrt)) return false;
		Sqrt abs = (Sqrt) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 53 * op.hashCode();
	}
}
