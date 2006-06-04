package be.benja.emcalculator.controller.beans;

import java.util.Vector;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;

import be.benja.emcalculator.controller.AbstractBackingBean;
import be.benja.emcalculator.controller.Controller;
import be.benja.emcalculator.controller.i18n.EMI18N;
import be.benja.emcalculator.service.ControllerService;

public class CompetitionNewBean extends AbstractBackingBean {

	TextField competitionName;
	TextField date;
	TextField place;
	TextField athlete;
	ChoiceGroup multiEventsList;
	Vector ids;
	Command commandCreate;
	Command commandCancel;
	Command commandDelete;
	
	
	public CompetitionNewBean(EMI18N emi18n, Controller controller, String name) {
		super(emi18n, controller, name);
		this.competitionName = new TextField(getEmi18n().translate("competition_name_input_key"),"",32,TextField.ANY);
		this.date = new TextField(getEmi18n().translate("competition_date_input_key"),"",16,TextField.ANY);
		this.place = new TextField(getEmi18n().translate("competition_place_input_key"),"",32,TextField.ANY);
		this.athlete = new TextField(getEmi18n().translate("competition_athlete_input_key"),"",32,TextField.ANY);
		multiEventsList = new ChoiceGroup("",Choice.EXCLUSIVE);
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

	public TextField getAthlete() {
		return athlete;
	}

	public void setAthlete(TextField athlete) {
		this.athlete = athlete;
	}

	public Command getCommandCancel() {
		return commandCancel;
	}

	public void setCommandCancel(Command commandCancel) {
		this.commandCancel = commandCancel;
	}

	public Command getCommandCreate() {
		return commandCreate;
	}

	public void setCommandCreate(Command commandCreate) {
		this.commandCreate = commandCreate;
	}

	public Command getCommandDelete() {
		return commandDelete;
	}

	public void setCommandDelete(Command commandDelete) {
		this.commandDelete = commandDelete;
	}

	public TextField getCompetitionName() {
		return competitionName;
	}

	public void setCompetitionName(TextField competitionName) {
		this.competitionName = competitionName;
	}

	public TextField getDate() {
		return date;
	}

	public void setDate(TextField date) {
		this.date = date;
	}

	public ChoiceGroup getMultiEventsList() {
		return multiEventsList;
	}

	public void setMultiEventsList(ChoiceGroup multiEventsList,Vector ids) {
		this.multiEventsList = multiEventsList;
		this.ids = ids;
	}
	
	public String getSelectedId()
	{
		int indice = multiEventsList.getSelectedIndex();
		return (String)ids.elementAt(indice);
	}

	public TextField getPlace() {
		return place;
	}

	public void setPlace(TextField place) {
		this.place = place;
	}

}
