package de.diffcalc.exp4j.ast;

public class Exp extends UnaryOperation {
	
	public Exp(Operation op) {
		super(op);
	}

	public String toString(){
		return "e^(" + op.toString() + ")";
 	}

	@Override
	public Double getNumericResult(Double val) {
		return Math.exp(op.getNumericResult(val));
	}

	// By Patrick & Nino
	@Override
	public Operation calcDerivative() {
		return new Product(new Exp(op), op.calcDerivative());	// e^g(x) = e^g(x) * g'(x)
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Exp)) return false;
		Exp abs = (Exp) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 31 * op.hashCode();
	}
}
