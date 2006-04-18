package be.benja.emcalculator.system.impl;

import be.benja.emcalculator.controller.BackingBeanFactory;
import be.benja.emcalculator.controller.EMCalculatorController;
import be.benja.emcalculator.controller.i18n.EMI18N;
import be.benja.emcalculator.controller.i18n.I18NItems;
import be.benja.emcalculator.service.ServiceLocator;
import be.benja.emcalculator.system.Initializer;
import be.benja.microapp.em.Controller;

public class StaticInitializerImpl implements Initializer {

	public Controller init() {
		ServiceLocator serviceLocator = loadServiceLocator();
		EMI18N emi18n = new I18NItems(System.getProperty("microedition.locale"));
		BackingBeanFactory backingBeanFactory = new BackingBeanFactory(serviceLocator,emi18n);
		Controller controller = new EMCalculatorController(backingBeanFactory);
		return controller;
	}

	private ServiceLocator loadServiceLocator() {
		// TODO Auto-generated method stub
		//TODO créer les datas business
		return null;
	}

}
