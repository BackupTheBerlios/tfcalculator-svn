package be.benja.emcalculator.model;

import java.util.Vector;


public class MultiEvent {
	private String name;
	private String category;
	private boolean gender;
	private Vector eventList;
	
	public MultiEvent()
	{
		
	}
	
	public MultiEvent(String name,String category,boolean gender,Vector eventList)
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
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
