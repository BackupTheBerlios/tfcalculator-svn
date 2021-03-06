package be.benja.emcalculator.model;

import be.benja.emcalculator.model.formula.Formula;

public class Event {
	private String name;
	private String category;
	private String gender;
	private Formula formula;
	public Event()
	{
		
	}
	
	public Event(String name,String category,String gender,Formula formula)
	{
		this.name=name;
		this.category=category;
		this.gender=gender;
		this.formula=formula;
	}
	
	public Formula getFormula() {
		return formula;
	}
	public void setFormula(Formula formula) {
		this.formula = formula;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
