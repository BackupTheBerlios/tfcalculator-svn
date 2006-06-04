package be.benja.emcalculator.controller;

import java.util.Date;
import java.util.Vector;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;

import be.benja.emcalculator.controller.beans.CompetitionListBean;
import be.benja.emcalculator.controller.beans.CompetitionNewBean;
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
			CompetitionListBean competitionListBean =(CompetitionListBean)backingBeanFactory.getBackingBean(ScreenName.SCREEN_1_competitionList);
			display.setCurrent(competitionListBean);
		}
		else if(this.display.getCurrent() instanceof CompetitionListBean)
		{
			switch(status)
			{
			case Command.ITEM:
				CompetitionNewBean competitionNewBean =(CompetitionNewBean)backingBeanFactory.getBackingBean(ScreenName.SCREEN_2_newCompetition);	
				competitionNewBean.setMultiEventsList(controllerService.getMultiEventListChoiceGroup(daoService.getMultiEventDAOService().loadAll()),controllerService.getMultiEventListIDS(daoService.getMultiEventDAOService().loadAll()));
				display.setCurrent(competitionNewBean);
			}
		}
		else if(this.display.getCurrent() instanceof CompetitionNewBean)
		{
			switch(status)
			{
			case Command.OK:
				CompetitionNewBean competitionNewBean =(CompetitionNewBean) this.display.getCurrent();
				//TODO	
				//MODEL
				MultiEvent multiEvent = daoService.getMultiEventDAOService().load(competitionNewBean.getSelectedId());
				Competition competition = new Competition(multiEvent);
				competition.setAthleteName(competitionNewBean.getAthlete().getString());
				competition.setDate(new Date());
				competition.setName(competitionNewBean.getCompetitionName().getString());
				competition.setPlace(competitionNewBean.getPlace().getString());
				
				daoService.getCompetitionDAOService().saveOrUpdate(competition);
				
				//VUE
				CompetitionListBean competitionListBean =(CompetitionListBean)backingBeanFactory.getBackingBean(ScreenName.SCREEN_1_competitionList);
				System.out.println("before save");
				Vector competitionList = daoService.getCompetitionDAOService().loadAll();
				competitionListBean.setCompetitionList(controllerService.getCompetitionListChoiceGroup(competitionList),controllerService.getCompetitionListIDS(competitionList));
				System.out.println("after save");
				display.setCurrent(competitionListBean);
			}			
		}
		

		
	}

}
