package de.diffcalc.exp4j.tokenizer;

public class TokenizerException extends Exception {

	/**
	 * Will be thrown if the tree could not be built due to a misspelling of the function for example
	 */
	public TokenizerException() {
	}

	public TokenizerException(String message) {
		super(message);
	}
}
