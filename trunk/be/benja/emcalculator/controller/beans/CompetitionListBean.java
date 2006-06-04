package be.benja.emcalculator.controller.beans;


import java.util.Vector;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;


import be.benja.emcalculator.controller.AbstractBackingBean;
import be.benja.emcalculator.controller.Controller;
import be.benja.emcalculator.controller.i18n.EMI18N;
import be.benja.emcalculator.service.ControllerService;


public class CompetitionListBean extends AbstractBackingBean {


	ChoiceGroup competitionList;
	Command commandOk;
	Command commandNew;
	Vector competitionListIDS;

	public CompetitionListBean(EMI18N emi18n,Controller controller, String name) {

		super(emi18n,controller,name);
		competitionList  = new ChoiceGroup("",Choice.EXCLUSIVE);
		this.setTitle(getEmi18n().translate("KEY_competition_title"));
		this.append(competitionList);
		commandOk = new Command(getEmi18n().translate("KEY_button_ok"),Command.OK,1);
		commandNew = new Command(getEmi18n().translate("KEY_button_new"),Command.ITEM,2);
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

}
