package be.benja.emcalculator.controller.beans;

import java.util.Date;
import java.util.Vector;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;

import be.benja.emcalculator.controller.AbstractView;
import be.benja.emcalculator.controller.Controller;
import be.benja.emcalculator.controller.ControllerActions;
import be.benja.emcalculator.controller.i18n.I18NKeys;
import be.benja.emcalculator.controller.i18n.I18NTranslator;
import be.benja.emcalculator.model.Competition;
import be.benja.emcalculator.service.ControllerService;

public class CompetitionNewView extends AbstractView {

	TextField competitionName;
	DateField date;
	TextField place;
	TextField athlete;
	String id;
	ChoiceGroup multiEventsList;
	Vector ids;
	
	Command commandCreate;
	Command commandCancel;
	Command commandDelete;
	
	
	public CompetitionNewView(I18NTranslator emi18n, Controller controller, String name) {
		super(emi18n, controller, name);
		this.competitionName = new TextField(getEmi18n().translate(I18NKeys.COMPETITION_NAME_INPUT),"",32,TextField.ANY);
		this.date = new DateField(getEmi18n().translate(I18NKeys.COMPETITION_DATE_INPUT),DateField.DATE,null);
		this.date.setDate(new Date());
		this.place = new TextField(getEmi18n().translate(I18NKeys.COMPETITION_PLACE_INPUT),"",32,TextField.ANY);
		this.athlete = new TextField(getEmi18n().translate(I18NKeys.COMPETITION_ATHLETE_INPUT),"",32,TextField.ANY);
		multiEventsList = new ChoiceGroup(I18NKeys.MULTI_EVENT_LIST,Choice.EXCLUSIVE);
		commandCreate = new Command(getEmi18n().translate(I18NKeys.BUTTON_VALIDATE),Command.OK,1);
		commandCancel = new Command(getEmi18n().translate(I18NKeys.BUTTON_CANCEL),Command.CANCEL,1);
		commandDelete = new Command(getEmi18n().translate(I18NKeys.BUTTON_DELETE),Command.ITEM,1);
		
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
		// TODO Auto-generated method stu
	}
	
	public void setCompetition(Competition competition)
	{
		this.athlete.setString(competition.getAthleteName());
		this.competitionName.setString(competition.getName());
		this.date.setDate(competition.getDate());
		this.place.setString(competition.getPlace());
		this.id=competition.getId();
	}
	
	public Competition getCompetition()
	{
		return null;
	}
	
	public void cleanView()
	{
		competitionName.setString("");
		place.setString("");
		athlete.setString("");
		date.setDate(new Date());
		id=null;
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

	public DateField getDate() {
		return date;
	}

	public void setDate(DateField date) {
		this.date = date;
	}

	public ChoiceGroup getMultiEventsList() {
		return multiEventsList;
	}

	public void setMultiEventsList(ChoiceGroup multiEventsList,Vector ids) {
		this.multiEventsList = multiEventsList;
		this.ids = ids;
		this.set(4,multiEventsList);
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
	
	public void commandAction(Command command, Displayable display) {
		getController().control(command.getCommandType());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Vector getIds() {
		return ids;
	}

	public void setIds(Vector ids) {
		this.ids = ids;
	}

	public void setMultiEventsList(ChoiceGroup multiEventsList) {
		this.multiEventsList = multiEventsList;
	}

}
