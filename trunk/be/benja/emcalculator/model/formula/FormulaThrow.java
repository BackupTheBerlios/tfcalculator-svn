package be.benja.emcalculator.model.formula;

import java.util.Vector;

import be.benja.emcalculator.exception.InvalidPatternFormulaException;

public class FormulaThrow extends Formula {

	public FormulaThrow(String correctInputPattern, Vector coefficientList) {
		super(correctInputPattern, coefficientList);
		// TODO Auto-generated constructor stub
	}

	public Integer calculate(String value)
			throws InvalidPatternFormulaException {
		// TODO Auto-generated method stub
		return null;
	}

}