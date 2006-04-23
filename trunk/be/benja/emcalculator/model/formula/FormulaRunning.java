package be.benja.emcalculator.model.formula;

import java.util.Vector;

import be.benja.emcalculator.exception.InvalidPatternFormulaException;

public class FormulaRunning extends Formula {

	public FormulaRunning(String correctInputPattern, Vector coefficientList) {
		super(correctInputPattern, coefficientList);
	}

	public Integer calculate(String value)
			throws InvalidPatternFormulaException {
		// TODO Auto-generated method stub
		return null;
	}

}
