package de.diffcalc.exp4j.ast;

public interface Operation {
	Double getNumericResult(Double val);
	Operation calcDerivative();		// By Patrick & Nino
}
