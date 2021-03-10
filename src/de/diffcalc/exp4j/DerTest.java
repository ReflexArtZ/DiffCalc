package de.diffcalc.exp4j;

import de.diffcalc.exp4j.ast.Operation;
import de.diffcalc.exp4j.tokenizer.AbstractTreeBuilder;
import de.diffcalc.exp4j.tokenizer.TokenizerException;

public class DerTest {
    public static void main(String[] args) throws TokenizerException {
        AbstractTreeBuilder tree = new AbstractTreeBuilder("(0)*((x)^(2.0))+(0.0)*(((x)^(2.0))*((0)*(log(x))+((2.0)*(1))/(x)))+(0)*(((x)^(2.0))*((0.0)*(log(x))+((2.0)*(1.0))/(x)))+(0.0)*((((x)^(2.0))*((0)*(log(x))+((2.0)*(1))/(x)))*((0.0)*(log(x))+((2.0)*(1.0))/(x))+((x)^(2.0))*((0)*(log(x))+(0.0)*((1)/(x))+(((0)*(1.0)+(2.0)*(0))*(x)-((2.0)*(1.0))*(1))/((x)^(2))))+(0)*(((x)^(2.0))*((0.0)*(log(x))+((2.0)*(1.0))/(x)))+(0.0)*((((x)^(2.0))*((0)*(log(x))+((2.0)*(1))/(x)))*((0.0)*(log(x))+((2.0)*(1.0))/(x))+((x)^(2.0))*((0)*(log(x))+(0.0)*((1)/(x))+(((0)*(1.0)+(2.0)*(0))*(x)-((2.0)*(1.0))*(1))/((x)^(2))))+(0)*((((x)^(2.0))*((0.0)*(log(x))+((2.0)*(1.0))/(x)))*((0.0)*(log(x))+((2.0)*(1.0))/(x))+((x)^(2.0))*((0.0)*(log(x))+(0.0)*((1.0)/(x))+(((0.0)*(1.0)+(2.0)*(0.0))*(x)-((2.0)*(1.0))*(1.0))/((x)^(2.0))))+(2.0)*(((((x)^(2.0))*((0)*(log(x))+((2.0)*(1))/(x)))*((0.0)*(log(x))+((2.0)*(1.0))/(x))+((x)^(2.0))*((0)*(log(x))+(0.0)*((1)/(x))+(((0)*(1.0)+(2.0)*(0))*(x)-((2.0)*(1.0))*(1))/((x)^(2))))*((0.0)*(log(x))+((2.0)*(1.0))/(x))+(((x)^(2.0))*((0.0)*(log(x))+((2.0)*(1.0))/(x)))*((0)*(log(x))+(0.0)*((1)/(x))+(((0)*(1.0)+(2.0)*(0))*(x)-((2.0)*(1.0))*(1))/((x)^(2)))+(((x)^(2.0))*((0)*(log(x))+((2.0)*(1))/(x)))*((0.0)*(log(x))+(0.0)*((1.0)/(x))+(((0.0)*(1.0)+(2.0)*(0.0))*(x)-((2.0)*(1.0))*(1.0))/((x)^(2.0)))+((x)^(2.0))*((0)*(log(x))+(0.0)*((1)/(x))+(0)*((1.0)/(x))+(0.0)*(((0)*(x)-(1.0)*(1))/((x)^(2)))+((((0)*(1.0)+(0.0)*(0)+(0)*(0.0)+(2.0)*(0))*(x)+((0.0)*(1.0)+(2.0)*(0.0))*(1)-((0)*(1.0)+(2.0)*(0))*(1.0)+((2.0)*(1.0))*(0))*((x)^(2.0))-(((0.0)*(1.0)+(2.0)*(0.0))*(x)-((2.0)*(1.0))*(1.0))*(((x)^(2.0))*((0)*(log(x))+((2.0)*(1))/(x))))/(((x)^(2.0))^(2))))+((((0)*(x)+(0.0)*(1)+(0)*(1.0)+(0.0)*(0)+(0)*(1.0)+(0.0)*(0)+(0)*(0.0)+(3.0)*(0))*((2.0)*(sqrt((3.0)*(x))))+((0.0)*(x)+(0.0)*(1.0)+(0.0)*(1.0)+(3.0)*(0.0))*((0)*(sqrt((3.0)*(x)))+(2.0)*(((0)*(x)+(3.0)*(1))/((2)*(sqrt((3.0)*(x))))))-((0)*(x)+(0.0)*(1)+(0)*(1.0)+(3.0)*(0))*((0.0)*(sqrt((3.0)*(x)))+(2.0)*(((0.0)*(x)+(3.0)*(1.0))/((2.0)*(sqrt((3.0)*(x))))))+((0.0)*(x)+(3.0)*(1.0))*((0)*(sqrt((3.0)*(x)))+(0.0)*(((0)*(x)+(3.0)*(1))/((2)*(sqrt((3.0)*(x)))))+(0)*(((0.0)*(x)+(3.0)*(1.0))/((2.0)*(sqrt((3.0)*(x)))))+(2.0)*((((0)*(x)+(0.0)*(1)+(0)*(1.0)+(3.0)*(0))*((2.0)*(sqrt((3.0)*(x))))-((0.0)*(x)+(3.0)*(1.0))*((0)*(sqrt((3.0)*(x)))+(2.0)*(((0)*(x)+(3.0)*(1))/((2)*(sqrt((3.0)*(x)))))))/(((2.0)*(sqrt((3.0)*(x))))^(2)))))*(((2.0)*(sqrt((3.0)*(x))))^(2.0))-(((0.0)*(x)+(0.0)*(1.0)+(0.0)*(1.0)+(3.0)*(0.0))*((2.0)*(sqrt((3.0)*(x))))-((0.0)*(x)+(3.0)*(1.0))*((0.0)*(sqrt((3.0)*(x)))+(2.0)*(((0.0)*(x)+(3.0)*(1.0))/((2.0)*(sqrt((3.0)*(x)))))))*((((2.0)*(sqrt((3.0)*(x))))^(2.0))*((0)*(log((2.0)*(sqrt((3.0)*(x)))))+((2.0)*((0)*(sqrt((3.0)*(x)))+(2.0)*(((0)*(x)+(3.0)*(1))/((2)*(sqrt((3.0)*(x)))))))/((2.0)*(sqrt((3.0)*(x)))))))/((((2.0)*(sqrt((3.0)*(x))))^(2.0))^(2))+0");
        Operation der = tree.getTree();

        System.out.println(der.getNumericResult(8d));
    }
}