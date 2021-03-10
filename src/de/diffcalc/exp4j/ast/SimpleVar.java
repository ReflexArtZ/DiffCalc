package de.diffcalc.exp4j.ast;

public class SimpleVar implements Operation {
	
	public String toString(){
		return "x";
 	}

	@Override
	public Double getNumericResult(Double val) {
		if (val == null) throw new NullPointerException("Variable set to null!");
		return val;
	}

	// By Patrick & Nino
	@Override
	public Operation calcDerivative() {
		return new Constant("1");		// derivative of x is 1
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		return (o instanceof SimpleVar);
	}
	
	public int hashCode(){
		return 43;
	}
}
