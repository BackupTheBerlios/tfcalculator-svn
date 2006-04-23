package be.benja.emcalculator.service.impl;

import java.util.Vector;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;

import be.benja.emcalculator.model.Event;
import be.benja.emcalculator.model.MultiEvent;
import be.benja.emcalculator.model.formula.Formula;
import be.benja.emcalculator.model.formula.FormulaRunning;
import be.benja.emcalculator.service.ServiceLocator;
import be.benja.util.Float;

public class ServiceLocatorStaticDatasImpl implements ServiceLocator {

	Vector multiEventList = new Vector();
	public ServiceLocatorStaticDatasImpl()
	{
		Vector coeff_100m_sen_h = new Vector();
		coeff_100m_sen_h.addElement(new Float(Float.parse("18",10)));
		coeff_100m_sen_h.addElement(new Float(Float.parse("1.81",10)));
		coeff_100m_sen_h.addElement(new Float(Float.parse("25.4347",10)));
		coeff_100m_sen_h.addElement(new Float(Float.parse("0.5",10)));
		Formula formula_100m_sen_h = new FormulaRunning("",coeff_100m_sen_h);
		Event epreuve_100m_sen_h = new Event("100m","sen",true,formula_100m_sen_h);
		
		Vector eventList_deca_sen_h = new Vector();
		eventList_deca_sen_h.addElement(epreuve_100m_sen_h);
		MultiEvent multiEvent_decathlon_sen_h = new MultiEvent("deca_sen_h","sen",true,eventList_deca_sen_h);
		multiEventList.addElement(multiEvent_decathlon_sen_h);
	}
	public ChoiceGroup getCompetitionList() {
		return null;
	}
	
	public ChoiceGroup getMultiEventList() {
		return getChoiceGroup(multiEventList);
	
	}
	
	private ChoiceGroup getChoiceGroup(Vector vector)
	{
		
		if(vector!=null&&vector.elementAt(0)!=null)
		{
			if(vector.elementAt(0) instanceof MultiEvent)
			{
				ChoiceGroup choiceGroup = new ChoiceGroup("titre",Choice.EXCLUSIVE);
				//TODO
				for(int i =0; i<vector.size();i++)
				{
					MultiEvent multiEvent = (MultiEvent) vector.elementAt(i);
					choiceGroup.append(multiEvent.getName(),null);
				}
				return choiceGroup;
			}
		}
		return new ChoiceGroup("titre",ChoiceGroup.IMPLICIT);
		//TODO
	}

}
