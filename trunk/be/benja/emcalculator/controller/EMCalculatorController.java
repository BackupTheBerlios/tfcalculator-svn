package be.benja.emcalculator.controller;

import java.util.Date;
import java.util.Vector;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;

import be.benja.emcalculator.controller.beans.CompetitionListView;
import be.benja.emcalculator.controller.beans.CompetitionNewView;
import be.benja.emcalculator.model.Competition;
import be.benja.emcalculator.model.MultiEvent;
import be.benja.emcalculator.model.DAOService.DAOService;
import be.benja.emcalculator.service.ControllerService;




public class EMCalculatorController implements Controller{
	Display display;
	DAOService daoService;
	ControllerService controllerService;
	BackingBeanFactory backingBeanFactory;
	
	public EMCalculatorController(BackingBeanFactory backingBeanFactory,Display display,DAOService daoService,ControllerService serviceLocator)
	{
		this.backingBeanFactory = backingBeanFactory;
		backingBeanFactory.setController(this);
		this.display = display;
		this.daoService = daoService;
		this.controllerService = serviceLocator;
	}
	//TODO sous classe
	public void control(int status) {
		if(display.getCurrent()==null)
		{
			CompetitionListView competitionListBean =(CompetitionListView)backingBeanFactory.getBackingBean(ScreenName.SCREEN_1_competitionList);
			Vector competitionList = daoService.getCompetitionDAOService().loadAll();
			System.out.println(competitionList);
			for(int i=0;i<competitionList.size();i++)
			{
				System.out.println("i:"+i+" id:"+((Competition)competitionList.elementAt(i)).getId()+" name:"+((Competition)competitionList.elementAt(i)).getName());
			}
			competitionListBean.setCompetitionList(controllerService.getCompetitionListChoiceGroup(competitionList),controllerService.getCompetitionListIDS(competitionList));
			display.setCurrent(competitionListBean);
		}
		else if(this.display.getCurrent() instanceof CompetitionListView)
		{
			CompetitionListView competitionListView = (CompetitionListView) backingBeanFactory.getBackingBean(ScreenName.SCREEN_1_competitionList);
			CompetitionNewView competitionNewBean =(CompetitionNewView)backingBeanFactory.getBackingBean(ScreenName.SCREEN_2_newCompetition);
			switch(status)
			{
			case Command.ITEM:
				competitionNewBean.setMultiEventsList(controllerService.getMultiEventListChoiceGroup(daoService.getMultiEventDAOService().loadAll()),controllerService.getMultiEventListIDS(daoService.getMultiEventDAOService().loadAll()));
				competitionNewBean.cleanView();
				break;
			case Command.OK:	
				competitionNewBean.setMultiEventsList(controllerService.getMultiEventListChoiceGroup(daoService.getMultiEventDAOService().loadAll()),controllerService.getMultiEventListIDS(daoService.getMultiEventDAOService().loadAll()));	
				
				Competition competition = daoService.getCompetitionDAOService().load((String)competitionListView.getCompetitionListIDS().elementAt(competitionListView.getCompetitionList().getSelectedIndex()));
				System.out.println("id:"+(String)competitionListView.getCompetitionListIDS().elementAt(competitionListView.getCompetitionList().getSelectedIndex()));
				competitionNewBean.getAthlete().setString(competition.getAthleteName());
				competitionNewBean.getCompetitionName().setString(competition.getName());
				competitionNewBean.getDate().setDate(competition.getDate());
				competitionNewBean.getPlace().setString(competition.getPlace());
				competitionNewBean.setId(competition.getId());
				break;
			}
			display.setCurrent(competitionNewBean);
		}
		else if(this.display.getCurrent() instanceof CompetitionNewView)
		{
			CompetitionNewView competitionNewBean =(CompetitionNewView) this.display.getCurrent();
			switch(status)
			{
			case Command.OK:
				if(competitionNewBean.getId()==null)
				{
					MultiEvent multiEvent = daoService.getMultiEventDAOService().load(competitionNewBean.getSelectedId());
					Competition competition = new Competition(multiEvent);
					competition.setAthleteName(competitionNewBean.getAthlete().getString());
					competition.setDate(competitionNewBean.getDate().getDate());
					competition.setName(competitionNewBean.getCompetitionName().getString());
					competition.setPlace(competitionNewBean.getPlace().getString());
					daoService.getCompetitionDAOService().saveOrUpdate(competition);
				}
				else
				{
					Competition competition = daoService.getCompetitionDAOService().load(competitionNewBean.getId());
					competition.setAthleteName(competitionNewBean.getAthlete().getString());
					competition.setDate(competitionNewBean.getDate().getDate());
					competition.setName(competitionNewBean.getCompetitionName().getString());
					competition.setPlace(competitionNewBean.getPlace().getString());
				}

				//VUE
				CompetitionListView competitionListBean =(CompetitionListView)backingBeanFactory.getBackingBean(ScreenName.SCREEN_1_competitionList);
				Vector competitionList = daoService.getCompetitionDAOService().loadAll();
				System.out.println(competitionList);
				competitionListBean.setCompetitionList(controllerService.getCompetitionListChoiceGroup(competitionList),controllerService.getCompetitionListIDS(competitionList));
				display.setCurrent(competitionListBean);
				break;
			}			
		}
		

		
	}

}
