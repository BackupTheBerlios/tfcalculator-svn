package be.benja.emcalculator.service;

import java.util.Vector;

import javax.microedition.lcdui.ChoiceGroup;


public interface ControllerService {
	public ChoiceGroup getCompetitionListChoiceGroup(Vector competitionsList); 
	
	public ChoiceGroup getMultiEventListChoiceGroup(Vector multiEventList);
	public Vector getMultiEventListIDS(Vector multiEventList);
}
