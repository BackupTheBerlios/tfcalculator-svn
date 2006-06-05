package be.benja.emcalculator.service.impl;

import java.util.Vector;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;

import be.benja.emcalculator.controller.i18n.I18NKeys;
import be.benja.emcalculator.controller.i18n.I18NTranslator;

import be.benja.emcalculator.model.Competition;
import be.benja.emcalculator.model.MultiEvent;
import be.benja.emcalculator.service.ControllerService;

public class ControllerServiceImpl implements ControllerService {


	Competition currentCompetition;
	I18NTranslator emi18N;
	public ControllerServiceImpl(I18NTranslator emi18N)
	{
		this.emi18N = emi18N;

	}
	public ChoiceGroup getCompetitionListChoiceGroup(Vector competitionsList) {
		//TODO
		ChoiceGroup choiceGroup = new ChoiceGroup(I18NKeys.COMPETITION_LIST,Choice.EXCLUSIVE); 
		int i =0;
		while(i<competitionsList.size())
		{
			choiceGroup.append(((Competition)competitionsList.elementAt(i)).getName(),null);
			i++;
		}
		return choiceGroup;	
	}
	
	public Vector getCompetitionListIDS(Vector competitionsList)
	{
		Vector vector = new Vector();
		int i =0;
		while(i<competitionsList.size())
		{
			vector.addElement(((Competition)competitionsList.elementAt(i)).getId());
			i++;
		}
		return vector;
	}
	
	public ChoiceGroup getMultiEventListChoiceGroup(Vector multiEventList) {
		//TODO
		ChoiceGroup choiceGroup = new ChoiceGroup(emi18N.translate(I18NKeys.MULTI_EVENT_LIST),Choice.EXCLUSIVE); 
		int i =0;
		while(i<multiEventList.size())
		{
			choiceGroup.append(emi18N.translate(((MultiEvent)multiEventList.elementAt(i)).getName()),null);
			i++;
		}
		return choiceGroup;
	}
	
	public Vector getMultiEventListIDS(Vector multiEventList){
		Vector vector = new Vector();
		int i =0;
		while(i<multiEventList.size())
		{
			vector.addElement(((MultiEvent)multiEventList.elementAt(i)).getName());
			i++;
		}
		return vector;
	}
	


}
