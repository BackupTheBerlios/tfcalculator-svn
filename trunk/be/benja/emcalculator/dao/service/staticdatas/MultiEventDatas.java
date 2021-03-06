package be.benja.emcalculator.dao.service.staticdatas;

import java.util.Vector;


import be.benja.emcalculator.model.DataConstants;
import be.benja.emcalculator.model.Event;
import be.benja.emcalculator.model.MultiEvent;
import be.benja.emcalculator.model.formula.Formula;
import be.benja.emcalculator.model.formula.FormulaJump;
import be.benja.emcalculator.model.formula.FormulaRunning;
import be.benja.util.Float;

public class MultiEventDatas {

	Vector multiEventList;
	Vector eventList;
	Vector formulaList;
	
	public MultiEventDatas()
	{
		multiEventList = new Vector();
		eventList = new Vector();
		formulaList = new Vector();
		
		init_Formulas();
		init_Events();
		init_MultiEvents();
	}
	
	private void init_MultiEvents()
	{
		Vector eventList_deca_sen_h = new Vector();
		eventList_deca_sen_h.addElement(getEvent(DataConstants.EVENT_100M,DataConstants.CATEGORY_SEN,DataConstants.GENDER_MALE));
		MultiEvent multiEvent_decathlon_sen_h = new MultiEvent(DataConstants.MULTIEVENT_DECATHLON,DataConstants.CATEGORY_SEN,DataConstants.GENDER_MALE,eventList_deca_sen_h);
		multiEventList.addElement(multiEvent_decathlon_sen_h);
	}
	
	private void init_Formulas()
	{
		Vector coeff_100m_h = new Vector();
		coeff_100m_h.addElement("25.4347");
		coeff_100m_h.addElement("18");
		coeff_100m_h.addElement("1.81");
		coeff_100m_h.addElement("0.5");
		Formula formula_100m_sen_h = new FormulaRunning(coeff_100m_h);
		
		formulaList.insertElementAt(formula_100m_sen_h,DataConstants.FORMULA_100M_H);
		
		Vector coeff_long_h = new Vector();
		coeff_long_h.addElement(new Float(Float.parse("0.14354",10)));
		coeff_long_h.addElement(new Float(Float.parse("220",10)));
		coeff_long_h.addElement(new Float(Float.parse("1.4",10)));
		coeff_long_h.addElement(new Float(Float.parse("0.5",10)));
		Formula formula_long_sen_h = new FormulaJump("",coeff_long_h);
		
		formulaList.insertElementAt(formula_long_sen_h,DataConstants.FORMULA_LONG_H);
		
	}
	
	private void init_Events()
	{
		Event epreuve_100m_sen_h = new Event(DataConstants.EVENT_100M,DataConstants.CATEGORY_SEN,DataConstants.GENDER_MALE,getFormula(DataConstants.FORMULA_100M_H));
		eventList.addElement(epreuve_100m_sen_h);
	}
	
	public Formula getFormula(int formulaNumber)
	{
		return (Formula)formulaList.elementAt(formulaNumber);
	}
	
	public Vector getMultiEventList() {
		return multiEventList;
	}

	public MultiEvent getMultiEvent(int indice) {
		return (MultiEvent)multiEventList.elementAt(indice);
	}
	
	public MultiEvent getMultiEvent(String id) {
		
		int i = 0;
		while(i<multiEventList.size())
		{
			MultiEvent multiEvent = (MultiEvent)multiEventList.elementAt(i);
			if(multiEvent.getName().equals(id))
			{
				return multiEvent;
			}
			i++;
		}
		return null;
	}
	
	public Event getEvent(String name,String category,String gender)
	{
		int i=0;
		while(i<eventList.size())
		{
			Event event = (Event)eventList.elementAt(i);
			if(event.getName().compareTo(name)==0 && event.getCategory().compareTo(category)==0 && event.getGender().compareTo(gender)==0)
			{
				return event;
			}
			i++;
		}
		return null;
	}

}
