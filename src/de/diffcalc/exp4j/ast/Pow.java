package de.diffcalc.exp4j.ast;

public class Pow extends BinaryOperation {
	public Pow(Operation left, Operation right) {
		super(left,right);
	}

	public String toString(){
		return "(" + left.toString() + ")^(" + right.toString() + ")";
 	}

	@Override
	public Double getNumericResult(Double val) {
		return Math.pow(left.getNumericResult(val), right.getNumericResult(val));
	}

	// By Patrick & Nino
	@Override
	public Operation calcDerivative() {
		// f(x)^g(x) = f(x)^g(x) * [ g'(x) * ln(x) + (g(x) * f'(x)) / f(x) ]
		Operation a = new Pow(left, right);
		Operation b = new Addition(new Product(right.calcDerivative(), new Log(left)), new Division(new Product(right, left.calcDerivative()), left));
		return new Product(a, b);
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Pow)) return false;
		Pow abs = (Pow) o;
		return (left.equals(abs.left) && right.equals(abs.right));
	}
	
	public int hashCode(){
		return 71 * (left.hashCode() + right.hashCode());
	}
}
