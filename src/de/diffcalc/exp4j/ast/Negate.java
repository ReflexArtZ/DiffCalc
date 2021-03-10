package de.diffcalc.exp4j.ast;

public class Negate extends UnaryOperation {

	public Negate(Operation op) {
		super(op);
	}

	public String toString(){
		return "-" + op.toString();
 	}

	@Override
	public Double getNumericResult(Double val) {
		return -op.getNumericResult(val);
	}

	// By Patrick & Nino
	@Override
	public Operation calcDerivative() {
		return new Negate(op.calcDerivative());		// derivative of a negation is a new negation
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Negate)) return false;
		Negate abs = (Negate) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 41 * op.hashCode();
	}
}
