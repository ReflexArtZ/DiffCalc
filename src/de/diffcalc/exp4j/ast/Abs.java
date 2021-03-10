package de.diffcalc.exp4j.ast;

public class Abs extends UnaryOperation {
	
	public Abs(Operation op) {
		super(op);
	}
	
	public String toString(){
		return "|" + op.toString() + "|";
 	}

	@Override
	public Double getNumericResult(Double val) {
		return Math.abs(op.getNumericResult(val));
	}

	// By Patrick & Nino
	@Override
	public Operation calcDerivative() {
		return new Division(new Product(new Abs(op), op.calcDerivative()), op);		// |g(x)| = ( |g(x)| * g'(x) ) / g(x)
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Abs)) return false;
		Abs abs = (Abs) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 7 * op.hashCode();
	}
}
