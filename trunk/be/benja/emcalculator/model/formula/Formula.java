package be.benja.emcalculator.model.formula;

import java.util.Vector;

import be.benja.emcalculator.exception.InvalidPatternFormulaException;
import be.benja.util.Float;

public abstract class Formula {
	Vector coefficentList;
	String correctInputPattern;

	public String getCorrectInputPattern() {
		return correctInputPattern;
	}

	public void setCorrectInputPattern(String correctInputPattern) {
		this.correctInputPattern = correctInputPattern;
	}

	public Vector getCoefficentList() {
		return coefficentList;
	}

	public void setCoefficentList(Vector coefficentList) {
		this.coefficentList = coefficentList;
	}
	
	public abstract Integer calculate(String value) throws InvalidPatternFormulaException;

}
