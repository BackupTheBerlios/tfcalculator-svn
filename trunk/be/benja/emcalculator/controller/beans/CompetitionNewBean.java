package be.benja.emcalculator.controller.beans;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;

import be.benja.emcalculator.controller.AbstractBackingBean;
import be.benja.emcalculator.controller.Controller;
import be.benja.emcalculator.controller.i18n.EMI18N;
import be.benja.emcalculator.service.ServiceLocator;

public class CompetitionNewBean extends AbstractBackingBean {

	TextField competitionName;
	TextField date;
	TextField place;
	TextField athlete;
	ChoiceGroup multiEventsList;
	Command commandCreate;
	Command commandCancel;
	Command commandDelete;
	
	
	public CompetitionNewBean(ServiceLocator serviceLocator, EMI18N emi18n, Controller controller, String name) {
		super(serviceLocator, emi18n, controller, name);
		this.competitionName = new TextField(getEmi18n().translate("competition_name_input_key"),"",32,TextField.ANY);
		this.date = new TextField(getEmi18n().translate("competition_date_input_key"),"",16,TextField.ANY);
		this.place = new TextField(getEmi18n().translate("competition_place_input_key"),"",32,TextField.ANY);
		this.athlete = new TextField(getEmi18n().translate("competition_athlete_input_key"),"",32,TextField.ANY);
		multiEventsList = getServiceLocator().getMultiEventList();
		commandCreate = new Command(getEmi18n().translate("button_create_key"),Command.OK,1);
		commandCancel = new Command(getEmi18n().translate("button_cancel_key"),Command.CANCEL,1);
		commandDelete = new Command(getEmi18n().translate("button_delete_key"),Command.ITEM,1);
		
		this.append(competitionName);
		this.append(date);
		this.append(place);
		this.append(athlete);
		this.append(multiEventsList);
		this.addCommand(commandCreate);
		this.addCommand(commandCancel);
		this.addCommand(commandDelete);
		
	}

	public void refresh() {
		// TODO Auto-generated method stub

	}

	public void commandAction(Command command, Displayable display) {
		getController().control(command.getCommandType());
	}

}
