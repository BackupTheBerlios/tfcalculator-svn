package be.benja.emcalculator.model.formula;

import java.util.Vector;


public abstract class Formula {
	Vector coefficentList;
	
	public Formula(Vector coefficientList)
	{
		this.coefficentList = coefficientList;
	}

	public Vector getCoefficentList() {
		return coefficentList;
	}

	public void setCoefficentList(Vector coefficentList) {
		this.coefficentList = coefficentList;
	}
	
	public abstract Integer calculate(String value);

}
