package be.benja.emcalculator.model.formula;

import java.util.Vector;

import be.benja.emcalculator.exception.InvalidPatternFormulaException;
import be.benja.util.Float;

public class FormulaRunning extends Formula {
	
	Float coefA;
	Float coefB;
	Float coefC;
	Float const1;
	public FormulaRunning(Vector coefficientList) {
		super(coefficientList);
		coefA=Float.parse((String)coefficientList.elementAt(0),10);
		coefB=Float.parse((String)coefficientList.elementAt(1),10);
		coefC=Float.parse((String)coefficientList.elementAt(2),10);
		const1 = Float.parse("0.5",10);
	}

	public Integer calculate(String valueString){
		Float value = Float.parse(valueString,10);
		Float tempCalc = coefB.Sub(value);
		tempCalc = Float.pow(tempCalc,coefC);
		tempCalc = tempCalc.Mul(coefA);
		tempCalc = tempCalc.Sub(const1);
		tempCalc = Float.ceil(tempCalc);
		return Integer.valueOf(tempCalc.toShortString());
	}

}
