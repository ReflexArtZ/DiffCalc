package de.diffcalc.exp4j.ast;

public class Product extends BinaryOperation {

	public Product(Operation left, Operation right) {
		super(left, right);
	}

	public Operation getLeft(){
		return left;
	}
	
	public Operation getRight(){
		return right;
	}

	public String toString(){
		return "(" + left.toString() + ")*(" + right.toString() + ")";
	}

	@Override
	public Double getNumericResult(Double val) {
		return left.getNumericResult(val) * right.getNumericResult(val);
	}

	// By Patrick & Nino
	@Override
	public Operation calcDerivative() {
		return new Addition(new Product(left.calcDerivative(), right), new Product(left, right.calcDerivative()));	// [ f(x) * g(x) ]' = f(x) * g'(x) + g(x) * f'(x)

	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Product)) return false;
		Product abs = (Product) o;
		return (left.equals(abs.left) && right.equals(abs.right));
	}
	
	public int hashCode(){
		return 73 * (left.hashCode() + right.hashCode());
	}
}
