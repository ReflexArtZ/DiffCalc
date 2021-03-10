package de.diffcalc.exp4j.ast;

public class Log extends UnaryOperation {
	
	public Log(Operation op) {
		super(op);
	}

	public String toString(){
		return "log(" + op.toString() + ")";
 	}

	@Override
	public Double getNumericResult(Double val) {
		return Math.log(op.getNumericResult(val));
	}

	// By Patrick & Nino
	@Override
	public Operation calcDerivative() {
		return new Division(op.calcDerivative(), op);		// ln(g(x))' = g'(x) / g(x)
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Log)) return false;
		Log abs = (Log) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 37 * op.hashCode();
	}
}
