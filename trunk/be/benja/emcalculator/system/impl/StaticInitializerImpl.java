package be.benja.emcalculator.system.impl;

import javax.microedition.lcdui.Display;
import be.benja.emcalculator.controller.BackingBeanFactory;
import be.benja.emcalculator.controller.Controller;
import be.benja.emcalculator.controller.EMCalculatorController;
import be.benja.emcalculator.controller.exceptions.InitializationException;
import be.benja.emcalculator.controller.i18n.EMI18N;
import be.benja.emcalculator.controller.i18n.I18NItems;
import be.benja.emcalculator.dao.service.CompetitionDAOServiceImpl;
import be.benja.emcalculator.dao.service.MultiEventDAOServiceImpl;
import be.benja.emcalculator.dao.service.staticdatas.MultiEventDatas;
import be.benja.emcalculator.model.DAOService.CompetitionDAOService;
import be.benja.emcalculator.model.DAOService.DAOServiceImpl;
import be.benja.emcalculator.model.DAOService.MultiEventDAOService;
import be.benja.emcalculator.service.ControllerService;
import be.benja.emcalculator.service.impl.ControllerServiceImpl;
import be.benja.emcalculator.system.Initializer;


public class StaticInitializerImpl implements Initializer {

	public Controller init(Display display) throws InitializationException {
		EMI18N emi18n = new I18NItems(System.getProperty("microedition.locale"));
		ControllerService serviceLocator = new ControllerServiceImpl(emi18n);
		DAOServiceImpl daoService = new DAOServiceImpl();
		
		//INIT DAO SERVICE
		CompetitionDAOService competitionDAOService;
		try {
			competitionDAOService = new CompetitionDAOServiceImpl(daoService);
		} catch (Exception e) {
			throw new InitializationException(e.getMessage());
		}
		MultiEventDatas multiEventDatas = new MultiEventDatas();
		MultiEventDAOService multiEventDAOService = new MultiEventDAOServiceImpl(multiEventDatas);
		
		daoService.setCompetitionDAOService(competitionDAOService);
		daoService.setMultiEventDAOService(multiEventDAOService);
		
		BackingBeanFactory backingBeanFactory = new BackingBeanFactory(emi18n);
		Controller controller = new EMCalculatorController(backingBeanFactory,display,daoService,serviceLocator);
		return controller;
	}


}
