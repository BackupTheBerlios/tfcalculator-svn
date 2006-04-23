package be.benja.emcalculator.service;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.List;

public interface ServiceLocator {
	public ChoiceGroup getCompetitionList(); 
	public ChoiceGroup getMultiEventList();
}
