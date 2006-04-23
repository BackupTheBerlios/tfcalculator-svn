package be.benja.emcalculator.controller;

import be.benja.emcalculator.controller.beans.CompetitionListBean;
import be.benja.emcalculator.controller.i18n.EMI18N;
import be.benja.emcalculator.service.ServiceLocator;

public class BackingBeanFactory {
	private AbstractBackingBean SCREEN_1_competitionList;
	private AbstractBackingBean SCREEN_2_newCompetition;
	private AbstractBackingBean SCREEN_3_competitionInfo;
	private AbstractBackingBean SCREEN_4_modifyEvent;
	private ServiceLocator serviceLocator;
	private EMI18N emi18n;
	private Controller controller;
	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	public BackingBeanFactory(ServiceLocator serviceLocator,EMI18N emi18n)
	{
		this.serviceLocator = serviceLocator;
		this.emi18n=emi18n;
	}
	public AbstractBackingBean getBackingBean(int id)
	{
		switch(id)
		{
		case ScreenName.SCREEN_1_competitionList:
			if(SCREEN_1_competitionList==null)
			{
				SCREEN_1_competitionList = new CompetitionListBean(serviceLocator,emi18n,controller,emi18n.translate("KEY_competition_title"));
				
			}
			SCREEN_1_competitionList.refresh();
			return SCREEN_1_competitionList;
		case ScreenName.SCREEN_2_newCompetition:
			if(SCREEN_2_newCompetition==null)
			{
				SCREEN_2_newCompetition = new CompetitionListBean(serviceLocator,emi18n,controller,emi18n.translate("KEY_competition_title"));;
				//TODO
			}
			SCREEN_2_newCompetition.refresh();
			return SCREEN_2_newCompetition;
		case ScreenName.SCREEN_3_competitionInfo:
			if(SCREEN_3_competitionInfo==null)
			{
				SCREEN_3_competitionInfo = new CompetitionListBean(serviceLocator,emi18n,controller,emi18n.translate("KEY_competition_title"));;
				//TODO
			}
			SCREEN_3_competitionInfo.refresh();
			return SCREEN_3_competitionInfo;
		case ScreenName.SCREEN_4_modifyEvent:
			if(SCREEN_4_modifyEvent==null)
			{
				SCREEN_4_modifyEvent = new CompetitionListBean(serviceLocator,emi18n,controller,emi18n.translate("KEY_competition_title"));;
				//TODO
			}	
			SCREEN_4_modifyEvent.refresh();
			return SCREEN_4_modifyEvent;
		default : 			
			if(SCREEN_1_competitionList==null)
		{
			SCREEN_1_competitionList = new CompetitionListBean(serviceLocator,emi18n,controller,emi18n.translate("KEY_competition_title"));
		}	
		return SCREEN_1_competitionList;
		//TODO exception
		}
		
	}

}
