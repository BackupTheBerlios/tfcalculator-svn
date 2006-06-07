package be.benja.emcalculator.model;

import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

import be.benja.emcalculator.exception.InvalidPatternFormulaException;


public class Competition {
	private String name;
	private Date date;
	private String place;
	private String athleteName;
	private String id;
	private MultiEvent multiEvent;
	private Hashtable resultTable;
	
	public Competition(MultiEvent multiEvent)
	{
		this.multiEvent = multiEvent;
		Vector eventList = multiEvent.getEventList();
		resultTable = new Hashtable();
		for(int i = 0; i<eventList.size();i++)
		{
			Result result = new Result();
			resultTable.put(eventList.elementAt(i),result);
		}
	}
	
	public void addResult(Event event,Integer performance) throws InvalidPatternFormulaException
	{
		Result result = (Result)resultTable.get(event);
		result.setScore(event.getFormula().calculate(performance));
	}
	
	public Result getResult(Event event)
	{
		return (Result)resultTable.get(event);
	}

	public String getAthleteName() {
		return athleteName;
	}

	public void setAthleteName(String athleteName) {
		this.athleteName = athleteName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MultiEvent getMultiEvent() {
		return multiEvent;
	}

	public void setMultiEvent(MultiEvent multiEvent) {
		this.multiEvent = multiEvent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Hashtable getResultTable() {
		return resultTable;
	}

	public void setResultTable(Hashtable resultTable) {
		this.resultTable = resultTable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	

}
