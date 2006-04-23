package be.benja.emcalculator.service;

import javax.microedition.lcdui.ChoiceGroup;


public interface ServiceLocator {
	public ChoiceGroup getCompetitionList(); 
	public ChoiceGroup getMultiEventList();
}
