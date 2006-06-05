package be.benja.emcalculator.controller.beans;


import java.util.Vector;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;


import be.benja.emcalculator.controller.AbstractView;
import be.benja.emcalculator.controller.Controller;
import be.benja.emcalculator.controller.i18n.I18NKeys;
import be.benja.emcalculator.controller.i18n.I18NTranslator;



public class CompetitionListView extends AbstractView {


	ChoiceGroup competitionList;
	Command commandOk;
	Command commandNew;
	Vector competitionListIDS;

	public CompetitionListView(I18NTranslator emi18n,Controller controller, String name) {

		super(emi18n,controller,name);
		competitionList  = new ChoiceGroup(I18NKeys.COMPETITION_LIST,Choice.EXCLUSIVE);
		this.setTitle(getEmi18n().translate(I18NKeys.COMPETITION_LIST));
		this.append(competitionList);
		commandOk = new Command(getEmi18n().translate(I18NKeys.BUTTON_EDIT),Command.OK,1);
		commandNew = new Command(getEmi18n().translate(I18NKeys.BUTTON_NEW),Command.ITEM,2);
		this.addCommand(commandOk);
		this.addCommand(commandNew);		
	}
	
	public void commandAction(Command command, Displayable display) {
		getController().control(command.getCommandType());
	}

	public ChoiceGroup getCompetitionList() {
		return competitionList;
	}
	
	public String getSelectedId()
	{
		int indice = competitionList.getSelectedIndex();
		return (String)competitionListIDS.elementAt(indice);
	}

	public void setCompetitionList(ChoiceGroup competitionList, Vector competitionListIDS) {
		this.competitionList = competitionList;
		this.competitionListIDS = competitionListIDS;
		this.set(0,competitionList);
	}

	public Vector getCompetitionListIDS() {
		return competitionListIDS;
	}

	public void setCompetitionListIDS(Vector competitionListIDS) {
		this.competitionListIDS = competitionListIDS;
	}

}
