package de.diffcalc.exp4j.ast;

public class Sin extends UnaryOperation {

	public Sin(Operation op) {
		super(op);
	}
	
	public String toString(){
		return "sin(" + op.toString() + ")";
 	}

	@Override
	public Double getNumericResult(Double val) {
		return Math.sin(op.getNumericResult(val));
	}

	// By Patrick & Nino
	@Override
	public Operation calcDerivative() {
		return new Product(new Cos(op), op.calcDerivative());	// sin(g(x))' = cos(g(x)) * g'(x)
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Sin)) return false;
		Sin abs = (Sin) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 47 * op.hashCode();
	}
}
