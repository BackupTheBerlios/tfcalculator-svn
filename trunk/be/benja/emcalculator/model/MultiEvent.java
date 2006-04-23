package be.benja.emcalculator.model;

import java.util.Vector;


public class MultiEvent {
	private String name;
	private String category;
	private String gender;
	private Vector eventList;
	
	public MultiEvent()
	{
		
	}
	
	public MultiEvent(String name,String category,String gender,Vector eventList)
	{
		this.name=name;
		this.category = category;
		this.gender = gender;
		this.eventList = eventList;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Vector getEventList() {
		return eventList;
	}
	public void setEventList(Vector eventList) {
		this.eventList = eventList;
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
