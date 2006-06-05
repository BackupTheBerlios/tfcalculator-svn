package be.benja.emcalculator.controller;

import be.benja.emcalculator.controller.beans.CompetitionListView;
import be.benja.emcalculator.controller.beans.CompetitionNewView;
import be.benja.emcalculator.controller.i18n.I18NTranslator;
import be.benja.emcalculator.service.ControllerService;

public class BackingBeanFactory {
	private AbstractView SCREEN_1_competitionList;
	private AbstractView SCREEN_2_newCompetition;
	private AbstractView SCREEN_3_competitionInfo;
	private AbstractView SCREEN_4_modifyEvent;
	private I18NTranslator emi18n;
	private Controller controller;
	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	public BackingBeanFactory(I18NTranslator emi18n)
	{

		this.emi18n=emi18n;
	}
	public AbstractView getBackingBean(int id)
	{
		switch(id)
		{
		case ScreenName.SCREEN_1_competitionList:
			if(SCREEN_1_competitionList==null)
			{
				SCREEN_1_competitionList = new CompetitionListView(emi18n,controller,emi18n.translate("KEY_competition_title"));
				
			}
			return SCREEN_1_competitionList;
		case ScreenName.SCREEN_2_newCompetition:
			if(SCREEN_2_newCompetition==null)
			{
				SCREEN_2_newCompetition = new CompetitionNewView(emi18n,controller,emi18n.translate("KEY_competition_title"));
			}
			return SCREEN_2_newCompetition;
		case ScreenName.SCREEN_3_competitionInfo:
			if(SCREEN_3_competitionInfo==null)
			{
				SCREEN_3_competitionInfo = new CompetitionListView(emi18n,controller,emi18n.translate("KEY_competition_title"));;
				//TODO
			}
			return SCREEN_3_competitionInfo;
		case ScreenName.SCREEN_4_modifyEvent:
			if(SCREEN_4_modifyEvent==null)
			{
				SCREEN_4_modifyEvent = new CompetitionListView(emi18n,controller,emi18n.translate("KEY_competition_title"));;
				//TODO
			}	
			return SCREEN_4_modifyEvent;
		default : 			
			if(SCREEN_1_competitionList==null)
		{
			SCREEN_1_competitionList = new CompetitionListView(emi18n,controller,emi18n.translate("KEY_competition_title"));
		}	
		return SCREEN_1_competitionList;
		//TODO exception
		}
		
	}

}
