package de.diffcalc.exp4j.ast;

public class Cos extends UnaryOperation {

	public Cos(Operation op) {
		super(op);
	}
	
	public String toString(){
		return "cos(" + op.toString() + ")";
 	}

	@Override
	public Double getNumericResult(Double val) {
		return Math.cos(op.getNumericResult(val));
	}

	// By Patrick & Nino
	@Override
	public Operation calcDerivative() {
		return new Negate(new Product(new Sin(op), op.calcDerivative()));	// cos(g(x)) = -sin(g(x)) * g'(x)
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Cos)) return false;
		Cos abs = (Cos) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 29 * op.hashCode();
	}

}
