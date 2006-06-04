package be.benja.emcalculator.service.impl;

import java.util.Vector;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;

import be.benja.emcalculator.controller.i18n.EMI18N;

import be.benja.emcalculator.model.Competition;
import be.benja.emcalculator.model.MultiEvent;
import be.benja.emcalculator.service.ControllerService;

public class ControllerServiceImpl implements ControllerService {


	Competition currentCompetition;
	EMI18N emi18N;
	public ControllerServiceImpl(EMI18N emi18N)
	{
		this.emi18N = emi18N;

	}
	public ChoiceGroup getCompetitionListChoiceGroup(Vector competitionsList) {
		//TODO
		ChoiceGroup choiceGroup = new ChoiceGroup(emi18N.translate("unknownlist_key"),Choice.EXCLUSIVE); 
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
		ChoiceGroup choiceGroup = new ChoiceGroup(emi18N.translate("unknownlist_key"),Choice.EXCLUSIVE); 
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
	
	private ChoiceGroup getChoiceGroup(Vector vector)
	{
		
		if(vector!=null&&vector.elementAt(0)!=null)
		{
			if(vector.elementAt(0) instanceof MultiEvent)
			{
				ChoiceGroup choiceGroup = new ChoiceGroup(emi18N.translate("multieventlist_key"),Choice.EXCLUSIVE);
				for(int i =0; i<vector.size();i++)
				{
					MultiEvent multiEvent = (MultiEvent) vector.elementAt(i);
					choiceGroup.append(emi18N.translate(multiEvent.getName())+" "+emi18N.translate(multiEvent.getCategory())+" "+emi18N.translate(multiEvent.getGender()),null);
				}
				return choiceGroup;
			}
		}
		return new ChoiceGroup(emi18N.translate("unknownlist_key"),Choice.EXCLUSIVE);
	}


}
